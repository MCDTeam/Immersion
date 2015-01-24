package teamUnknown.immersion.features.blacksmithFeature.events;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import teamUnknown.immersion.core.feature.FeatureDataCollector;
import teamUnknown.immersion.core.utils.WorldBlockPosition;
import teamUnknown.immersion.features.blacksmithFeature.BlacksmithFeature;

import java.util.Random;

/**
 *
 */
public class PlayerInteractEventListener {

    private BlacksmithFeature _feature;

    public PlayerInteractEventListener(BlacksmithFeature feature){
        this._feature = feature;
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onInteract(PlayerInteractEvent event){
        World world = event.world;

        if (event.entityPlayer != null
            && event.entityPlayer.getHeldItem() != null
            && event.entityPlayer.getHeldItem().getItem() != null
            && event.entityPlayer.getHeldItem().getItem() == Items.flint_and_steel)
        {
            WorldBlockPosition pos = new WorldBlockPosition(event.world, event.pos.getX(), event.pos.getY(), event.pos.getZ());

            if (pos.getBlock() == Blocks.coal_block)
            {
                WorldBlockPosition top = pos.top();
                if (top.isAir()){
                    if (world.isRemote){
                        // prevent flame "flickering"
                        pos.top().setBlock(FeatureDataCollector.instance.FEATUREOBJECTMAP.get(_feature).readBlock("BlockFakeAir"));

                        // client side effects
                        Random random = new Random();
                        world.playSoundEffect((double)event.pos.getX() + 0.5D, (double)event.pos.getY() + 0.5D, (double)event.pos.getZ() + 0.5D, "fire.ignite", 1.0F, 0.8F);

                        // TODO: via function
                        for (int i = 0; i < 16; i++){
                            //world.spawnParticle("smoke", event.pos.getX() + 0.5, event.pos.getY() + 1, event.pos.getZ() + 0.5, random.nextDouble() * 0.3 - 0.15, random.nextDouble() * 0.4, random.nextDouble() * 0.3 - 0.15);
                        }

                        return;

                    } else {
                        // prevent flame from spawning
                        event.setCanceled(true);
                    }

                    pos.setBlock(FeatureDataCollector.instance.FEATUREOBJECTMAP.get(_feature).readBlock("BlockHeatedCoal"));
                }
            }
        }
    }
}
