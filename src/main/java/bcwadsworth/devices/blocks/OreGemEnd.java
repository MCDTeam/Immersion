package bcwadsworth.devices.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import bcwadsworth.devices.Devices;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OreGemEnd extends Block 
{
	@SideOnly(Side.CLIENT)
	protected IIcon texture;

	public OreGemEnd() 
	{
		super(Material.rock);
		setHardness(2.0F);
		setStepSound(Block.soundTypeStone);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName("oreGemEnd");
		setHarvestLevel("pickaxe", 3);
	}

	public Item getItemDropped(int metadata, Random random, int fortune) 
	{
		return Devices.gemEnd;
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
