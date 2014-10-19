package teamUnknown.immersion.features.oreGenFeature;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.terraingen.OreGenEvent;
import teamUnknown.immersion.features.oreGenFeature.config.OreGenConfig;

import java.util.Random;

public class OreGeneration  implements IWorldGenerator
{
    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
        switch (world.provider.dimensionId) {

            case -1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
                return;

            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
                return;

            case 1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16);
                return;

            default:
                //Exception.Catch all for other mod dimensions- If they are stone based, generation will occur
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
                return;
        }
    }

    private void generateEnd(World world, Random random, int chunkX, int chunkZ) {
        for (int k = 0; k < OreGenConfig.ORE_GEM_END_CHUNK_DENSITY; k++) {
            new WorldGenMinable(ORef.oreGemEnd, (OreGenConfig.ORE_GEM_END_CHUNK_DENSITY + random.nextInt(OreGenConfig.ORE_GEM_END_CHUNK_DENSITY - OreGenConfig.ORE_GEM_END_GENERATE_MIN)), Blocks.end_stone).generate(world, random, (chunkX + random.nextInt(16)), random.nextInt(64), (chunkZ + random.nextInt(16)));
        }
    }

    private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
        for (int k = 0; k < OreGenConfig.ORE_GEM_RED_CHUNK_DENSITY; k++) {
            new WorldGenMinable(ORef.oreGemRed, (OreGenConfig.ORE_GEM_RED_GENERATE_MIN + random.nextInt(OreGenConfig.ORE_GEM_RED_GENERATE_MAX - OreGenConfig.ORE_GEM_RED_GENERATE_MIN))).generate(world, random, (chunkX + random.nextInt(16)), (OreGenConfig.ORE_GEM_RED_Y_MIN + random.nextInt(OreGenConfig.ORE_GEM_RED_Y_BREAK - OreGenConfig.ORE_GEM_RED_Y_MIN)), (chunkZ + random.nextInt(16)));
        }

        for (int k = 0; k < OreGenConfig.ORE_GEM_DIAMOND_CHUNK_DENSITY; k++) {
            new WorldGenMinable(ORef.oreGemDiamond, (OreGenConfig.ORE_GEM_DIAMOND_GENERATE_MIN + random.nextInt(OreGenConfig.ORE_GEM_DIAMOND_GENERATE_MAX - OreGenConfig.ORE_GEM_DIAMOND_GENERATE_MIN))).generate(world, random, (chunkX + random.nextInt(16)), (OreGenConfig.ORE_GEM_DIAMOND_Y_MIN + random.nextInt(OreGenConfig.ORE_GEM_DIAMOND_Y_BREAK - OreGenConfig.ORE_GEM_DIAMOND_Y_MIN)), (chunkZ + random.nextInt(16)));
        }

        for (int k = 0; k < OreGenConfig.ORE_GEM_EMERALD_CHUNK_DENSITY; k++) {
            new WorldGenMinable(ORef.oreGemEmerald, (OreGenConfig.ORE_GEM_EMERALD_GENERATE_MIN + random.nextInt(OreGenConfig.ORE_GEM_EMERALD_GENERATE_MAX - OreGenConfig.ORE_GEM_EMERALD_GENERATE_MIN))).generate(world, random, (chunkX + random.nextInt(16)), (OreGenConfig.ORE_GEM_EMERALD_Y_MIN + random.nextInt(OreGenConfig.ORE_GEM_EMERALD_Y_BREAK - OreGenConfig.ORE_GEM_EMERALD_Y_MIN)), (chunkZ + random.nextInt(16)));
        }
/**
        for (int k = 0; k < OreGenConfig.ORE_GEM_RED_CHUNK_DENSITY; k++) {
            new WorldGenMinable(ORef.oreGemRed, (OreGenConfig.OREGEMREDGENERATEMIN + random.nextInt(OreGenConfig.OREGEMREDGENERATEMAX - OreGenConfig.OREGEMREDGENERATEMIN))).generate(world, random, (chunkX + random.nextInt(16)), (OreGenConfig.OREGEMREDYMIN + random.nextInt(OreGenConfig.OREGEMREDYBREAK - OreGenConfig.OREGEMREDYMIN)), (chunkZ + random.nextInt(16)));
        }

        for (int k = 0; k < OreGenConfig.ORE_GEM_DIAMOND_CHUNK_DENSITY; k++) {
            new WorldGenMinable(ORef.oreGemDiamond, (OreGenConfig.OREGEMDIAMONDGENERATEMIN + random.nextInt(OreGenConfig.OREGEMDIAMONDGENERATEMAX - OreGenConfig.OREGEMDIAMONDGENERATEMIN))).generate(world, random, (chunkX + random.nextInt(16)), (OreGenConfig.OREGEMDIAMONDYMIN + random.nextInt(OreGenConfig.OREGEMDIAMONDYBREAK - OreGenConfig.OREGEMDIAMONDYMIN)), (chunkZ + random.nextInt(16)));
        }

        for (int k = 0; k < OreGenConfig.OREGEMEMERALDCHUNKDENSITY; k++) {
            new WorldGenMinable(ORef.oreGemEmerald, (OreGenConfig.OREGEMEMERALDGENERATEMIN + random.nextInt(OreGenConfig.OREGEMEMERALDGENERATEMAX - OreGenConfig.OREGEMEMERALDGENERATEMIN))).generate(world, random, (chunkX + random.nextInt(16)), (OreGenConfig.OREGEMEMERALDYMIN + random.nextInt(OreGenConfig.OREGEMEMERALDYBREAK - OreGenConfig.OREGEMEMERALDYMIN)), (chunkZ + random.nextInt(16)));
        }**/
    }

    private void generateNether(World world, Random random, int chunkX, int chunkZ) {
        for (int k = 0; k < OreGenConfig.ORE_GEM_GLOW_CHUNK_DENSITY; k++) {
            new WorldGenMinable(ORef.oreGemGlow, (OreGenConfig.ORE_GEM_GLOW_GENERATE_MIN + random.nextInt(OreGenConfig.ORE_GEM_GLOW_GENERATE_MAX - OreGenConfig.ORE_GEM_GLOW_GENERATE_MIN)), Blocks.netherrack).generate(world, random, (chunkX + random.nextInt(16)), (OreGenConfig.ORE_GEM_GLOW_Y_MIN + random.nextInt(OreGenConfig.ORE_GEM_GLOW_Y_MAX - OreGenConfig.ORE_GEM_GLOW_Y_MIN)), (chunkZ + random.nextInt(16)));
        }

        for (int k = 0; k < OreGenConfig.ORE_GEM_QUARTZ_CHUNK_DENSITY; k++) {
            new WorldGenMinable(ORef.oreGemQuartz, (OreGenConfig.ORE_GEM_QUARTZ_GENERATE_MIN + random.nextInt(OreGenConfig.ORE_GEM_QUARTZ_GENERATE_MAX - OreGenConfig.ORE_GEM_QUARTZ_GENERATE_MIN))).generate(world, random, (chunkX + random.nextInt(16)), (OreGenConfig.ORE_GEM_QUARTZ_Y_MIN + random.nextInt(OreGenConfig.ORE_GEM_QUARTZ_Y_BREAK - OreGenConfig.ORE_GEM_GLOW_Y_MIN)), (chunkZ + random.nextInt(16)));
        }
    }

    //Override of Vanilla Gen
    @SubscribeEvent
    public void undoVanillaGen(OreGenEvent.GenerateMinable event) {
        if(oreGenFeature.enableSpecialSpawning) {
            if (event.type == OreGenEvent.GenerateMinable.EventType.REDSTONE) {
                event.setResult(Event.Result.DENY);
            }
            if (event.type == OreGenEvent.GenerateMinable.EventType.DIAMOND) {
                event.setResult(Event.Result.DENY);
            }
            if (event.type == OreGenEvent.GenerateMinable.EventType.QUARTZ) {
                event.setResult(Event.Result.DENY);
            }
            if (event.type == OreGenEvent.GenerateMinable.EventType.IRON) {
                event.setResult(Event.Result.DENY);
            }
            if (event.type == OreGenEvent.GenerateMinable.EventType.GOLD) {
                event.setResult(Event.Result.DENY);
            }
            /**if (event.type == OreGenEvent.GenerateMinable.EventType.DIRT && OreGenConfig.GENERATEDIRTUNDERGROUND) {
             event.setResult(Event.Result.DENY);
             }**/
        }
    }

}

