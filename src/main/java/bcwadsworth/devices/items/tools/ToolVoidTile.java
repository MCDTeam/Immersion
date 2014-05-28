package bcwadsworth.devices.items.tools;

import java.util.List;

import bcwadsworth.devices.resources.core.BlockCompound;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ToolVoidTile extends Item
{
	public ToolVoidTile()
	{
		maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName("toolVoidTile");
	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon("devices:toolVoid");
	}
	
	public ItemStack onItemRightClick(ItemStack ItemStack, World world,
			EntityPlayer EntityPlayer)
	{
		MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(
				world, EntityPlayer, true);
		if (movingobjectposition == null || world.isRemote)
		{
			
		} 
		else
		{
			if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
			{
				int x = movingobjectposition.blockX;
				int y = movingobjectposition.blockY;
				int z = movingobjectposition.blockZ;
				
				BlockCompound block = BlockCompound.get(world, x, y, z);
				if (block.getBlock().hasTileEntity(block.getMetadata()))
				{
					BlockCompound.set(world, x, y, z, block);
				}
			}
		}
		return ItemStack;
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list,
			boolean par4)
	{
		list.add("No contents to display at this time!");
		super.addInformation(stack, player, list, par4);
	}
}
