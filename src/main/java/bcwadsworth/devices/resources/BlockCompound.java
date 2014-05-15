package bcwadsworth.devices.resources;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import bcwadsworth.devices.resources.SHandler;

public class BlockCompound 
{
	private Block block;
	private int metadata;
	public BlockCompound (Block setblock, int setmetadata)
	{
		block = setblock;
		metadata = setmetadata;
	}
	
	public Block getBlock()
	{
		return block;
	}
	
	public int getMetadata()
	{
		return metadata;
	}
	
	public ItemStack getStack()
	{
		return SHandler.SM(block, metadata);
	}
	
	public ItemStack getStack(int amount)
	{
		return SHandler.S(block, amount, metadata);
	}
	
	public static BlockCompound get(World world, int X, int Y, int Z)
	{
		return new BlockCompound(world.getBlock(X, Y, Z), world.getBlockMetadata(X,Y,Z));
	}
	
	public static void set(World world, int X, int Y, int Z, BlockCompound block)
	{
		world.setBlock(X, Y, Z, block.getBlock(), block.getMetadata(), 3);
	}
}
