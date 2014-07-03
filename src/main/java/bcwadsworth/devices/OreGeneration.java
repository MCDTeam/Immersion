package bcwadsworth.devices;

import java.util.Random;

import bcwadsworth.devices.resources.ConfigLoad;
import bcwadsworth.devices.resources.api.ORef;
import bcwadsworth.devices.resources.core.Generators;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.event.terraingen.OreGenEvent;
import cpw.mods.fml.common.IWorldGenerator;

public class OreGeneration implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
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
		if (ConfigLoad.OREGEMENDCHUNKDENSITY == 1 && ConfigLoad.OREGEMENDGENERATE)//OreGemEnd
		{
			Generators.createVein(world, random, ORef.oreGemEnd, Blocks.end_stone, chunkX, chunkZ, 1, 256, ConfigLoad.OREGEMENDGENERATEMIN, ConfigLoad.OREGEMENDGENERATEMAX);
		}
		else if ((0 == random.nextInt(ConfigLoad.OREGEMENDCHUNKDENSITY-1)) && ConfigLoad.OREGEMENDGENERATE)
		{
			Generators.createVein(world, random, ORef.oreGemEnd, Blocks.end_stone, chunkX, chunkZ, 1, 256, ConfigLoad.OREGEMENDGENERATEMIN, ConfigLoad.OREGEMENDGENERATEMAX);
		}
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) 
	{
		if (ConfigLoad.OREGEMREDCHUNKDENSITY == 1 && ConfigLoad.OREGEMREDGENERATE)// OreGemRed
		{
			Generators.createVein(world, random, ORef.oreGemRed, Blocks.stone, chunkX, chunkZ, ConfigLoad.OREGEMREDYMIN, ConfigLoad.OREGEMREDYMAX, ConfigLoad.OREGEMREDGENERATEMIN, ConfigLoad.OREGEMREDGENERATEMAX);
		}
		else if ((0 == random.nextInt(ConfigLoad.OREGEMREDCHUNKDENSITY-1)) && ConfigLoad.OREGEMREDGENERATE)
		{
			Generators.createVein(world, random, ORef.oreGemRed, Blocks.stone, chunkX, chunkZ, ConfigLoad.OREGEMREDYMIN, ConfigLoad.OREGEMREDYMAX, ConfigLoad.OREGEMREDGENERATEMIN, ConfigLoad.OREGEMREDGENERATEMAX);
		}
		
		if (ConfigLoad.OREGEMDIAMONDCHUNKDENSITY == 1 && ConfigLoad.OREGEMDIAMONDGENERATE)// OreGemDiamond
		{
			Generators.createVein(world, random, ORef.oreGemDiamond, Blocks.stone, chunkX, chunkZ, ConfigLoad.OREGEMDIAMONDYMIN, ConfigLoad.OREGEMDIAMONDYMAX, ConfigLoad.OREGEMDIAMONDGENERATEMIN, ConfigLoad.OREGEMDIAMONDGENERATEMAX);
		}
		else if ((0 == random.nextInt(ConfigLoad.OREGEMDIAMONDCHUNKDENSITY-1)) && ConfigLoad.OREGEMDIAMONDGENERATE)
		{
			Generators.createVein(world, random, ORef.oreGemDiamond, Blocks.stone, chunkX, chunkZ, ConfigLoad.OREGEMDIAMONDYMIN, ConfigLoad.OREGEMDIAMONDYMAX, ConfigLoad.OREGEMDIAMONDGENERATEMIN, ConfigLoad.OREGEMDIAMONDGENERATEMAX);
		}
		
		if (ConfigLoad.OREGEMEMERALDCHUNKDENSITY == 1 && ConfigLoad.OREGEMEMERALDGENERATE)// OreGemEmerald
		{
			Generators.createVein(world, random, ORef.oreGemEmerald, Blocks.stone, chunkX, chunkZ, ConfigLoad.OREGEMEMERALDYMIN, ConfigLoad.OREGEMEMERALDYMAX, ConfigLoad.OREGEMEMERALDGENERATEMIN, ConfigLoad.OREGEMEMERALDGENERATEMAX);
		}
		else if ((0 == random.nextInt(ConfigLoad.OREGEMEMERALDCHUNKDENSITY-1)) && ConfigLoad.OREGEMEMERALDGENERATE)
		{
			Generators.createVein(world, random, ORef.oreGemEmerald, Blocks.stone, chunkX, chunkZ, ConfigLoad.OREGEMEMERALDYMIN, ConfigLoad.OREGEMEMERALDYMAX, ConfigLoad.OREGEMEMERALDGENERATEMIN, ConfigLoad.OREGEMEMERALDGENERATEMAX);
		}
	}
	private void generateNether(World world, Random random, int chunkX, int chunkZ) 
	{
		if (ConfigLoad.OREGEMGLOWCHUNKDENSITY == 1 && ConfigLoad.OREGEMREDGENERATE)// OreGemGlow
		{
			Generators.createVein(world, random, ORef.oreGemGlow, Blocks.netherrack, chunkX, chunkZ, ConfigLoad.OREGEMGLOWYMIN, ConfigLoad.OREGEMGLOWYMAX, ConfigLoad.OREGEMGLOWGENERATEMIN, ConfigLoad.OREGEMGLOWGENERATEMAX);
		}
		else if ((0 == random.nextInt(ConfigLoad.OREGEMGLOWCHUNKDENSITY-1)) && ConfigLoad.OREGEMGLOWGENERATE)
		{
			Generators.createVein(world, random, ORef.oreGemGlow, Blocks.netherrack, chunkX, chunkZ, ConfigLoad.OREGEMGLOWYMIN, ConfigLoad.OREGEMGLOWYMAX, ConfigLoad.OREGEMGLOWGENERATEMIN, ConfigLoad.OREGEMGLOWGENERATEMAX);
		}
		
		if (ConfigLoad.OREGEMQUARTZCHUNKDENSITY == 1 && ConfigLoad.OREGEMREDGENERATE)// OreGemQuartz
		{
			Generators.createVein(world, random, ORef.oreGemQuartz, Blocks.netherrack, chunkX, chunkZ, ConfigLoad.OREGEMQUARTZYMIN, ConfigLoad.OREGEMQUARTZYMAX, ConfigLoad.OREGEMQUARTZGENERATEMIN, ConfigLoad.OREGEMQUARTZGENERATEMAX);
		}
		else if ((0 == random.nextInt(ConfigLoad.OREGEMQUARTZCHUNKDENSITY-1)) && ConfigLoad.OREGEMQUARTZGENERATE)
		{
			Generators.createVein(world, random, ORef.oreGemQuartz, Blocks.netherrack, chunkX, chunkZ, ConfigLoad.OREGEMQUARTZYMIN, ConfigLoad.OREGEMQUARTZYMAX, ConfigLoad.OREGEMQUARTZGENERATEMIN, ConfigLoad.OREGEMQUARTZGENERATEMAX);
		}
	}
	
}

