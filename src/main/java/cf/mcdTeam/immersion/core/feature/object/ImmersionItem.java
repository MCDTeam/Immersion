package cf.mcdTeam.immersion.core.feature.object;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cf.mcdTeam.immersion.core.providers.resources.ResourceProvider;

public class ImmersionItem extends Item implements IImersionObject
{
    protected ImmersionItem(String name) {

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
