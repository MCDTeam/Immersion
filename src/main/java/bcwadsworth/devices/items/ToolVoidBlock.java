package bcwadsworth.devices.items;

import java.util.Arrays;

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
	BlockList blacklist = new BlockList(null);
	public ToolVoidBlock() 
	{
		maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName("toolVoidBlock");
		blacklist.addAllToList(Blocks.water);
		blacklist.addAllToList(Blocks.lava);
		blacklist.addToList(new BlockCompound(Blocks.bedrock, 0));
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) 
	{
		itemIcon = iconRegister.registerIcon("devices:toolVoidBlock");
	}
	
	public ItemStack onItemRightClick(ItemStack ItemStack, World World,
			EntityPlayer EntityPlayer) {
		MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(
				World, EntityPlayer, true);
		if (movingobjectposition == null || World.isRemote) 
		{
			
		} 
		else 
		{
			if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) 
			{
				int X = movingobjectposition.blockX;
				int Y = movingobjectposition.blockY;
				int Z = movingobjectposition.blockZ;

				BlockCompound block = BlockCompound.get(World, X, Y, Z);
				if (!blacklist.has(block)) 
				{
					World.setBlockToAir(X, Y, Z);
				}
			}
		}
		return ItemStack;
    }
}

