package bcwadsworth.devices.resources;

public class ConfigLoad 
{
	//This keeps all the variables returned from the config file and stores the default values
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
	
	public static Boolean OREGEMGLOWGENERATE = true;
	public static int OREGEMGLOWYMIN = 100;
	public static int OREGEMGLOWYMAX = 124;
	public static int OREGEMGLOWCHUNKDENSITY = 2;
	public static int OREGEMGLOWGENERATEMIN = 4;
	public static int OREGEMGLOWGENERATEMAX = 12;
	
	public static Boolean OREGEMQUARTZGENERATE = true;
	public static int OREGEMQUARTZYMIN = 4;
	public static int OREGEMQUARTZYMAX = 28;
	public static int OREGEMQUARTZCHUNKDENSITY = 2;
	public static int OREGEMQUARTZGENERATEMIN = 4;
	public static int OREGEMQUARTZGENERATEMAX = 12;
	
	public static Boolean OREGEMENDGENERATE = true;
	public static int OREGEMENDCHUNKDENSITY = 1;
	public static int OREGEMENDGENERATEMIN = 2;
	public static int OREGEMENDGENERATEMAX = 6;
	
}
