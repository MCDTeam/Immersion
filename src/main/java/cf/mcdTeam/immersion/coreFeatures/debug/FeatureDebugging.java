package cf.mcdTeam.immersion.coreFeatures.debug;

import cf.mcdTeam.immersion.core.feature.Feature;
import cf.mcdTeam.immersion.core.feature.FeatureCommon;
import cf.mcdTeam.immersion.core.feature.configuration.IConfigurationProvider;
import cf.mcdTeam.immersion.coreFeatures.debug.items.DebugItems;

@Feature(name = "Debugging", version = "1.0", isBase = true)
public class FeatureDebugging extends FeatureCommon{

    @Feature.FeatureElement(Feature.FeatureElement.Element.CONFIGURATION)
    public void registerConfiguration(IConfigurationProvider cfg) {

    }

    @Feature.FeatureElement(Feature.FeatureElement.Element.PREINITIALIZATION)
    public void runFeaturePreInitialization() {

        DebugItems.init();
    }


}
