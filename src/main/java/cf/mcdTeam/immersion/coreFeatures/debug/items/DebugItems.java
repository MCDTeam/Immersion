package cf.mcdTeam.immersion.coreFeatures.debug.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cf.mcdTeam.immersion.core.feature.object.ImmersionItem;

public class DebugItems {

    public static ImmersionItem itemAdminDebug = new itemAdminDebug();

    public static void init(){
        GameRegistry.registerItem(itemAdminDebug, "itemAdminDebug");
    }
}
