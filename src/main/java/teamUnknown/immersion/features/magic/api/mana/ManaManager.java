package teamUnknown.immersion.features.magic.api.mana;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.tileentity.TileEntity;
import teamUnknown.immersion.core.utils.BlockPosition;

public class ManaManager
{
	public static ManaManager instance = new ManaManager();
	
	public HashMap<BlockPosition, IManaBlock> manablocks= new HashMap<BlockPosition, IManaBlock>();
	
	public void joinManaManager(IManaBlock b)
	{
		BlockPosition bpos = BlockPosition.getPositonFromTile((TileEntity)b);
		manablocks.put(bpos, b);
		ArrayList<IManaBlock> list = new ArrayList<IManaBlock>();
		for(IManaBlock check: manablocks.values())
		{
			if(check.isBlockAbleToConnect(bpos))
			{
				check.connectBlock(bpos);
				b.connectBlock(BlockPosition.getPositonFromTile((TileEntity)check));
				list.add(check);
			}
		}
		
		for (IManaBlock check: list)
		{
			check.checkConnected();
		}
	}
	
	public void unjoinManaManager(IManaBlock b)
	{
		manablocks.remove(BlockPosition.getPositonFromTile((TileEntity)b));
		for (BlockPosition r: b.connectedblocks())
		{
			IManaBlock e = (IManaBlock) r.getTileEntity();
			e.disconnectBlock(r);
		}
		
		for (BlockPosition r: b.connectedblocks())
		{
			IManaBlock e = (IManaBlock) r.getTileEntity();
			e.checkConnected();
		}
	}
	
	public void tick()
	{
		
	}
}
