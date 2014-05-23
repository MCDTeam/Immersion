package bcwadsworth.devices.items.tools;

import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import bcwadsworth.devices.resources.BlockCompound;
import bcwadsworth.devices.resources.BlockList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolVoidBlock extends Item
{
	public ToolVoidBlock() 
	{
		maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName("toolVoidBlock");
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) 
	{
		itemIcon = iconRegister.registerIcon("devices:toolVoid");
	}
	
	public ItemStack onItemRightClick(ItemStack ItemStack, World world, EntityPlayer EntityPlayer) 
	{
		MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(world, EntityPlayer, true);
		if (movingobjectposition == null || world.isRemote) 
		{
			
		} 
		else 
		{
			if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) 
			{
				int X = movingobjectposition.blockX;
				int Y = movingobjectposition.blockY;
				int Z = movingobjectposition.blockZ;

				BlockCompound block = BlockCompound.get(world, X, Y, Z);
				System.out.print(block.getBlock().getUnlocalizedName() + block.getMetadata());
				if (block.getBlock().canHarvestBlock(EntityPlayer, block.getMetadata())) 
				{
					world.setBlockToAir(X, Y, Z);
				}
			}
		}
		return ItemStack;
    }
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) 
	{
		list.add("404 Error: Block not Found");
		super.addInformation(stack, player, list, par4);
	}
}

