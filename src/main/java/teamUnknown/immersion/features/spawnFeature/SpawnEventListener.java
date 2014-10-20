package teamUnknown.immersion.features.spawnFeature;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChunkCoordinates;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import teamUnknown.immersion.core.logging.FeatureLogger;

/**
 *
 */
public class SpawnEventListener {

    private final RespawnConfig _cfg;
	private FeatureLogger _logger;
    public SpawnEventListener(FeatureLogger logger, RespawnConfig cfg) 
    {
        this._logger = logger;
        this._cfg = cfg;
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onDeath(LivingDeathEvent event){
        if (event.entityLiving instanceof EntityPlayer){
            EntityPlayer player = (EntityPlayer)event.entityLiving;

            for (int i = 0; i < this._cfg.RespawnTries; i++){
                double direction = Math.random() * Math.PI * 2;
                double distance = Math.random() * this._cfg.RespawnRadius + this._cfg.MinDistanceFromWorldSpawn;

                int x = (int)Math.round(Math.sin(direction) * distance) + player.worldObj.getSpawnPoint().posX;
                int z = (int)Math.round(Math.cos(direction) * distance) + player.worldObj.getSpawnPoint().posZ;


                if (!player.worldObj.provider.canCoordinateBeSpawn(x, z)){
                    this._logger.info("Bad spawn @ X:%1$d Z:%2$d", x, z);
                    continue;
                }

                int y = player.worldObj.getTopSolidOrLiquidBlock(x, z);
                this._logger.info("Player spawn @ X:%1$d Y:%2$d Z:%3$d", x, y, z);

                player.setSpawnChunk(new ChunkCoordinates(x, y, z), true);
                break;
            }


        }
    }

    @SubscribeEvent(priority = EventPriority.NORMAL)
    public void onRespawn(PlayerEvent.PlayerRespawnEvent event)
    {
        _logger.info("Respawn");
    }

    public static class RespawnConfig{
        public int MinDistanceFromWorldSpawn;
        public int RespawnRadius;
        public int RespawnTries;
    }
}
