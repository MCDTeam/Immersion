package teamUnknown.immersion.core.feature.object;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import teamUnknown.immersion.Immersion;
import teamUnknown.immersion.core.providers.resources.ResourceProvider;

public class ImmersionItem extends Item implements IImersionObject
{
    protected ImmersionItem(String name) {

        if (name == null)
            name = this.inferName();

        this.setUnlocalizedName(ResourceProvider.getBlockName(name));
        this.setTextureName(ResourceProvider.getTextureName(name));

        // Override if needed
        this.setCreativeTab(Immersion.tabIM);
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
