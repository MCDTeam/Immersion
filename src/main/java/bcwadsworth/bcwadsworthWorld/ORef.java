package bcwadsworth.bcwadsworthWorld;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Items;
import bcwadsworth.bcwadsworthWorld.Blocks.BlockStorage;
import bcwadsworth.bcwadsworthWorld.Blocks.BlockOre;
import bcwadsworth.bcwadsworthWorld.Blocks.FuelEnrichedCoal;
import bcwadsworth.bcwadsworthWorld.Items.ItemMaterial;

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
	public static ItemMaterial chunkCopper = new ItemMaterial("chunkCopper");
	public static ItemMaterial chunkSilver = new ItemMaterial("chunkSilver");
	public static ItemMaterial chunkChromium = new ItemMaterial("chunkChromium");
	public static ItemMaterial chunkGold = new ItemMaterial("chunkGold");
	public static ItemMaterial chunkPlatinum = new ItemMaterial("chunkPlatinum");
	public static ItemMaterial chunkMythril = new ItemMaterial("chunkMythril");
	
	//Rare Earths
	public static ItemMaterial chunkOsmium = new ItemMaterial("chunkOsmium");
	public static ItemMaterial chunkIridium = new ItemMaterial("chunkIridium");
	public static ItemMaterial chunkTin = new ItemMaterial("chunkTin");
	public static ItemMaterial chunkLead = new ItemMaterial("chunkLead");
	public static ItemMaterial chunkUranium = new ItemMaterial("chunkUranium");
	public static ItemMaterial chunkPlutonium = new ItemMaterial("chunkPlutonium");
	public static ItemMaterial chunkNickel = new ItemMaterial("chunkNickel");
	public static ItemMaterial chunkZinc = new ItemMaterial("chunkZinc");
	public static ItemMaterial chunkAluminium = new ItemMaterial("chunkAluminium");
	public static ItemMaterial chunkBismuth = new ItemMaterial("chunkBismuth");
	public static ItemMaterial chunkThorium = new ItemMaterial("chunkThorium");
	public static ItemMaterial chunkRadium = new ItemMaterial("chunkRadium");
	public static ItemMaterial chunkMaganese = new ItemMaterial("chunkMaganese");
	public static ItemMaterial chunkMolybdenum = new ItemMaterial("chunkMolybdenum");
	
	//Building Family
	public static ItemMaterial chunkIron = new ItemMaterial("chunkIron");
	public static ItemMaterial chunkTitanium = new ItemMaterial("chunkTitanium");
	public static ItemMaterial chunkTungsten = new ItemMaterial("chunkTungsten");
	public static ItemMaterial chunkStrongithium = new ItemMaterial("chunkStrongithium");
	
	//Alloys
	public static ItemMaterial chunkBronze = new ItemMaterial("chunkBronze"); //Cu/Sn
	public static ItemMaterial chunkBrass = new ItemMaterial("chunkBrass"); //Cu/Zn
	public static ItemMaterial chunkDuralumin = new ItemMaterial("chunkDuralumin"); //Cu/Al
	public static ItemMaterial chunkCupronickel = new ItemMaterial("chunkCupronickel"); //Cu/Ni
	public static ItemMaterial chunkCopernium = new ItemMaterial("chunkCopernium"); //Cu/Au
	public static ItemMaterial chunkManganin = new ItemMaterial("chunkMaganin"); //Cu/Mn
	public static ItemMaterial chunkdummy = new ItemMaterial("chunkdummy");
	public static ItemMaterial chunkdm = new ItemMaterial("chunkdm");
	
	public static BlockOre oreGemDiamond = new BlockOre("GemDiamond", Items.diamond);
	public static BlockOre oreGemEmerald = new BlockOre("GemEmerald", Items.emerald);
	public static BlockOre oreGemEnd = new BlockOre("GemEnd", ORef.gemEnd);
	public static BlockOre oreGemGlow = new BlockOre("GemGlow", ORef.gemGlow);
	public static BlockOre oreGemQuartz = new BlockOre("GemQuartz", ORef.gemQuartz);
	public static BlockOre oreGemRed = new BlockOre("GemRed", ORef.gemRed);
	
	public static BlockOre oreImperfectDiamond = new BlockOre("GemImperfectDiamond", ORef.gemImperfectDiamond);
	public static BlockOre oreImperfectEmerald = new BlockOre("GemImperfectEmerald", ORef.gemImperfectEmerald);
	public static BlockOre oreImperfectQuartz = new BlockOre("GemImperfectQuartz", Items.quartz);
	public static BlockOre oreImperfectRed = new BlockOre("GemImperfectRed", Items.redstone);
	
	public static BlockOre oreCopper = new BlockOre("Copper", ORef.chunkCopper);
	public static BlockOre oreTin = new BlockOre("Tin", ORef.chunkTin);
	public static BlockOre oreAluminium = new BlockOre("Aluminium", ORef.chunkTin);
	public static BlockOre oreZinc = new BlockOre("Zinc", ORef.chunkTin);
	public static BlockOre oreIron = new BlockOre("Iron", ORef.chunkIron);
	public static BlockOre oreGold = new BlockOre("Gold", ORef.chunkGold);
	
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
