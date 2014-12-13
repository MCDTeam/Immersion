package teamUnknown.immersion.core.network;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import teamUnknown.immersion.core.meta.ModMetadata;
import teamUnknown.immersion.core.network.message.MessageSocialPacket;

public class PacketHandler {

    public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(ModMetadata.MOD_ID.toLowerCase());

    public static void init(){

        INSTANCE.registerMessage(MessageSocialPacket.class, MessageSocialPacket.class, 0, Side.SERVER);
    }
}
