package bcwadsworth.devices.tileEntity;

import java.util.Arrays;

import bcwadsworth.devices.resources.api.components.ItemComponent;
import bcwadsworth.devices.resources.api.energy.EEnergyTypes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
 
public class TileMachineBox extends TileEntity implements ISidedInventory
{
	public ItemStack[] inventory;
	
	
	public TileMachineBox()
	{
		inventory = new ItemStack[25];
	}
	 
	@Override
    public int getSizeInventory()
    {
	    return inventory.length;
    }

	@Override
    public ItemStack getStackInSlot(int slot)
    {
	    	return inventory[slot];
    }

	@Override
    public ItemStack decrStackSize(int slot, int amount)
    {
        ItemStack stack = getStackInSlot(slot);
        if (stack != null) 
        {
			if (stack.stackSize <= amount) 
			{
				setInventorySlotContents(slot, null);
			} 
			else 
			{
				stack = stack.splitStack(amount);
				if (stack.stackSize == 0) 
				{
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
		inventory[slot] = item;
    }

	@Override
    public String getInventoryName()
    {
	    return "machineBox";
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

	}

	@Override
    public void closeInventory()
	{

	}
	
	@Override
	public void updateEntity()
	{
		
	}

	@Override
    public boolean isItemValidForSlot(int slot, ItemStack item)
    {
	    if (slot < 25)
	    {
	    	return true;
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
				stack.writeToNBT(tag);
				list.appendTag(tag);
			}
		}
		tagCompound.setTag("Inventory", list);
		
		super.writeToNBT(tagCompound);
	}
}