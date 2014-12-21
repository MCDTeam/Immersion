package teamUnknown.immersion.features.electricalAge;

import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.network.NetworkRegistry;
import mcp.mobius.waila.api.IWailaRegistrar;
import teamUnknown.immersion.Immersion;
import teamUnknown.immersion.core.feature.Feature;
import teamUnknown.immersion.core.feature.FeatureCommon;
import teamUnknown.immersion.features.electricalAge.blocks.ElectricalBlocks;
import teamUnknown.immersion.features.electricalAge.handler.ElectricalFeatureGuiHandler;
import teamUnknown.immersion.features.electricalAge.items.ElectricalItems;
import teamUnknown.immersion.features.electricalAge.thirdParty.WailaHandler;

import static teamUnknown.immersion.core.feature.Feature.*;

@Feature(name = "Electrical Age", version = "0.1", isBase = true)
public class ElectricalFeature extends FeatureCommon{

    @FeatureElement(FeatureElement.Element.CONFIGURATION)
    public void registerConfiguration(){

    }

    @FeatureElement(FeatureElement.Element.PREINITIALIZATION)
    public void preInit(){

        ElectricalBlocks.init();
        ElectricalItems.init();
    }

    @FeatureElement(FeatureElement.Element.INTITIALIZATION)
    public void init(){
        FMLInterModComms.sendMessage("Waila", "register", "teamUnknown.immersion.features.electricalAge.ElectricalFeature.doWailaRegistry");
    }

    @FeatureElement(FeatureElement.Element.EVENTBUS_EVENT)
    public void registerEventHandlers(){

        NetworkRegistry.INSTANCE.registerGuiHandler(Immersion.instance, new ElectricalFeatureGuiHandler());
    }

    @FeatureElement(FeatureElement.Element.MOD_COMPATIBILITY)
    public void thirdPartyMods(){
    }

    @FeatureElement(FeatureElement.Element.NONSETUP)
    public void doWailaRegistry(IWailaRegistrar registrar){
        registrar.registerBodyProvider(new WailaHandler(), Immersion.class);
    }

    /**@Feature.FeatureElement(Feature.FeatureElement.Element.)
    public void clientThings(){

    }**/
}
