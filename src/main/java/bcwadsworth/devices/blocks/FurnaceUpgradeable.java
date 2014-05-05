package bcwadsworth.devices.blocks;

import bcwadsworth.devices.Devices;
import bcwadsworth.devices.tileEntity.TileFurnaceUpgradable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

public class FurnaceUpgradeable extends BlockContainer
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


	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register) 
	{
		texture = register.registerIcon("devices:redGemOre");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		return texture;
	}

	@Override
    public TileEntity createNewTileEntity(World var1, int var2)
    {
	    return new TileFurnaceUpgradable();
    }
}