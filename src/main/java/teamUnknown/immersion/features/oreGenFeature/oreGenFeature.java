package teamUnknown.immersion.features.oreGenFeature;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import teamUnknown.immersion.features.common.CommonFeature;
import teamUnknown.immersion.features.common.FeatureContext;
import teamUnknown.immersion.features.common.FeatureProperties;

/**
 *
 */
@FeatureProperties(name = "Ore Generation feature")
public class oreGenFeature extends CommonFeature {

      //TODO: do all worldGen and block registration here


    @Override
    public void runFeaturePreInitialization(FeatureContext context) {
        super.runFeaturePreInitialization(context);

        Item StickDebug = new itemStickDebug();

        GameRegistry.registerItem(StickDebug, "itemStickDebug");
    }
}
