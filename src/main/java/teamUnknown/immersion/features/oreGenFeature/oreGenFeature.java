package teamUnknown.immersion.features.oreGenFeature;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import teamUnknown.immersion.Immersion;
import teamUnknown.immersion.features.common.CommonFeature;
import teamUnknown.immersion.features.common.FeatureContext;
import teamUnknown.immersion.features.common.FeatureProperties;
import teamUnknown.immersion.features.metallurgyFeature.OreDropsHelper;

/**
 *
 */
@FeatureProperties(name = "Ore Generation feature", doConfigurationRegistration = true, doEventListenersRegistration = true, doItemsRegistration = true)
public class oreGenFeature extends CommonFeature {

    public static boolean enableSpecialSpawning;

    @Override
    protected void registerItems(FeatureContext context) {
        super.registerItems(context);

        Item StickDebug = new itemStickDebug();

        GameRegistry.registerItem(StickDebug, "itemStickDebug");
    }

    @Override
    protected void registerConfiguration(FeatureContext context) {
        super.registerConfiguration(context);

        this.enableSpecialSpawning = context.getConfiguration().getConfig("enable special spawning", "Enables the special ore spawning", true);
    }

    @Override
    protected void registerEventListeners(FeatureContext context) {

        OreGeneration generator = new OreGeneration();

        GameRegistry.registerWorldGenerator(generator, 0);
        Immersion.log.debug("Ore Generator Loaded");

        MinecraftForge.ORE_GEN_BUS.register(generator);
        MinecraftForge.EVENT_BUS.register(new OreDropsHelper());
        Immersion.log.debug("Event Busses Loaded");
    }
}
