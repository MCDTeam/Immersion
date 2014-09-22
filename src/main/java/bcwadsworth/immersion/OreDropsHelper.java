package bcwadsworth.immersion;

import bcwadsworth.immersion.blocks.BlockOre;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.world.BlockEvent.HarvestDropsEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

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
				return;
			}
			
			int nuggets = (event.world.rand.nextInt(16) + event.fortuneLevel * event.world.rand.nextInt(5) + 1);
			ItemStack stack = Stack.S(ORef.lumpOre);
			
			event.drops.clear();
			event.drops.add(ORef.lumpOre.addOre((BlockOre) event.block, nuggets, stack));
			event.dropChance = 1.0F;
		}
	}
}
