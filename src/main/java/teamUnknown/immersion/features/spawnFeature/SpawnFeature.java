package teamUnknown.immersion.features.spawnFeature;

import net.minecraftforge.common.MinecraftForge;
import teamUnknown.immersion.core.providers.IConfigurationProvider;
import teamUnknown.immersion.features.common.CommonFeature;
import teamUnknown.immersion.features.common.FeatureContext;
import teamUnknown.immersion.features.common.FeatureProperties;
import teamUnknown.immersion.features.spawnFeature.events.SpawnEventListener;

/**
 *  Feature that forces player to spawn randomly
 */
@FeatureProperties(
        name = "Player Spawning",
        doConfigurationRegistration = true,
        doEventListenersRegistration = true)
public class SpawnFeature extends CommonFeature {

    private SpawnEventListener.RespawnConfig _spawnCfg;

    @Override
    protected void registerConfiguration(FeatureContext context) {
        super.registerConfiguration(context);
        IConfigurationProvider cfg = context.getConfiguration();

        this._spawnCfg = new SpawnEventListener.RespawnConfig();

        this._spawnCfg.MinDistanceFromWorldSpawn = cfg.getConfig("MinDistanceFromSpawn", "Minimum distance from world spawn", 500);
        this._spawnCfg.RespawnRadius = cfg.getConfig("RespawnRadius", "The distance between minimum and maximum distance of the respawn", 500);
        this._spawnCfg.RespawnTries = cfg.getConfig("RespawnTries", "The maximum number of times minecraft tries to find good spawn", 50);
    }

    @Override
    protected void registerEventListeners(final FeatureContext context) {
        super.registerEventListeners(context);

        MinecraftForge.EVENT_BUS.register(new SpawnEventListener(context, this._spawnCfg));
    }
}
