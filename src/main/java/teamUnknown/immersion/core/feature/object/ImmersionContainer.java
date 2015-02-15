package teamUnknown.immersion.core.feature.object;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import teamUnknown.immersion.core.providers.resources.ResourceProvider;
import teamUnknown.immersion.coreFeatures.creativeTab.FeatureCreativeTab;

public class ImmersionContainer extends BlockContainer implements IImersionObject {

    private static final Material DEFAULT_MATERIAL = Material.rock;

    public ImmersionContainer() {
        this(null, DEFAULT_MATERIAL);
    }

    public ImmersionContainer(String name, Material material) {
        super(material);

        if (name == null)
            name = this.inferName();

        //this.setBlockName(ResourceProvider.getBlockName(name));

        //Sets a basic creative tab so that it is accessible. Calling this in the constuructor overrides this
        this.setCreativeTab(FeatureCreativeTab.tabImmersionCore);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return null;
    }

    private String inferName() {
        return this.getClass().getSimpleName();
    }

    @Override
    public void craftingRegistration() {

    }

    @Override
    public void forgeOreDict() {

    }
}
