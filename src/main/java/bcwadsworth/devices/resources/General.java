package bcwadsworth.devices.resources;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class General
{
public static final String MODID = "devices";
public static final String VERSION = "0.0.1.0";
public static final String NAME = "Devices";

//Options TODO: Move to Config
public static Boolean DEBUG = false;


//Features
public static Boolean VOIDTOOLS = true;
public static Boolean REDGEMTOOLS = true;
public static Boolean GEMEMERALDTOOLS = true;
public static Boolean GEMGLOWTOOLS = true;
public static Boolean GEMQUARTZTOOLS = true;
public static Boolean GEMENDTOOLS = true;
public static Boolean GEMMIXEDTOOLS = true;
public static Boolean GEMCRAFTABLE = true;


//OreGeneration
public static int OREGENERATIONATTEMPTS = 20;

public static Boolean OREGEMREDGENERATE = true;
public static int OREGEMREDYMIN = 4;
public static int OREGEMREDYMAX = 12;
public static int OREGEMREDCHUNKDENSITY = 4;
public static int OREGEMREDGENERATEMIN = 4;
public static int OREGEMREDGENERATEMAX = 12;


//Tool Materials
//TODO: Handle EnumHelper
//public static Item.ToolMaterial gemRed = EnumHelper.addToolMaterial(ToolMaterial.class, "gemRed", 3, 512, 10.0F, 8.0F, 5);

}
