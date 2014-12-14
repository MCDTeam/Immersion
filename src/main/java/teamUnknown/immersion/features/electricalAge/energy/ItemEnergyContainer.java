package teamUnknown.immersion.features.electricalAge.energy;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import teamUnknown.immersion.core.feature.object.ImmersionItem;

/**
 * Reference implementation of {@link IEnergyContainerItem}. Use/extend this or implement your own.
 */

public class ItemEnergyContainer extends ImmersionItem implements IEnergyContainerItem{

    protected int capacity;
    protected int maxReceive;
    protected int maxExtract;

    public ItemEnergyContainer(String name) {
        super(name);
    }

    public ItemEnergyContainer(String name, int capacity) {

        this(name, capacity, capacity, capacity);
    }

    public ItemEnergyContainer(String name, int capacity, int maxTransfer) {

        this(name, capacity, maxTransfer, maxTransfer);
    }

    public ItemEnergyContainer(String name, int capacity, int maxReceive, int maxExtract) {

        super(name);

        this.capacity = capacity;
        this.maxReceive = maxReceive;
        this.maxExtract = maxExtract;
    }

    public ItemEnergyContainer setCapacity(int capacity) {

        this.capacity = capacity;
        return this;
    }

    public void setMaxTransfer(int maxTransfer) {

        setMaxReceive(maxTransfer);
        setMaxExtract(maxTransfer);
    }

    public void setMaxReceive(int maxReceive) {

        this.maxReceive = maxReceive;
    }

    public void setMaxExtract(int maxExtract) {

        this.maxExtract = maxExtract;
    }

    /* IEnergyContainerItem */
    @Override
    public int receiveEnergy(ItemStack container, int maxReceive, boolean simulate) {

        if (container.stackTagCompound == null) {
            container.stackTagCompound = new NBTTagCompound();
        }
        int energy = container.stackTagCompound.getInteger("Energy");
        int energyReceived = Math.min(capacity - energy, Math.min(this.maxReceive, maxReceive));

        if (!simulate) {
            energy += energyReceived;
            container.stackTagCompound.setInteger("Energy", energy);
        }
        return energyReceived;
    }

    @Override
    public int extractEnergy(ItemStack container, int maxExtract, boolean simulate) {

        if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Energy")) {
            return 0;
        }
        int energy = container.stackTagCompound.getInteger("Energy");
        int energyExtracted = Math.min(energy, Math.min(this.maxExtract, maxExtract));

        if (!simulate) {
            energy -= energyExtracted;
            container.stackTagCompound.setInteger("Energy", energy);
        }
        return energyExtracted;
    }

    @Override
    public int getEnergyStored(ItemStack container) {

        if (container.stackTagCompound == null || !container.stackTagCompound.hasKey("Energy")) {
            return 0;
        }
        return container.stackTagCompound.getInteger("Energy");
    }

    @Override
    public int getMaxEnergyStored(ItemStack container) {

        return capacity;
    }
}
