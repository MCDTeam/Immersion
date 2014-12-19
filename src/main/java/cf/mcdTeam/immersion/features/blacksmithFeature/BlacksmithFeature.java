package cf.mcdTeam.immersion.features.blacksmithFeature;

import net.minecraftforge.common.MinecraftForge;
import cf.mcdTeam.immersion.core.feature.Feature;
import cf.mcdTeam.immersion.core.feature.FeatureCommon;
import cf.mcdTeam.immersion.features.blacksmithFeature.events.PlayerInteractEventListener;

/**
 *
 */

@Feature(name = "Blacksmithing", version = "0.0.1")
public class BlacksmithFeature extends FeatureCommon 
{
    @Feature.FeatureElement(Feature.FeatureElement.Element.OBJECT)
    public ObjectRegister registerBlocks() 
    {
        return new ObjectRegister();
    }

    @Feature.FeatureElement(Feature.FeatureElement.Element.EVENTBUS_EVENT)
    public void registerEventListeners() {
        MinecraftForge.EVENT_BUS.register(new PlayerInteractEventListener(this));
    }
}
