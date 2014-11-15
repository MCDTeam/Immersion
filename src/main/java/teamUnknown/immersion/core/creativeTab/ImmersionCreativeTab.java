package teamUnknown.immersion.core.creativeTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

import java.util.Random;

public class ImmersionCreativeTab extends CreativeTabs{

    public ImmersionCreativeTab(int tab, String id) {
        super(tab, id);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return getRandomItem();
    }

    private Item getRandomItem(){

        Random rand = new Random();

        for(int x = 0; x < 40; x++){
            System.out.println(rand);
        }

        switch (rand.nextInt(5)){

            case 1:
                return Items.apple;

            case 2:
                return Items.beef;

            case 3:
                return Items.diamond;

            case 4:
                return Items.tnt_minecart;

            case 5:
                return Items.fish;

            default:
                return Items.diamond_chestplate;
        }
    }
}
