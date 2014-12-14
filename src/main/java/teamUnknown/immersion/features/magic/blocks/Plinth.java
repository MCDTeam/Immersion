package teamUnknown.immersion.features.magic.blocks;

import teamUnknown.immersion.core.feature.object.ImmersionBlock;
import teamUnknown.immersion.features.magic.blocks.tileEntity.TileManaPylon;
import teamUnknown.immersion.features.magic.blocks.tileEntity.TilePlinth;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class Plinth extends ImmersionBlock implements ITileEntityProvider{

	public Plinth ()
	{
		super();
		this.setBlockBounds(0F, 0F, 0F, 1F, .25F, 1F);
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
		return new TilePlinth();
	}
}
