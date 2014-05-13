package bcwadsworth.devices.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class BlockList 
{
	private Block[] list;
	private Integer[] metadata;
	private static Block[] defaultList = new Block[] {Blocks.bedrock, Blocks.water, Blocks.lava};
	private static Integer[] defaultMetadata = new Integer[] {17, 17, 17};
	public BlockList(Block[] initialList, Integer[] listmetadata)
	{
		if (initialList == null)
		{
			this.setToDefaultList();
		}
		else
		{
			this.setList(initialList, listmetadata);
		}
	}
	public Boolean addToList (Block blacklist, int blackmetadata)
	{
		if (list.length == metadata.length)
		{
			list = Arrays.copyOf(list, list.length + 1);
			list[list.length - 1] = blacklist;
			metadata = Arrays.copyOf(metadata, list.length + 1);
			metadata[metadata.length - 1] = blackmetadata;
			return true;
		}
		return false;
	}
	public Boolean removeFromList (Block whitelist)
	{
		if (list.length == metadata.length)
		{
			List<Block> listlist = Arrays.asList(list);
			int whiteIndex = listlist.indexOf(whitelist);
			listlist.remove(whitelist);
			list = listlist.toArray(new Block[listlist.size()]);
			List<Integer> listmetadata = Arrays.asList(metadata);
			listmetadata.remove(whiteIndex);
			metadata = listmetadata.toArray(new Integer[listmetadata.size()]);
			if (list.length == metadata.length)
			{
				return true;
			}
		}
		return false;
	}
	public void clearList ()
	{
		list = new Block[] {null};
		System.out.println(this + " just got cleared, something may not work right");
	}
	public Boolean setList (Block[] setList, Integer[] setMetadata)
	{
		if (list == null && setList.length == setMetadata.length)
		{
			list = setList;
			metadata = setMetadata;
			return true;
		}
		else
		{
			return false;
		}
	}
	public Boolean setToDefaultList()
	{
		if (list == null && defaultList.length == defaultMetadata.length)
		{
			list = defaultList;
			metadata = defaultMetadata;
			return true;
		}
		else
		{
			return false;
		}
	}
	public Block[] getList()
	{
		return list;
	}
	public Integer[] getMetadata()
	{
		return metadata;
	}
	public static Boolean addToDefaultList (Item blacklist)
	{
		return true;
	}
	public static Boolean removeFromDefaultList (Item whitelist)
	{
		if (defaultList.length == defaultMetadata.length)
		{
			List<Block> listlist = Arrays.asList(defaultList);
			int whiteIndex = listlist.indexOf(whitelist);
			listlist.remove(whitelist);
			defaultList = listlist.toArray(new Block[listlist.size()]);
			List<Integer> listmetadata = Arrays.asList(defaultMetadata);
			listmetadata.remove(whiteIndex);
			defaultMetadata = listmetadata.toArray(new Integer[listmetadata.size()]);
			if (defaultList.length == defaultMetadata.length)
			{
				return true;
			}
		}
		return false;
	}
	public static void clearDefaultList ()
	{
		defaultList = new Block[] {null};
	}
	public static Boolean setDefaultList (Block[] setList)
	{
		if (defaultList.length == 0)
		{
			defaultList = setList;
			return true;
		}
		else
		{
			return false;
		}
	}
	public static Block[] getDefaultList ()
	{
		return defaultList;
	}
}
