package bcwadsworth.bcwadsworthWorld;

import java.util.Iterator;
import java.util.List;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.oredict.OreDictionary;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import bcwadsworth.bcwadsworthWorld.Blocks.BlockStorage;
import bcwadsworth.bcwadsworthWorld.Blocks.BlockOre;
import bcwadsworth.bcwadsworthWorld.Blocks.FuelEnrichedCoal;
import bcwadsworth.bcwadsworthWorld.Items.ItemMaterial;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = ModConfig.MODID, name = ModConfig.NAME, version = ModConfig.VERSION)
public class BcwadsworthWorld 
{
	public static Logger log = LogManager.getLogger(ModConfig.MODID);
	
	@Instance(ModConfig.MODID)
	public static BcwadsworthWorld instance;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) 
	{	
		log.info("Pre-Init Version: " + ModConfig.VERSION);
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		ModConfig.configLoad(config);
		log.debug("Config Loaded");
		
		log.info("Pre-Init Finished");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) 
	{

		log.info("Init Version: " + ModConfig.VERSION);
		
		OreGeneration generator = new OreGeneration();
	
		GameRegistry.registerWorldGenerator(generator, 0);
		log.debug("Ore Generator Loaded");
		
		MinecraftForge.ORE_GEN_BUS.register(generator);
		log.debug("Event Busses Loaded");
		
		GameRegistry.registerFuelHandler(new FuelHandler());
		log.debug("Fuel Handler Loaded");
				
		this.craftingRegistration();
		log.debug("Crafting/Smelting Loaded");
		
		log.info(GameRegistry.getFuelValue(Stack.S(Blocks.coal_block)));
		
		log.info("Init Finished");
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent event)
	{
		log.info("Post-Init Version: " + ModConfig.VERSION);
		log.info("Post-Init Finished");
	}
	
	private void craftingRegistration()
	{
		//Remove all vanilla unsupported recipies
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
	/*	
		//Smelting to ingots: Will change to nbt related nugget processing once I figure out how
		GameRegistry.addSmelting(ORef.chunkCopper, Stack.S(ORef.ingotCopper), .05F);
		GameRegistry.addSmelting(ORef.chunkTin, Stack.S(ORef.ingotTin), .05F);
		GameRegistry.addSmelting(ORef.chunkBronze, Stack.S(ORef.ingotBronze), .05F);
		GameRegistry.addSmelting(ORef.chunkIron, Stack.S(Items.iron_ingot), .05F);
		GameRegistry.addSmelting(ORef.chunkSteel, Stack.S(ORef.ingotSteel), .05F);
		GameRegistry.addSmelting(ORef.chunkGold, Stack.S(Items.gold_ingot), .05F);
		
		//Alloying Recipies: Will change to nbt related nugget processing once I figure out how
		GameRegistry.addShapelessRecipe(Stack.S(ORef.chunkBronze, 4), ORef.chunkTin, ORef.chunkCopper, ORef.chunkCopper, ORef.chunkCopper);
		GameRegistry.addShapelessRecipe(Stack.S(ORef.chunkSteel, 4), Items.coal, ORef.chunkIron, ORef.chunkIron, ORef.chunkIron);
	*/
		GameRegistry.addShapelessRecipe(Stack.S(ORef.chunkGold), Blocks.gravel, Items.gold_ingot);
		
		GameRegistry.addShapelessRecipe(Stack.S(ORef.fuelEnrichedCoal), Items.redstone, Items.redstone, Items.redstone, Items.redstone, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal);
	}
}