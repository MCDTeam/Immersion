package teamUnknown.immersion.items;

import java.util.List;

import teamUnknown.immersion.ORef;
import teamUnknown.immersion.Stack;
import teamUnknown.immersion.blocks.BlockOre;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class ItemPartOre extends ItemMaterial {

	public ItemPartOre(String type) 
	{
		super(type + "Ore");
		maxStackSize = 1;
	}
	
	/*
	 * This is the only way to create an item stack for this
	 * If you do not you will not have any data
	 */
	public ItemStack addOre(BlockOre ore, int nuggets, ItemStack stack)
	{
		NBTTagList taglist = (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("Ores")) ? (NBTTagList) stack.stackTagCompound.getTag("BiggerDim") : new NBTTagList();
		NBTTagCompound tag = new NBTTagCompound();
		
		tag.setInteger("nuggets", nuggets);
		tag.setInteger("ore", ore.getIdFromBlock(ore));
		taglist.appendTag(tag);
		
		System.out.println(tag.getInteger("ore"));
		
		stack.stackTagCompound.setTag("Ores", taglist);
		
		return stack;
	}
	
	public NBTTagList getOreTag (ItemStack stack)
	{
		return (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("Ores")) ? (NBTTagList) stack.stackTagCompound.getTag("BiggerDim") : new NBTTagList();
	}
	
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) 
	{
		NBTTagList taglist = (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("Ores")) ? (NBTTagList) stack.stackTagCompound.getTag("BiggerDim") : new NBTTagList();
		if (taglist != new NBTTagList())
		{
			int id = taglist.getCompoundTagAt(0).getInteger("ore");
		
			list.add(Item.getItemById(id).getItemStackDisplayName(Stack.S(Item.getItemById(id))) + ", " + taglist.getCompoundTagAt(0).getInteger("nuggets"));	
		}
		super.addInformation(stack, player, list, par4);
	}

}
