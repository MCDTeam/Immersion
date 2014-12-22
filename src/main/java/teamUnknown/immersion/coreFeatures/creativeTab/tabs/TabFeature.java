package teamUnknown.immersion.coreFeatures.creativeTab.tabs;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class TabFeature extends CreativeTabs{

    private Object tabIcon;

    public TabFeature(int tab, String id, Object tabIcon) {

        super(tab, id);
        this.tabIcon = tabIcon;
    }

    @Override
    public Item getTabIconItem() {
        if(this.tabIcon instanceof Item){

            return (Item)tabIcon;
        }else if(this.tabIcon instanceof Block){

            return Item.getItemFromBlock((Block)tabIcon);
        }else{
            System.out.println(tabIcon.toString() + " is not an intance of block/item");
            return Items.ender_pearl;
        }
    }
}
