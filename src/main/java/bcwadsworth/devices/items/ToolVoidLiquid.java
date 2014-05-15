package bcwadsworth.devices.items;

import java.util.Arrays;

import bcwadsworth.devices.resources.BlockCompound;
import bcwadsworth.devices.resources.BlockList;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolVoidLiquid extends Item
{
	BlockList fluidlist = new BlockList (null);
	public ToolVoidLiquid() 
	{
		maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName("toolVoidLiquid");
		fluidlist.addAllToList(Blocks.water);
		fluidlist.addAllToList(Blocks.lava);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) 
	{
		itemIcon = iconRegister.registerIcon("devices:toolVoidLiquid");
	}
	
	public ItemStack onItemRightClick(ItemStack ItemStack, World World, EntityPlayer EntityPlayer)
    {
		MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(World, EntityPlayer, true);
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
				if (fluidlist.has(block)) 
				{
					World.setBlockToAir(X, Y, Z);
				}
			}
        }
		return ItemStack;
    }
}
