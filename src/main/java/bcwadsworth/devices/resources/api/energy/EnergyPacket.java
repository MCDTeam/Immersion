package bcwadsworth.devices.resources.api.energy;

public class EnergyPacket
{
	EEnergyTypes type;
	int factor1;
	int factor2;
	
	public EnergyPacket(EEnergyTypes type, int factor1, int factor2)
	{
		this.type = type;
		this.factor1 = factor1;
		this.factor2 = factor2;
	}
	
}
