package cf.mcdTeam.immersion.features.electricalAge.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ElectricalItems {

    // Item Instances
    public static Item immersionWrench = new ItemImmersionWrench("immersionWrench");

    // Registry
    public static void init(){

        GameRegistry.registerItem(immersionWrench, "immersionWrench");
    }
}
