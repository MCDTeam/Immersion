package teamUnknown.immersion.features.metallurgyFeature;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import teamUnknown.immersion.core.feature.Feature;
import teamUnknown.immersion.core.feature.FeatureCommon;
<<<<<<< HEAD
import teamUnknown.immersion.core.providers.IConfigurationProvider;
=======
>>>>>>> origin/Block-Registry---New
import teamUnknown.immersion.core.utils.Stack;
import teamUnknown.immersion.features.metallurgyFeature.items.ModBlocks;

import java.util.Iterator;
import java.util.List;

/**
 *
 */
<<<<<<< HEAD
@Feature(name = "Metallurgy", version = "0.1")
public class MetallurgyFeature extends FeatureCommon {

    @Feature.FeatureElement(Feature.FeatureElement.Element.CONFIGURATION)
    protected void registerConfiguration(IConfigurationProvider cfg) {
=======
@Feature(name = "Metallurgy", version = "1.0")
public class MetallurgyFeature extends FeatureCommon {

    @Feature.FeatureElement(Feature.FeatureElement.Element.CONFIGURATION)
    protected void registerConfiguration() {
>>>>>>> origin/Block-Registry---New

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
        GameRegistry.addSmelting(ModBlocks.blockGemImperfectRed, Stack.S(ModBlocks.gemRed, 2), 0.5F);
        GameRegistry.addSmelting(ModBlocks.gemRed, Stack.S(Items.redstone, 2), 0.5F);
        GameRegistry.addSmelting(Blocks.redstone_block, Stack.S(Items.redstone, 20), 0.5F);

        GameRegistry.addSmelting(ModBlocks.blockGemImperfectQuartz, Stack.S(ModBlocks.gemQuartz, 2), 0.5F);
        GameRegistry.addSmelting(ModBlocks.gemQuartz, Stack.S(Items.quartz, 2), 0.5F);
        GameRegistry.addSmelting(Blocks.quartz_block, Stack.S(Items.quartz, 20), 0.5F);

        GameRegistry.addSmelting(ModBlocks.blockGemImperfectDiamond, Stack.S(Items.diamond, 2), 0.5F);
        GameRegistry.addSmelting(Items.diamond, Stack.S(ModBlocks.gemImperfectDiamond, 2), 0.5F);
        GameRegistry.addSmelting(Blocks.diamond_block, Stack.S(ModBlocks.gemImperfectDiamond, 20), 0.5F);

        GameRegistry.addSmelting(ModBlocks.blockGemImperfectEmerald, Stack.S(Items.emerald, 2), 0.5F);
        GameRegistry.addSmelting(Items.emerald, Stack.S(ModBlocks.gemImperfectEmerald, 2), 0.5F);
        GameRegistry.addSmelting(Blocks.emerald_block, Stack.S(ModBlocks.gemImperfectEmerald, 20), 0.5F);

        GameRegistry.addSmelting(ModBlocks.blockGemImperfectEnd, Stack.S(ModBlocks.gemEnd, 2), 0.5F);
        GameRegistry.addSmelting(ModBlocks.gemEnd, Stack.S(ModBlocks.gemImperfectEnd, 2), 0.5F);
        GameRegistry.addSmelting(ModBlocks.blockGemEnd, Stack.S(ModBlocks.gemImperfectEnd, 20), 0.5F);

        GameRegistry.addSmelting(Blocks.glowstone, Stack.S(ModBlocks.gemGlow, 2), 0.5F);
        GameRegistry.addSmelting(ModBlocks.gemGlow, Stack.S(Items.glowstone_dust, 2), 0.5F);
        GameRegistry.addSmelting(ModBlocks.blockGemGlow, Stack.S(Items.glowstone_dust, 20), 0.5F);

        GameRegistry.addSmelting(Items.ender_pearl, Stack.S(ModBlocks.gemImperfectEnd, 1), 0.5F);
        GameRegistry.addSmelting(ModBlocks.gemImperfectEnd, Stack.S(Items.ender_pearl, 1), 0.5F);

        GameRegistry.addShapelessRecipe(Stack.S(ModBlocks.fuelEnrichedCoal), Items.redstone, Items.redstone, Items.redstone, Items.redstone, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal);

    }
}
