package bcwadsworth.devices.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class BlockList 
{
	private BlockCompound[] list;
	
	public BlockList(BlockCompound[] initialList)
	{
		this.setList(initialList);
	}
	
	public void addToList(BlockCompound block)
	{
		list = Arrays.copyOf(list, list.length + 1);
		list[list.length - 1] = block;
	}
	
	public void addAllToList(Block block)
	{
		for (int i = 0; i < 16; i++)
		{
			BlockCompound blockcomp = new BlockCompound(block, i);
			list = Arrays.copyOf(list, list.length + 1);
			list[list.length - 1] = blockcomp;
		}
	}
	
	public void changeToList(int index, BlockCompound block)
	{
		list[index] = block;
	}
	
	public void removeFromList(BlockCompound whitelist)
	{
			List<BlockCompound> listlist = Arrays.asList(list);
			int whiteIndex = listlist.indexOf(whitelist);
			listlist.remove(whitelist);
			list = listlist.toArray(new BlockCompound[listlist.size()]);
	}
	
	public void removeFromList(int index)
	{
			List<BlockCompound> listlist = Arrays.asList(list);
			listlist.remove(index);
			list = listlist.toArray(new BlockCompound[listlist.size()]);
	}
	
	public void clearList()
	{
		list = new BlockCompound[] {null};
		System.out.println(this + " just got cleared, something may not work right");
	}
	
	public void setList(BlockCompound[] setList)
	{
		this.clearList();
		list = setList;
	}
	
	public BlockCompound[] get()
	{
		return list;
	}
	
	public int get(BlockCompound block)
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
	
	public Boolean has(BlockCompound block)
	{
		return Arrays.asList(list).contains(block);
	}
	
	public BlockCompound get(int index)
	{
		return list[index];
	}
}
