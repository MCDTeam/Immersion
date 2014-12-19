package cf.mcdTeam.immersion.coreFeatures.versionCheck;

import cf.mcdTeam.immersion.core.feature.Feature;
import cf.mcdTeam.immersion.core.feature.Feature.FeatureData;
import cf.mcdTeam.immersion.core.feature.Feature.FeatureData.Data;
import cf.mcdTeam.immersion.core.feature.Feature.FeatureElement;
import cf.mcdTeam.immersion.core.feature.Feature.FeatureElement.Element;
import cf.mcdTeam.immersion.core.feature.FeatureCommon;
import cf.mcdTeam.immersion.core.feature.configuration.IConfigurationProvider;
import cf.mcdTeam.immersion.core.meta.ModMetadata;
import cpw.mods.fml.common.event.FMLInterModComms;

/**
 * Feature that allows the client to check for updates and display the link to the user
 */
@Feature(name = "Version Checker", version = "1.0", isBase = true)
public class FeatureVersion extends FeatureCommon {

    public static boolean enableVersionChecker;

    @FeatureData(Data.NONDATA)
    public static String LAST_DISCOVERED_VERSION;

    @FeatureElement(Element.CONFIGURATION)
    public void registerConfiguration(IConfigurationProvider cfg) {
        this.enableVersionChecker = cfg.getConfig("Enable version checker", "Enable version checker", true);
        //this.LAST_DISCOVERED_VERSION = context.getConfiguration().
    }

    @FeatureElement(Element.PREINITIALIZATION)
    public void runFeaturePreInitialization() {
        VersionHelper.execute();
    }

    @FeatureElement(Element.INTITIALIZATION)
    public void runFeatureInitialization() {
        if(this.enableVersionChecker)
        {
            FMLInterModComms.sendRuntimeMessage(ModMetadata.MOD_ID, "VersionChecker", "addVersionCheck", ModMetadata.VERSION_CHECKER_REMOTE_URL);
        }
    }
}
