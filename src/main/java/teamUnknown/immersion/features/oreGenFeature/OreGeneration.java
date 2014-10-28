package teamUnknown.immersion.features.oreGenFeature;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.event.terraingen.OreGenEvent;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class OreGeneration implements IWorldGenerator {
	private ArrayList<BlockOre> ores= new ArrayList<BlockOre>();
	public void registerForGeneration(BlockOre ore) 
	{

	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
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
			// Exception.Catch all for other mod dimensions- If they are stone
			// based, generation will occur
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			return;
		}
	}

	private void generateNether(World world, Random random, int i, int j) 
	{
		// TODO Auto-generated method stub

	}

	private void generateEnd(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub

	}

	private void generateSurface(World world, Random random, int i, int j) {
		// TODO Auto-generated method stub

	}

	// Override of Vanilla Gen
	@SubscribeEvent
	public void undoVanillaGen(OreGenEvent.GenerateMinable event) {
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
		if (event.type == OreGenEvent.GenerateMinable.EventType.DIRT && OreGenConfig.GENERATEDIRTUNDERGROUND) {
			event.setResult(Event.Result.DENY);
		}
	}
}
