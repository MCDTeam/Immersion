package teamUnknown.immersion.features.metallurgyFeature.items;

import teamUnknown.immersion.core.feature.object.ImmersionBlock;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.IIcon;

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
