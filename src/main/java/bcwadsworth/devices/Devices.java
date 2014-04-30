package bcwadsworth.devices;

import bcwadsworth.devices.blocks.RedGemOre;
import bcwadsworth.devices.generation.oreGeneration;
import bcwadsworth.devices.items.RedGem;
import bcwadsworth.devices.resources.General;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import java.io.PrintStream;

import net.minecraft.block.material.Material;
import net.minecraft.block.Block;
import net.minecraft.item.Item;

@Mod(modid = General.MODID, name = General.NAME, version = General.VERSION)
public class Devices {
	@Instance(General.MODID)
	public static Devices instance;

	public static Item redGem;
	public static Block redGemOre;

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) 
	{
		System.out.println("Pre-Initializing Devices Version 0.0.1.0");

		redGemOre = new RedGemOre(Material.rock);
		GameRegistry.registerBlock(redGemOre, "redGemOre");

		redGem = new RedGem();
		GameRegistry.registerItem(redGem, "redGem");

		System.out.println("Redstone Gem Change: Initialized");

	}

	@EventHandler
	public void init(FMLInitializationEvent event) 
	{
		System.out.println("Initializing Devices Version 0.0.1.0");
		
		GameRegistry.registerWorldGenerator(new oreGeneration(),200);
	}
}
