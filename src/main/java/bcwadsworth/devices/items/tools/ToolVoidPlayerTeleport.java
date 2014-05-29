package bcwadsworth.devices.items.tools;

import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import bcwadsworth.devices.resources.core.BlockCompound;
import bcwadsworth.devices.resources.core.BlockList;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolVoidPlayerTeleport extends Item
{
	public ToolVoidPlayerTeleport() 
	{
		maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabTools);
		setUnlocalizedName("toolVoidBlockRanged");
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) 
	{
		itemIcon = iconRegister.registerIcon("devices:toolVoid");
	}
	
	public void onCreated(ItemStack stack, World world, EntityPlayer pplayer)
	{
		NBTTagList nbttaglist = new NBTTagList();
		NBTTagCompound tag = new NBTTagCompound();
		
		tag.setInteger("x", 0);
		tag.setInteger("y", 0);
		tag.setInteger("z", 0);
		tag.setInteger("dim", 0);
		nbttaglist.appendTag(tag);
		stack.stackTagCompound.setTag("Position", nbttaglist);
	}
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer EntityPlayer) 
	{
		NBTTagList nbttaglist = (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("Position") ? (NBTTagList) stack.stackTagCompound.getTag("Position") : new NBTTagList());
		NBTTagCompound tag = new NBTTagCompound();
		if (world.isRemote) 
		{
			
		} 
		else 
		{
			if (EntityPlayer.isSneaking())
			{
				tag.setDouble("x", EntityPlayer.posX);
				tag.setDouble("y", EntityPlayer.posY);
				tag.setDouble("z", EntityPlayer.posZ);
				tag.setInteger("dim", EntityPlayer.dimension);
				nbttaglist = new NBTTagList();
    	        stack.setTagCompound(new NBTTagCompound());
    	        nbttaglist.appendTag(tag);
                stack.stackTagCompound.setTag("BiggerDim", nbttaglist);
			}
			if (!EntityPlayer.isSneaking()) 
			{
				double X = nbttaglist.getCompoundTagAt(0).getDouble("x");
				double Y = nbttaglist.getCompoundTagAt(0).getDouble("y");
				double Z = nbttaglist.getCompoundTagAt(0).getDouble("z");
				int dim = nbttaglist.getCompoundTagAt(0).getInteger("dim");
				EntityPlayer.dimension = dim;
				EntityPlayer.setPositionAndUpdate(X, Y, Z);
			}
		}
		return stack;
    }
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) 
	{
		list.add("Player here, player there!");
		NBTTagList nbttaglist = (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("Position") ? (NBTTagList) stack.stackTagCompound.getTag("BiggerDim") : new NBTTagList());
		int X = nbttaglist.getCompoundTagAt(0).getInteger("x");
		int Y = nbttaglist.getCompoundTagAt(0).getInteger("y");
		int Z = nbttaglist.getCompoundTagAt(0).getInteger("z");
		list.add("Teleporting to: X-" + X + " Y-" + Y + " Z-" + Z);
		super.addInformation(stack, player, list, par4);
	}
}

