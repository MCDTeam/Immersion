package bcwadsworth.devices;

import java.util.Random;

import bcwadsworth.devices.resources.ConfigLoad;
import bcwadsworth.devices.resources.Generators;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class OreGeneration implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch(world.provider.dimensionId)
		{
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
		if ((0 == random.nextInt(ConfigLoad.OREGEMENDCHUNKDENSITY-1)) && ConfigLoad.OREGEMENDGENERATE)
		{
			Generators.createVein(world, random, Devices.oreGemEnd, Blocks.end_stone, chunkX, chunkZ, 1, 256, ConfigLoad.OREGEMENDGENERATEMIN, ConfigLoad.OREGEMENDGENERATEMAX);
		}
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) 
	{
		if ((0 == random.nextInt(ConfigLoad.OREGEMREDCHUNKDENSITY-1)) && ConfigLoad.OREGEMREDGENERATE)
		{
			Generators.createVein(world, random, Devices.oreGemRed, Blocks.stone, chunkX, chunkZ, ConfigLoad.OREGEMREDYMIN, ConfigLoad.OREGEMREDYMAX, ConfigLoad.OREGEMREDGENERATEMIN, ConfigLoad.OREGEMREDGENERATEMAX); //Generate OreGemRed
		}
	}
	private void generateNether(World world, Random random, int chunkX, int chunkZ) 
	{
		//Currently Empty TODO: Add the Two Nether Ores
	}
	
}

