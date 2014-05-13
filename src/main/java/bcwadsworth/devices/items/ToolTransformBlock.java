package bcwadsworth.devices.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ToolTransformBlock extends Item 
{
	public ToolTransformBlock() 
	{
		maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName("toolTransformBlock");
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) 
	{
		itemIcon = iconRegister.registerIcon("devices:toolTransformBlock");
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

                Block block = World.getBlock(X, Y, Z);
                if (block != Blocks.bedrock)
                {
                	
                }
            }
        }
		return ItemStack;
    }
}

