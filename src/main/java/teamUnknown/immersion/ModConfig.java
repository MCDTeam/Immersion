package teamUnknown.immersion;

import net.minecraftforge.common.config.Configuration;

public class ModConfig 
{

	public static final String MODID = "immersion";

	public static final String NAME = "Immersion";

	public static final String VERSION = "0.0.1.0";
	
	
	//This keeps all the variables returned from the config file and stores the default values
	public static Boolean DEFAULTCONFIG = true;

	//OreGeneration
	public static int OREGEMREDYMIN = 4;
	public static int OREGEMREDYBREAK = 12;
	public static int OREGEMREDYMAX = 24;
	public static int OREGEMREDCHUNKDENSITY = 4;
	public static int OREGEMREDGENERATEMIN = 2;
	public static int OREGEMREDGENERATEMAX = 6;
	
	public static int OREGEMDIAMONDYMIN = 4;
	public static int OREGEMDIAMONDYBREAK = 12;
	public static int OREGEMDIAMONDYMAX = 24;
	public static int OREGEMDIAMONDCHUNKDENSITY = 4;
	public static int OREGEMDIAMONDGENERATEMIN = 2;
	public static int OREGEMDIAMONDGENERATEMAX = 6;

	public static int OREGEMEMERALDYMIN = 4;
	public static int OREGEMEMERALDYBREAK  = 12;
	public static int OREGEMEMERALDYMAX = 24;
	public static int OREGEMEMERALDCHUNKDENSITY = 4;
	public static int OREGEMEMERALDGENERATEMIN = 2;
	public static int OREGEMEMERALDGENERATEMAX = 6;

	public static int OREGEMGLOWYMIN = 100;
	public static int OREGEMGLOWYMAX = 124;
	public static int OREGEMGLOWCHUNKDENSITY = 2;
	public static int OREGEMGLOWGENERATEMIN = 2;
	public static int OREGEMGLOWGENERATEMAX = 6;

	public static int OREGEMQUARTZYMIN = 4;
	public static int OREGEMQUARTZYBREAK = 12;
	public static int OREGEMQUARTZYMAX = 64;
	public static int OREGEMQUARTZCHUNKDENSITY = 2;
	public static int OREGEMQUARTZGENERATEMIN = 4;
	public static int OREGEMQUARTZGENERATEMAX = 6;

	public static int OREGEMENDCHUNKDENSITY = 4;
	public static int OREGEMENDGENERATEMIN = 2;
	public static int OREGEMENDGENERATEMAX = 8;
	
	public static Boolean GENERATEDIRTUNDERGROUND = true;
	public static Boolean ADDITIONALFUELS = true;
	
	protected static void configLoad(Configuration config)
	{
		config.load();
		
		// Checking for defaults, skipping loading if defaultconfig is true
		String CATEGORYDEFAULTS = "Defaults";
		if (config.get(CATEGORYDEFAULTS, "Use the Default Config", true).getBoolean(true))
		{
			return;
		}
		
		// OreGen Category
		String CATEGORYOREGEN = "Ore Generation";
	
		ModConfig.OREGEMREDCHUNKDENSITY = config.get(CATEGORYOREGEN, "Redstone Gem Ore Chunk Density", ModConfig.OREGEMREDCHUNKDENSITY).getInt(ModConfig.OREGEMREDCHUNKDENSITY);
		ModConfig.OREGEMREDYMIN = config.get(CATEGORYOREGEN, "Redstone Gem Ore Minimum Y", ModConfig.OREGEMREDYMIN).getInt(ModConfig.OREGEMREDYMIN);
		ModConfig.OREGEMREDYMAX = config.get(CATEGORYOREGEN, "Redstone Gem Ore Maximum Y", ModConfig.OREGEMREDYMAX).getInt(ModConfig.OREGEMREDYMAX);
		ModConfig.OREGEMREDGENERATEMIN = config.get(CATEGORYOREGEN, "Redstone Gem Ore Minimum Generated", ModConfig.OREGEMREDGENERATEMIN).getInt(ModConfig.OREGEMREDGENERATEMIN);
		ModConfig.OREGEMREDGENERATEMAX = config.get(CATEGORYOREGEN, "Redstone Gem Ore Maximum Generated", ModConfig.OREGEMREDGENERATEMAX).getInt(ModConfig.OREGEMREDGENERATEMAX);
	
		ModConfig.OREGEMDIAMONDCHUNKDENSITY = config.get(CATEGORYOREGEN, "Diamond Gem Ore Chunk Density", ModConfig.OREGEMDIAMONDCHUNKDENSITY).getInt(ModConfig.OREGEMDIAMONDCHUNKDENSITY);
		ModConfig.OREGEMDIAMONDYMIN = config.get(CATEGORYOREGEN, "Diamond Gem Ore Minimum Y", ModConfig.OREGEMDIAMONDYMIN).getInt(ModConfig.OREGEMDIAMONDYMIN);
		ModConfig.OREGEMDIAMONDYMAX = config.get(CATEGORYOREGEN, "Diamond Gem Ore Maximum Y", ModConfig.OREGEMDIAMONDYMAX).getInt(ModConfig.OREGEMDIAMONDYMAX);
		ModConfig.OREGEMDIAMONDGENERATEMIN = config.get(CATEGORYOREGEN, "Diamond Gem Ore Minimum Generated", ModConfig.OREGEMDIAMONDGENERATEMIN).getInt(ModConfig.OREGEMDIAMONDGENERATEMIN);
		ModConfig.OREGEMDIAMONDGENERATEMAX = config.get(CATEGORYOREGEN, "Diamond Gem Ore Maximum Generated", ModConfig.OREGEMDIAMONDGENERATEMAX).getInt(ModConfig.OREGEMDIAMONDGENERATEMAX);
	
		ModConfig.OREGEMEMERALDCHUNKDENSITY = config.get(CATEGORYOREGEN, "Emerald Gem Ore Chunk Density", ModConfig.OREGEMEMERALDCHUNKDENSITY).getInt(ModConfig.OREGEMEMERALDCHUNKDENSITY);
		ModConfig.OREGEMEMERALDYMIN = config.get(CATEGORYOREGEN, "Emerald Gem Ore Minimum Y", ModConfig.OREGEMEMERALDYMIN).getInt(ModConfig.OREGEMEMERALDYMIN);
		ModConfig.OREGEMEMERALDYMAX = config.get(CATEGORYOREGEN, "Emerald Gem Ore Maximum Y", ModConfig.OREGEMEMERALDYMAX).getInt(ModConfig.OREGEMEMERALDYMAX);
		ModConfig.OREGEMEMERALDGENERATEMIN = config.get(CATEGORYOREGEN, "Emerald Gem Ore Minimum Generated", ModConfig.OREGEMEMERALDGENERATEMIN).getInt(ModConfig.OREGEMEMERALDGENERATEMIN);
		ModConfig.OREGEMEMERALDGENERATEMAX = config.get(CATEGORYOREGEN, "Emerald Gem Ore Maximum Generated", ModConfig.OREGEMEMERALDGENERATEMAX).getInt(ModConfig.OREGEMEMERALDGENERATEMAX);
		
		ModConfig.OREGEMGLOWCHUNKDENSITY = config.get(CATEGORYOREGEN, "Glowstone Gem Ore Chunk Density", ModConfig.OREGEMGLOWCHUNKDENSITY).getInt(ModConfig.OREGEMGLOWCHUNKDENSITY);
		ModConfig.OREGEMGLOWYMIN = config.get(CATEGORYOREGEN, "Glowstone Gem Ore Minimum Y", ModConfig.OREGEMGLOWYMIN).getInt(ModConfig.OREGEMGLOWYMIN);
		ModConfig.OREGEMGLOWYMAX = config.get(CATEGORYOREGEN, "Glowstone Gem Ore Maximum Y", ModConfig.OREGEMGLOWYMAX).getInt(ModConfig.OREGEMGLOWYMAX);
		ModConfig.OREGEMGLOWGENERATEMIN = config.get(CATEGORYOREGEN, "Glowstone Gem Ore Minimum Generated", ModConfig.OREGEMGLOWGENERATEMIN).getInt(ModConfig.OREGEMGLOWGENERATEMIN);
		ModConfig.OREGEMGLOWGENERATEMAX = config.get(CATEGORYOREGEN, "Glowstone Gem Ore Maximum Generated", ModConfig.OREGEMGLOWGENERATEMAX).getInt(ModConfig.OREGEMGLOWGENERATEMAX);
	
		ModConfig.OREGEMQUARTZCHUNKDENSITY = config.get(CATEGORYOREGEN, "Quartz Gem Ore Chunk Density", ModConfig.OREGEMQUARTZCHUNKDENSITY).getInt(ModConfig.OREGEMQUARTZCHUNKDENSITY);
		ModConfig.OREGEMQUARTZYMIN = config.get(CATEGORYOREGEN, "Quartz Gem Ore Minimum Y", ModConfig.OREGEMQUARTZYMIN).getInt(ModConfig.OREGEMQUARTZYMIN);
		ModConfig.OREGEMQUARTZYMAX = config.get(CATEGORYOREGEN, "Quartz Gem Ore Maximum Y", ModConfig.OREGEMQUARTZYMAX).getInt(ModConfig.OREGEMQUARTZYMAX);
		ModConfig.OREGEMQUARTZGENERATEMIN = config.get(CATEGORYOREGEN, "Quartz Gem Ore Minimum Generated", ModConfig.OREGEMQUARTZGENERATEMIN).getInt(ModConfig.OREGEMQUARTZGENERATEMIN);
		ModConfig.OREGEMQUARTZGENERATEMAX = config.get(CATEGORYOREGEN, "Quartz Gem Ore Maximum Generated", ModConfig.OREGEMQUARTZGENERATEMAX).getInt(ModConfig.OREGEMQUARTZGENERATEMAX);
	
		ModConfig.OREGEMENDCHUNKDENSITY = config.get(CATEGORYOREGEN, "End Gem Ore Chunk Density", ModConfig.OREGEMENDCHUNKDENSITY).getInt(ModConfig.OREGEMENDCHUNKDENSITY);
		ModConfig.OREGEMENDGENERATEMIN = config.get(CATEGORYOREGEN, "End Gem Ore Minimum Generated", ModConfig.OREGEMENDGENERATEMIN).getInt(ModConfig.OREGEMENDGENERATEMIN);
		ModConfig.OREGEMENDGENERATEMAX = config.get(CATEGORYOREGEN, "End Gem Ore Maximum Generated", ModConfig.OREGEMENDGENERATEMAX).getInt(ModConfig.OREGEMENDGENERATEMAX);
			
		config.save();
	}	
}
