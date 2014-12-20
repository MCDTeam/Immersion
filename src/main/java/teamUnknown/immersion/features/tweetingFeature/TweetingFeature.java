package teamUnknown.immersion.features.tweetingFeature;

import teamUnknown.immersion.core.feature.Feature;
import teamUnknown.immersion.core.feature.FeatureCommon;
import teamUnknown.immersion.core.feature.configuration.IConfigurationProvider;

@Feature(name = "TweetingFeature", version = "0.1")
public class TweetingFeature extends FeatureCommon{

    public static int userID;
    public static int IDSecret;

    @Feature.FeatureElement(Feature.FeatureElement.Element.CONFIGURATION)
    public void doConfiguration(IConfigurationProvider cfg){

        this.userID = cfg.getConfig("User ID", "The user is for the account", 1234);
        this.IDSecret = cfg.getConfig("ID Secret", "The secret ID for the account", 1234);
    }

    @Feature.FeatureElement(Feature.FeatureElement.Element.EVENTBUS_EVENT)
    public void registerEventHandlers(){

    }
}
