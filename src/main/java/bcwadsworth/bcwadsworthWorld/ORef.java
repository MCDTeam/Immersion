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
	
	public static ItemMaterial chunkCopper = new ItemMaterial("chunkCopper");
	public static ItemMaterial chunkTin = new ItemMaterial("chunkTin");
	public static ItemMaterial chunkBronze = new ItemMaterial("chunkBronze");
	public static ItemMaterial chunkIron = new ItemMaterial("chunkIron");
	public static ItemMaterial chunkSteel = new ItemMaterial("chunkSteel");
	public static ItemMaterial chunkGold = new ItemMaterial("chunkGold");
	
	public static ItemMaterial ingotCopper = new ItemMaterial("ingotCopper");
	public static ItemMaterial ingotTin = new ItemMaterial("ingotTin");
	public static ItemMaterial ingotBronze = new ItemMaterial("ingotBronze");
	public static ItemMaterial ingotSteel = new ItemMaterial("ingotSteel");
	
	
	
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
	
	protected static void ORegistration()
	{
		GameRegistry.registerItem(gemRed, "gemRed");
		GameRegistry.registerItem(gemEnd, "gemEnd");
		GameRegistry.registerItem(gemGlow, "gemGlow");
		GameRegistry.registerItem(gemQuartz, "gemQuartz");
		
		GameRegistry.registerItem(gemImperfectDiamond, "gemImperfectDiamond");
		GameRegistry.registerItem(gemImperfectEmerald, "gemImperfectEmerald");
		GameRegistry.registerItem(gemImperfectEnd, "gemImperfectEnd");
		
		GameRegistry.registerItem(chunkCopper, "chunkCopper");
		GameRegistry.registerItem(chunkTin, "chunkTin");
		GameRegistry.registerItem(chunkBronze, "chunkBronze");
		GameRegistry.registerItem(chunkIron, "chunkIron");
		GameRegistry.registerItem(chunkSteel, "chunkSteel");
		GameRegistry.registerItem(chunkGold, "chunkGold");
		
		GameRegistry.registerItem(ingotCopper, "ingotCopper");
		GameRegistry.registerItem(ingotTin, "ingotTin");
		GameRegistry.registerItem(ingotBronze, "ingotBronze");
		GameRegistry.registerItem(ingotSteel, "ingotSteel");
		
		
		
		GameRegistry.registerBlock(oreGemRed, "oreGemRed");
		GameRegistry.registerBlock(oreGemEnd, "oreGemEnd");
		GameRegistry.registerBlock(oreGemDiamond, "oreGemDiamond");
		GameRegistry.registerBlock(oreGemEmerald, "oreGemEmerald");
		GameRegistry.registerBlock(oreGemQuartz, "oreGemQuartz");
		GameRegistry.registerBlock(oreGemGlow, "oreGemGlow");
		
		GameRegistry.registerBlock(oreImperfectRed, "oreImperfectRed");
		GameRegistry.registerBlock(oreImperfectDiamond, "oreImperfectDiamond");
		GameRegistry.registerBlock(oreImperfectEmerald, "oreImperfectEmerald");
		GameRegistry.registerBlock(oreImperfectQuartz, "oreImperfectQuartz");
		
		GameRegistry.registerBlock(oreCopper, "oreCopper");
		GameRegistry.registerBlock(oreTin, "oreTin");
		GameRegistry.registerBlock(oreIron, "oreIron");
		GameRegistry.registerBlock(oreGold, "oreGemGold");
		
		GameRegistry.registerBlock(blockGemEnd, "blockGemEnd");
		GameRegistry.registerBlock(blockGemGlow, "blockGemGlow");
		
		GameRegistry.registerBlock(blockGemImperfectRed, "blockGemImperfectRed");
		GameRegistry.registerBlock(blockGemImperfectDiamond, "blockGemImperfectDiamond");
		GameRegistry.registerBlock(blockGemImperfectEmerald, "blockGemImperfectEmerald");
		GameRegistry.registerBlock(blockGemImperfectQuartz, "blockGemImperfectQuartz");
		GameRegistry.registerBlock(blockGemImperfectEnd, "blockGemImperfectEnd");
		
		GameRegistry.registerBlock(blockIngotCopper, "blockIngotCopper");
		GameRegistry.registerBlock(blockIngotTin, "blockIngotTin");
		GameRegistry.registerBlock(blockIngotBronze, "blockIngotBronze");
		GameRegistry.registerBlock(blockIngotSteel, "blockIngotSteel");
		
		GameRegistry.registerBlock(fuelEnrichedCoal, "fuelEnrichedCoal");
	}
}
