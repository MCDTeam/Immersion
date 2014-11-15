package teamUnknown.immersion.features.electricalAge.tileEntitys;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;
import teamUnknown.immersion.core.meta.EnergyValues;
import teamUnknown.immersion.features.electricalAge.energy.EnergyBar;
import teamUnknown.immersion.features.electricalAge.energy.EnergyNet;
import teamUnknown.immersion.features.electricalAge.energy.IEnergy;

public class TileEntityElectricalWire extends TileEntity implements IEnergy {

    private EnergyBar energyBar = new EnergyBar(EnergyValues.Values.ELECTRICAL_WIRE_STORGE);
    private ForgeDirection lastReceivedDirection = ForgeDirection.UNKNOWN;

    public TileEntityElectricalWire(){

    }

    @Override
    public void updateEntity() {
        EnergyNet.distributeEnergyToSurrounding(worldObj, xCoord, yCoord, zCoord, lastReceivedDirection, energyBar);
    }

    /**
     * Power Network Functions *
     */
    @Override
    public boolean canAddEnergyOnSide(ForgeDirection direction) {
        return true;
    }

    @Override
    public boolean canConnect(ForgeDirection direction) {
        return true;
    }

    public EnergyBar getEnergyBar() {
        return energyBar;
    }

    @Override
    public void setLastReceivedDirection(ForgeDirection direction) {
        this.lastReceivedDirection = direction;
    }

    @Override
    public int getEnergyTransferRate() {
        return EnergyValues.Values.ELECTRICAL_WIRE_TRANSFERE;
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {

        super.writeToNBT(tag);
        energyBar.writeToNBT(tag);
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {

        super.readFromNBT(tag);
        energyBar.readFromNBT(tag);
    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1, yCoord + 1, zCoord + 1);
    }

    /**
     * Network
     */

    /**@Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }**/

    @Override
    public void onDataPacket(NetworkManager manager, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
    }
}
