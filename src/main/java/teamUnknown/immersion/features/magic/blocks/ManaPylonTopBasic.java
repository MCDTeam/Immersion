package teamUnknown.immersion.features.magic.blocks;

import teamUnknown.immersion.core.feature.object.ImmersionBlock;
import teamUnknown.immersion.features.magic.blocks.tileEntity.TileManaPylonBasic;
import teamUnknown.immersion.features.magic.blocks.tileEntity.TileManaPylonTopBasic;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ManaPylonTopBasic extends ImmersionBlock implements ITileEntityProvider{

	public ManaPylonTopBasic ()
	{
		super();
		this.setBlockBounds(0.25F, 0.0F, 0.25F, 0.75F, .5F, 0.75F);
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileManaPylonTopBasic();
	}
}
