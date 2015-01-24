package teamUnknown.immersion.coreFeatures.debug.items;

import net.minecraftforge.fml.common.registry.GameRegistry;
import teamUnknown.immersion.core.feature.object.ImmersionItem;

public class DebugItems {

    public static ImmersionItem itemAdminDebug = new itemAdminDebug();

    public static void init(){
        GameRegistry.registerItem(itemAdminDebug, "itemAdminDebug");
    }
}
