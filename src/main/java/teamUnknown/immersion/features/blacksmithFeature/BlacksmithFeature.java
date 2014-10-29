package teamUnknown.immersion.features.blacksmithFeature;

import net.minecraftforge.common.MinecraftForge;
import teamUnknown.immersion.core.feature.Feature;
import teamUnknown.immersion.core.feature.FeatureCommon;
import teamUnknown.immersion.features.blacksmithFeature.blocks.BlockFakeAir;
import teamUnknown.immersion.features.blacksmithFeature.blocks.BlockHeatedCoal;
import teamUnknown.immersion.features.blacksmithFeature.events.PlayerInteractEventListener;

/**
 *
 */

@Feature(name = "Blacksmithing", version = "0.0.1")
public class BlacksmithFeature extends FeatureCommon {

    public BlockHeatedCoal blockHeatedCoal;
    public BlockFakeAir blockFakeAir;

    @Feature.FeatureElement(Feature.FeatureElement.Element.PREINITIALIZATION)
    public void registerBlocks() {
        this.blockHeatedCoal = new BlockHeatedCoal();
        this.blockFakeAir = new BlockFakeAir();

    }

    @Feature.FeatureElement(Feature.FeatureElement.Element.EVENTBUS_EVENT)
    public void registerEventListeners() {
        MinecraftForge.EVENT_BUS.register(new PlayerInteractEventListener(this));
    }
}
