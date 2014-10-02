package teamUnknown.immersion.features.metallurgyFeature;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import teamUnknown.immersion.core.utils.Stack;
import teamUnknown.immersion.features.common.CommonFeature;
import teamUnknown.immersion.features.common.FeatureContext;
import teamUnknown.immersion.features.common.FeatureProperties;
import teamUnknown.immersion.features.oreGenFeature.ORef;

import java.util.Iterator;
import java.util.List;

/**
 *
 */
@FeatureProperties(name = "Metallurgy")
public class MetallurgyFeature extends CommonFeature {

    @Override
    protected void registerConfiguration(FeatureContext context) {
        super.registerConfiguration(context);

        List<IRecipe> recipes = CraftingManager.getInstance().getRecipeList();

        Iterator<IRecipe> iterator = recipes.iterator();
        while (iterator.hasNext())
        {
            ItemStack stack = iterator.next().getRecipeOutput();
            if (stack != null && stack.getItem() == Item.getItemFromBlock(Blocks.glowstone))
            {
                iterator.remove();
            }
            else if (stack != null && stack.getItem() == Item.getItemFromBlock(Blocks.redstone_block))
            {
                iterator.remove();
            }
            else if (stack != null && stack.getItem() == Item.getItemFromBlock(Blocks.quartz_block))
            {
                iterator.remove();
            }
            else if (stack != null && stack.getItem() instanceof ItemTool)
            {
                iterator.remove();
            }
        }

        //Add Smelting
        GameRegistry.addSmelting(ORef.blockGemImperfectRed, Stack.S(ORef.gemRed, 2), 0.5F);
        GameRegistry.addSmelting(ORef.gemRed, Stack.S(Items.redstone, 2), 0.5F);
        GameRegistry.addSmelting(Blocks.redstone_block, Stack.S(Items.redstone, 20), 0.5F);

        GameRegistry.addSmelting(ORef.blockGemImperfectQuartz, Stack.S(ORef.gemQuartz, 2), 0.5F);
        GameRegistry.addSmelting(ORef.gemQuartz, Stack.S(Items.quartz, 2), 0.5F);
        GameRegistry.addSmelting(Blocks.quartz_block, Stack.S(Items.quartz, 20), 0.5F);

        GameRegistry.addSmelting(ORef.blockGemImperfectDiamond, Stack.S(Items.diamond, 2), 0.5F);
        GameRegistry.addSmelting(Items.diamond, Stack.S(ORef.gemImperfectDiamond, 2), 0.5F);
        GameRegistry.addSmelting(Blocks.diamond_block, Stack.S(ORef.gemImperfectDiamond, 20), 0.5F);

        GameRegistry.addSmelting(ORef.blockGemImperfectEmerald, Stack.S(Items.emerald, 2), 0.5F);
        GameRegistry.addSmelting(Items.emerald, Stack.S(ORef.gemImperfectEmerald, 2), 0.5F);
        GameRegistry.addSmelting(Blocks.emerald_block, Stack.S(ORef.gemImperfectEmerald, 20), 0.5F);

        GameRegistry.addSmelting(ORef.blockGemImperfectEnd, Stack.S(ORef.gemEnd, 2), 0.5F);
        GameRegistry.addSmelting(ORef.gemEnd, Stack.S(ORef.gemImperfectEnd, 2), 0.5F);
        GameRegistry.addSmelting(ORef.blockGemEnd, Stack.S(ORef.gemImperfectEnd, 20), 0.5F);

        GameRegistry.addSmelting(Blocks.glowstone, Stack.S(ORef.gemGlow, 2), 0.5F);
        GameRegistry.addSmelting(ORef.gemGlow, Stack.S(Items.glowstone_dust, 2), 0.5F);
        GameRegistry.addSmelting(ORef.blockGemGlow, Stack.S(Items.glowstone_dust, 20), 0.5F);

        GameRegistry.addSmelting(Items.ender_pearl, Stack.S(ORef.gemImperfectEnd, 1), 0.5F);
        GameRegistry.addSmelting(ORef.gemImperfectEnd, Stack.S(Items.ender_pearl, 1), 0.5F);

        GameRegistry.addShapelessRecipe(Stack.S(ORef.fuelEnrichedCoal), Items.redstone, Items.redstone, Items.redstone, Items.redstone, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal);

    }
}
