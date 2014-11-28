package teamUnknown.immersion.features.magic.api.mana;

import teamUnknown.immersion.core.utils.BlockPosition;

public interface IManaBlock
{
	public Boolean isBlockAbleToConnect(BlockPosition pos);
	public BlockPosition[] connectedblocks();
	public ManaPacket getCollectedStorage();
	public void connectBlock(BlockPosition pos);
	public void disconnectBlock(BlockPosition pos);
	public void checkConnected();
}
