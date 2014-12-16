package teamUnknown.immersion.features.electricalAge.tileEntitys;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;
import teamUnknown.immersion.features.electricalAge.energy.EnergyBar;
import teamUnknown.immersion.features.electricalAge.energy.IEnergy;

public class TileEntityMachine extends TileEntity implements IEnergy{

    public int rotation;
    /**private EnergyBar energyBar;
    private ForgeDirection lastReceivedDirection;
    private int maxStorage storage;
    private String playerOwner;

    public TileEntityMachine(){

    }

    public TileEntityMachine(EnergyBar energyBar, ForgeDirection direction){
        this.energyBar = energyBar;
        this.lastReceivedDirection = direction;

    }**/

    @Override
    public boolean canAddEnergyOnSide(ForgeDirection direction) {
        return true;
    }

    @Override
    public boolean canConnect(ForgeDirection direction) {
        return true;
    }

    public EnergyBar getEnergyBar() {
        return null;
    }

    @Override
    public void setLastReceivedDirection(ForgeDirection direction) {
        //this.lastReceivedDirection = direction;
    }

    @Override
    public int getEnergyTransferRate() {
        return 0;
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {

    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {

    }

    @Override
    public AxisAlignedBB getRenderBoundingBox() {
        return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1, yCoord + 1, zCoord + 1);
    }

    /**
     * Network
     */

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager manager, S35PacketUpdateTileEntity packet) {
        readFromNBT(packet.func_148857_g());
    }

    public int getRotation(){
        return this.rotation;
    }
}
