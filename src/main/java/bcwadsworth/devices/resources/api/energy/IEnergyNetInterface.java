package bcwadsworth.devices.resources.api.energy;

public interface IEnergyNetInterface
{
	public Boolean CanAcceptEnergy(EEnergyTypes type);

	public Boolean CanGiveEnergy(EEnergyTypes type);
	
	public EnergyPacket AcceptEnergy(EnergyPacket packet);
}
