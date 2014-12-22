package teamUnknown.immersion.coreFeatures.creativeTab;

import net.minecraft.creativetab.CreativeTabs;
import teamUnknown.immersion.core.feature.Feature;
import teamUnknown.immersion.core.feature.FeatureCommon;
import teamUnknown.immersion.core.feature.FeatureDataCollector;
import teamUnknown.immersion.core.feature.IFeature;
import teamUnknown.immersion.core.meta.ModMetadata;
import teamUnknown.immersion.coreFeatures.creativeTab.tabs.CreativeTabCore;
import teamUnknown.immersion.coreFeatures.creativeTab.tabs.TabFeature;

@Feature(name = "FeatureCreativeTab", version = "0.1", isBase = true)
public class FeatureCreativeTab extends FeatureCommon{

    public static CreativeTabs tabImmersionCore = new CreativeTabCore(CreativeTabs.getNextID(), ModMetadata.MOD_ID);

    /**
     * Returns a creative tab for a feature
     *
     * @param feature
     * @param tabIcon
     * @return the creative tab for the feature
     */
    public CreativeTabs getCreativeTabForFeature(IFeature feature, Object tabIcon){
        String name = FeatureDataCollector.instance.getFeatureName(feature);

        return new TabFeature(CreativeTabs.getNextID(), name, tabIcon);
    }
}
