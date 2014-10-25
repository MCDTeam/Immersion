package teamUnknown.immersion.features.oreGenFeature.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import teamUnknown.immersion.core.meta.ModMetadata;
import teamUnknown.immersion.features.oreGenFeature.ORef;

import java.util.Random;

public class BlockGemOre extends Block 
{
	@SideOnly(Side.CLIENT)
	protected IIcon texture;
	
	protected Item drop;
	
	public BlockGemOre(String type, Item dropped) 
	{
		super(Material.rock);
		setHardness(2.0F);
		setStepSound(Block.soundTypeStone);
		setCreativeTab(CreativeTabs.tabBlock);
		setBlockName("oreGem" + type);
		setHarvestLevel("pickaxe", 3);
		drop = dropped;
		if (drop == ORef.gemGlow)
		{
			lightValue = 10;
		}
		else if (drop == ORef.gemRed || drop == Items.redstone)
		{
			lightValue = 5;
		}
		
		//External Registration
		GameRegistry.registerBlock(this, this.getUnlocalizedName().substring(5));
	}

	public Item getItemDropped(int meta, Random random, int fortune)
    {
        return drop;
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
