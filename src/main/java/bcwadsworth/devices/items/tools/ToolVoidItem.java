package bcwadsworth.devices.items.tools;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import bcwadsworth.devices.resources.BlockCompound;
import bcwadsworth.devices.resources.SHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolVoidItem extends Item
{
	public ToolVoidItem() 
	{
		maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName("toolVoidItem");
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) 
	{
		itemIcon = iconRegister.registerIcon("devices:toolVoid");
	}
    
	public ItemStack onItemRightClick(ItemStack itemStack, World world,	EntityPlayer player) 
	{
	    for (int k = 0; k < player.inventory.mainInventory.length; ++k)
	    {
	        ItemStack itemstack = player.inventory.mainInventory[k];
	        if (itemstack != null)
	        {
	            if (itemstack != itemStack)
	            {
	            	player.inventory.inventoryChanged = true;
	            	player.inventory.mainInventory[k] = null;
	            }
	        }
		}
		return itemStack;
    }
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) 
	{
		list.add("Goodbye Everything!");
		super.addInformation(stack, player, list, par4);
	}
	
}
