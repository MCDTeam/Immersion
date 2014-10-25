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

public class FuelEnrichedCoal extends Block 
{
	@SideOnly(Side.CLIENT)
	protected IIcon texture;

	public FuelEnrichedCoal() 
	{
		super(Material.rock);
		setHardness(2.0F);
		setStepSound(Block.soundTypeStone);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName("fuelEnrichedCoal");
		setHarvestLevel("pickaxe", 1);
		setLightLevel(.5F);
		
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