package teamUnknown.immersion.features.versionCheckerFeature;

import teamUnknown.immersion.core.feature.Feature;
import teamUnknown.immersion.core.feature.Feature.FeatureData;
import teamUnknown.immersion.core.feature.Feature.FeatureData.Data;
import teamUnknown.immersion.core.feature.Feature.FeatureElement;
import teamUnknown.immersion.core.feature.Feature.FeatureElement.Element;
import teamUnknown.immersion.core.feature.FeatureCommon;
import teamUnknown.immersion.core.feature.IFeature;
import teamUnknown.immersion.core.providers.IConfigurationProvider;

/**
 * Feature that allows the client to check for updates and display the link to the user
 */
@Feature(name = "Version Checker", version = "1.0")
public class FeatureVersion extends FeatureCommon
{
	@FeatureData(Data.NONDATA)
    public static String LAST_DISCOVERED_VERSION;

    @FeatureElement(Element.CONFIGURATION)
    public void registerConfiguration(IConfigurationProvider cfg) 
    {
        //this.LAST_DISCOVERED_VERSION = context.getConfiguration().
    }

    @FeatureElement(Element.PREINITIALIZATION)
    public void runFeaturePreInitialization() 
    {
        VersionHelper.execute();
    }

    /**@FeatureElement(Element.Initialization)
    public void runFeatureInitialization(FeatureContext context) {
        super.runFeatureInitialization(context);

        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(VersionHelper.getResultMessageForClient()));
    }**/
}
