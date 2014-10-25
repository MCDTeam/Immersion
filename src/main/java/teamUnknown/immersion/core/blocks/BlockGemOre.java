package teamUnknown.immersion.core.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;

import java.util.Random;

public class BlockGemOre extends ImmersionBlock
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
		if (drop == ModBlocks.gemGlow)
		{
			lightValue = 10;
		}
		else if (drop == ModBlocks.gemRed || drop == Items.redstone)
		{
			lightValue = 5;
		}
	}

	public Item getItemDropped(int meta, Random random, int fortune)
    {
        return drop;
    }
}
