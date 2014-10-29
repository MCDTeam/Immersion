package teamUnknown.immersion.core.feature.object;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import teamUnknown.immersion.core.providers.resources.ResourceProvider;

/**
 *
 */
public class ImmersionBlock extends Block implements IImersionObject
{
    private static final Material DEFAULT_MATERIAL = Material.rock;

    protected ImmersionBlock() {
        this(null, DEFAULT_MATERIAL);
    }

    protected ImmersionBlock(Material material) {
        this(null, material);
    }

    protected ImmersionBlock(String name) {
        this(name, DEFAULT_MATERIAL);
    }

    protected ImmersionBlock(String name, Material material) {
        super(material);

        if (name == null)
            name = this.inferName();

        this.setBlockName(ResourceProvider.getBlockName(name));
        this.setBlockTextureName(ResourceProvider.getTextureName(name));

        // ToDo: Creative tab handler?
        this.setCreativeTab(CreativeTabs.tabBlock);

        // ToDo: Do we need to register it via FeatureObjectRegister?
        GameRegistry.registerBlock(this, name);
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
