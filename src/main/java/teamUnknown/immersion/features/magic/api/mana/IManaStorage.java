package teamUnknown.immersion.features.magic.api.mana;

public interface IManaStorage extends IManaBlock
{
	public ManaPacket getStoredPacket();
	public ManaPacket pushManaPacket(ManaPacket push);
	public ManaPacket pullManaPacket(ManaPacket pull);
	public int getStorageCap();
}
