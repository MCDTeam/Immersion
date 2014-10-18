package teamUnknown.immersion.features.versionCheckerFeature;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import teamUnknown.immersion.features.common.CommonFeature;
import teamUnknown.immersion.features.common.FeatureContext;
import teamUnknown.immersion.features.common.FeatureProperties;

/**
 * Feature that allows the client to check for updates and display the link to the user
 */
@FeatureProperties(name = "Version Checker", doConfigurationRegistration = true)
public class VersionFeature extends CommonFeature{

    public static String LAST_DISCOVERED_VERSION;

    @Override
    protected void registerConfiguration(FeatureContext context) {
        super.registerConfiguration(context);

        //this.LAST_DISCOVERED_VERSION = context.getConfiguration().
    }

    public static void updateConfig(String version){

    }

    @Override
    public void runFeaturePreInitialization(FeatureContext context) {
        super.runFeaturePreInitialization(context);

        VersionHelper.execute();
    }

    /**@Override
    public void runFeatureInitialization(FeatureContext context) {
        super.runFeatureInitialization(context);

        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(VersionHelper.getResultMessageForClient()));
    }**/
}
