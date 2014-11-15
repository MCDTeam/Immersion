package teamUnknown.immersion.features.electricalAge;

import teamUnknown.immersion.core.feature.Feature;
import teamUnknown.immersion.core.feature.FeatureCommon;
import teamUnknown.immersion.features.electricalAge.blocks.ElectricalBlocks;

@Feature(name = "Electrical Age", version = "0.1", isBase = true)
public class ElectricalFeature extends FeatureCommon{

    @Feature.FeatureElement(Feature.FeatureElement.Element.CONFIGURATION)
    public void registerConfiguration(){

    }

    @Feature.FeatureElement(Feature.FeatureElement.Element.PREINITIALIZATION)
    public void preInit(){
        ElectricalBlocks.init();
    }

    @Feature.FeatureElement(Feature.FeatureElement.Element.INTITIALIZATION)
    public void init(){

    }
}
