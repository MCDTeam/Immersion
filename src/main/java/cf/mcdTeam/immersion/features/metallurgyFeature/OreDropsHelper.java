package cf.mcdTeam.immersion.features.metallurgyFeature;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import cf.mcdTeam.immersion.core.utils.Stack;
import cf.mcdTeam.immersion.coreFeatures.oreGen.BlockOre;
import cf.mcdTeam.immersion.features.metallurgyFeature.items.ModBlocks;

public class OreDropsHelper 
{
	//Thanks goes to DemoXin for posting his source on GitHub
	//His mod FortuneOres gave me the Idea for this drop corrector
	
	
	@SubscribeEvent
	public void GetCorrectOreDrops(HarvestDropsEvent event)
	{
		if (event.block instanceof BlockOre)
		{
		
			//STOP NOW if Block is being silk touched
			if (event.isSilkTouching)
			{
				event.drops.clear();
				event.drops.add(Stack.S(event.block));
			}
			
			int nuggets = (event.world.rand.nextInt(16) + event.fortuneLevel * event.world.rand.nextInt(5) + 1);
			
			ItemStack stack = event.drops.get(0);
			stack = ModBlocks.lumpOre.addOre((BlockOre) event.block, nuggets, stack);
			event.drops.set(0, stack);
			event.dropChance = 1.0F;
		}
	}
}
