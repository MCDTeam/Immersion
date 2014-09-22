package bcwadsworth.immersion;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import bcwadsworth.immersion.blocks.BlockGemOre;
import bcwadsworth.immersion.blocks.BlockOre;
import bcwadsworth.immersion.blocks.BlockStorage;
import bcwadsworth.immersion.blocks.FuelEnrichedCoal;
import bcwadsworth.immersion.items.ItemPartOre;
import bcwadsworth.immersion.items.ItemMaterial;

public class ORef 
{
	
	public static ItemMaterial gemEnd = new ItemMaterial("gemEnd");
	public static ItemMaterial gemGlow = new ItemMaterial("gemGlow");
	public static ItemMaterial gemQuartz = new ItemMaterial("gemQuartz");
	public static ItemMaterial gemRed = new ItemMaterial("gemRed");
	
	public static ItemMaterial gemImperfectDiamond = new ItemMaterial("gemImperfectDiamond");
	public static ItemMaterial gemImperfectEmerald = new ItemMaterial("gemImperfectEmerald");
	public static ItemMaterial gemImperfectEnd = new ItemMaterial("gemImperfectEnd");
	
	//Precious Family
	public static BlockOre oreCopper = new BlockOre("Copper");
	public static BlockOre oreSilver = new BlockOre("Silver");
	public static BlockOre oreChromium = new BlockOre("Chromium");
	public static BlockOre oreGold = new BlockOre("Gold");
	public static BlockOre orePlatinum = new BlockOre("Platinum");
	public static BlockOre oreMythril = new BlockOre("Mythril");
	
	//Rare Earths
	public static BlockOre oreOsmium = new BlockOre("Osmium");
	public static BlockOre oreIridium = new BlockOre("Iridium");
	public static BlockOre oreTin = new BlockOre("Tin");
	public static BlockOre oreLead = new BlockOre("Lead");
	public static BlockOre oreUranium = new BlockOre("Uranium");
	public static BlockOre orePlutonium = new BlockOre("Plutonium");
	public static BlockOre oreNickel = new BlockOre("Nickel");
	public static BlockOre oreZinc = new BlockOre("Zinc");
	public static BlockOre oreAluminium = new BlockOre("Aluminium");
	public static BlockOre oreBismuth = new BlockOre("Bismuth");
	public static BlockOre oreThorium = new BlockOre("Thorium");
	public static BlockOre oreRadium = new BlockOre("Radium");
	public static BlockOre oreMaganese = new BlockOre("Maganese");
	public static BlockOre oreMolybdenum = new BlockOre("Molybdenum");
	
	//Building Family
	public static BlockOre oreIron = new BlockOre("Iron");
	public static BlockOre oreTitanium = new BlockOre("Titanium");
	public static BlockOre oreTungsten = new BlockOre("Tungsten");
	public static BlockOre oreStrongithium = new BlockOre("Strongithium");
	

	
	public static ItemPartOre lumpOre = new ItemPartOre("lump");
	
	public static BlockGemOre oreGemDiamond = new BlockGemOre("GemDiamond", Items.diamond);
	public static BlockGemOre oreGemEmerald = new BlockGemOre("GemEmerald", Items.emerald);
	public static BlockGemOre oreGemEnd = new BlockGemOre("GemEnd", ORef.gemEnd);
	public static BlockGemOre oreGemGlow = new BlockGemOre("GemGlow", ORef.gemGlow);
	public static BlockGemOre oreGemQuartz = new BlockGemOre("GemQuartz", ORef.gemQuartz);
	public static BlockGemOre oreGemRed = new BlockGemOre("GemRed", ORef.gemRed);
	
	public static BlockGemOre oreImperfectDiamond = new BlockGemOre("GemImperfectDiamond", ORef.gemImperfectDiamond);
	public static BlockGemOre oreImperfectEmerald = new BlockGemOre("GemImperfectEmerald", ORef.gemImperfectEmerald);
	public static BlockGemOre oreImperfectQuartz = new BlockGemOre("GemImperfectQuartz", Items.quartz);
	public static BlockGemOre oreImperfectRed = new BlockGemOre("GemImperfectRed", Items.redstone);
	
	public static BlockStorage blockGemEnd = new BlockStorage("GemEnd");
	public static BlockStorage blockGemGlow = new BlockStorage("GemGlow");
	
	public static BlockStorage blockGemImperfectDiamond = new BlockStorage("GemImperfectDiamond");
	public static BlockStorage blockGemImperfectEmerald = new BlockStorage("GemImperfectEmerald");
	public static BlockStorage blockGemImperfectEnd = new BlockStorage("GemImperfectEnd");
	public static BlockStorage blockGemImperfectQuartz = new BlockStorage("GemImperfectQuartz");
	public static BlockStorage blockGemImperfectRed = new BlockStorage("GemImperfectRed");
	
	public static BlockStorage blockIngotCopper = new BlockStorage("IngotCopper");
	public static BlockStorage blockIngotTin = new BlockStorage("IngotTin");
	public static BlockStorage blockIngotBronze = new BlockStorage("IngotBronze");
	public static BlockStorage blockIngotSteel = new BlockStorage("IngotSteel");
	
	public static Block fuelEnrichedCoal = new FuelEnrichedCoal();
}
