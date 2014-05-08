package bcwadsworth.devices.resources;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ToolArmorMaterial 
{
	public static ToolMaterial gemRed = EnumHelper.addToolMaterial("GemRed", 3, 512, 14.0F, 2.0F, 10);
	public static ToolMaterial gemEmerald = EnumHelper.addToolMaterial("GemEmerald", 3, 512, 8.0F, 2.0F, 25);
	public static ToolMaterial gemDiamond = EnumHelper.addToolMaterial("GemDiamond", 3, 1024, 8.0F, 2.0F, 10);
	public static ToolMaterial gemQuartz = EnumHelper.addToolMaterial("GemQuartz", 3, 512, 8.0F, 5.0F, 10);
	public static ToolMaterial gemGlow = EnumHelper.addToolMaterial("GemGlow", 4, 512, 8.0F, 2.0F, 10);
	public static ToolMaterial gemEnd = EnumHelper.addToolMaterial("GemEnd", 4, 768, 11.0F, 3.5F, 16);
	
	public static ToolMaterial lapis = EnumHelper.addToolMaterial("Lapis", 1, 128, 4.0F, 1.0F, 15);
	public static ToolMaterial obsidian = EnumHelper.addToolMaterial("Obsidian", 4, 128, 2.0F, 3.0F, 5);
}
