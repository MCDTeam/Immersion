package teamUnknown.immersion.core.feature.object;

import net.minecraft.item.Item;
import teamUnknown.immersion.core.providers.resources.ResourceProvider;
import teamUnknown.immersion.coreFeatures.creativeTab.FeatureCreativeTab;

public class ImmersionItem extends Item implements IImersionObject
{
    protected ImmersionItem(String name) {

        if (name == null)
            name = this.inferName();

        this.setUnlocalizedName(ResourceProvider.getBlockName(name));

        // Override if needed
        this.setCreativeTab(FeatureCreativeTab.tabImmersionCore);
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
