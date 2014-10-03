package teamUnknown.immersion.features.oreGenFeature.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import teamUnknown.immersion.core.meta.ModMetadata;

public class BlockStorage extends Block 
{
	@SideOnly(Side.CLIENT)
	protected IIcon texture;
	
	public BlockStorage(String type) 
	{
		super(Material.iron);
		setHardness(2.0F);
		setStepSound(Block.soundTypeMetal);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName("block" + type);
		setHarvestLevel("pickaxe", 3);
		if (type == "GemGlow")
		{
			lightValue = 15;
		}
		
		//External Registration
		GameRegistry.registerBlock(this, this.getUnlocalizedName().substring(5));
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
