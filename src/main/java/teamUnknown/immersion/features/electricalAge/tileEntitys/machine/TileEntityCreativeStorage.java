package teamUnknown.immersion.features.electricalAge.tileEntitys.machine;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import teamUnknown.immersion.features.electricalAge.energy.EnergyBar;
import teamUnknown.immersion.features.electricalAge.energy.EnergyNet;
import teamUnknown.immersion.core.meta.Energy;
import teamUnknown.immersion.features.electricalAge.tileEntitys.TileEntityMachine;

public class TileEntityCreativeStorage extends TileEntityMachine {

    private EnergyBar energyBar = new EnergyBar(Energy.Values.CREATIVE_CELL_STORAGE, true);

    public void updateEntity() {
        EnergyNet.distributeEnergyToSurrounding(worldObj, xCoord, yCoord, zCoord, energyBar);
        energyBar.setEnergyLevel(energyBar.getMaxEnergyLevel());
    }

    @Override
    public boolean canAddEnergyOnSide(ForgeDirection direction) {
        return false;
    }

    @Override
    public boolean canConnect(ForgeDirection direction) {
        return true;
    }

    @Override
    public void setLastReceivedDirection(ForgeDirection direction) {
    }

    @Override
    public EnergyBar getEnergyBar() {
        return energyBar;
    }

    public void writeToNBT(NBTTagCompound tag) {
        energyBar.writeToNBT(tag);
    }

    public void readFromNBT(NBTTagCompound tag) {
        energyBar.readFromNBT(tag);
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
    public int getEnergyTransferRate() {
        return energyBar.getMaxEnergyLevel();
    }
}
