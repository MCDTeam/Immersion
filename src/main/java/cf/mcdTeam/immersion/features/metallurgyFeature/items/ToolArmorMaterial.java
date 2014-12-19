package cf.mcdTeam.immersion.features.metallurgyFeature.items;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ToolArmorMaterial 
{
	public static ToolMaterial gemRed = EnumHelper.addToolMaterial("GemRed", 3, 512, 14.0F, 2.0F, 10);
	public static ToolMaterial gemEmerald = EnumHelper.addToolMaterial("GemEmerald", 3, 512, 8.0F, 2.0F, 25);
	public static ToolMaterial gemDiamond = EnumHelper.addToolMaterial("GemDiamond", 3, 1024, 8.0F, 2.0F, 10);
	public static ToolMaterial gemQuartz = EnumHelper.addToolMaterial("GemQuartz", 3, 512, 8.0F, 5.0F, 10);
	public static ToolMaterial gemGlow = EnumHelper.addToolMaterial("GemGlow", 3, 512, 8.0F, 2.0F, 10);
	public static ToolMaterial gemEnd = EnumHelper.addToolMaterial("GemEnd", 3, 512, 8.0F, 2.0F, 10);
	
	public static ToolMaterial flint = EnumHelper.addToolMaterial("Flint", 1, 128, 2.0F, 2.0F, 5);
}
