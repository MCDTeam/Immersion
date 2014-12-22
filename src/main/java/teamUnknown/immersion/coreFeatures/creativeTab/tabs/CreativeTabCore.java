package teamUnknown.immersion.coreFeatures.creativeTab.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import teamUnknown.immersion.features.electricalAge.blocks.ElectricalBlocks;

public class CreativeTabCore extends CreativeTabs{

    public CreativeTabCore(int tab, String id) {
        super(tab, id);
    }

    @Override
    public Item getTabIconItem() {
        return Item.getItemFromBlock(ElectricalBlocks.electricalWire);
    }
}
