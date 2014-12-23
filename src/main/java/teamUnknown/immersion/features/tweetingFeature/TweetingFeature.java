package teamUnknown.immersion.features.tweetingFeature;

import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import teamUnknown.immersion.Immersion;
import teamUnknown.immersion.core.feature.Feature;
import teamUnknown.immersion.core.feature.FeatureCommon;
import teamUnknown.immersion.core.feature.configuration.IConfigurationProvider;
import teamUnknown.immersion.features.tweetingFeature.blocks.TwitterBlocks;
import teamUnknown.immersion.features.tweetingFeature.client.handler.TwitterGuiHandler;
import teamUnknown.immersion.features.tweetingFeature.command.TwitterCommandAuth;
import teamUnknown.immersion.features.tweetingFeature.command.TwitterCommandTweet;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

@Feature(name = "TweetingFeature", version = "0.1")
public class TweetingFeature extends FeatureCommon {

    public static Twitter twitter;

    public static String consumerKey = "52TWYbKYwPyHbm6qOe0kMg";
    public static String consumerSecret = "jEvA6VB5TXvcfx6x21Y7YIVzC9qkAp00a7PthOtcNFY";
    public static String accessToken = "";
    public static String accessTokenSecret = "";
    public static boolean isAuthorized = false;
    public static boolean isConfirmed = false;
    public static RequestToken requestToken = null;
    public static String ScreenShotAnnouncement = "";


    @Feature.FeatureElement(Feature.FeatureElement.Element.CONFIGURATION)
    public void doConfiguration(IConfigurationProvider cfg) {

        this.accessToken = cfg.getConfig("Access Token", "The user's access token", "NULL");
        this.accessTokenSecret = cfg.getConfig("Access Token Secret", "The secret access token for the user", "NULL");
        this.ScreenShotAnnouncement = cfg.getConfig("Screenshot announchement", "Message posted with a picture", "Posted using the Immersion framework");

    }

    @Feature.FeatureElement(Feature.FeatureElement.Element.PREINITIALIZATION)
    public void preInit() {
        TwitterBlocks.init();

        doTwitterInit();
    }

    @Feature.FeatureElement(Feature.FeatureElement.Element.EVENTBUS_EVENT)
    public void registerEventHandlers() {

        NetworkRegistry.INSTANCE.registerGuiHandler(Immersion.instance, new TwitterGuiHandler());
    }

    @Feature.FeatureElement(Feature.FeatureElement.Element.SERVERSTARTING)
    public void serverStarting() {

    }

    public void doTwitterInit() {
        if (!accessToken.equals("NULL")) {
            isAuthorized = true;
            isConfirmed = true;
        }
        if (!accessTokenSecret.equals("NULL")) {
            isAuthorized = true;
            isConfirmed = true;
        }

        if (!accessToken.equals("NULL")) {

            new TwitterFactory();
            twitter = TwitterFactory.getSingleton();
            twitter.setOAuthConsumer(consumerKey, consumerSecret);
            TweetingFeature tweetingFeature = this;
            twitter.setOAuthAccessToken(new AccessToken(accessToken, accessTokenSecret));
        } else {
            new TwitterFactory();
            twitter = TwitterFactory.getSingleton();
            twitter.setOAuthConsumer(consumerKey, consumerSecret);
        }
    }

    // TEMP BECAUSE I NEED THE EVENT PARAM
    public void registerCommands(FMLServerStartingEvent event){

        event.registerServerCommand(new TwitterCommandAuth(consumerKey, consumerSecret, accessToken, accessTokenSecret, this.configFile, this.config));
        event.registerServerCommand(new TwitterCommandTweet(consumerKey, consumerSecret, accessToken, accessTokenSecret));
    }
}
