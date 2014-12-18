package teamUnknown.immersion.features.electricalAge.tileEntitys.machine;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import teamUnknown.immersion.core.meta.Energy;
import teamUnknown.immersion.features.electricalAge.energy.EnergyNet;
import teamUnknown.immersion.features.electricalAge.energy.EnergyStorage;
import teamUnknown.immersion.features.electricalAge.energy.IEnergyHandler;

public class TileEntityBasicStorage extends TileEntity implements IEnergyHandler {

    private EnergyStorage storage = new EnergyStorage(Energy.Values.BASIC_CELL_STORAGE);
    public ForgeDirection outputSide = ForgeDirection.SOUTH;

    public void updateEntity() {
        EnergyNet.distributeEnergyToSurrounding(worldObj, xCoord, yCoord, zCoord, outputSide, storage);

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
        return direction != outputSide;
    }

    @Override
    public boolean canConnectEnergy(ForgeDirection from) {
        return true;
    }

    @Override
    public void setLastReceivedDirection(ForgeDirection direction) {

    }

    public void writeToNBT(NBTTagCompound tag) {
        super.writeToNBT(tag);
        storage.writeToNBT(tag);
        tag.setInteger("outputSide", outputSide.ordinal());
    }

    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        storage.readFromNBT(tag);
        outputSide = ForgeDirection.getOrientation(tag.getInteger("outputSide"));
    }

    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    public void onDataPacket(NetworkManager manager, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
    }
}
