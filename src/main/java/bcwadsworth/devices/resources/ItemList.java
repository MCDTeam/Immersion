package bcwadsworth.devices.resources;

import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

public class ItemList 
{
	private Item[] list;
	private static Item[] defaultList = null;
	public ItemList(Item[] initialList)
	{
		if (initialList == null)
		{
			this.setList(getDefaultList());
		}
		else
		{
			this.setList(initialList);
		}
	}
	public Boolean addToList (Item blacklist)
	{
		return true;
	}
	public Boolean removeFromList (Item whitelist)
	{
		return true;
	}
	public void clearList ()
	{
		list = new Item[] {null};
	}
	public Boolean setList (Item[] setList)
	{
		if (list == null)
		{
			list = setList;
			return true;
		}
		else
		{
			return false;
		}
	}
	public Boolean setToDefaultList()
	{
		if (list == null)
		{
			list = defaultList;
			return true;
		}
		else
		{
			return false;
		}
	}
	public Item[] getList ()
	{
		return list;
	}
	public static Boolean addToDefaultList (Item blacklist)
	{
		return true;
	}
	public static Boolean removeFromDefaultList (Item whitelist)
	{
		return true;
	}
	public static void clearDefaultList ()
	{
		defaultList = new Item[] {null};
	}
	public static Boolean setDefaultList (Item[] setList)
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
	public static Item[] getDefaultList ()
	{
		return defaultList;
	}
}
