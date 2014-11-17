package teamUnknown.immersion.core.feature.object;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ImmersionItem extends Item implements IImersionObject
{
    public ImmersionItem(String name) {

        if (name == null)
            name = this.inferName();

        this.setUnlocalizedName(ResourceProvider.getBlockName(name));
        this.setTextureName(ResourceProvider.getTextureName(name));

        // Override if needed
        this.setCreativeTab(CreativeTabs.tabMisc);
    }

    private String inferName() {
        return this.getClass().getSimpleName();
    }

    @Override
	public void craftingRegistration() 
	{

	}

	@Override
	public void forgeOreDict() 
	{

	}
}
