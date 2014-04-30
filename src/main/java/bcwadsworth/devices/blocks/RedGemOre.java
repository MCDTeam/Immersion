package bcwadsworth.devices.blocks;

import bcwadsworth.devices.Devices;
import bcwadsworth.devices.resources.General;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class RedGemOre extends Block 
{
	@SideOnly(Side.CLIENT)
	protected IIcon texture;

	public RedGemOre(Material material) 
	{
		super(material);
		setHardness(2.0F);
		setStepSound(Block.soundTypeStone);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName("redGemOre");
		setHarvestLevel("pickaxe", 2);
	}

	public Item func_149650_a(int metadata, Random random, int fortune) 
	{
		return Devices.redGem;
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
