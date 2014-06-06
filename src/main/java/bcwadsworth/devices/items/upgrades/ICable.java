package bcwadsworth.devices.items.upgrades;

import bcwadsworth.devices.tileEntity.TileUpgradable;
import net.minecraft.tileentity.TileEntity;

/*
 * Interface for EType Upgrade
 */
public interface ICable
{
	public void installationEvent(TileUpgradable tile); 
	
	public void deinstallationEvent(TileUpgradable tile);

	public void inventoryOpenEvent(TileUpgradable tile);

	public void inventoryCloseEvent(TileUpgradable tile);

	public void inventoryTickEvent(TileUpgradable tile);
}
