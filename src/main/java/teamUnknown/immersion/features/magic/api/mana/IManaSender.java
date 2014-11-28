package teamUnknown.immersion.features.magic.api.mana;

public interface IManaSender extends IManaBlock
{
	public ManaPacket getSendablePacket();
	public void returnUnusedPacket();
}
