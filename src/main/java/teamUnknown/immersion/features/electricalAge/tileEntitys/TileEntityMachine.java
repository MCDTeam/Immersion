package teamUnknown.immersion.features.electricalAge.tileEntitys;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import teamUnknown.immersion.core.meta.Names;
import teamUnknown.immersion.core.utils.NBTHelper;

public class TileEntityMachine extends TileEntity implements IEnergy{

    private int DEFAULT_TRANSFERE_RATE = 100;
    public int rotation;
    private String playerOwner;

    public TileEntityMachine(){
        super();
    }

    @Override
    public boolean canAddEnergyOnSide(ForgeDirection direction) {
        return true;
    }

    @Override
    public boolean canConnect(ForgeDirection direction) {
        return false;
    }

    @Override
    public EnergyBar getEnergyBar() {
        return null;
    }

    @Override
    public void setLastReceivedDirection(ForgeDirection direction) {

    }

    public int getRotation(){
        return this.rotation;
    }

    @Override
    public int getEnergyTransferRate() {
        return DEFAULT_TRANSFERE_RATE;
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

    public void writeToNBT(NBTTagCompound tag, EnergyBar energyBar, int actionStatus, ItemStack[] itemStacks, int rotation) {
        super.writeToNBT(tag);
        energyBar.writeToNBT(tag);
        tag.setInteger(Names.NBT.DIRECTION, rotation);
        tag.setInteger("actionStatus", actionStatus);
        NBTHelper.Inventorys.writeItemStackArrayToNBT(itemStacks, tag);
        //markDirty();
    }

    public void readFromNBT(NBTTagCompound tag, EnergyBar energyBar, int actionStatus, ItemStack[] itemStacks, int rotation) {
        super.readFromNBT(tag);
        energyBar.readFromNBT(tag);
        rotation = tag.getInteger(Names.NBT.DIRECTION);
        actionStatus = tag.getInteger("actionStatus"); //TODO check what for
        NBTHelper.Inventorys.readItemStackArrayFromNBT(itemStacks, tag);
        //markDirty();
    }
}
