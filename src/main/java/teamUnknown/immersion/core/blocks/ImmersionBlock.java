package teamUnknown.immersion.core.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import teamUnknown.immersion.core.meta.ImmersionRegistry;
import teamUnknown.immersion.core.meta.ModMetadata;

/**
 *
 */
public class ImmersionBlock extends Block {

    @SideOnly(Side.CLIENT)
    protected IIcon texture;

    public ImmersionBlock(Material material, String type) {
        super(material);


        //External Registration
        //GameRegistry.registerBlock(this, this.getUnlocalizedName().substring(5));
        ImmersionRegistry.registry.RegisterBlock(this);
    }

    public ImmersionBlock(Material material) {
        super(material);

        //External Registration
        //GameRegistry.registerBlock(this, this.getUnlocalizedName().substring(5));
        ImmersionRegistry.registry.RegisterBlock(this);
    }

    @SideOnly(Side.CLIENT)
    public void registerBlockIcons(IIconRegister register)
    {
        texture = register.registerIcon(ModMetadata.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int side, int meta)
    {
        return texture;
    }
}
