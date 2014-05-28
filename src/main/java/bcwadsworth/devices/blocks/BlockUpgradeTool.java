package bcwadsworth.devices.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockUpgradeTool extends Block
{
	@SideOnly(Side.CLIENT)
	protected IIcon texture;
	
	public BlockUpgradeTool(String type) 
	{
		super(Material.cloth);
		setHardness(0.5F);
		setStepSound(Block.soundTypeCloth);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName("blockUpgradeTool" + type);
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) 
	{
		texture = register.registerIcon("devices:" + this.getUnlocalizedName().substring(5));
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) 
	{
		return texture;
	}
}
