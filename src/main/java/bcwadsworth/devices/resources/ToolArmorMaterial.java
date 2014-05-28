package bcwadsworth.devices.resources;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ToolArmorMaterial 
{
	public static ToolMaterial gemRed = EnumHelper.addToolMaterial("GemRed", 3, 512, 14.0F, 2.0F, 10);
	public static ToolMaterial gemEmerald = EnumHelper.addToolMaterial("GemEmerald", 3, 512, 8.0F, 2.0F, 25);
	public static ToolMaterial gemDiamond = EnumHelper.addToolMaterial("GemDiamond", 3, 1024, 8.0F, 2.0F, 10);
	public static ToolMaterial gemQuartz = EnumHelper.addToolMaterial("GemQuartz", 3, 512, 8.0F, 5.0F, 10);
	public static ToolMaterial gemGlow = EnumHelper.addToolMaterial("GemGlow", 3, 512, 8.0F, 2.0F, 10);//fortune
	public static ToolMaterial gemEnd = EnumHelper.addToolMaterial("GemEnd", 3, 512, 8.0F, 2.0F, 10);//teleporty or voidy things
	
	public static ToolMaterial lapis = EnumHelper.addToolMaterial("Lapis", 1, 128, 4.0F, 1.0F, 15);
	public static ToolMaterial obsidian = EnumHelper.addToolMaterial("Obsidian", 4, 128, 2.0F, 3.0F, 5);
	public static ToolMaterial flint = EnumHelper.addToolMaterial("Flint", 1, 128, 2.0F, 2.0F, 5);
	
	public static ArmorMaterial gemRedA = EnumHelper.addArmorMaterial("GemRed", 512, new int[] {3,7,5,3}, 10);//speed boosts to all, H: aqua affinity, C:Haste, L:Speed, B: Speed
	public static ArmorMaterial gemEmeraldA = EnumHelper.addArmorMaterial("GemEmerald", 512, new int[] {3,7,5,3}, 25);
	public static ArmorMaterial gemDiamondA = EnumHelper.addArmorMaterial("GemDiamond", 1024, new int[] {3,7,5,3}, 10);
	public static ArmorMaterial gemQuartzA = EnumHelper.addArmorMaterial("GemQuartz", 512, new int[] {4,9,7,4}, 10);//protection, B: FeatherFalling
	public static ArmorMaterial gemGlowA = EnumHelper.addArmorMaterial("GemGlow", 512, new int[] {3,7,5,3}, 10);//fire/blast protection
	public static ArmorMaterial gemEndA = EnumHelper.addArmorMaterial("GemEnd", 512, new int[] {3,7,5,3}, 10);//damage avoidance
}
