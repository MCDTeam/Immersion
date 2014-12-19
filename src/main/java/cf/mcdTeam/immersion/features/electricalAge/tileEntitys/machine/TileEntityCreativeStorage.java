package cf.mcdTeam.immersion.features.electricalAge.tileEntitys.machine;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import cf.mcdTeam.immersion.core.meta.Energy;
import cf.mcdTeam.immersion.features.electricalAge.energy.EnergyNet;
import cf.mcdTeam.immersion.features.electricalAge.energy.EnergyStorage;
import cf.mcdTeam.immersion.features.electricalAge.energy.IEnergyHandler;

public class TileEntityCreativeStorage extends TileEntity implements IEnergyHandler{

    private EnergyStorage storage = new EnergyStorage(Energy.Values.CREATIVE_CELL_STORAGE);

    public void updateEntity() {
        EnergyNet.distributeEnergyToSurrounding(worldObj, xCoord, yCoord, zCoord, storage);
        storage.setEnergyStored(storage.getMaxEnergyStored());
    }

    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    public void onDataPacket(NetworkManager manager, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
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
    public EnergyStorage getEnergyStorage() {
        return storage;
    }

    @Override
    public boolean canAddEnergyOnSide(ForgeDirection direction) {
        return true;
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection from) {
        return true;
    }

    @Override
    public void setLastReceivedDirection(ForgeDirection direction) {

    }

    @Override
    public void writeToNBT(NBTTagCompound tagCompound) {
        super.writeToNBT(tagCompound);
        storage.writeToNBT(tagCompound);
    }

    @Override
    public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
        storage.readFromNBT(tagCompound);
    }
}
