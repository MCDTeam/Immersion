package teamUnknown.immersion.features.magic.api.mana;

public interface IManaReciever extends IManaBlock
{
	public ManaPacket pushPacket(ManaPacket packet);
}
