package teamUnknown.immersion.features.magic.blocks.tileEntity;

import teamUnknown.immersion.core.utils.BlockPosition;
import teamUnknown.immersion.features.magic.api.mana.IManaBlock;
import teamUnknown.immersion.features.magic.api.mana.ManaPacket;
import net.minecraft.tileentity.TileEntity;

public class TileManaPylon extends TileEntity implements IManaBlock
{

	@Override
	public Boolean isBlockAbleToConnect(BlockPosition pos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BlockPosition[] connectedblocks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ManaPacket getCollectedStorage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void connectBlock(BlockPosition pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disconnectBlock(BlockPosition pos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void checkConnected() {
		// TODO Auto-generated method stub
		
	}
	
}
