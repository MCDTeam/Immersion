package bcwadsworth.devices;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import bcwadsworth.devices.blocks.OreGemRed;
import bcwadsworth.devices.generation.OreGeneration;
import bcwadsworth.devices.items.GemRed;
import bcwadsworth.devices.resources.General;
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
	public static Block oreGemRed;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) 
	{
		System.out.println("Pre-Initializing Devices Version " + General.VERSION);
		
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		//General Category
		String CATEGORYFEATURES = "Features";
		General.DEBUG = config.get(CATEGORYFEATURES, "Debug Mode Active", General.DEBUG).getBoolean(General.DEBUG);
		General.GEMCRAFTABLE = config.get(CATEGORYFEATURES, "Gems Craftable / Uncraftable", General.GEMCRAFTABLE).getBoolean(General.GEMCRAFTABLE);
		General.GEMEMERALDTOOLS = config.get(CATEGORYFEATURES, "Emerald Tools", General.GEMEMERALDTOOLS).getBoolean(General.GEMEMERALDTOOLS);
		General.GEMGLOWTOOLS = config.get(CATEGORYFEATURES, "Glowstone Gem Tools", General.GEMGLOWTOOLS).getBoolean(General.GEMGLOWTOOLS);
		General.GEMQUARTZTOOLS = config.get(CATEGORYFEATURES, "Quartz Tools", General.GEMQUARTZTOOLS).getBoolean(General.GEMQUARTZTOOLS);
		General.GEMENDTOOLS = config.get(CATEGORYFEATURES, "End Gem Tools", General.GEMENDTOOLS).getBoolean(General.GEMENDTOOLS);
		General.VOIDTOOLS = config.get(CATEGORYFEATURES, "Void Tools", General.VOIDTOOLS).getBoolean(General.VOIDTOOLS);
		
		//OreGen Category
		String CATEGORYOREGEN = "Ore Generation";
		General.OREGENERATIONATTEMPTS = config.get(CATEGORYOREGEN, "Ore Generation Attempts", General.OREGENERATIONATTEMPTS).getInt(General.OREGENERATIONATTEMPTS);
		General.OREGEMREDGENERATE = config.get(CATEGORYOREGEN, "Generate Redstone Gem Ore", General.OREGEMREDGENERATE).getBoolean(General.DEBUG);
		if (General.OREGEMREDGENERATE)
		{
			General.OREGEMREDCHUNKDENSITY = config.get(CATEGORYOREGEN, "Redstone Gem Ore Chunk Density", General.OREGEMREDCHUNKDENSITY).getInt(General.OREGEMREDCHUNKDENSITY);
			General.OREGEMREDYMIN = config.get(CATEGORYOREGEN, "Redstone Gem Ore Minimum Y", General.OREGEMREDYMIN).getInt(General.OREGEMREDYMIN);
			General.OREGEMREDYMAX = config.get(CATEGORYOREGEN, "Redstone Gem Ore Maximum Y", General.OREGEMREDYMAX).getInt(General.OREGEMREDYMAX);
			General.OREGEMREDGENERATEMIN = config.get(CATEGORYOREGEN, "Redstone Gem Ore Minimum Generated", General.OREGEMREDGENERATEMIN).getInt(General.OREGEMREDGENERATEMIN);
			General.OREGEMREDGENERATEMAX = config.get(CATEGORYOREGEN, "Redstone Gem Ore Maximum Generated", General.OREGEMREDGENERATEMAX).getInt(General.OREGEMREDGENERATEMAX);
		}
		
		config.save();
		System.out.println("Config Loaded");

		oreGemRed = new OreGemRed(Material.rock);
		GameRegistry.registerBlock(oreGemRed, "oreGemRed");

		gemRed = new GemRed();
		GameRegistry.registerItem(gemRed, "gemRed");

		System.out.println("Devices: Pre-Initialized");

	}

	@EventHandler
	public void init(FMLInitializationEvent event) 
	{
		System.out.println("Initializing Devices Version " + General.VERSION);
		
		GameRegistry.registerWorldGenerator(new OreGeneration(),0);
	}
}
