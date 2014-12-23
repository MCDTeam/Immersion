package teamUnknown.immersion.features.tweetingFeature.command;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import teamUnknown.immersion.core.utils.ChatHelper;
import teamUnknown.immersion.features.tweetingFeature.TweetingFeature;
import twitter4j.TwitterException;

public class TwitterCommandTweet extends CommandBase{

    String consumerKey;
    String consumerSecret;
    String accessToken;
    String accessTokenSecret;

    @SideOnly(Side.CLIENT)
    public TwitterCommandTweet(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret){

        this.consumerKey = "";
        this.consumerSecret = "";
        this.accessToken = "";
        this.accessTokenSecret = "";
        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;
    }

    @Override
    public String getCommandName() {
        return "tweet";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "/tweet 'message'";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {

        if (TweetingFeature.isAuthorized)
        {
            if (args.length > 0)
            {
                String message = "";
                String[] arr$ = args;
                int len$ = arr$.length;
                for (int i$ = 0; i$ < len$; i$++)
                {
                    String s = arr$[i$];
                    message = message + s + " ";
                }

                try
                {
                    TweetingFeature.twitter.updateStatus(message);
                    ChatHelper.sendCommandMessageToPlayer(sender, "Tweet sent!");
                }
                catch (TwitterException ex)
                {
                    ChatHelper.sendCommandMessageToPlayer(sender, "Error sending tweet. Verify configuration for API tokens");
                }
            }
            else {
                ChatHelper.sendCommandMessageToPlayer(sender, "Please type /tweet 'message'");
            }
        }
        else
            ChatHelper.sendCommandMessageToPlayer(sender, "Please use /tc authorize to start the authorization process.");
    }
}
