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
		if (ConfigLoad.OREGEMENDCHUNKDENSITY == 1)//OreGemEnd
		{
			Generators.createVein(world, random, Devices.oreGemEnd, Blocks.end_stone, chunkX, chunkZ, 1, 256, ConfigLoad.OREGEMENDGENERATEMIN, ConfigLoad.OREGEMENDGENERATEMAX);
		}
		else if ((0 == random.nextInt(ConfigLoad.OREGEMENDCHUNKDENSITY-1)) && ConfigLoad.OREGEMENDGENERATE)
		{
			Generators.createVein(world, random, Devices.oreGemEnd, Blocks.end_stone, chunkX, chunkZ, 1, 256, ConfigLoad.OREGEMENDGENERATEMIN, ConfigLoad.OREGEMENDGENERATEMAX);
		}
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) 
	{
		if (ConfigLoad.OREGEMREDCHUNKDENSITY == 1)// OreGemRed
		{
			Generators.createVein(world, random, Devices.oreGemRed, Blocks.stone, chunkX, chunkZ, ConfigLoad.OREGEMREDYMIN, ConfigLoad.OREGEMREDYMAX, ConfigLoad.OREGEMREDGENERATEMIN, ConfigLoad.OREGEMREDGENERATEMAX);
		}
		else if ((0 == random.nextInt(ConfigLoad.OREGEMREDCHUNKDENSITY-1)) && ConfigLoad.OREGEMREDGENERATE)
		{
			Generators.createVein(world, random, Devices.oreGemRed, Blocks.stone, chunkX, chunkZ, ConfigLoad.OREGEMREDYMIN, ConfigLoad.OREGEMREDYMAX, ConfigLoad.OREGEMREDGENERATEMIN, ConfigLoad.OREGEMREDGENERATEMAX);
		}
	}
	private void generateNether(World world, Random random, int chunkX, int chunkZ) 
	{
		if (ConfigLoad.OREGEMGLOWCHUNKDENSITY == 1)// OreGemGlow
		{
			Generators.createVein(world, random, Devices.oreGemRed, Blocks.netherrack, chunkX, chunkZ, ConfigLoad.OREGEMGLOWYMIN, ConfigLoad.OREGEMGLOWYMAX, ConfigLoad.OREGEMGLOWGENERATEMIN, ConfigLoad.OREGEMGLOWGENERATEMAX);
		}
		else if ((0 == random.nextInt(ConfigLoad.OREGEMGLOWCHUNKDENSITY-1)) && ConfigLoad.OREGEMGLOWGENERATE)
		{
			Generators.createVein(world, random, Devices.oreGemRed, Blocks.netherrack, chunkX, chunkZ, ConfigLoad.OREGEMGLOWYMIN, ConfigLoad.OREGEMGLOWYMAX, ConfigLoad.OREGEMGLOWGENERATEMIN, ConfigLoad.OREGEMGLOWGENERATEMAX);
		}
		
		if (ConfigLoad.OREGEMQUARTZCHUNKDENSITY == 1)// OreGemQuartz
		{
			Generators.createVein(world, random, Devices.oreGemRed, Blocks.netherrack, chunkX, chunkZ, ConfigLoad.OREGEMQUARTZYMIN, ConfigLoad.OREGEMQUARTZYMAX, ConfigLoad.OREGEMQUARTZGENERATEMIN, ConfigLoad.OREGEMQUARTZGENERATEMAX);
		}
		else if ((0 == random.nextInt(ConfigLoad.OREGEMQUARTZCHUNKDENSITY-1)) && ConfigLoad.OREGEMQUARTZGENERATE)
		{
			Generators.createVein(world, random, Devices.oreGemRed, Blocks.netherrack, chunkX, chunkZ, ConfigLoad.OREGEMQUARTZYMIN, ConfigLoad.OREGEMQUARTZYMAX, ConfigLoad.OREGEMQUARTZGENERATEMIN, ConfigLoad.OREGEMQUARTZGENERATEMAX);
		}
	}
	
}

