package bcwadsworth.devices.generation;

import java.util.Random;

import bcwadsworth.devices.Devices;
import bcwadsworth.devices.blocks.RedGemOre;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class oreGeneration implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.dimensionId){
        case -1:
            generateNether(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 0:
            generateSurface(world, random, chunkX * 16, chunkZ * 16);
            break;
        case 1:
            generateEnd(world, random, chunkX * 16, chunkZ * 16);
            break;
        }
	}

	private void generateEnd(World world, Random random, int chunkX, int chunkZ) 
	{
		
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) 
	{
        if (random.nextBoolean())
        {
        	(new WorldGenMinable(Devices.redGemOre, random.nextInt(20))).generate(world, random, chunkX*16 + random.nextInt(16), 4 + random.nextInt(9), chunkZ*16 + random.nextInt(16));
        }
	}

	private void generateNether(World world, Random random, int chunkX, int chunkZ) 
	{
		
	}
}

