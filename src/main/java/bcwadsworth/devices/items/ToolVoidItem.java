package bcwadsworth.devices.items;

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
import net.minecraft.world.World;
import bcwadsworth.devices.resources.BlockCompound;
import bcwadsworth.devices.resources.BlockList;
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
		itemIcon = iconRegister.registerIcon("devices:toolVoidBlock");
	}
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world,	EntityPlayer player) 
	{
		MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(world, player, true);
		if (movingobjectposition == null || world.isRemote) 
		{
			
		} 
		else 
		{
			if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) 
			{
				int X = movingobjectposition.blockX;
				int Y = movingobjectposition.blockY;
				int Z = movingobjectposition.blockZ;

				BlockCompound block = BlockCompound.get(world, X, Y, Z);
				ItemStack stack = block.getStack();
				
				NBTTagCompound tag = new NBTTagCompound();
				NBTTagList nbttaglist = (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("Items") ? (NBTTagList) stack.stackTagCompound.getTag("Items") : new NBTTagList());
				tag.setInteger("item", Item.getIdFromItem(stack.getItem()));
	            nbttaglist.appendTag(tag);
	            itemStack.setTagCompound(new NBTTagCompound());
		        itemStack.getTagCompound().setTag("Items", nbttaglist);
			}
		}
		return itemStack;
    }
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) 
	{
		NBTTagList nbttaglist = (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("Items") ? (NBTTagList) stack.stackTagCompound.getTag("Items") : new NBTTagList());

		if (nbttaglist != null) 
		{
			for (int i = 0; i < nbttaglist.tagCount(); ++i) 
			{
				int itemid = nbttaglist.getCompoundTagAt(i).getInteger("item");

				list.add(Item.getItemById(itemid));
			}
		}

		super.addInformation(stack, player, list, par4);
	}
	
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		NBTTagList nbttaglist = (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("Items") ? (NBTTagList) stack.stackTagCompound.getTag("Items") : new NBTTagList());

		if (nbttaglist != null) 
		{
			if (player.isSneaking())
			{
				stack.setTagCompound(new NBTTagCompound());
			}
			else
			{
				for (int i = 0; i < nbttaglist.tagCount(); ++i) 
				{
					int itemid = nbttaglist.getCompoundTagAt(i).getInteger("item");

					player.inventory.clearInventory(Item.getItemById(itemid), -1);
				}
			}
		}
        return true;
    }
	
}
