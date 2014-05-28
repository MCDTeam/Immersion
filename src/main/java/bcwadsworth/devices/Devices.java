package bcwadsworth.devices;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.event.terraingen.OreGenEvent;
import bcwadsworth.devices.resources.ORef;
import bcwadsworth.devices.blocks.BlockGemOre;
import bcwadsworth.devices.blocks.BlockImperfectOre;
import bcwadsworth.devices.blocks.FuelEnrichedCoal;
import bcwadsworth.devices.items.ItemCircuit;
import bcwadsworth.devices.items.ItemGem;
import bcwadsworth.devices.items.ItemMatrix;
import bcwadsworth.devices.items.tools.ToolHoe;
import bcwadsworth.devices.items.tools.ToolPickaxe;
import bcwadsworth.devices.items.tools.ToolShovel;
import bcwadsworth.devices.items.tools.ToolSword;
import bcwadsworth.devices.items.tools.ToolTransformBlock;
import bcwadsworth.devices.items.tools.ToolVoidBlock;
import bcwadsworth.devices.items.tools.ToolVoidBlockRanged;
import bcwadsworth.devices.items.tools.ToolVoidItem;
import bcwadsworth.devices.items.tools.ToolVoidItemBlack;
import bcwadsworth.devices.items.tools.ToolVoidItemWhite;
import bcwadsworth.devices.items.tools.ToolVoidTile;
import bcwadsworth.devices.resources.ConfigLoad;
import bcwadsworth.devices.resources.General;
import bcwadsworth.devices.resources.ToolArmorMaterial;
import bcwadsworth.devices.resources.core.SHandler;
import bcwadsworth.devices.EventHooks;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = General.MODID, name = General.NAME, version = General.VERSION)
public class Devices 
{
	@Instance(General.MODID)
	public static Devices instance;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) 
	{
		System.out.println("Pre-Initializing Devices Version " + General.VERSION);
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		
		this.configLoad(config);
		
		this.itemRegistration();
		
		this.blockRegistration();

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
		
		MinecraftForge.ORE_GEN_BUS.register(new EventHooks());
		
		this.craftingRegistration();
		
		System.out.println("Devices: Initialized");
	}
	
	private void configLoad(Configuration config)
	{
		config.load();
		
		// Checking for defaults, skipping loading if defaultconfig is true
		String CATEGORYDEFAULTS = "Defaults";
		if (config.get(CATEGORYDEFAULTS, "Use the Default Config", true).getBoolean(true))
		{
			return;
		}
		
		// Features Category
		if (!config.get(CATEGORYDEFAULTS, "Use the Default Features", true).getBoolean(true))
		{
			String CATEGORYFEATURES = "Features";
			ConfigLoad.GEMCRAFTABLE = config.get(CATEGORYFEATURES, "Gems Craftable / Uncraftable", ConfigLoad.GEMCRAFTABLE).getBoolean(ConfigLoad.GEMCRAFTABLE);
			ConfigLoad.GEMEMERALDTOOLS = config.get(CATEGORYFEATURES, "Emerald Tools", ConfigLoad.GEMEMERALDTOOLS).getBoolean(ConfigLoad.GEMEMERALDTOOLS);
			ConfigLoad.GEMGLOWTOOLS = config.get(CATEGORYFEATURES, "Glowstone Gem Tools", ConfigLoad.GEMGLOWTOOLS).getBoolean(ConfigLoad.GEMGLOWTOOLS);
			ConfigLoad.GEMQUARTZTOOLS = config.get(CATEGORYFEATURES, "Quartz Tools", ConfigLoad.GEMQUARTZTOOLS).getBoolean(ConfigLoad.GEMQUARTZTOOLS);
			ConfigLoad.GEMENDTOOLS = config.get(CATEGORYFEATURES, "End Gem Tools", ConfigLoad.GEMENDTOOLS).getBoolean(ConfigLoad.GEMENDTOOLS);
			ConfigLoad.VOIDTOOLS = config.get(CATEGORYFEATURES, "Void Tools", ConfigLoad.VOIDTOOLS).getBoolean(ConfigLoad.VOIDTOOLS);
		}
		
		// OreGen Category
		if (!config.get(CATEGORYDEFAULTS, "Use the Default Ore Generation", true).getBoolean(true))
		{
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
			
			ConfigLoad.OREGEMDIAMONDGENERATE = config.get(CATEGORYOREGEN, "Generate Diamond Gem Ore", ConfigLoad.OREGEMDIAMONDGENERATE).getBoolean(ConfigLoad.OREGEMDIAMONDGENERATE);
			if (ConfigLoad.OREGEMDIAMONDGENERATE)
			{
				ConfigLoad.OREGEMDIAMONDCHUNKDENSITY = config.get(CATEGORYOREGEN, "Diamond Gem Ore Chunk Density", ConfigLoad.OREGEMDIAMONDCHUNKDENSITY).getInt(ConfigLoad.OREGEMDIAMONDCHUNKDENSITY);
				ConfigLoad.OREGEMDIAMONDYMIN = config.get(CATEGORYOREGEN, "Diamond Gem Ore Minimum Y", ConfigLoad.OREGEMDIAMONDYMIN).getInt(ConfigLoad.OREGEMDIAMONDYMIN);
				ConfigLoad.OREGEMDIAMONDYMAX = config.get(CATEGORYOREGEN, "Diamond Gem Ore Maximum Y", ConfigLoad.OREGEMDIAMONDYMAX).getInt(ConfigLoad.OREGEMDIAMONDYMAX);
				ConfigLoad.OREGEMDIAMONDGENERATEMIN = config.get(CATEGORYOREGEN, "Diamond Gem Ore Minimum Generated", ConfigLoad.OREGEMDIAMONDGENERATEMIN).getInt(ConfigLoad.OREGEMDIAMONDGENERATEMIN);
				ConfigLoad.OREGEMDIAMONDGENERATEMAX = config.get(CATEGORYOREGEN, "Diamond Gem Ore Maximum Generated", ConfigLoad.OREGEMDIAMONDGENERATEMAX).getInt(ConfigLoad.OREGEMDIAMONDGENERATEMAX);
			}
			
			ConfigLoad.OREGEMEMERALDGENERATE = config.get(CATEGORYOREGEN, "Generate Emerald Gem Ore", ConfigLoad.OREGEMEMERALDGENERATE).getBoolean(ConfigLoad.OREGEMEMERALDGENERATE);
			if (ConfigLoad.OREGEMEMERALDGENERATE)
			{
				ConfigLoad.OREGEMEMERALDCHUNKDENSITY = config.get(CATEGORYOREGEN, "Emerald Gem Ore Chunk Density", ConfigLoad.OREGEMEMERALDCHUNKDENSITY).getInt(ConfigLoad.OREGEMEMERALDCHUNKDENSITY);
				ConfigLoad.OREGEMEMERALDYMIN = config.get(CATEGORYOREGEN, "Emerald Gem Ore Minimum Y", ConfigLoad.OREGEMEMERALDYMIN).getInt(ConfigLoad.OREGEMEMERALDYMIN);
				ConfigLoad.OREGEMEMERALDYMAX = config.get(CATEGORYOREGEN, "Emerald Gem Ore Maximum Y", ConfigLoad.OREGEMEMERALDYMAX).getInt(ConfigLoad.OREGEMEMERALDYMAX);
				ConfigLoad.OREGEMEMERALDGENERATEMIN = config.get(CATEGORYOREGEN, "Emerald Gem Ore Minimum Generated", ConfigLoad.OREGEMEMERALDGENERATEMIN).getInt(ConfigLoad.OREGEMEMERALDGENERATEMIN);
				ConfigLoad.OREGEMEMERALDGENERATEMAX = config.get(CATEGORYOREGEN, "Emerald Gem Ore Maximum Generated", ConfigLoad.OREGEMEMERALDGENERATEMAX).getInt(ConfigLoad.OREGEMEMERALDGENERATEMAX);
			}
			
			
			ConfigLoad.OREGEMGLOWGENERATE = config.get(CATEGORYOREGEN, "Generate Glowstone Gem Ore", ConfigLoad.OREGEMGLOWGENERATE).getBoolean(ConfigLoad.OREGEMGLOWGENERATE);
			if (ConfigLoad.OREGEMGLOWGENERATE)
			{
				ConfigLoad.OREGEMGLOWCHUNKDENSITY = config.get(CATEGORYOREGEN, "Glowstone Gem Ore Chunk Density", ConfigLoad.OREGEMGLOWCHUNKDENSITY).getInt(ConfigLoad.OREGEMGLOWCHUNKDENSITY);
				ConfigLoad.OREGEMGLOWYMIN = config.get(CATEGORYOREGEN, "Glowstone Gem Ore Minimum Y", ConfigLoad.OREGEMGLOWYMIN).getInt(ConfigLoad.OREGEMGLOWYMIN);
				ConfigLoad.OREGEMGLOWYMAX = config.get(CATEGORYOREGEN, "Glowstone Gem Ore Maximum Y", ConfigLoad.OREGEMGLOWYMAX).getInt(ConfigLoad.OREGEMGLOWYMAX);
				ConfigLoad.OREGEMGLOWGENERATEMIN = config.get(CATEGORYOREGEN, "Glowstone Gem Ore Minimum Generated", ConfigLoad.OREGEMGLOWGENERATEMIN).getInt(ConfigLoad.OREGEMGLOWGENERATEMIN);
				ConfigLoad.OREGEMGLOWGENERATEMAX = config.get(CATEGORYOREGEN, "Glowstone Gem Ore Maximum Generated", ConfigLoad.OREGEMGLOWGENERATEMAX).getInt(ConfigLoad.OREGEMGLOWGENERATEMAX);
			}
			
			ConfigLoad.OREGEMQUARTZGENERATE = config.get(CATEGORYOREGEN, "Generate Quartz Gem Ore", ConfigLoad.OREGEMQUARTZGENERATE).getBoolean(ConfigLoad.OREGEMQUARTZGENERATE);
			if (ConfigLoad.OREGEMQUARTZGENERATE)
			{
				ConfigLoad.OREGEMQUARTZCHUNKDENSITY = config.get(CATEGORYOREGEN, "Quartz Gem Ore Chunk Density", ConfigLoad.OREGEMQUARTZCHUNKDENSITY).getInt(ConfigLoad.OREGEMQUARTZCHUNKDENSITY);
				ConfigLoad.OREGEMQUARTZYMIN = config.get(CATEGORYOREGEN, "Quartz Gem Ore Minimum Y", ConfigLoad.OREGEMQUARTZYMIN).getInt(ConfigLoad.OREGEMQUARTZYMIN);
				ConfigLoad.OREGEMQUARTZYMAX = config.get(CATEGORYOREGEN, "Quartz Gem Ore Maximum Y", ConfigLoad.OREGEMQUARTZYMAX).getInt(ConfigLoad.OREGEMQUARTZYMAX);
				ConfigLoad.OREGEMQUARTZGENERATEMIN = config.get(CATEGORYOREGEN, "Quartz Gem Ore Minimum Generated", ConfigLoad.OREGEMQUARTZGENERATEMIN).getInt(ConfigLoad.OREGEMQUARTZGENERATEMIN);
				ConfigLoad.OREGEMQUARTZGENERATEMAX = config.get(CATEGORYOREGEN, "Quartz Gem Ore Maximum Generated", ConfigLoad.OREGEMQUARTZGENERATEMAX).getInt(ConfigLoad.OREGEMQUARTZGENERATEMAX);
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
		}
	}
	
	private void itemRegistration()
	{
		ORef.gemRed = new ItemGem("Red");
		GameRegistry.registerItem(ORef.gemRed, "gemRed");	
		ORef.gemEnd = new ItemGem("End");
		GameRegistry.registerItem(ORef.gemEnd, "gemEnd");
		ORef.gemGlow = new ItemGem("Glow");
		GameRegistry.registerItem(ORef.gemGlow, "gemGlow");
		ORef.gemQuartz = new ItemGem("Quartz");
		GameRegistry.registerItem(ORef.gemQuartz, "gemQuartz");
		
		ORef.circuitCapacitative = new ItemCircuit("Capacitative");
		GameRegistry.registerItem(ORef.circuitCapacitative, "circuitCapacitative");
		ORef.circuitComputational = new ItemCircuit("Computational");
		GameRegistry.registerItem(ORef.circuitComputational, "circuitComputational");
		ORef.circuitEnergetic = new ItemCircuit("Energetic");
		GameRegistry.registerItem(ORef.circuitEnergetic, "circuitEnergetic");
		ORef.circuitRandom = new ItemCircuit("Random");
		GameRegistry.registerItem(ORef.circuitRandom, "circuitRandom");
		ORef.circuitTransforming = new ItemCircuit("Transforming");
		GameRegistry.registerItem(ORef.circuitTransforming, "circuitTransforming");		
		ORef.circuitVoid = new ItemCircuit("Void");
		GameRegistry.registerItem(ORef.circuitVoid, "circuitVoid");
		
		ORef.matrixRandom = new ItemMatrix("Random");
		GameRegistry.registerItem(ORef.matrixRandom, "matrixRandom");
		ORef.matrixStorage = new ItemMatrix("Storage");
		GameRegistry.registerItem(ORef.matrixStorage, "matrixStorage");
		
		ORef.pickaxeGemRed = new ToolPickaxe(ToolArmorMaterial.gemRed);
		GameRegistry.registerItem(ORef.pickaxeGemRed, "pickaxeGemRed");
		ORef.pickaxeGemDiamond = new ToolPickaxe(ToolArmorMaterial.gemDiamond);
		GameRegistry.registerItem(ORef.pickaxeGemDiamond, "pickaxeGemDiamond");
		ORef.pickaxeGemEmerald = new ToolPickaxe(ToolArmorMaterial.gemEmerald);
		GameRegistry.registerItem(ORef.pickaxeGemEmerald, "pickaxeGemEmerald");
		ORef.pickaxeGemGlow = new ToolPickaxe(ToolArmorMaterial.gemGlow);
		GameRegistry.registerItem(ORef.pickaxeGemGlow, "pickaxeGemGlow");
		ORef.pickaxeGemEnd = new ToolPickaxe(ToolArmorMaterial.gemEnd);
		GameRegistry.registerItem(ORef.pickaxeGemEnd, "pickaxeGemEnd");
		ORef.pickaxeGemQuartz = new ToolPickaxe(ToolArmorMaterial.gemQuartz);
		GameRegistry.registerItem(ORef.pickaxeGemQuartz, "pickaxeGemQuartz");
		ORef.pickaxeLapis = new ToolPickaxe(ToolArmorMaterial.lapis);
		GameRegistry.registerItem(ORef.pickaxeLapis, "pickaxeLapis");
		ORef.pickaxeObsidian = new ToolPickaxe(ToolArmorMaterial.obsidian);
		GameRegistry.registerItem(ORef.pickaxeObsidian, "pickaxeObsidian");
		
		ORef.axeGemRed = new ToolHoe(ToolArmorMaterial.gemRed);
		GameRegistry.registerItem(ORef.axeGemRed, "axeGemRed");
		ORef.axeGemDiamond = new ToolHoe(ToolArmorMaterial.gemDiamond);
		GameRegistry.registerItem(ORef.axeGemDiamond, "axeGemDiamond");
		ORef.axeGemEmerald = new ToolHoe(ToolArmorMaterial.gemEmerald);
		GameRegistry.registerItem(ORef.axeGemEmerald, "axeGemEmerald");
		ORef.axeGemGlow = new ToolHoe(ToolArmorMaterial.gemGlow);
		GameRegistry.registerItem(ORef.axeGemGlow, "axeGemGlow");
		ORef.axeGemEnd = new ToolHoe(ToolArmorMaterial.gemEnd);
		GameRegistry.registerItem(ORef.axeGemEnd, "axeGemEnd");
		ORef.axeGemQuartz = new ToolHoe(ToolArmorMaterial.gemQuartz);
		GameRegistry.registerItem(ORef.axeGemQuartz, "axeGemQuartz");
		ORef.axeLapis = new ToolHoe(ToolArmorMaterial.lapis);
		GameRegistry.registerItem(ORef.axeLapis, "axeLapis");
		ORef.axeObsidian = new ToolHoe(ToolArmorMaterial.obsidian);
		GameRegistry.registerItem(ORef.axeObsidian, "axeObsidian");
		
		ORef.shovelGemRed = new ToolShovel(ToolArmorMaterial.gemRed);
		GameRegistry.registerItem(ORef.shovelGemRed, "shovelGemRed");
		ORef.shovelGemDiamond = new ToolShovel(ToolArmorMaterial.gemDiamond);
		GameRegistry.registerItem(ORef.shovelGemDiamond, "shovelGemDiamond");
		ORef.shovelGemEmerald = new ToolShovel(ToolArmorMaterial.gemEmerald);
		GameRegistry.registerItem(ORef.shovelGemEmerald, "shovelGemEmerald");
		ORef.shovelGemGlow = new ToolShovel(ToolArmorMaterial.gemGlow);
		GameRegistry.registerItem(ORef.shovelGemGlow, "shovelGemGlow");
		ORef.shovelGemEnd = new ToolShovel(ToolArmorMaterial.gemEnd);
		GameRegistry.registerItem(ORef.shovelGemEnd, "shovelGemEnd");
		ORef.shovelGemQuartz = new ToolShovel(ToolArmorMaterial.gemQuartz);
		GameRegistry.registerItem(ORef.shovelGemQuartz, "shovelGemQuartz");
		ORef.shovelLapis = new ToolShovel(ToolArmorMaterial.lapis);
		GameRegistry.registerItem(ORef.shovelLapis, "shovelLapis");
		ORef.shovelObsidian = new ToolShovel(ToolArmorMaterial.obsidian);
		GameRegistry.registerItem(ORef.shovelObsidian, "shovelObsidian");
		
		ORef.swordGemRed = new ToolSword(ToolArmorMaterial.gemRed);
		GameRegistry.registerItem(ORef.swordGemRed, "swordGemRed");
		ORef.swordGemDiamond = new ToolSword(ToolArmorMaterial.gemDiamond);
		GameRegistry.registerItem(ORef.swordGemDiamond, "swordGemDiamond");
		ORef.swordGemEmerald = new ToolSword(ToolArmorMaterial.gemEmerald);
		GameRegistry.registerItem(ORef.swordGemEmerald, "swordGemEmerald");
		ORef.swordGemGlow = new ToolSword(ToolArmorMaterial.gemGlow);
		GameRegistry.registerItem(ORef.swordGemGlow, "swordGemGlow");
		ORef.swordGemEnd = new ToolSword(ToolArmorMaterial.gemEnd);
		GameRegistry.registerItem(ORef.swordGemEnd, "swordGemEnd");
		ORef.swordGemQuartz = new ToolSword(ToolArmorMaterial.gemQuartz);
		GameRegistry.registerItem(ORef.swordGemQuartz, "swordGemQuartz");
		ORef.swordLapis = new ToolSword(ToolArmorMaterial.lapis);
		GameRegistry.registerItem(ORef.swordLapis, "swordLapis");
		ORef.swordObsidian = new ToolSword(ToolArmorMaterial.obsidian);
		GameRegistry.registerItem(ORef.swordObsidian, "swordObsidian");
		
		ORef.hoeGemRed = new ToolHoe(ToolArmorMaterial.gemRed);
		GameRegistry.registerItem(ORef.hoeGemRed, "hoeGemRed");
		ORef.hoeGemDiamond = new ToolHoe(ToolArmorMaterial.gemDiamond);
		GameRegistry.registerItem(ORef.hoeGemDiamond, "hoeGemDiamond");
		ORef.hoeGemEmerald = new ToolHoe(ToolArmorMaterial.gemEmerald);
		GameRegistry.registerItem(ORef.hoeGemEmerald, "hoeGemEmerald");
		ORef.hoeGemGlow = new ToolHoe(ToolArmorMaterial.gemGlow);
		GameRegistry.registerItem(ORef.hoeGemGlow, "hoeGemGlow");
		ORef.hoeGemEnd = new ToolHoe(ToolArmorMaterial.gemEnd);
		GameRegistry.registerItem(ORef.hoeGemEnd, "hoeGemEnd");
		ORef.hoeGemQuartz = new ToolHoe(ToolArmorMaterial.gemQuartz);
		GameRegistry.registerItem(ORef.hoeGemQuartz, "hoeGemQuartz");
		ORef.hoeLapis = new ToolHoe(ToolArmorMaterial.lapis);
		GameRegistry.registerItem(ORef.hoeLapis, "hoeLapis");
		ORef.hoeObsidian = new ToolHoe(ToolArmorMaterial.obsidian);
		GameRegistry.registerItem(ORef.hoeObsidian, "hoeObsidian");
		
		ORef.toolTransformBlock = new ToolTransformBlock();
		GameRegistry.registerItem(ORef.toolTransformBlock, "toolTransformBlock");
		ORef.toolVoidBlock = new ToolVoidBlock();
		GameRegistry.registerItem(ORef.toolVoidBlock, "toolVoidBlock");
		ORef.toolVoidBlockRanged = new ToolVoidBlockRanged();
		GameRegistry.registerItem(ORef.toolVoidBlockRanged, "toolVoidBlockRanged");
		ORef.toolVoidItem = new ToolVoidItem();
		GameRegistry.registerItem(ORef.toolVoidItem, "toolVoidItem");
		ORef.toolVoidItemWhite = new ToolVoidItemWhite();
		GameRegistry.registerItem(ORef.toolVoidItemWhite, "toolVoidItemWhite");
		ORef.toolVoidItemBlack = new ToolVoidItemBlack();
		GameRegistry.registerItem(ORef.toolVoidItemBlack, "toolVoidItemBlack");
		ORef.toolVoidTile = new ToolVoidTile();
		GameRegistry.registerItem(ORef.toolVoidTile, "toolVoidTile");
		
		if (ConfigLoad.DEBUG)
		{
			System.out.println("Devices: Items Loaded");
		}
	}
	
	private void blockRegistration()
	{	
		ORef.oreGemRed = new BlockGemOre("Red", ORef.gemRed);
		GameRegistry.registerBlock(ORef.oreGemRed, "oreGemRed");		
		ORef.oreGemEnd = new BlockGemOre("End", ORef.gemEnd);
		GameRegistry.registerBlock(ORef.oreGemEnd, "oreGemEnd");
		ORef.oreGemDiamond = new BlockGemOre("Diamond", Items.diamond);
		GameRegistry.registerBlock(ORef.oreGemDiamond, "oreGemDiamond");
		ORef.oreGemEmerald = new BlockGemOre("Emerald", Items.emerald);
		GameRegistry.registerBlock(ORef.oreGemEmerald, "oreGemEmerald");
		ORef.oreGemQuartz = new BlockGemOre("Quartz", ORef.gemQuartz);
		GameRegistry.registerBlock(ORef.oreGemQuartz, "oreGemQuartz");
		ORef.oreGemGlow = new BlockGemOre("Glow", ORef.gemGlow);
		GameRegistry.registerBlock(ORef.oreGemGlow, "oreGemGlow");
		
		ORef.oreImperfectDiamond = new BlockImperfectOre("Diamond", Items.diamond);
		
		ORef.fuelEnrichedCoal = new FuelEnrichedCoal();
		GameRegistry.registerBlock(ORef.fuelEnrichedCoal, "fuelEnrichedCoal");
		
		if (ConfigLoad.DEBUG)
		{
			System.out.println("Devices: Blocks Loaded");
		}
	}
	
	private void craftingRegistration()
	{
		GameRegistry.addShapedRecipe(SHandler.S(ORef.circuitCapacitative), "aba","bcb","aba", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Items.ender_pearl), 'c', SHandler.S(Items.quartz));
		GameRegistry.addShapedRecipe(SHandler.S(ORef.circuitCapacitative), "bab","aca","bab", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Items.ender_pearl), 'c', SHandler.S(Items.quartz));
		GameRegistry.addShapedRecipe(SHandler.S(ORef.circuitComputational), "aba","bcb","aba", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Items.gold_ingot), 'c', SHandler.S(Items.diamond));
		GameRegistry.addShapedRecipe(SHandler.S(ORef.circuitComputational), "bab","aca","bab", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Items.gold_ingot), 'c', SHandler.S(Items.diamond));
		GameRegistry.addShapedRecipe(SHandler.S(ORef.circuitEnergetic), "aba","bcb","aba", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Items.quartz), 'c', SHandler.S(ORef.gemRed));
		GameRegistry.addShapedRecipe(SHandler.S(ORef.circuitEnergetic), "bab","aca","bab", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Items.quartz), 'c', SHandler.S(ORef.gemRed));
		GameRegistry.addShapedRecipe(SHandler.S(ORef.circuitRandom), "aba","bcb","aba", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(ORef.matrixRandom), 'c', SHandler.S(Items.emerald));
		GameRegistry.addShapedRecipe(SHandler.S(ORef.circuitRandom), "bab","aca","bab", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(ORef.matrixRandom), 'c', SHandler.S(Items.emerald));
		GameRegistry.addShapedRecipe(SHandler.S(ORef.circuitTransforming), "aba","bcb","aba", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Blocks.obsidian), 'c', SHandler.S(Blocks.glowstone));
		GameRegistry.addShapedRecipe(SHandler.S(ORef.circuitTransforming), "bab","aca","bab", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Blocks.obsidian), 'c', SHandler.S(Blocks.glowstone));
		GameRegistry.addShapedRecipe(SHandler.S(ORef.circuitVoid), "aba","bcb","aba", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Items.ender_pearl), 'c', SHandler.S(ORef.gemEnd));
		GameRegistry.addShapedRecipe(SHandler.S(ORef.circuitVoid), "bab","aca","bab", 'a', SHandler.S(Items.redstone), 'b', SHandler.S(Items.ender_pearl), 'c', SHandler.S(ORef.gemEnd));
		
		GameRegistry.addShapelessRecipe(SHandler.S(ORef.matrixRandom, 2), SHandler.S(Blocks.flower_pot), SHandler.S(Blocks.wooden_door), SHandler.S(Items.arrow), SHandler.S(Items.baked_potato));
		GameRegistry.addShapelessRecipe(SHandler.S(ORef.matrixStorage, 2), SHandler.S(Blocks.chest), SHandler.S(Items.quartz), SHandler.S(Items.book), SHandler.S(Items.bed));
		
		
		if (ConfigLoad.VOIDTOOLS)
		{
			GameRegistry.addShapedRecipe(SHandler.S(ORef.toolVoidBlock), "aba","bcb","aba", 'a', SHandler.S(Items.emerald), 'b', SHandler.S(ORef.circuitVoid), 'c', SHandler.S(Blocks.stone));
			GameRegistry.addShapedRecipe(SHandler.S(ORef.toolVoidBlock), "bab","aca","bab", 'a', SHandler.S(Items.emerald), 'b', SHandler.S(ORef.circuitVoid), 'c', SHandler.S(Blocks.stone));
		}
		
		if (ConfigLoad.GEMCRAFTABLE)
		{
			GameRegistry.addSmelting(Blocks.redstone_block, SHandler.S(ORef.gemRed, 2), 0.1F);
			GameRegistry.addSmelting(ORef.gemRed, SHandler.S(Items.redstone, 2), 0.1F);
			GameRegistry.addSmelting(Blocks.quartz_block, SHandler.S(ORef.gemQuartz, 1), 0.1F);
			GameRegistry.addSmelting(ORef.gemQuartz, SHandler.S(Items.quartz, 1), 0.1F);
		}
		
		if (ConfigLoad.DEBUG)
		{
			System.out.println("Devices: Recipies Loaded");
		}
	}
}