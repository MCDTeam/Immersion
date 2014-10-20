package teamUnknown.immersion.core.utils;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class S 
{
	public static ItemStack St (Item item)
	{
		return new ItemStack (item);
	}
	public static ItemStack St (Block block)
	{
		return new ItemStack (block);
	}
	public static ItemStack St (Item item, int amount)
	{
		return new ItemStack (item, amount, 0);
	}
	public static ItemStack St (Block block, int amount)
	{
		return new ItemStack (block, amount, 0);
	}
	public static ItemStack SM (Item item, int metadata)
	{
		return new ItemStack (item, 1, metadata);
	}
	public static ItemStack SM (Block block, int metadata)
	{
		return new ItemStack (block, 1, metadata);
	}
	public static ItemStack St (Item item, int metadata, int amount)
	{
		return new ItemStack (item, amount, metadata);
	}
	public static ItemStack St (Block block, int metadata, int amount)
	{
		return new ItemStack (block, amount, metadata);
	}
}
