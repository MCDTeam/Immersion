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

                if (World.canMineBlock(EntityPlayer, X, Y, Z))
                {
                	Block block = World.getBlock(X, Y, Z);
                	if (block == Blocks.stone)
                	{
                		World.setBlock(X,Y,Z, Blocks.gravel);
                	}
                	else if (block == Blocks.gravel)
                	{
                		World.setBlock(X,Y,Z, Blocks.sand);
                	}
                	else if (block == Blocks.sand)
                	{
                		World.setBlock(X,Y,Z, Blocks.glass);
                	}
                	else if (block == Blocks.glass)
                	{
                		World.setBlock(X,Y,Z, Blocks.dirt);
                	}
                	else if (block == Blocks.dirt)
                	{
                		World.setBlock(X,Y,Z, Blocks.cobblestone);
                	}
                	else if (block == Blocks.grass || block == Blocks.mycelium)
                	{
                		World.setBlock(X,Y,Z, Blocks.dirt);
                	}
                	else if (block == Blocks.cobblestone)
                	{
                		World.setBlock(X,Y,Z, Blocks.stonebrick);
                	}
                	else if (block == Blocks.mossy_cobblestone)
                	{
                		World.setBlock(X,Y,Z, Blocks.cobblestone);
                	}
                	else if (block == Blocks.wool)
                	{
                		int metadata = World.getBlockMetadata(X, Y, Z);
                		if (metadata == 16)
                		{
                			metadata = 0;
                		}
                		World.setBlock(X,Y,Z, Blocks.wool, metadata + 1, 0);
                	}
                	if (block == Blocks.stonebrick)
                	{
                		World.setBlock(X,Y,Z, Blocks.stone);
                	}
                }
            }
        }
		return ItemStack;
    }
}

