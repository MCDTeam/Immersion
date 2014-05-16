package bcwadsworth.devices.blocks;

import java.util.Random;

import bcwadsworth.devices.Devices;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

public class BlockImperfectOre extends Block 
{
	@SideOnly(Side.CLIENT)
	protected IIcon texture;
	
	private Item drop;
	public BlockImperfectOre(String type, Item dropped) 
	{
		super(Material.rock);
		setHardness(2.0F);
		setStepSound(Block.soundTypeStone);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName("oreImperfect" + type);
		setHarvestLevel("pickaxe", 3);
		drop = dropped;
	}

	public Item getItemDropped(int metadata, Random random, int fortune) 
	{
		return drop;
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
