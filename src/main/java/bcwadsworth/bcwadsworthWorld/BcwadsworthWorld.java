package bcwadsworth.bcwadsworthWorld;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
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
		
		ORef.ORegistration();
		log.debug("Blocks/Items Loaded");
		
		log.info("Pre-Init Finished");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) 
	{
		log.info("Init Version: " + ModConfig.VERSION);
		
		GameRegistry.registerWorldGenerator(new OreGeneration(), 0);
		log.debug("Ore Generator Loaded");
		
		GameRegistry.registerFuelHandler(new FuelHandler());
		log.debug("Fuel Handler Loaded");
		
		MinecraftForge.ORE_GEN_BUS.register(new EventHooks());
		log.debug("Event Busses Loaded");
				
		this.craftingRegistration();
		log.debug("Crafting/Smelting Loaded");
		
		OreDictionary.registerOre("oreGemEnd", ORef.oreGemEnd);
		
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
		
		GameRegistry.addSmelting(ORef.chunkCopper, Stack.S(ORef.ingotCopper), .05F);
		GameRegistry.addSmelting(ORef.chunkTin, Stack.S(ORef.ingotTin), .05F);
		GameRegistry.addSmelting(ORef.chunkBronze, Stack.S(ORef.ingotBronze), .05F);
		GameRegistry.addSmelting(ORef.chunkIron, Stack.S(Items.iron_ingot), .05F);
		GameRegistry.addSmelting(ORef.chunkSteel, Stack.S(ORef.ingotSteel), .05F);
		GameRegistry.addSmelting(ORef.chunkGold, Stack.S(Items.gold_ingot), .05F);
		
		GameRegistry.addShapelessRecipe(Stack.S(ORef.chunkBronze, 4), ORef.chunkTin, ORef.chunkCopper, ORef.chunkCopper, ORef.chunkCopper);
		GameRegistry.addShapelessRecipe(Stack.S(ORef.chunkSteel, 4), Items.coal, ORef.chunkIron, ORef.chunkIron, ORef.chunkIron);
		
		GameRegistry.addShapelessRecipe(Stack.S(ORef.fuelEnrichedCoal), Items.redstone, Items.redstone, Items.redstone, Items.redstone, Items.coal, Items.coal, Items.coal, Items.coal, Items.coal);
	}
}