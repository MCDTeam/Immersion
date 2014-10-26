package teamUnknown.immersion.features.versionCheckerFeature;

import cpw.mods.fml.common.event.FMLInterModComms;
import teamUnknown.immersion.core.feature.Feature;
import teamUnknown.immersion.core.feature.Feature.FeatureData;
import teamUnknown.immersion.core.feature.Feature.FeatureData.Data;
import teamUnknown.immersion.core.feature.Feature.FeatureElement;
import teamUnknown.immersion.core.feature.Feature.FeatureElement.Element;
import teamUnknown.immersion.core.feature.configuration.IConfigurationProvider;
import teamUnknown.immersion.core.feature.FeatureCommon;
<<<<<<< HEAD
import teamUnknown.immersion.core.meta.ModMetadata;
import teamUnknown.immersion.core.providers.IConfigurationProvider;
=======
import teamUnknown.immersion.core.feature.IFeature;
>>>>>>> origin/Block-Registry---New

/**
 * Feature that allows the client to check for updates and display the link to the user
 */
@Feature(name = "Version Checker", version = "1.0", isBase = true)
public class FeatureVersion extends FeatureCommon {

    public static boolean enableVersionCheckerMod;

    @FeatureData(Data.NONDATA)
    public static String LAST_DISCOVERED_VERSION;

    @FeatureElement(Element.CONFIGURATION)
    public void registerConfiguration(IConfigurationProvider cfg) {
        this.enableVersionCheckerMod = cfg.getConfig("Enable version checker mod", "Enable version checker mod", true);
        //this.LAST_DISCOVERED_VERSION = context.getConfiguration().
    }

    @FeatureElement(Element.PREINITIALIZATION)
    public void runFeaturePreInitialization() {
        VersionHelper.execute();
    }

    @FeatureElement(Element.INTITIALIZATION)
    public void runFeatureInitialization() {
        if(this.enableVersionCheckerMod){
            FMLInterModComms.sendRuntimeMessage(ModMetadata.MOD_ID, "VersionChecker", "addVersionCheck", ModMetadata.VERSION_CHECKER_REMOTE_URL);
        }
    }
}
