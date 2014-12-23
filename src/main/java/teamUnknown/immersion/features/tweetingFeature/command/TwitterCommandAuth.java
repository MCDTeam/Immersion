package teamUnknown.immersion.features.tweetingFeature.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraftforge.common.config.Configuration;
import teamUnknown.immersion.core.utils.ChatHelper;
import teamUnknown.immersion.features.tweetingFeature.TweetingFeature;
import twitter4j.TwitterException;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;

public class TwitterCommandAuth extends CommandBase{

    String consumerKey = "";
    String consumerSecret = "";
    String accessToken = "";
    String accessTokenSecret = "";
    private File configFile;
    private Configuration config;
    private String googUrl;

    public TwitterCommandAuth(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret, File configFile, Configuration config){

        this.consumerKey = consumerKey;
        this.consumerSecret = consumerSecret;
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;

        this.googUrl = "https://www.googleapis.com/urlshortener/v1/url?longUrl={LONG}&key=AIzaSyBb5KmtnjkjMC0Zsz7RDao74ldJTu7sMoo";
    }

    @Override
    public String getCommandName() {
        return "tc";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return null;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) {

        if(args.length == 0){
            if (TweetingFeature.isAuthorized)
                ChatHelper.sendCommandMessageToPlayer(sender, "Already authorized. Please use /tweet 'message'");
            else
                ChatHelper.sendCommandMessageToPlayer(sender, "Please type /tc authorize to begin the authorization process.");
            return;
        }

        if ((args != null) && (!args[0].isEmpty()))
        {
            if (args[0].toLowerCase().equals("authorize"))
                if (!TweetingFeature.isAuthorized)
                {
                    RequestToken requestToken = null;
                    AccessToken accessToken = null;
                    try
                    {
                        requestToken = TweetingFeature.twitter.getOAuthRequestToken();
                        TweetingFeature.requestToken = requestToken;
                    }
                    catch (TwitterException e)
                    {
                        ChatHelper.sendCommandMessageToPlayer(sender, e.getMessage());
                        e.printStackTrace();
                    }
                    if (requestToken != null)
                    {
                        String shortUrl = shorten(requestToken.getAuthorizationURL());
                        ChatHelper.sendCommandMessageToPlayer(sender, "Click URL to authorize your Twitter account: " + shortUrl);
                        ChatHelper.sendCommandMessageToPlayer(sender, "When you click Authorize App, You will get a PIN.");
                        ChatHelper.sendCommandMessageToPlayer(sender, "Type '/tc confirm <pin>' after you authorize the app.");
                        TweetingFeature.isAuthorized = true;
                    }
                }
                else {
                    ChatHelper.sendCommandMessageToPlayer(sender, "Already authorized.");
                }
            if (args[0].toLowerCase().equals("confirm"))
                if (!TweetingFeature.isConfirmed)
                {
                    if ((!args[1].isEmpty()) && (args[1].length() > 0))
                        try
                        {
                            AccessToken accessToken = TweetingFeature.twitter.getOAuthAccessToken(TweetingFeature.requestToken, args[1]);
                            String token = accessToken.getToken().toString();
                            String secret = accessToken.getTokenSecret().toString();
                            ArrayList lines = new ArrayList();
                            try
                            {
                                BufferedReader reader = new BufferedReader(new FileReader(this.configFile.getPath()));
                                String line = "";
                                int c = 1;
                                while ((line = reader.readLine()) != null)
                                {
                                    line = line.replace("S:AccessToken=NULL", "S:AccessToken=" + accessToken.getToken());
                                    line = line.replace("S:AccessTokenSecret=NULL", "S:AccessTokenSecret=" + accessToken.getTokenSecret());
                                    lines.add(line);
                                }
                                reader.close();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            try
                            {
                                BufferedWriter writer = new BufferedWriter(new FileWriter(this.configFile.getPath()));
                                for (Iterator i$ = lines.iterator(); i$.hasNext(); writer.newLine())
                                {
                                    String s = (String)i$.next();
                                    writer.write(s);
                                }

                                writer.flush();
                                writer.close();
                            }
                            catch (IOException e)
                            {
                                e.printStackTrace();
                            }
                            TweetingFeature.twitter.setOAuthAccessToken(accessToken);
                            ChatHelper.sendCommandMessageToPlayer(sender, "Success! Enjoy Telecrapht!");
                        }
                        catch (TwitterException e)
                        {
                            ChatHelper.sendCommandMessageToPlayer(sender, e.getMessage());
                            e.printStackTrace();
                        }
                }
                else
                    ChatHelper.sendCommandMessageToPlayer(sender, "Already confirmed.");
        }
    }

    public String shorten(String longUrl)
    {
        String shortUrl = "";
        this.googUrl = this.googUrl.replace("{LONG}", longUrl);
        try
        {
            URLConnection conn = new URL(this.googUrl).openConnection();
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-Type", "application/json");
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write("{\"longUrl\":\"" + longUrl + "\"}");
            wr.flush();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null)
            {
                if (line.indexOf("id") > -1)
                {
                    shortUrl = line.substring(8, line.length() - 2);
                }
            }
            wr.close();
            rd.close();
        }
        catch (MalformedURLException e)
        {
            System.out.println(e.getMessage());
            return longUrl;
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
            return longUrl;
        }
        if (shortUrl == null) {
            return longUrl;
        }
        return shortUrl;
    }
}
