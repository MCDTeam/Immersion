package teamUnknown.immersion.core.creativeTab;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ImmersionCreativeTab extends CreativeTabs{

    public ImmersionCreativeTab(int tab, String id) {
        super(tab, id);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getTabIconItem() {
        return ModItems.quantumWrench;
    }
}
