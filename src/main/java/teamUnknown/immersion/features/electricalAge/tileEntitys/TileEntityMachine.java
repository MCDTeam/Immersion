package teamUnknown.immersion.features.electricalAge.tileEntitys;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import teamUnknown.immersion.features.electricalAge.energy.EnergyStorage;
import teamUnknown.immersion.features.electricalAge.energy.IEnergy;
import teamUnknown.immersion.features.electricalAge.energy.IEnergyHandler;

public class TileEntityMachine extends TileEntity implements IEnergy{

    public int rotation;
    public EnergyStorage storage;
    private String playerOwner;

    public TileEntityMachine(EnergyStorage storage){
        this.storage = storage;
    }

    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
        return storage.receiveEnergy(maxReceive, simulate);
    }

    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
        return storage.extractEnergy(maxExtract, simulate);
    }

    @Override
    public int getEnergyStored(ForgeDirection from) {
        return storage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {
        return storage.getMaxEnergyStored();
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection from) {
        return true;
    }

    public Packet getDescriptionPacket() {
        //super.getDescriptionPacket();
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    public void onDataPacket(NetworkManager manager, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
    }

    public int getRotation(){
        return this.rotation;
    }
}
