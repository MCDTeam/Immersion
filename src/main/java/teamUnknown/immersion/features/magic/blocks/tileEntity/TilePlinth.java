package teamUnknown.immersion.features.magic.blocks.tileEntity;

import java.util.Random;

import teamUnknown.immersion.core.utils.BlockPosition;
import teamUnknown.immersion.features.magic.api.mana.IManaReciever;
import teamUnknown.immersion.features.magic.api.mana.ManaPacket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.tileentity.TileEntity;

public class TilePlinth extends TileEntity implements IManaReciever
{
	@SideOnly(Side.CLIENT)
	public float x;	
	@SideOnly(Side.CLIENT)
	public float y;
	@SideOnly(Side.CLIENT)
	public float z;
	@SideOnly(Side.CLIENT)
	public float mx;	
	@SideOnly(Side.CLIENT)
	public float my;
	@SideOnly(Side.CLIENT)
	public float mz;
	
	@SideOnly(Side.CLIENT)
	public TilePlinth()
	{
		Random r = Minecraft.getMinecraft().theWorld.rand;
		mx = r.nextFloat()/100F;
		my = r.nextFloat()/100F;
		mz = r.nextFloat()/100F;
	}
	
	@Override
	public Boolean isBlockAbleToConnect(BlockPosition pos) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BlockPosition[] connectedblocks() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public ManaPacket getCollectedStorage() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void connectBlock(BlockPosition pos) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void disconnectBlock(BlockPosition pos) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void checkConnected() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public ManaPacket pushPacket(ManaPacket packet) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
