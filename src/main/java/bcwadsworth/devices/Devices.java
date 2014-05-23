package bcwadsworth.devices;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
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
import bcwadsworth.devices.resources.ConfigLoad;
import bcwadsworth.devices.resources.General;
import bcwadsworth.devices.resources.SHandler;
import bcwadsworth.devices.resources.ToolArmorMaterial;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid = General.MODID, name = General.NAME, version = General.VERSION)
public class Devices {
	@Instance(General.MODID)
	public static Devices instance;

	public static ItemGem gemRed;
	public static ItemGem gemEnd;
	public static ItemGem gemGlow;
	public static ItemGem gemQuartz;
	public static ItemCircuit circuitCapacitative;
	public static ItemCircuit circuitComputational;
	public static ItemCircuit circuitEnergetic;
	public static ItemCircuit circuitRandom;
	public static ItemCircuit circuitTransforming;
	public static ItemCircuit circuitVoid;
	public static ItemMatrix matrixRandom;
	public static ItemMatrix matrixStorage;
	public static Item toolTransformBlock;
	public static Item toolVoidBlock;
	public static Item toolVoidBlockRanged;
	public static Item toolVoidItem;
	public static Item toolVoidItemWhite;
	public static Item toolVoidItemBlack;
	public static ToolPickaxe pickaxeGemRed;
	public static ToolPickaxe pickaxeGemEnd;
	public static ToolPickaxe pickaxeGemDiamond;
	public static ToolPickaxe pickaxeGemEmerald;
	public static ToolPickaxe pickaxeGemQuartz;
	public static ToolPickaxe pickaxeGemGlow;
	public static ToolPickaxe pickaxeLapis;
	public static ToolPickaxe pickaxeObsidian;
	public static ToolHoe axeGemRed;
	public static ToolHoe axeGemEnd;
	public static ToolHoe axeGemDiamond;
	public static ToolHoe axeGemEmerald;
	public static ToolHoe axeGemQuartz;
	public static ToolHoe axeGemGlow;
	public static ToolHoe axeLapis;
	public static ToolHoe axeObsidian;
	public static ToolShovel shovelGemRed;
	public static ToolShovel shovelGemEnd;
	public static ToolShovel shovelGemDiamond;
	public static ToolShovel shovelGemEmerald;
	public static ToolShovel shovelGemQuartz;
	public static ToolShovel shovelGemGlow;
	public static ToolShovel shovelLapis;
	public static ToolShovel shovelObsidian;
	public static ToolSword swordGemRed;
	public static ToolSword swordGemEnd;
	public static ToolSword swordGemDiamond;
	public static ToolSword swordGemEmerald;
	public static ToolSword swordGemQuartz;
	public static ToolSword swordGemGlow;
	public static ToolSword swordLapis;
	public static ToolSword swordObsidian;
	public static ToolHoe hoeGemRed;
	public static ToolHoe hoeGemEnd;
	public static ToolHoe hoeGemDiamond;
	public static ToolHoe hoeGemEmerald;
	public static ToolHoe hoeGemQuartz;
	public static ToolHoe hoeGemGlow;
	public static ToolHoe hoeLapis;
	public static ToolHoe hoeObsidian;
	
	public static BlockGemOre oreGemRed;
	public static BlockGemOre oreGemEnd;
	public static BlockGemOre oreGemDiamond;
	public static BlockGemOre oreGemEmerald;
	public static BlockGemOre oreGemQuartz;
	public static BlockGemOre oreGemGlow;
	public static BlockImperfectOre oreImperfectDiamond;
	public static Block fuelEnrichedCoal;

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
		
		this.craftingRegistration();
		
		System.out.println("Devices: Initialized");
	}
	
	private void configLoad(Configuration config)
	{
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
	
	private void itemRegistration()
	{
		gemRed = new ItemGem("Red");
		GameRegistry.registerItem(gemRed, "gemRed");	
		gemEnd = new ItemGem("End");
		GameRegistry.registerItem(gemEnd, "gemEnd");
		gemGlow = new ItemGem("Glow");
		GameRegistry.registerItem(gemGlow, "gemGlow");
		gemQuartz = new ItemGem("Quartz");
		GameRegistry.registerItem(gemQuartz, "gemQuartz");
		
		circuitCapacitative = new ItemCircuit("Capacitative");
		GameRegistry.registerItem(circuitCapacitative, "circuitCapacitative");
		circuitComputational = new ItemCircuit("Computational");
		GameRegistry.registerItem(circuitComputational, "circuitComputational");
		circuitEnergetic = new ItemCircuit("Energetic");
		GameRegistry.registerItem(circuitEnergetic, "circuitEnergetic");
		circuitRandom = new ItemCircuit("Random");
		GameRegistry.registerItem(circuitRandom, "circuitRandom");
		circuitTransforming = new ItemCircuit("Transforming");
		GameRegistry.registerItem(circuitTransforming, "circuitTransforming");		
		circuitVoid = new ItemCircuit("Void");
		GameRegistry.registerItem(circuitVoid, "circuitVoid");
		
		matrixRandom = new ItemMatrix("Random");
		GameRegistry.registerItem(matrixRandom, "matrixRandom");
		matrixStorage = new ItemMatrix("Storage");
		GameRegistry.registerItem(matrixStorage, "matrixStorage");
		
		pickaxeGemRed = new ToolPickaxe(ToolArmorMaterial.gemRed);
		GameRegistry.registerItem(pickaxeGemRed, "pickaxeGemRed");
		pickaxeGemDiamond = new ToolPickaxe(ToolArmorMaterial.gemDiamond);
		GameRegistry.registerItem(pickaxeGemDiamond, "pickaxeGemDiamond");
		pickaxeGemEmerald = new ToolPickaxe(ToolArmorMaterial.gemEmerald);
		GameRegistry.registerItem(pickaxeGemEmerald, "pickaxeGemEmerald");
		pickaxeGemGlow = new ToolPickaxe(ToolArmorMaterial.gemGlow);
		GameRegistry.registerItem(pickaxeGemGlow, "pickaxeGemGlow");
		pickaxeGemEnd = new ToolPickaxe(ToolArmorMaterial.gemEnd);
		GameRegistry.registerItem(pickaxeGemEnd, "pickaxeGemEnd");
		pickaxeGemQuartz = new ToolPickaxe(ToolArmorMaterial.gemQuartz);
		GameRegistry.registerItem(pickaxeGemQuartz, "pickaxeGemQuartz");
		pickaxeLapis = new ToolPickaxe(ToolArmorMaterial.lapis);
		GameRegistry.registerItem(pickaxeLapis, "pickaxeLapis");
		pickaxeObsidian = new ToolPickaxe(ToolArmorMaterial.obsidian);
		GameRegistry.registerItem(pickaxeObsidian, "pickaxeObsidian");
		
		axeGemRed = new ToolHoe(ToolArmorMaterial.gemRed);
		GameRegistry.registerItem(axeGemRed, "axeGemRed");
		axeGemDiamond = new ToolHoe(ToolArmorMaterial.gemDiamond);
		GameRegistry.registerItem(axeGemDiamond, "axeGemDiamond");
		axeGemEmerald = new ToolHoe(ToolArmorMaterial.gemEmerald);
		GameRegistry.registerItem(axeGemEmerald, "axeGemEmerald");
		axeGemGlow = new ToolHoe(ToolArmorMaterial.gemGlow);
		GameRegistry.registerItem(axeGemGlow, "axeGemGlow");
		axeGemEnd = new ToolHoe(ToolArmorMaterial.gemEnd);
		GameRegistry.registerItem(axeGemEnd, "axeGemEnd");
		axeGemQuartz = new ToolHoe(ToolArmorMaterial.gemQuartz);
		GameRegistry.registerItem(axeGemQuartz, "axeGemQuartz");
		axeLapis = new ToolHoe(ToolArmorMaterial.lapis);
		GameRegistry.registerItem(axeLapis, "axeLapis");
		axeObsidian = new ToolHoe(ToolArmorMaterial.obsidian);
		GameRegistry.registerItem(axeObsidian, "axeObsidian");
		
		shovelGemRed = new ToolShovel(ToolArmorMaterial.gemRed);
		GameRegistry.registerItem(shovelGemRed, "shovelGemRed");
		shovelGemDiamond = new ToolShovel(ToolArmorMaterial.gemDiamond);
		GameRegistry.registerItem(shovelGemDiamond, "shovelGemDiamond");
		shovelGemEmerald = new ToolShovel(ToolArmorMaterial.gemEmerald);
		GameRegistry.registerItem(shovelGemEmerald, "shovelGemEmerald");
		shovelGemGlow = new ToolShovel(ToolArmorMaterial.gemGlow);
		GameRegistry.registerItem(shovelGemGlow, "shovelGemGlow");
		shovelGemEnd = new ToolShovel(ToolArmorMaterial.gemEnd);
		GameRegistry.registerItem(shovelGemEnd, "shovelGemEnd");
		shovelGemQuartz = new ToolShovel(ToolArmorMaterial.gemQuartz);
		GameRegistry.registerItem(shovelGemQuartz, "shovelGemQuartz");
		shovelLapis = new ToolShovel(ToolArmorMaterial.lapis);
		GameRegistry.registerItem(shovelLapis, "shovelLapis");
		shovelObsidian = new ToolShovel(ToolArmorMaterial.obsidian);
		GameRegistry.registerItem(shovelObsidian, "shovelObsidian");
		
		swordGemRed = new ToolSword(ToolArmorMaterial.gemRed);
		GameRegistry.registerItem(swordGemRed, "swordGemRed");
		swordGemDiamond = new ToolSword(ToolArmorMaterial.gemDiamond);
		GameRegistry.registerItem(swordGemDiamond, "swordGemDiamond");
		swordGemEmerald = new ToolSword(ToolArmorMaterial.gemEmerald);
		GameRegistry.registerItem(swordGemEmerald, "swordGemEmerald");
		swordGemGlow = new ToolSword(ToolArmorMaterial.gemGlow);
		GameRegistry.registerItem(swordGemGlow, "swordGemGlow");
		swordGemEnd = new ToolSword(ToolArmorMaterial.gemEnd);
		GameRegistry.registerItem(swordGemEnd, "swordGemEnd");
		swordGemQuartz = new ToolSword(ToolArmorMaterial.gemQuartz);
		GameRegistry.registerItem(swordGemQuartz, "swordGemQuartz");
		swordLapis = new ToolSword(ToolArmorMaterial.lapis);
		GameRegistry.registerItem(swordLapis, "swordLapis");
		swordObsidian = new ToolSword(ToolArmorMaterial.obsidian);
		GameRegistry.registerItem(swordObsidian, "swordObsidian");
		
		hoeGemRed = new ToolHoe(ToolArmorMaterial.gemRed);
		GameRegistry.registerItem(hoeGemRed, "hoeGemRed");
		hoeGemDiamond = new ToolHoe(ToolArmorMaterial.gemDiamond);
		GameRegistry.registerItem(hoeGemDiamond, "hoeGemDiamond");
		hoeGemEmerald = new ToolHoe(ToolArmorMaterial.gemEmerald);
		GameRegistry.registerItem(hoeGemEmerald, "hoeGemEmerald");
		hoeGemGlow = new ToolHoe(ToolArmorMaterial.gemGlow);
		GameRegistry.registerItem(hoeGemGlow, "hoeGemGlow");
		hoeGemEnd = new ToolHoe(ToolArmorMaterial.gemEnd);
		GameRegistry.registerItem(hoeGemEnd, "hoeGemEnd");
		hoeGemQuartz = new ToolHoe(ToolArmorMaterial.gemQuartz);
		GameRegistry.registerItem(hoeGemQuartz, "hoeGemQuartz");
		hoeLapis = new ToolHoe(ToolArmorMaterial.lapis);
		GameRegistry.registerItem(hoeLapis, "hoeLapis");
		hoeObsidian = new ToolHoe(ToolArmorMaterial.obsidian);
		GameRegistry.registerItem(hoeObsidian, "hoeObsidian");
		
		toolTransformBlock = new ToolTransformBlock();
		GameRegistry.registerItem(toolTransformBlock, "toolTransformBlock");
		toolVoidBlock = new ToolVoidBlock();
		GameRegistry.registerItem(toolVoidBlock, "toolVoidBlock");
		toolVoidBlockRanged = new ToolVoidBlockRanged();
		GameRegistry.registerItem(toolVoidBlockRanged, "toolVoidBlockRanged");
		toolVoidItem = new ToolVoidItem();
		GameRegistry.registerItem(toolVoidItem, "toolVoidItem");
		toolVoidItemWhite = new ToolVoidItemWhite();
		GameRegistry.registerItem(toolVoidItemWhite, "toolVoidItemWhite");
		toolVoidItemBlack = new ToolVoidItemBlack();
		GameRegistry.registerItem(toolVoidItemBlack, "toolVoidItemBlack");
		
		if (ConfigLoad.DEBUG)
		{
			System.out.println("Devices: Items Loaded");
		}
	}
	
	private void blockRegistration()
	{
		oreGemRed = new BlockGemOre("Red", gemRed);
		GameRegistry.registerBlock(oreGemRed, "oreGemRed");		
		oreGemEnd = new BlockGemOre("End", gemEnd);
		GameRegistry.registerBlock(oreGemEnd, "oreGemEnd");
		oreGemDiamond = new BlockGemOre("Diamond", Items.diamond);
		GameRegistry.registerBlock(oreGemDiamond, "oreGemDiamond");
		oreGemEmerald = new BlockGemOre("Emerald", Items.emerald);
		GameRegistry.registerBlock(oreGemEmerald, "oreGemEmerald");
		oreGemQuartz = new BlockGemOre("Quartz", Items.quartz);
		GameRegistry.registerBlock(oreGemQuartz, "oreGemQuartz");
		oreGemGlow = new BlockGemOre("Glow", gemGlow);
		GameRegistry.registerBlock(oreGemGlow, "oreGemGlow");
		
		oreImperfectDiamond = new BlockImperfectOre("Diamond", Items.diamond);
		Block.blockRegistry.addObject(56, "imperfect_diamond_ore", (oreImperfectDiamond)); //Overriding Vanilla Diamond Ore>imperfect diamond ore
		
		fuelEnrichedCoal = new FuelEnrichedCoal();
		GameRegistry.registerBlock(fuelEnrichedCoal, "fuelEnrichedCoal");
		
		if (ConfigLoad.DEBUG)
		{
			System.out.println("Devices: Blocks Loaded");
		}
	}
	
	private void craftingRegistration()
	{
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
		GameRegistry.addShapelessRecipe(SHandler.S(matrixStorage, 2), SHandler.S(Blocks.chest), SHandler.S(Items.quartz), SHandler.S(Items.book), SHandler.S(Items.bed));
		
		
		if (ConfigLoad.VOIDTOOLS)
		{
			GameRegistry.addShapedRecipe(SHandler.S(toolVoidBlock), "aba","bcb","aba", 'a', SHandler.S(Items.emerald), 'b', SHandler.S(circuitVoid), 'c', SHandler.S(Blocks.stone));
			GameRegistry.addShapedRecipe(SHandler.S(toolVoidBlock), "bab","aca","bab", 'a', SHandler.S(Items.emerald), 'b', SHandler.S(circuitVoid), 'c', SHandler.S(Blocks.stone));
		}
		
		if (ConfigLoad.GEMCRAFTABLE)
		{
			GameRegistry.addSmelting(Blocks.redstone_block, SHandler.S(gemRed, 2), 0.1F);
			GameRegistry.addSmelting(gemRed, SHandler.S(Items.redstone, 2), 0.1F);
			GameRegistry.addSmelting(Blocks.quartz_block, SHandler.S(gemQuartz, 1), 0.1F);
			GameRegistry.addSmelting(gemQuartz, SHandler.S(Items.quartz, 1), 0.1F);
		}
		
		if (ConfigLoad.DEBUG)
		{
			System.out.println("Devices: Recipies Loaded");
		}
	}
}