package teamUnknown.immersion.features.metallurgyFeature.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import teamUnknown.immersion.core.utils.NBTHelper;
import teamUnknown.immersion.core.utils.Stack;

import java.util.List;

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

    //TODO CAUSES CRASH
	/**@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4) 
	{
		//NBTTagList taglist = (stack.stackTagCompound != null && stack.stackTagCompound.hasKey("Ores")) ? (NBTTagList) stack.stackTagCompound.getTag("BiggerDim") : new NBTTagList();
        NBTTagList tagList = (NBTHelper.hasTag(stack, "Ores") ? (NBTHelper.getString(stack, "BiggerDim")) : new NBTTagList();
        if (taglist != new NBTTagList())
		{
			//int id = taglist.getCompoundTagAt(0).getInteger("ore");
            int id = NBTHelper.getInt(stack, "ore");
		
			list.add(getItemById(id).getItemStackDisplayName(Stack.S(getItemById(id))) + ", " + NBTHelper.getInt(stack, "nuggets"));
            //list.add(getItemById(id).getItemStackDisplayName(Stack.S(getItemById(id))) + ", " + taglist.getCompoundTagAt(0).getInteger("nuggets"));
		}
		super.addInformation(stack, player, list, par4);
	}**/

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
    {
        boolean hasKeys = (NBTHelper.hasTag(stack, "ores") && (NBTHelper.hasTag(stack, "BiggerDim")));

        if(hasKeys){
            int id = NBTHelper.getInt(stack, "ore");

            list.add(getItemById(id).getItemStackDisplayName(Stack.S(getItemById(id))) + ", " + NBTHelper.getInt(stack, "nuggets"));
        }
    }
}
