package teamUnknown.immersion.core.feature.object;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import teamUnknown.immersion.core.feature.object.IImersionObject;
import teamUnknown.immersion.core.meta.ModMetadata;

/**
 *
 */
public class ImmersionBlock extends Block implements IImersionObject
{

    @SideOnly(Side.CLIENT)
    protected IIcon texture;

    public ImmersionBlock(String name, Material material) 
    {
        super(material);
    	setBlockName(name);
    }

	@Override
	public void craftingRegistration() 
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
