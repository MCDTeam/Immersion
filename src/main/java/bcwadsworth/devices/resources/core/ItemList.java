package bcwadsworth.devices.resources.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemList //This is a reimplementation of Blocklist with itemstacks, pardon arguments being called block!
{
	private ItemStack[] list;
	
	public ItemList(ItemStack[] initialList)
	{
		this.setList(initialList);
	}
	
	public void addToList(ItemStack block)
	{
		list = Arrays.copyOf(list, list.length + 1);
		list[list.length - 1] = block;
	}
	
	public void addAllToList(Block block)
	{
		for (int i = 0; i < 16; i++)
		{
			if (list == null)
			{
				list = new ItemStack[] {new ItemStack(Blocks.air, 0)};
			}
			ItemStack blockcomp = new ItemStack(block, i);
			list = Arrays.copyOf(list, list.length + 1);
			list[list.length - 1] = blockcomp;
			if (list[0] == new ItemStack(Blocks.air, 0))
			{
				this.removeFromList(0);
			}
		}
	}
	
	public void changeToList(int index, ItemStack block)
	{
		list[index] = block;
	}
	
	public void removeFromList(ItemStack whitelist)
	{
			List<ItemStack> listlist = Arrays.asList(list);
			int whiteIndex = listlist.indexOf(whitelist);
			listlist.remove(whitelist);
			list = listlist.toArray(new ItemStack[listlist.size()]);
	}
	
	public void removeFromList(int index)
	{
			List<ItemStack> listlist = Arrays.asList(list);
			listlist.remove(index);
			list = listlist.toArray(new ItemStack[listlist.size()]);
	}
	
	public void clearList()
	{
		list = new ItemStack[] {null};
		System.out.println(this + " just got cleared, something may not work right");
	}
	
	public void setList(ItemStack[] setList)
	{
		this.clearList();
		list = setList;
	}
	
	public ItemStack[] get()
	{
		return list;
	}
	
	public int get(ItemStack block)
	{
		if (this.has(block))
		{
			return Arrays.asList(list).indexOf(block);
		}
		else
		{
			return -1;
		}
	}
	
	public Boolean has(ItemStack block)
	{
		return Arrays.asList(list).contains(block);
	}
	
	public ItemStack get(int index)
	{
		return list[index];
	}
}
