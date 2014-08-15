package bcwadsworth.bcwadsworthWorld;

import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.terraingen.OreGenEvent;

public class EventHooks
{
	@SubscribeEvent
	public void undoVanillaGemGen (OreGenEvent.GenerateMinable event)
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
	}
}
