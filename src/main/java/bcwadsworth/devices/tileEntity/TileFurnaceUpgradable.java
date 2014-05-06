package bcwadsworth.devices.tileEntity;

import bcwadsworth.devices.tileEntity.TileUpgradable;

public class TileFurnaceUpgradable extends TileUpgradable
{

	public TileFurnaceUpgradable() 
	{
		super("FurnaceUpgradable", "machine", 24);
		this.constructSections();
		this.sectionsAcceptItems();
	}
	
}
