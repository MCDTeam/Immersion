package teamUnknown.immersion.features.oreGenFeature.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import teamUnknown.immersion.core.meta.ModMetadata;
import teamUnknown.immersion.features.oreGenFeature.ORef;

import java.util.Random;

public class BlockOre extends Block 
{
	@SideOnly(Side.CLIENT)
	protected IIcon texture;

	public BlockOre(String type) 
	{
		super(Material.rock);
		setHardness(2.0F);
		setStepSound(Block.soundTypeStone);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName("ore" + type);
		setHarvestLevel("pickaxe", 3);

		//External Registration
		GameRegistry.registerBlock(this, this.getUnlocalizedName().substring(5));
	}
	
	public Item getItemDropped(int meta, Random random, int fortune)
    {
        return ORef.lumpOre;
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
