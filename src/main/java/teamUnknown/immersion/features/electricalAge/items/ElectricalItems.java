package teamUnknown.immersion.features.electricalAge.items;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ElectricalItems {

    // Item Instances
    public static Item immersionWrench = new ItemImmersionWrench("immersionWrench");

    // Registry
    public static void init(){

        GameRegistry.registerItem(immersionWrench, "immersionWrench");
    }
}
