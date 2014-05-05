package bcwadsworth.devices.tileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileFurnaceUpgradable extends TileEntity implements ISidedInventory
{
	public ItemStack[] inventory;
	public Boolean[] inventoryAvalible;
	
	public TileFurnaceUpgradable()
	{
		inventory = new ItemStack[28];
		inventoryAvalible = new Boolean[28];
		for (int i = 1; i <= 28; i++)
		{
			if (i == 1 || i == 9 || i == 17 || i == 25 || i == 26 || i == 27 || i == 28)
			{
				inventoryAvalible[i] = true;
			}
			else
			{
				inventoryAvalible[i] = false;
			}
		}
	}
	
	@Override
    public int getSizeInventory()
    {
	    return inventory.length;
    }

	@Override
    public ItemStack getStackInSlot(int slot)
    {
	    if (inventoryAvalible[slot])
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
	    if (inventoryAvalible[slot])
	    {
	    	inventory[slot] = item;
	    }
	    
    }

	@Override
    public String getInventoryName()
    {
	    return "upgradeableFurnace";
    }

	@Override
    public boolean hasCustomInventoryName()
    {
	   return true;
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
    public boolean isItemValidForSlot(int slot, ItemStack item)
    {
	    if (inventoryAvalible[slot])
	    {
	    	if (slot <= 16)
	    	{
	    		return true;
	    	}
	    	else if (slot >= 25)
	    	{
	    		return true;
	    	}
	    }
	    else
	    {
	    	return false;
	    }
	    return false;
    }

	@Override
    public int[] getAccessibleSlotsFromSide(int var1)
    {
	    // TODO Auto-generated method stub
	    return null;
    }

	@Override
    public boolean canInsertItem(int slot, ItemStack item, int side)
    {
	    // TODO Auto-generated method stub
	    return false;
    }

	@Override
    public boolean canExtractItem(int slot, ItemStack item, int side)
    {
	    // TODO Auto-generated method stub
	    return false;
    }
	
}
