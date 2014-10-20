package teamUnknown.immersion.features.oreGenFeature;

import net.minecraftforge.common.config.Configuration;

/**
 *
 */
public class OreGenConfig {
    //This keeps all the variables returned from the config file and stores the default values
    public static Boolean DEFAULT_CONFIG = true;

    //OreGeneration
    public static int ORE_GEM_RED_Y_MIN = 4;
    public static int ORE_GEM_RED_Y_BREAK = 12;
    public static int ORE_GEM_RED_Y_MAX = 24;
    public static int ORE_GEM_RED_CHUNK_DENSITY = 4;
    public static int ORE_GEM_RED_GENERATE_MIN = 2;
    public static int ORE_GEM_RED_GENERATE_MAX = 6;

    public static int ORE_GEM_DIAMOND_Y_MIN = 4;
    public static int ORE_GEM_DIAMOND_Y_BREAK = 12;
    public static int ORE_GEM_DIAMOND_Y_MAX = 24;
    public static int ORE_GEM_DIAMOND_CHUNK_DENSITY = 4;
    public static int ORE_GEM_DIAMOND_GENERATE_MIN = 2;
    public static int ORE_GEM_DIAMOND_GENERATE_MAX = 6;

    public static int ORE_GEM_EMERALD_Y_MIN = 4;
    public static int ORE_GEM_EMERALD_Y_BREAK = 12;
    public static int ORE_GEM_EMERALD_Y_MAX = 24;
    public static int ORE_GEM_EMERALD_CHUNK_DENSITY = 4;
    public static int ORE_GEM_EMERALD_GENERATE_MIN = 2;
    public static int ORE_GEM_EMERALD_GENERATE_MAX = 6;

    public static int ORE_GEM_GLOW_Y_MIN = 100;
    public static int ORE_GEM_GLOW_Y_MAX = 124;
    public static int ORE_GEM_GLOW_CHUNK_DENSITY = 2;
    public static int ORE_GEM_GLOW_GENERATE_MIN = 2;
    public static int ORE_GEM_GLOW_GENERATE_MAX = 6;

    public static int ORE_GEM_QUARTZ_Y_MIN = 4;
    public static int ORE_GEM_QUARTZ_Y_BREAK = 12;
    public static int ORE_GEM_QUARTZ_Y_MAX = 64;
    public static int ORE_GEM_QUARTZ_CHUNK_DENSITY = 2;
    public static int ORE_GEM_QUARTZ_GENERATE_MIN = 4;
    public static int ORE_GEM_QUARTZ_GENERATE_MAX = 6;

    public static int ORE_GEM_END_CHUNK_DENSITY = 4;
    public static int ORE_GEM_END_GENERATE_MIN = 2;
    public static int ORE_GEM_END_GENERATE_MAX = 8;

    public static Boolean GENERATE_DIRT_UNDERGROUND = true;
    public static Boolean ADDITIONAL_FUELS = true;

    public static void configLoad(Configuration config)
    {
        config.load();

        // Checking for defaults, skipping loading if defaultconfig is true
        String CATEGORY_DEFAULTS = "Defaults";
        if (config.get(CATEGORY_DEFAULTS, "Use the Default Config", true).getBoolean(true))
        {
            return;
        }

        // OreGen Category
        String CATEGORY_ORE_GEN = "Ore Generation";

        OreGenConfig.ORE_GEM_RED_CHUNK_DENSITY = config.get(CATEGORY_ORE_GEN, "Redstone Gem Ore Chunk Density", OreGenConfig.ORE_GEM_RED_CHUNK_DENSITY).getInt(OreGenConfig.ORE_GEM_RED_CHUNK_DENSITY);
        OreGenConfig.ORE_GEM_RED_Y_MIN = config.get(CATEGORY_ORE_GEN, "Redstone Gem Ore Minimum Y", OreGenConfig.ORE_GEM_RED_Y_MIN).getInt(OreGenConfig.ORE_GEM_RED_Y_MIN);
        OreGenConfig.ORE_GEM_RED_Y_MAX = config.get(CATEGORY_ORE_GEN, "Redstone Gem Ore Maximum Y", OreGenConfig.ORE_GEM_RED_Y_MAX).getInt(OreGenConfig.ORE_GEM_RED_Y_MAX);
        OreGenConfig.ORE_GEM_RED_GENERATE_MIN = config.get(CATEGORY_ORE_GEN, "Redstone Gem Ore Minimum Generated", OreGenConfig.ORE_GEM_RED_GENERATE_MIN).getInt(OreGenConfig.ORE_GEM_RED_GENERATE_MIN);
        OreGenConfig.ORE_GEM_RED_GENERATE_MAX = config.get(CATEGORY_ORE_GEN, "Redstone Gem Ore Maximum Generated", OreGenConfig.ORE_GEM_RED_GENERATE_MAX).getInt(OreGenConfig.ORE_GEM_RED_GENERATE_MAX);

        OreGenConfig.ORE_GEM_DIAMOND_CHUNK_DENSITY = config.get(CATEGORY_ORE_GEN, "Diamond Gem Ore Chunk Density", OreGenConfig.ORE_GEM_DIAMOND_CHUNK_DENSITY).getInt(OreGenConfig.ORE_GEM_DIAMOND_CHUNK_DENSITY);
        OreGenConfig.ORE_GEM_DIAMOND_Y_MIN = config.get(CATEGORY_ORE_GEN, "Diamond Gem Ore Minimum Y", OreGenConfig.ORE_GEM_DIAMOND_Y_MIN).getInt(OreGenConfig.ORE_GEM_DIAMOND_Y_MIN);
        OreGenConfig.ORE_GEM_DIAMOND_Y_MAX = config.get(CATEGORY_ORE_GEN, "Diamond Gem Ore Maximum Y", OreGenConfig.ORE_GEM_DIAMOND_Y_MAX).getInt(OreGenConfig.ORE_GEM_DIAMOND_Y_MAX);
        OreGenConfig.ORE_GEM_DIAMOND_GENERATE_MIN = config.get(CATEGORY_ORE_GEN, "Diamond Gem Ore Minimum Generated", OreGenConfig.ORE_GEM_DIAMOND_GENERATE_MIN).getInt(OreGenConfig.ORE_GEM_DIAMOND_GENERATE_MIN);
        OreGenConfig.ORE_GEM_DIAMOND_GENERATE_MAX = config.get(CATEGORY_ORE_GEN, "Diamond Gem Ore Maximum Generated", OreGenConfig.ORE_GEM_DIAMOND_GENERATE_MAX).getInt(OreGenConfig.ORE_GEM_DIAMOND_GENERATE_MAX);

        OreGenConfig.ORE_GEM_EMERALD_CHUNK_DENSITY = config.get(CATEGORY_ORE_GEN, "Emerald Gem Ore Chunk Density", OreGenConfig.ORE_GEM_EMERALD_CHUNK_DENSITY).getInt(OreGenConfig.ORE_GEM_EMERALD_CHUNK_DENSITY);
        OreGenConfig.ORE_GEM_EMERALD_Y_MIN = config.get(CATEGORY_ORE_GEN, "Emerald Gem Ore Minimum Y", OreGenConfig.ORE_GEM_EMERALD_Y_MIN).getInt(OreGenConfig.ORE_GEM_EMERALD_Y_MIN);
        OreGenConfig.ORE_GEM_EMERALD_Y_MAX = config.get(CATEGORY_ORE_GEN, "Emerald Gem Ore Maximum Y", OreGenConfig.ORE_GEM_EMERALD_Y_MAX).getInt(OreGenConfig.ORE_GEM_EMERALD_Y_MAX);
        OreGenConfig.ORE_GEM_EMERALD_GENERATE_MIN = config.get(CATEGORY_ORE_GEN, "Emerald Gem Ore Minimum Generated", OreGenConfig.ORE_GEM_EMERALD_GENERATE_MIN).getInt(OreGenConfig.ORE_GEM_EMERALD_GENERATE_MIN);
        OreGenConfig.ORE_GEM_EMERALD_GENERATE_MAX = config.get(CATEGORY_ORE_GEN, "Emerald Gem Ore Maximum Generated", OreGenConfig.ORE_GEM_EMERALD_GENERATE_MAX).getInt(OreGenConfig.ORE_GEM_EMERALD_GENERATE_MAX);

        OreGenConfig.ORE_GEM_GLOW_CHUNK_DENSITY = config.get(CATEGORY_ORE_GEN, "Glowstone Gem Ore Chunk Density", OreGenConfig.ORE_GEM_GLOW_CHUNK_DENSITY).getInt(OreGenConfig.ORE_GEM_GLOW_CHUNK_DENSITY);
        OreGenConfig.ORE_GEM_GLOW_Y_MIN = config.get(CATEGORY_ORE_GEN, "Glowstone Gem Ore Minimum Y", OreGenConfig.ORE_GEM_GLOW_Y_MIN).getInt(OreGenConfig.ORE_GEM_GLOW_Y_MIN);
        OreGenConfig.ORE_GEM_GLOW_Y_MAX = config.get(CATEGORY_ORE_GEN, "Glowstone Gem Ore Maximum Y", OreGenConfig.ORE_GEM_GLOW_Y_MAX).getInt(OreGenConfig.ORE_GEM_GLOW_Y_MAX);
        OreGenConfig.ORE_GEM_GLOW_GENERATE_MIN = config.get(CATEGORY_ORE_GEN, "Glowstone Gem Ore Minimum Generated", OreGenConfig.ORE_GEM_GLOW_GENERATE_MIN).getInt(OreGenConfig.ORE_GEM_GLOW_GENERATE_MIN);
        OreGenConfig.ORE_GEM_GLOW_GENERATE_MAX = config.get(CATEGORY_ORE_GEN, "Glowstone Gem Ore Maximum Generated", OreGenConfig.ORE_GEM_GLOW_GENERATE_MAX).getInt(OreGenConfig.ORE_GEM_GLOW_GENERATE_MAX);

        OreGenConfig.ORE_GEM_QUARTZ_CHUNK_DENSITY = config.get(CATEGORY_ORE_GEN, "Quartz Gem Ore Chunk Density", OreGenConfig.ORE_GEM_QUARTZ_CHUNK_DENSITY).getInt(OreGenConfig.ORE_GEM_QUARTZ_CHUNK_DENSITY);
        OreGenConfig.ORE_GEM_QUARTZ_Y_MIN = config.get(CATEGORY_ORE_GEN, "Quartz Gem Ore Minimum Y", OreGenConfig.ORE_GEM_QUARTZ_Y_MIN).getInt(OreGenConfig.ORE_GEM_QUARTZ_Y_MIN);
        OreGenConfig.ORE_GEM_QUARTZ_Y_MAX = config.get(CATEGORY_ORE_GEN, "Quartz Gem Ore Maximum Y", OreGenConfig.ORE_GEM_QUARTZ_Y_MAX).getInt(OreGenConfig.ORE_GEM_QUARTZ_Y_MAX);
        OreGenConfig.ORE_GEM_QUARTZ_GENERATE_MIN = config.get(CATEGORY_ORE_GEN, "Quartz Gem Ore Minimum Generated", OreGenConfig.ORE_GEM_QUARTZ_GENERATE_MIN).getInt(OreGenConfig.ORE_GEM_QUARTZ_GENERATE_MIN);
        OreGenConfig.ORE_GEM_QUARTZ_GENERATE_MAX = config.get(CATEGORY_ORE_GEN, "Quartz Gem Ore Maximum Generated", OreGenConfig.ORE_GEM_QUARTZ_GENERATE_MAX).getInt(OreGenConfig.ORE_GEM_QUARTZ_GENERATE_MAX);

        OreGenConfig.ORE_GEM_END_CHUNK_DENSITY = config.get(CATEGORY_ORE_GEN, "End Gem Ore Chunk Density", OreGenConfig.ORE_GEM_END_CHUNK_DENSITY).getInt(OreGenConfig.ORE_GEM_END_CHUNK_DENSITY);
        OreGenConfig.ORE_GEM_END_GENERATE_MIN = config.get(CATEGORY_ORE_GEN, "End Gem Ore Minimum Generated", OreGenConfig.ORE_GEM_END_GENERATE_MIN).getInt(OreGenConfig.ORE_GEM_END_GENERATE_MIN);
        OreGenConfig.ORE_GEM_END_GENERATE_MAX = config.get(CATEGORY_ORE_GEN, "End Gem Ore Maximum Generated", OreGenConfig.ORE_GEM_END_GENERATE_MAX).getInt(OreGenConfig.ORE_GEM_END_GENERATE_MAX);

        config.save();
    }
}
