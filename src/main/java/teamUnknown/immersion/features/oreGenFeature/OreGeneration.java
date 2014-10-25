package teamUnknown.immersion.features.oreGenFeature;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.event.terraingen.OreGenEvent;

import java.util.Random;

public class OreGeneration implements IWorldGenerator
{
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
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
				//Catch all for other mod dimensions- If they are stone based, generation will occur
				generateSurface(world, random, chunkX * 16, chunkZ * 16);
				return;
		}
	}

	private void generateEnd(World world, Random random, int chunkX, int chunkZ)
	{/**
		for(int k = 0; k < ModMetadata.OREGEMENDCHUNKDENSITY; k++)
		{
		    new WorldGenMinable(ORef.oreGemEnd, (ModMetadata.OREGEMENDGENERATEMIN + random.nextInt(ModMetadata.OREGEMENDGENERATEMAX - ModMetadata.OREGEMENDGENERATEMIN)), Blocks.end_stone).generate(world, random, (chunkX + random.nextInt(16)), random.nextInt(64), (chunkZ + random.nextInt(16)));
		}**/
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ)
	{/**
		for(int k = 0; k < ModMetadata.OREGEMREDCHUNKDENSITY; k++)
		{
		    new WorldGenMinable(ORef.oreGemRed, (ModMetadata.OREGEMREDGENERATEMIN + random.nextInt(ModMetadata.OREGEMREDGENERATEMAX - ModMetadata.OREGEMREDGENERATEMIN))).generate(world, random, (chunkX + random.nextInt(16)), (ModMetadata.OREGEMREDYMIN + random.nextInt(ModMetadata.OREGEMREDYBREAK - ModMetadata.OREGEMREDYMIN)), (chunkZ + random.nextInt(16)));
		}

		for(int k = 0; k < ModMetadata.OREGEMDIAMONDCHUNKDENSITY; k++)
		{
		    new WorldGenMinable(ORef.oreGemDiamond, (ModMetadata.OREGEMDIAMONDGENERATEMIN + random.nextInt(ModMetadata.OREGEMDIAMONDGENERATEMAX - ModMetadata.OREGEMDIAMONDGENERATEMIN))).generate(world, random, (chunkX + random.nextInt(16)), (ModMetadata.OREGEMDIAMONDYMIN + random.nextInt(ModMetadata.OREGEMDIAMONDYBREAK - ModMetadata.OREGEMDIAMONDYMIN)), (chunkZ + random.nextInt(16)));
		}

		for(int k = 0; k < ModMetadata.OREGEMEMERALDCHUNKDENSITY; k++)
		{
		    new WorldGenMinable(ORef.oreGemEmerald, (ModMetadata.OREGEMEMERALDGENERATEMIN + random.nextInt(ModMetadata.OREGEMEMERALDGENERATEMAX - ModMetadata.OREGEMEMERALDGENERATEMIN))).generate(world, random, (chunkX + random.nextInt(16)), (ModMetadata.OREGEMEMERALDYMIN + random.nextInt(ModMetadata.OREGEMEMERALDYBREAK - ModMetadata.OREGEMEMERALDYMIN)), (chunkZ + random.nextInt(16)));
		}

		for(int k = 0; k < ModMetadata.OREGEMREDCHUNKDENSITY; k++)
		{
		    new WorldGenMinable(ORef.oreGemRed, (ModMetadata.OREGEMREDGENERATEMIN + random.nextInt(ModMetadata.OREGEMREDGENERATEMAX - ModMetadata.OREGEMREDGENERATEMIN))).generate(world, random, (chunkX + random.nextInt(16)), (ModMetadata.OREGEMREDYMIN + random.nextInt(ModMetadata.OREGEMREDYBREAK - ModMetadata.OREGEMREDYMIN)), (chunkZ + random.nextInt(16)));
		}

		for(int k = 0; k < ModMetadata.OREGEMDIAMONDCHUNKDENSITY; k++)
		{
		    new WorldGenMinable(ORef.oreGemDiamond, (ModMetadata.OREGEMDIAMONDGENERATEMIN + random.nextInt(ModMetadata.OREGEMDIAMONDGENERATEMAX - ModMetadata.OREGEMDIAMONDGENERATEMIN))).generate(world, random, (chunkX + random.nextInt(16)), (ModMetadata.OREGEMDIAMONDYMIN + random.nextInt(ModMetadata.OREGEMDIAMONDYBREAK - ModMetadata.OREGEMDIAMONDYMIN)), (chunkZ + random.nextInt(16)));
		}

		for(int k = 0; k < ModMetadata.OREGEMEMERALDCHUNKDENSITY; k++)
		{
		    new WorldGenMinable(ORef.oreGemEmerald, (ModMetadata.OREGEMEMERALDGENERATEMIN + random.nextInt(ModMetadata.OREGEMEMERALDGENERATEMAX - ModMetadata.OREGEMEMERALDGENERATEMIN))).generate(world, random, (chunkX + random.nextInt(16)), (ModMetadata.OREGEMEMERALDYMIN + random.nextInt(ModMetadata.OREGEMEMERALDYBREAK - ModMetadata.OREGEMEMERALDYMIN)), (chunkZ + random.nextInt(16)));
		}**/
	}
	
	private void generateNether(World world, Random random, int chunkX, int chunkZ)
	{/**
		for(int k = 0; k < ModMetadata.OREGEMGLOWCHUNKDENSITY; k++)
		{
		    new WorldGenMinable(ORef.oreGemGlow, (ModMetadata.OREGEMGLOWGENERATEMIN + random.nextInt(ModMetadata.OREGEMGLOWGENERATEMAX - ModMetadata.OREGEMGLOWGENERATEMIN)), Blocks.netherrack).generate(world, random, (chunkX + random.nextInt(16)), (ModMetadata.OREGEMGLOWYMIN + random.nextInt(ModMetadata.OREGEMGLOWYMAX - ModMetadata.OREGEMGLOWYMIN)), (chunkZ + random.nextInt(16)));
		}

		for(int k = 0; k < ModMetadata.OREGEMQUARTZCHUNKDENSITY; k++)
		{
		    new WorldGenMinable(ORef.oreGemQuartz, (ModMetadata.OREGEMQUARTZGENERATEMIN + random.nextInt(ModMetadata.OREGEMQUARTZGENERATEMAX - ModMetadata.OREGEMQUARTZGENERATEMIN))).generate(world, random, (chunkX + random.nextInt(16)), (ModMetadata.OREGEMQUARTZYMIN + random.nextInt(ModMetadata.OREGEMQUARTZYBREAK - ModMetadata.OREGEMQUARTZYMIN)), (chunkZ + random.nextInt(16)));
		}**/
	}

	//Override of Vanilla Gen
	@SubscribeEvent
	public void undoVanillaGen (OreGenEvent.GenerateMinable event)
	{
		if (event.type == OreGenEvent.GenerateMinable.EventType.REDSTONE)
		{
			event.setResult(Result.DENY);
		}
		if (event.type == OreGenEvent.GenerateMinable.EventType.DIAMOND)
		{
			event.setResult(Result.DENY);
		}
		if (event.type == OreGenEvent.GenerateMinable.EventType.QUARTZ)
		{
			event.setResult(Result.DENY);
		}
		if (event.type == OreGenEvent.GenerateMinable.EventType.IRON)
		{
			event.setResult(Result.DENY);
		}
		if (event.type == OreGenEvent.GenerateMinable.EventType.GOLD)
		{
			event.setResult(Result.DENY);
		}
		/**if (event.type == OreGenEvent.GenerateMinable.EventType.DIRT && ModMetadata.GENERATEDIRTUNDERGROUND)
		{
			event.setResult(Result.DENY);
		}**/
	}
	
}

