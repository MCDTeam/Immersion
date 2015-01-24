package teamUnknown.immersion.features.metallurgyFeature;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import teamUnknown.immersion.core.utils.Stack;
import teamUnknown.immersion.coreFeatures.oreGen.BlockOre;
import teamUnknown.immersion.features.metallurgyFeature.items.ModBlocks;

public class OreDropsHelper 
{
	//Thanks goes to DemoXin for posting his source on GitHub
	//His mod FortuneOres gave me the Idea for this drop corrector
	
	
	@SubscribeEvent
	public void GetCorrectOreDrops(HarvestDropsEvent event)
	{
		Block block = event.state.getBlock();
		if (block instanceof BlockOre)
		{
		
			//STOP NOW if Block is being silk touched
			if (event.isSilkTouching)
			{
				event.drops.clear();
				event.drops.add(Stack.S(block));
			}
			
			int nuggets = (event.world.rand.nextInt(16) + event.fortuneLevel * event.world.rand.nextInt(5) + 1);
			
			ItemStack stack = event.drops.get(0);
			stack = ModBlocks.lumpOre.addOre((BlockOre) block, nuggets, stack);
			event.drops.set(0, stack);
			event.dropChance = 1.0F;
		}
	}
}
