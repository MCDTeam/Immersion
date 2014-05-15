package bcwadsworth.devices.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import bcwadsworth.devices.resources.BlockCompound;
import bcwadsworth.devices.resources.BlockConversionRecipieHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolTransformBlock extends Item 
{
	public BlockConversionRecipieHandler worldRecipieHandler;
	public ToolTransformBlock() 
	{
		maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName("toolTransformBlock");
		worldRecipieHandler = new BlockConversionRecipieHandler(null, null);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) 
	{
		itemIcon = iconRegister.registerIcon("devices:toolTransformBlock");
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
                block = worldRecipieHandler.getRecipie(block);
                if (block != null)
                {
                	BlockCompound.set(world, X, Y, Z, block);
                }
            }
        }
		return ItemStack;
    }
}

