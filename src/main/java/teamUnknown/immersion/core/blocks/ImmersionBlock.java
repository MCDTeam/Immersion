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
public class ImmersionBlock extends Block implements IImersionBlock
{

    @SideOnly(Side.CLIENT)
    protected IIcon texture;

    public ImmersionBlock(Material material) 
    {
        super(material);
        ImmersionRegistry.registry.register(this);
    }

	@Override
	public void onRegistration() 
	{

	}

	@Override
	public void forgeOreDict() 
	{

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
