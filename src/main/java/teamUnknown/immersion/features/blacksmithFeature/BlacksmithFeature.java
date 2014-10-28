package teamUnknown.immersion.features.blacksmithFeature;

import net.minecraftforge.common.MinecraftForge;
import teamUnknown.immersion.features.blacksmithFeature.blocks.BlockFakeAir;
import teamUnknown.immersion.features.blacksmithFeature.blocks.BlockHeatedCoal;
import teamUnknown.immersion.features.blacksmithFeature.events.PlayerInteractEventListener;
import teamUnknown.immersion.features.common.CommonFeature;
import teamUnknown.immersion.features.common.FeatureContext;
import teamUnknown.immersion.features.common.FeatureProperties;

/**
 *
 */

@FeatureProperties(name = "Blacksmithing",
        doEventListenersRegistration = true,
        doBlocksRegistration = true)
public class BlacksmithFeature extends CommonFeature {

    public BlockHeatedCoal blockHeatedCoal;
    public BlockFakeAir blockFakeAir;

    @Override
    protected void registerBlocks(FeatureContext context) {
        super.registerBlocks(context);

        this.blockHeatedCoal = new BlockHeatedCoal();
        this.blockFakeAir = new BlockFakeAir();

    }

    @Override
    protected void registerEventListeners(FeatureContext context) {
        super.registerEventListeners(context);

        MinecraftForge.EVENT_BUS.register(new PlayerInteractEventListener(this));
    }
}
