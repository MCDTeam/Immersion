package bcwadsworth.devices.items.tools;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;
import bcwadsworth.devices.resources.BlockCompound;
import bcwadsworth.devices.resources.BlockList;
import bcwadsworth.devices.resources.SHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolVoidItemWhite extends Item
{
	public ToolVoidItemWhite() 
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
		NBTTagList nbttaglist = (itemStack.stackTagCompound != null && itemStack.stackTagCompound.hasKey("Items") ? (NBTTagList) itemStack.stackTagCompound.getTag("Items") : new NBTTagList());
		MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(world, player, true);
		if (player.isSneaking() && movingobjectposition == null)
		{
	        itemStack.setTagCompound(new NBTTagCompound());
		}
		else if (player.isSneaking() && movingobjectposition.typeOfHit == MovingObjectType.BLOCK) 
		{
			int X = movingobjectposition.blockX;
			int Y = movingobjectposition.blockY;
			int Z = movingobjectposition.blockZ;

			BlockCompound block = BlockCompound.get(world, X, Y, Z);
			ItemStack stack = block.getStack();
				
			NBTTagCompound tag = new NBTTagCompound();
			tag.setInteger("item", Item.getIdFromItem(stack.getItem()));
			tag.setInteger("damage", stack.getItemDamage());
			for (int i = 0; i < nbttaglist.tagCount(); ++i) 
			{
				NBTTagCompound item = nbttaglist.getCompoundTagAt(i);
				if (item == tag)
				{
					return itemStack;
				}
			}

	        nbttaglist.appendTag(tag);
	        itemStack.setTagCompound(new NBTTagCompound());
		    itemStack.getTagCompound().setTag("Items", nbttaglist);
		}
		if (!player.isSneaking() && nbttaglist != null) 
		{
			for (int i = 0; i < nbttaglist.tagCount(); ++i) 
			{
				int itemid = nbttaglist.getCompoundTagAt(i).getInteger("item");
				int itemdamage = nbttaglist.getCompoundTagAt(i).getInteger("damage");
			    for (int k = 0; k < player.inventory.mainInventory.length; ++k)
			    {
			        ItemStack itemstack = player.inventory.mainInventory[k];
			        if (itemstack != null)
			        {
			        	if (itemstack.getItem() == Item.getItemById(itemid) && itemstack.getItemDamage() == itemdamage)
			            {
			            	player.inventory.mainInventory[k] = null;
			            }
			        }
			    }
			}
		}
		return itemStack;
    }
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) 
	{
		list.add("Goodbye Somethings!");
		NBTTagList nbttaglist = (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("Items") ? (NBTTagList) stack.stackTagCompound.getTag("Items") : new NBTTagList());

		if (nbttaglist != null) 
		{
			for (int i = 0; i < nbttaglist.tagCount(); ++i) 
			{
				int itemid = nbttaglist.getCompoundTagAt(i).getInteger("item");
				int itemdamage = nbttaglist.getCompoundTagAt(i).getInteger("damage");

				list.add(Item.getItemById(itemid).getItemStackDisplayName(SHandler.SM(Item.getItemById(itemid), itemdamage)));
			}
		}

		super.addInformation(stack, player, list, par4);
	}
}
