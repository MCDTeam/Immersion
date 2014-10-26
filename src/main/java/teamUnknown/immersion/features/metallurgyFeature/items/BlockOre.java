package teamUnknown.immersion.features.metallurgyFeature.items;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import teamUnknown.immersion.core.feature.object.ImmersionBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOre extends ImmersionBlock
{
	@SideOnly(Side.CLIENT)
	protected IIcon texture;

	public BlockOre(String type) 
	{
		super("ore" + type, Material.rock);
		setHardness(2.0F);
		setStepSound(Block.soundTypeStone);
		setCreativeTab(CreativeTabs.tabBlock);
		setHarvestLevel("pickaxe", 3);
	}
	
	public Item getItemDropped(int meta, Random random, int fortune)
    {
        return ModBlocks.lumpOre;
    }
}
