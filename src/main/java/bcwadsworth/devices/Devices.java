package bcwadsworth.devices;

//Blocks
import bcwadsworth.devices.blocks.FuelEnrichedCoal;
import bcwadsworth.devices.blocks.OreGemEnd;
import bcwadsworth.devices.blocks.OreGemRed;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;

//Items
import bcwadsworth.devices.items.CircuitCapacitative;
import bcwadsworth.devices.items.CircuitComputational;
import bcwadsworth.devices.items.CircuitEnergetic;
import bcwadsworth.devices.items.CircuitRandom;
import bcwadsworth.devices.items.CircuitTransforming;
import bcwadsworth.devices.items.CircuitVoid;
import bcwadsworth.devices.items.GemEnd;
import bcwadsworth.devices.items.GemRed;
import bcwadsworth.devices.items.MatrixRandom;
import bcwadsworth.devices.items.ToolVoidBlock;
import bcwadsworth.devices.items.ToolVoidLiquid;
import net.minecraft.item.Item;
import net.minecraft.init.Items;

//Loaders

//Refrence Classes
import bcwadsworth.devices.resources.General;
import bcwadsworth.devices.resources.ConfigLoad;
import bcwadsworth.devices.resources.SHandler;

//Internals
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = General.MODID, name = General.NAME, version = General.VERSION)
public class Devices {
	@Instance(General.MODID)
	public static Devices instance;

	public static Item gemRed;
	public static Item gemEnd;
	public static Item circuitCapacitative;
	public static Item circuitComputational;
	public static Item circuitEnergetic;
	public static Item circuitRandom;
	public static Item circuitTransforming;
	public static Item circuitVoid;
	public static Item matrixRandom;
	public static Item toolVoidLiquid;
	public static Item toolVoidBlock;
	
	public static Block oreGemRed;
	public static Block oreGemEnd;
	public static Block fuelEnrichedCoal;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) 
	{
		System.out.println("Pre-Initializing Devices Version " + General.VERSION);
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		//General Category
		String CATEGORYFEATURES = "Features";
		ConfigLoad.DEBUG = config.get(CATEGORYFEATURES, "Debug Mode Active", ConfigLoad.DEBUG).getBoolean(ConfigLoad.DEBUG);
		ConfigLoad.GEMCRAFTABLE = config.get(CATEGORYFEATURES, "Gems Craftable / Uncraftable", ConfigLoad.GEMCRAFTABLE).getBoolean(ConfigLoad.GEMCRAFTABLE);
		ConfigLoad.GEMEMERALDTOOLS = config.get(CATEGORYFEATURES, "Emerald Tools", ConfigLoad.GEMEMERALDTOOLS).getBoolean(ConfigLoad.GEMEMERALDTOOLS);
		ConfigLoad.GEMGLOWTOOLS = config.get(CATEGORYFEATURES, "Glowstone Gem Tools", ConfigLoad.GEMGLOWTOOLS).getBoolean(ConfigLoad.GEMGLOWTOOLS);
		ConfigLoad.GEMQUARTZTOOLS = config.get(CATEGORYFEATURES, "Quartz Tools", ConfigLoad.GEMQUARTZTOOLS).getBoolean(ConfigLoad.GEMQUARTZTOOLS);
		ConfigLoad.GEMENDTOOLS = config.get(CATEGORYFEATURES, "End Gem Tools", ConfigLoad.GEMENDTOOLS).getBoolean(ConfigLoad.GEMENDTOOLS);
		ConfigLoad.VOIDTOOLS = config.get(CATEGORYFEATURES, "Void Tools", ConfigLoad.VOIDTOOLS).getBoolean(ConfigLoad.VOIDTOOLS);
		
		//OreGen Category
		String CATEGORYOREGEN = "Ore Generation";
		ConfigLoad.OREGENERATIONATTEMPTS = config.get(CATEGORYOREGEN, "Ore Generation Attempts", ConfigLoad.OREGENERATIONATTEMPTS).getInt(ConfigLoad.OREGENERATIONATTEMPTS);
		ConfigLoad.OREGEMREDGENERATE = config.get(CATEGORYOREGEN, "Generate Redstone Gem Ore", ConfigLoad.OREGEMREDGENERATE).getBoolean(ConfigLoad.OREGEMREDGENERATE);
		if (ConfigLoad.OREGEMREDGENERATE)
		{
			ConfigLoad.OREGEMREDCHUNKDENSITY = config.get(CATEGORYOREGEN, "Redstone Gem Ore Chunk Density", ConfigLoad.OREGEMREDCHUNKDENSITY).getInt(ConfigLoad.OREGEMREDCHUNKDENSITY);
			ConfigLoad.OREGEMREDYMIN = config.get(CATEGORYOREGEN, "Redstone Gem Ore Minimum Y", ConfigLoad.OREGEMREDYMIN).getInt(ConfigLoad.OREGEMREDYMIN);
			ConfigLoad.OREGEMREDYMAX = config.get(CATEGORYOREGEN, "Redstone Gem Ore Maximum Y", ConfigLoad.OREGEMREDYMAX).getInt(ConfigLoad.OREGEMREDYMAX);
			ConfigLoad.OREGEMREDGENERATEMIN = config.get(CATEGORYOREGEN, "Redstone Gem Ore Minimum Generated", ConfigLoad.OREGEMREDGENERATEMIN).getInt(ConfigLoad.OREGEMREDGENERATEMIN);
			ConfigLoad.OREGEMREDGENERATEMAX = config.get(CATEGORYOREGEN, "Redstone Gem Ore Maximum Generated", ConfigLoad.OREGEMREDGENERATEMAX).getInt(ConfigLoad.OREGEMREDGENERATEMAX);
		}
		ConfigLoad.OREGEMENDGENERATE = config.get(CATEGORYOREGEN, "Generate End Gem Ore", ConfigLoad.OREGEMENDGENERATE).getBoolean(ConfigLoad.OREGEMENDGENERATE);
		if (ConfigLoad.OREGEMENDGENERATE)
		{
			ConfigLoad.OREGEMENDCHUNKDENSITY = config.get(CATEGORYOREGEN, "End Gem Ore Chunk Density", ConfigLoad.OREGEMENDCHUNKDENSITY).getInt(ConfigLoad.OREGEMENDCHUNKDENSITY);
			ConfigLoad.OREGEMENDGENERATEMIN = config.get(CATEGORYOREGEN, "End Gem Ore Minimum Generated", ConfigLoad.OREGEMENDGENERATEMIN).getInt(ConfigLoad.OREGEMENDGENERATEMIN);
			ConfigLoad.OREGEMENDGENERATEMAX = config.get(CATEGORYOREGEN, "End Gem Ore Maximum Generated", ConfigLoad.OREGEMENDGENERATEMAX).getInt(ConfigLoad.OREGEMENDGENERATEMAX);
		}
		
		config.save();
		if (ConfigLoad.DEBUG)
		{
			System.out.println("Devices: Config Loaded");
		}
		
		gemRed = new GemRed();
		GameRegistry.registerItem(gemRed, "gemRed");
		
		gemEnd = new GemEnd();
		GameRegistry.registerItem(gemEnd, "gemEnd");
		
		circuitCapacitative = new CircuitCapacitative();
		GameRegistry.registerItem(circuitCapacitative, "circuitCapacitative");
		
		circuitComputational = new CircuitComputational();
		GameRegistry.registerItem(circuitComputational, "circuitComputational");
		
		circuitEnergetic = new CircuitEnergetic();
		GameRegistry.registerItem(circuitEnergetic, "circuitEnergetic");
		
		circuitRandom = new CircuitRandom();
		GameRegistry.registerItem(circuitRandom, "circuitRandom");
		
		circuitTransforming = new CircuitTransforming();
		GameRegistry.registerItem(circuitTransforming, "circuitTransforming");
		
		circuitVoid = new CircuitVoid();
		GameRegistry.registerItem(circuitVoid, "circuitVoid");
		
		matrixRandom = new MatrixRandom();
		GameRegistry.registerItem(matrixRandom, "matrixRandom");
		
		toolVoidLiquid = new ToolVoidLiquid();
		GameRegistry.registerItem(toolVoidLiquid, "toolVoidLiquid");
		
		toolVoidBlock = new ToolVoidBlock();
		GameRegistry.registerItem(toolVoidBlock, "toolVoidBlock");
		
		if (ConfigLoad.DEBUG)
		{
			System.out.println("Devices: Items Loaded");
		}
		
		
		oreGemRed = new OreGemRed();
		GameRegistry.registerBlock(oreGemRed, "oreGemRed");
		
		oreGemEnd = new OreGemEnd();
		GameRegistry.registerBlock(oreGemEnd, "oreGemEnd");
		
		fuelEnrichedCoal = new FuelEnrichedCoal();
		GameRegistry.registerBlock(fuelEnrichedCoal, "fuelEnrichedCoal");
		
		if (ConfigLoad.DEBUG)
		{
			System.out.println("Devices: Blocks Loaded");
		}

		System.out.println("Devices: Pre-Initialized");

	}

	@EventHandler
	public void init(FMLInitializationEvent event) 
	{
		System.out.println("Initializing Devices Version " + General.VERSION);
		
		GameRegistry.registerWorldGenerator(new OreGeneration(),0);
		if (ConfigLoad.DEBUG)
		{
			System.out.println("World Generator Loaded");
		}
		GameRegistry.registerFuelHandler(new FuelHandler());
		if (ConfigLoad.DEBUG)
		{
			System.out.println("Fuel Handler Loaded");
		}
		
		GameRegistry.addShapedRecipe(SHandler.S(circuitCapacitative), "aba","bcb","aba", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Items.ender_pearl), 'c', SHandler.S(Items.quartz));
		GameRegistry.addShapedRecipe(SHandler.S(circuitCapacitative), "bab","aca","bab", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Items.ender_pearl), 'c', SHandler.S(Items.quartz));
		GameRegistry.addShapedRecipe(SHandler.S(circuitComputational), "aba","bcb","aba", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Items.gold_ingot), 'c', SHandler.S(Items.diamond));
		GameRegistry.addShapedRecipe(SHandler.S(circuitComputational), "bab","aca","bab", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Items.gold_ingot), 'c', SHandler.S(Items.diamond));
		GameRegistry.addShapedRecipe(SHandler.S(circuitEnergetic), "aba","bcb","aba", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Items.quartz), 'c', SHandler.S(gemRed));
		GameRegistry.addShapedRecipe(SHandler.S(circuitEnergetic), "bab","aca","bab", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Items.quartz), 'c', SHandler.S(gemRed));
		GameRegistry.addShapedRecipe(SHandler.S(circuitRandom), "aba","bcb","aba", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(matrixRandom), 'c', SHandler.S(Items.emerald));
		GameRegistry.addShapedRecipe(SHandler.S(circuitRandom), "bab","aca","bab", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(matrixRandom), 'c', SHandler.S(Items.emerald));
		GameRegistry.addShapedRecipe(SHandler.S(circuitTransforming), "aba","bcb","aba", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Blocks.obsidian), 'c', SHandler.S(Blocks.glowstone));
		GameRegistry.addShapedRecipe(SHandler.S(circuitTransforming), "bab","aca","bab", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Blocks.obsidian), 'c', SHandler.S(Blocks.glowstone));
		GameRegistry.addShapedRecipe(SHandler.S(circuitVoid), "aba","bcb","aba", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Items.ender_pearl), 'c', SHandler.S(gemEnd));
		GameRegistry.addShapedRecipe(SHandler.S(circuitVoid), "bab","aca","bab", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Items.ender_pearl), 'c', SHandler.S(gemEnd));
		
		GameRegistry.addShapelessRecipe(SHandler.S(matrixRandom, 2), SHandler.S(Blocks.flower_pot), SHandler.S(Blocks.wooden_door), SHandler.S(Items.arrow), SHandler.S(Items.baked_potato));
		
		if (ConfigLoad.VOIDTOOLS)
		{
			GameRegistry.addShapedRecipe(SHandler.S(toolVoidLiquid), "aba","bcb","aba", 'a', SHandler.S(gemRed), 'b', SHandler.S(circuitVoid), 'c', SHandler.S(Items.bucket));
			GameRegistry.addShapedRecipe(SHandler.S(toolVoidLiquid), "bab","aca","bab", 'a', SHandler.S(gemRed), 'b', SHandler.S(circuitVoid), 'c', SHandler.S(Items.bucket));
			GameRegistry.addShapedRecipe(SHandler.S(toolVoidBlock), "aba","bcb","aba", 'a', SHandler.S(Items.emerald), 'b', SHandler.S(circuitVoid), 'c', SHandler.S(Blocks.stone));
			GameRegistry.addShapedRecipe(SHandler.S(toolVoidBlock), "bab","aca","bab", 'a', SHandler.S(Items.emerald), 'b', SHandler.S(circuitVoid), 'c', SHandler.S(Blocks.stone));
		}
		
		if (ConfigLoad.GEMCRAFTABLE)
		{
			GameRegistry.addSmelting(Blocks.redstone_block, SHandler.S(gemRed, 2), 0.1F);
			GameRegistry.addSmelting(gemRed, SHandler.S(Items.redstone, 2), 0.1F);
		}
		
		if (ConfigLoad.DEBUG)
		{
			System.out.println("Devices: Recipies Loaded");
		}
		
		System.out.println("Devices: Initialized");
	}
}