package teamUnknown.immersion.core.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import teamUnknown.immersion.core.providers.resources.ResourceProvider;

/**
 *
 */
public class ImmersionBlock extends Block {

    protected ImmersionBlock() {
        this(Material.rock);
    }

    protected ImmersionBlock(Material material) {
        this(material, null);
    }

    protected ImmersionBlock(Material material, String name) {
        super(material);

        if (name == null)
            name = this.inferName();

        this.setBlockName(ResourceProvider.getBlockName(name));
        this.setBlockTextureName(ResourceProvider.getTextureName(name));

        this.setCreativeTab(CreativeTabs.tabBlock);
        GameRegistry.registerBlock(this, name);
    }

    private String inferName() {
        return this.getClass().getSimpleName();
    }


}
