package bcwadsworth.bcwadsworthWorld;

import java.util.Random;

import bcwadsworth.bcwadsworthWorld.ORef;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.terraingen.OreGenEvent;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

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
	{
		for(int k = 0; k < ModConfig.OREGEMENDCHUNKDENSITY; k++) 
		{
		    new WorldGenMinable(ORef.oreGemEnd, (ModConfig.OREGEMENDGENERATEMIN + random.nextInt(ModConfig.OREGEMENDGENERATEMAX - ModConfig.OREGEMENDGENERATEMIN)), Blocks.end_stone).generate(world, random, (chunkX + random.nextInt(16)), random.nextInt(64), (chunkZ + random.nextInt(16)));
		}
	}
	
	private void generateSurface(World world, Random random, int chunkX, int chunkZ) 
	{
		for(int k = 0; k < ModConfig.OREGEMREDCHUNKDENSITY; k++) 
		{
		    new WorldGenMinable(ORef.oreGemRed, (ModConfig.OREGEMREDGENERATEMIN + random.nextInt(ModConfig.OREGEMREDGENERATEMAX - ModConfig.OREGEMREDGENERATEMIN))).generate(world, random, (chunkX + random.nextInt(16)), (ModConfig.OREGEMREDYMIN + random.nextInt(ModConfig.OREGEMREDYBREAK - ModConfig.OREGEMREDYMIN)), (chunkZ + random.nextInt(16)));
		}
		
		for(int k = 0; k < ModConfig.OREGEMDIAMONDCHUNKDENSITY; k++) 
		{
		    new WorldGenMinable(ORef.oreGemDiamond, (ModConfig.OREGEMDIAMONDGENERATEMIN + random.nextInt(ModConfig.OREGEMDIAMONDGENERATEMAX - ModConfig.OREGEMDIAMONDGENERATEMIN))).generate(world, random, (chunkX + random.nextInt(16)), (ModConfig.OREGEMDIAMONDYMIN + random.nextInt(ModConfig.OREGEMDIAMONDYBREAK - ModConfig.OREGEMDIAMONDYMIN)), (chunkZ + random.nextInt(16)));
		}
		
		for(int k = 0; k < ModConfig.OREGEMEMERALDCHUNKDENSITY; k++) 
		{
		    new WorldGenMinable(ORef.oreGemEmerald, (ModConfig.OREGEMEMERALDGENERATEMIN + random.nextInt(ModConfig.OREGEMEMERALDGENERATEMAX - ModConfig.OREGEMEMERALDGENERATEMIN))).generate(world, random, (chunkX + random.nextInt(16)), (ModConfig.OREGEMEMERALDYMIN + random.nextInt(ModConfig.OREGEMEMERALDYBREAK - ModConfig.OREGEMEMERALDYMIN)), (chunkZ + random.nextInt(16)));
		}
		
		for(int k = 0; k < ModConfig.OREGEMREDCHUNKDENSITY; k++) 
		{
		    new WorldGenMinable(ORef.oreGemRed, (ModConfig.OREGEMREDGENERATEMIN + random.nextInt(ModConfig.OREGEMREDGENERATEMAX - ModConfig.OREGEMREDGENERATEMIN))).generate(world, random, (chunkX + random.nextInt(16)), (ModConfig.OREGEMREDYMIN + random.nextInt(ModConfig.OREGEMREDYBREAK - ModConfig.OREGEMREDYMIN)), (chunkZ + random.nextInt(16)));
		}
		
		for(int k = 0; k < ModConfig.OREGEMDIAMONDCHUNKDENSITY; k++) 
		{
		    new WorldGenMinable(ORef.oreGemDiamond, (ModConfig.OREGEMDIAMONDGENERATEMIN + random.nextInt(ModConfig.OREGEMDIAMONDGENERATEMAX - ModConfig.OREGEMDIAMONDGENERATEMIN))).generate(world, random, (chunkX + random.nextInt(16)), (ModConfig.OREGEMDIAMONDYMIN + random.nextInt(ModConfig.OREGEMDIAMONDYBREAK - ModConfig.OREGEMDIAMONDYMIN)), (chunkZ + random.nextInt(16)));
		}
		
		for(int k = 0; k < ModConfig.OREGEMEMERALDCHUNKDENSITY; k++) 
		{
		    new WorldGenMinable(ORef.oreGemEmerald, (ModConfig.OREGEMEMERALDGENERATEMIN + random.nextInt(ModConfig.OREGEMEMERALDGENERATEMAX - ModConfig.OREGEMEMERALDGENERATEMIN))).generate(world, random, (chunkX + random.nextInt(16)), (ModConfig.OREGEMEMERALDYMIN + random.nextInt(ModConfig.OREGEMEMERALDYBREAK - ModConfig.OREGEMEMERALDYMIN)), (chunkZ + random.nextInt(16)));
		}
	}
	private void generateNether(World world, Random random, int chunkX, int chunkZ) 
	{
		for(int k = 0; k < ModConfig.OREGEMGLOWCHUNKDENSITY; k++) 
		{
		    new WorldGenMinable(ORef.oreGemGlow, (ModConfig.OREGEMGLOWGENERATEMIN + random.nextInt(ModConfig.OREGEMGLOWGENERATEMAX - ModConfig.OREGEMGLOWGENERATEMIN)), Blocks.netherrack).generate(world, random, (chunkX + random.nextInt(16)), (ModConfig.OREGEMGLOWYMIN + random.nextInt(ModConfig.OREGEMGLOWYMAX - ModConfig.OREGEMGLOWYMIN)), (chunkZ + random.nextInt(16)));
		}
		
		for(int k = 0; k < ModConfig.OREGEMQUARTZCHUNKDENSITY; k++) 
		{
		    new WorldGenMinable(ORef.oreGemQuartz, (ModConfig.OREGEMQUARTZGENERATEMIN + random.nextInt(ModConfig.OREGEMQUARTZGENERATEMAX - ModConfig.OREGEMQUARTZGENERATEMIN))).generate(world, random, (chunkX + random.nextInt(16)), (ModConfig.OREGEMQUARTZYMIN + random.nextInt(ModConfig.OREGEMQUARTZYBREAK - ModConfig.OREGEMQUARTZYMIN)), (chunkZ + random.nextInt(16)));
		}
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
		if (event.type == OreGenEvent.GenerateMinable.EventType.DIRT && ModConfig.GENERATEDIRTUNDERGROUND)
		{
			event.setResult(Result.DENY);
		}
	}
	
}

