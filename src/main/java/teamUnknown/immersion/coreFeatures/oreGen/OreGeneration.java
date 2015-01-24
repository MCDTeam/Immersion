package teamUnknown.immersion.coreFeatures.oreGen;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OreGeneration implements IWorldGenerator {
	private ArrayList<BlockOre> ores= new ArrayList<BlockOre>();
	
	public void registerForGeneration(BlockOre ore) 
	{
		ores.add(ore);
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) 
	{
		for (BlockOre ore : ores)
		{
			ore.generate(world, random, chunkX, chunkZ);
		}
	}

	// Override of Vanilla Gen
	@SubscribeEvent
	public void undoVanillaDirtGen(OreGenEvent.GenerateMinable event) {
		if (event.type == OreGenEvent.GenerateMinable.EventType.DIRT) 
		{
			event.setResult(Event.Result.DENY);
		}
	}
}
