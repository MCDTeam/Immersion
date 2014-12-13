package teamUnknown.immersion.core.network.message;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import teamUnknown.immersion.core.network.PacketHandler;
import teamUnknown.immersion.coreFeatures.social.SocialRegistry;

import java.util.LinkedList;

public class MessageSocialPacket extends ImmersionPacketBase{

    public static void initialize() {

        PacketHandler.instance.registerPacket(MessageSocialPacket.class);
    }

    public enum PacketTypes {
        FRIEND_LIST, ADD_FRIEND, REMOVE_FRIEND
    }

    @Override
    public void handlePacket(EntityPlayer player, boolean isServer) {

        switch (PacketTypes.values()[getByte()]) {
            case FRIEND_LIST:
                int size = getInt();
                SocialRegistry.clientPlayerFriends = new LinkedList<String>();
                for (int i = 0; i < size; i++) {
                    SocialRegistry.clientPlayerFriends.add(getString());
                }
                java.util.Collections.sort(SocialRegistry.clientPlayerFriends);
                CoFHCore.proxy.updateFriendListGui();
                return;
            case ADD_FRIEND:
                SocialRegistry.addFriend(player.getCommandSenderName(), getString());
                SocialRegistry.sendFriendsToPlayer((EntityPlayerMP) player);
                return;
            case REMOVE_FRIEND:
                SocialRegistry.removeFriend(player.getCommandSenderName(), getString());
                SocialRegistry.sendFriendsToPlayer((EntityPlayerMP) player);
                return;
        }
    }
}
