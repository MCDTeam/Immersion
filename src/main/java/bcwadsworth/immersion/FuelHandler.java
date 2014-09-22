package bcwadsworth.immersion;

import bcwadsworth.immersion.ORef;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler
{
	@Override
	public int getBurnTime (ItemStack fuel)
	{
		Item item = fuel.getItem();
		if (item == Item.getItemFromBlock(ORef.fuelEnrichedCoal))
		{
			return 12800;
		}
		if (ModConfig.ADDITIONALFUELS)
		{
			if (item == Items.paper)
			{
				return 50;
			}
			if (item == Items.book)
			{
				return 150;
			}
			if (item == Items.boat)
			{
				return 300;
			}
			if (item == Items.fishing_rod)
			{
				return 200;
			}
			if (item == Items.bow)
			{
				return 200;
			}
			if (item == Items.arrow)
			{
				return 25;
			}
			if (item == Items.bowl)
			{
				return 100;
			}
			if (item == Items.sign)
			{
				return 100;
			}
		}
		
		// I am re-registering the vanilla blocks here to make sure that they are loaded into the GameRegistry
        if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
        {
            Block block = Block.getBlockFromItem(item);

            if (block == Blocks.wooden_slab)
            {
                return 150;
            }

            if (block.getMaterial() == Material.wood)
            {
                return 300;
            }

            if (block == Blocks.coal_block)
            {
                return 16000;
            }
        }

        if (item instanceof ItemTool && ((ItemTool)item).getToolMaterialName().equals("WOOD")) return 200;
        if (item instanceof ItemSword && ((ItemSword)item).getToolMaterialName().equals("WOOD")) return 200;
        if (item instanceof ItemHoe && ((ItemHoe)item).getToolMaterialName().equals("WOOD")) return 200;
        if (item == Items.stick) return 100;
        if (item == Items.coal) return 1600;
        if (item == Items.lava_bucket) return 20000;
        if (item == Item.getItemFromBlock(Blocks.sapling)) return 100;
        if (item == Items.blaze_rod) return 2400;
		return 0;
	}
}
