package teamUnknown.immersion.features.metallurgyFeature.items;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamUnknown.immersion.core.feature.object.ImmersionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockStorage extends ImmersionBlock
{
	@SideOnly(Side.CLIENT)
	protected IIcon texture;
	
	public BlockStorage(String type) 
	{
		super("block" + type, Material.iron);
		setHardness(2.0F);
		setStepSound(Block.soundTypeMetal);
		setCreativeTab(CreativeTabs.tabBlock);
		setHarvestLevel("pickaxe", 3);
		if (type == "GemGlow")
		{
			lightValue = 15;
		}

	}


}
