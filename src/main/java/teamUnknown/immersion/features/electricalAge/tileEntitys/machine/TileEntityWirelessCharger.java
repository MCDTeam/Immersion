package teamUnknown.immersion.features.electricalAge.tileEntitys.machine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import teamUnknown.immersion.core.feature.object.ImmersionBlock;
import teamUnknown.immersion.features.electricalAge.energy.EnergyStorage;
import teamUnknown.immersion.features.electricalAge.energy.IEnergyContainerItem;
import teamUnknown.immersion.features.electricalAge.energy.IEnergyHandler;

import java.util.Iterator;
import java.util.List;

public class TileEntityWirelessCharger extends TileEntity implements IEnergyHandler {

    private EnergyStorage storage = new EnergyStorage(10000);
    private int energyUsePerOperation = 100;

    private int range = 50;
    private int timer = 40;
    private int counter = 0;

    @Override
    public void updateEntity() {
        counter++;

        if (counter == timer) {
            doWirelessCharging();
        }
    }

    public void doWirelessCharging() {

        List players = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, this.getRenderBoundingBox().expand(range, 5, range));
        Iterator iterator = players.iterator();

        if (this.worldObj.isRemote) {
            while (iterator.hasNext()) {

                EntityPlayer entityplayer = (EntityPlayer) iterator.next();

                if(!entityplayer.capabilities.isCreativeMode) {
                    EnergyStorage storageItem = getItemEnergyStorage(entityplayer);

                    chargeItem(storageItem);
                }
            }
        }
    }

    public EnergyStorage getItemEnergyStorage(EntityPlayer player){
        InventoryPlayer inventory = player.inventory;

        for(int x = 0; x <= 35; x++) {
            ItemStack itemStack = inventory.getStackInSlot(x);
            if (itemStack != null) {
                Item item = itemStack.getItem();

                if (item instanceof IEnergyContainerItem) {
                    return ((IEnergyContainerItem) item).getEnergyStorage();
                } else {
                    return null;
                }
            }
        }
        return null;
    }

    public void chargeItem(EnergyStorage itemEnergyStorage){
        if(storage.getEnergyStored() > 0){
            if(storage.getEnergyStored() >= energyUsePerOperation){

                if((itemEnergyStorage.canAddEnergy(energyUsePerOperation)) && (storage.canRemoveEnergy(energyUsePerOperation))){
                    itemEnergyStorage.addEnergy(energyUsePerOperation);
                    storage.removeEnergy(energyUsePerOperation);
                }
            }else{
                int remainder = storage.getEnergyStored();
                if((itemEnergyStorage.canAddEnergy(remainder)) && (storage.canRemoveEnergy(remainder))){
                    itemEnergyStorage.addEnergyWithRemaining(remainder);
                    storage.removeEnergy(remainder);
                }
            }
        }
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
