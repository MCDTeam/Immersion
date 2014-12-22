package teamUnknown.immersion.coreFeatures.creativeTab;

import net.minecraft.creativetab.CreativeTabs;
import teamUnknown.immersion.core.feature.Feature;
import teamUnknown.immersion.core.feature.FeatureCommon;
import teamUnknown.immersion.core.meta.ModMetadata;
import teamUnknown.immersion.coreFeatures.creativeTab.tabs.CreativeTabCore;

@Feature(name = "FeatureCreativeTab", version = "0.1", isBase = true)
public class FeatureCreativeTab extends FeatureCommon{

    public static CreativeTabs tabImmersionCore = new CreativeTabCore(CreativeTabs.getNextID(), ModMetadata.MOD_ID);

    @Feature.FeatureElement(Feature.FeatureElement.Element.PREINITIALIZATION)
    public void doPreInit(){

    }


}
