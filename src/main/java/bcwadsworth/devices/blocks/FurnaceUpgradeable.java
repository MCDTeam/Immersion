package bcwadsworth.devices.blocks;

import bcwadsworth.devices.Devices;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class FurnaceUpgradeable extends Block 
{
	@SideOnly(Side.CLIENT)
	protected IIcon texture;

	public FurnaceUpgradeable() 
	{
		super(Material.rock);
		setHardness(1.0F);
		setStepSound(Block.soundTypeStone);
		setCreativeTab(CreativeTabs.tabDecorations);
		setBlockName("furnaceUpgradeable");
		setHarvestLevel("pickaxe", 0);
		setLightLevel(.5F);
	}

	public Item getItemDropped(int metadata, Random random, int fortune) 
	{
		return Devices.gemRed;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) 
	{
		texture = register.registerIcon("devices:redGemOre");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return texture;
	}
}