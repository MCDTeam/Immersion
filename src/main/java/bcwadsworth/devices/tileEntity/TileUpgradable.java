package bcwadsworth.devices.tileEntity;

import java.util.Arrays;

import bcwadsworth.devices.items.upgrades.ItemUpgrade;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
 
public class TileUpgradable extends TileEntity implements ISidedInventory
{
	public ItemStack[] inventory;
	public Integer[] inventorySection;
	public ItemStack[][] uInventory;
	public Boolean[][] sectionInitialConstruction;
	public int[] sectionLength;
	public ItemUpgrade[] upgradeSlotContents;
	public Boolean[] sectionAcceptsItems;
	public String name;
	public String type;
	public int tier;
	
	
	public TileUpgradable()
	{
		tier = 0;
		inventory = new ItemStack[64];
		inventorySection = new Integer[64];
		uInventory = new ItemStack[8][8];
		Arrays.fill(inventorySection, 0);
	}
	
	public void constructSections(Boolean[]... sectionConstructRaw)
	{
		sectionInitialConstruction = sectionConstructRaw;
		sectionLength = new int[sectionInitialConstruction.length];
		for (int i = 0; i < sectionInitialConstruction.length; i++)
		{
			sectionLength[i] = sectionInitialConstruction[i].length;
		}
	}
	public void sectionsAcceptItems(Boolean... acceptItemsRaw)
	{
		if (acceptItemsRaw.length == (sectionLength.length - 1))
		{
			sectionAcceptsItems = acceptItemsRaw;
		}
	}
	public int getSectionForSlot (int slot)
	{
		
		return 0;
	}
	 
	@Override
    public int getSizeInventory()
    {
	    return inventory.length;
    }

	@Override
    public ItemStack getStackInSlot(int slot)
    {
	    if (inventorySection[slot] == 0)
	    {
	    	return null;
	    }
	    else 
	    {
	    	return inventory[slot];
	    }
    }

	@Override
    public ItemStack decrStackSize(int slot, int amount)
    {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) {
                if (stack.stackSize <= amount) {
                        setInventorySlotContents(slot, null);
                } else {
                        stack = stack.splitStack(amount);
                        if (stack.stackSize == 0) {
                                setInventorySlotContents(slot, null);
                        }
                }
        }
        return stack;
    }

	@Override
    public ItemStack getStackInSlotOnClosing(int slot)
    {
	    return inventory[slot];
    }

	@Override
    public void setInventorySlotContents(int slot, ItemStack item)
    {
	    if (inventorySection[slot] == 0)
	    {
	    	inventory[slot] = item;
	    }
	    
    }

	@Override
    public String getInventoryName()
    {
	    return name;
    }

	@Override
    public boolean hasCustomInventoryName()
    {
	   return false;
    }

	@Override
    public int getInventoryStackLimit()
    {
	    return 64;
    }

	@Override
    public boolean isUseableByPlayer(EntityPlayer player)
    {
        return ((worldObj.getTileEntity(xCoord, yCoord, zCoord) == this) && (player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64));
    }

	@Override
    public void openInventory()
    {
		for (ItemUpgrade i : upgradeSlotContents)
		{
			i.inventoryOpenEvent(name, type);
		}
	}

	@Override
    public void closeInventory()
	{
		for (ItemUpgrade i : upgradeSlotContents)
		{
			i.inventoryCloseEvent(name, type);
		}
	}
	
	@Override
	public void updateEntity()
	{
		
	}

	@Override
    public boolean isItemValidForSlot(int slot, ItemStack item)
    {
	    if (inventoryAvalible[slot])
	    {
	    	if (Arrays.asList(upgradeSlots).contains(slot))
	    	{
	    		if (ItemUpgrade.class.isAssignableFrom(item.getItem().getClass()))
	    		{
	    			ItemUpgrade upgrade = (ItemUpgrade) item.getItem();
	    			if (upgrade.isAllowed(tier))
	    			{
	    				return true;
	    			}
	    		}
	    			return false;
	    	}
	    	else if (sectionAcceptsItems[this.getSectionForSlot(slot)])
	    	{
	    		return true;
	    	}
	    	else
	    	{
	    		return false;
	    	}
	    }
	    else
	    {
	    	return false;
	    }
    }

	@Override
    public int[] getAccessibleSlotsFromSide(int var1)
    {
	    return null;
    }

	@Override
    public boolean canInsertItem(int slot, ItemStack item, int side)
    {
	    return false;
    }

	@Override
    public boolean canExtractItem(int slot, ItemStack item, int side)
    {
	    return false;
    }
	
	@Override
	public void readFromNBT(NBTTagCompound tagCompound)
	{
		super.readFromNBT(tagCompound);
		
		NBTTagList tagList = tagCompound.getTagList("Inventory", 0);
		for (int i = 0; i < tagList.tagCount(); i++)
		{
			NBTTagCompound tag = (NBTTagCompound) tagList.getCompoundTagAt(i);
			byte slot = tag.getByte("Slot");
			if (slot >= 0 && slot < inventory.length)
			{
				inventory[slot] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tagCompound)
	{
		NBTTagList list = new NBTTagList();
		for (int i = 0; i < inventory.length; i++)
		{
			ItemStack stack = inventory[i];
			if (stack != null)
			{
				NBTTagCompound tag = new NBTTagCompound();
				tag.setInteger("Slot", i);
				tag.setInteger("Section", inventorySection[i]);
				stack.writeToNBT(tag);
				list.appendTag(tag);
			}
		}
		tagCompound.setTag("Inventory", list);
		
		list = new NBTTagList();
		for (int i = 0; i < uInventory.length; i++)
		{
			for (int j = 0; j < uInventory[i].length; j++)
			{
				ItemStack stack = uInventory[i][j];
				if (stack != null)
				{
					NBTTagCompound tag = new NBTTagCompound();
					tag.setInteger("VSlot", i);
					tag.setInteger("HSlot", j);
					stack.writeToNBT(tag);
					list.appendTag(tag);
				}
			}
		}
		tagCompound.setTag("UpgradeInventory", list);
		
		super.writeToNBT(tagCompound);
	}
}