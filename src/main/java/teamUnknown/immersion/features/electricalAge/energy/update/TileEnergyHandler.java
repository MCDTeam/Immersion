package teamUnknown.immersion.features.electricalAge.energy.update;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEnergyHandler extends TileEntity implements IEnergyHandler {

    protected EnergyStorage storage = new EnergyStorage(32000);
    private ForgeDirection lastReceivedDirection = ForgeDirection.UNKNOWN;


    @Override
    public void readFromNBT(NBTTagCompound nbt) {

        super.readFromNBT(nbt);
        storage.readFromNBT(nbt);
    }

    @Override
    public void writeToNBT(NBTTagCompound nbt) {

        super.writeToNBT(nbt);
        storage.writeToNBT(nbt);
    }

    /* IEnergyConnection */
    @Override
    public boolean canConnectEnergy(ForgeDirection from) {

        return true;
    }

    @Override
    public void setLastReceivedDirection(ForgeDirection direction) {
        this.lastReceivedDirection = direction;
    }

    /* IEnergyReceiver */
    @Override
    public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {

        return storage.receiveEnergy(maxReceive, simulate);
    }

    /* IEnergyProvider */
    @Override
    public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {

        return storage.extractEnergy(maxExtract, simulate);
    }

    /* IEnergyReceiver and IEnergyProvider */
    @Override
    public int getEnergyStored(ForgeDirection from) {

        return storage.getEnergyStored();
    }

    @Override
    public int getMaxEnergyStored(ForgeDirection from) {

        return storage.getMaxEnergyStored();
    }

    @Override
    public void removeEnergy(int amount) {
        storage.energy -= amount;
    }

    @Override
    public void addEnergy(int amount) {
        storage.energy += amount;
    }

    @Override
    public EnergyStorage getEnergyStorage() {
        return storage;
    }
}
