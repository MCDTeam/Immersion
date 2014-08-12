package bcwadsworth.devices.resources.api.components;

import bcwadsworth.devices.tileEntity.TileMachineBox;
import net.minecraft.tileentity.TileEntity;

/*
 * Interface for EType Upgrade
 */
public interface IComponent
{
	public void installationEvent(TileMachineBox tile); 
	
	public void deinstallationEvent(TileMachineBox tile);

	public void inventoryOpenEvent(TileMachineBox tile);

	public void inventoryCloseEvent(TileMachineBox tile);

	public void inventoryTickEvent(TileMachineBox tile);
}
