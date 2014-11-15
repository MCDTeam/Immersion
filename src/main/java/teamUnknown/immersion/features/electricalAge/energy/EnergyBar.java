package teamUnknown.immersion.features.electricalAge.energy;

import net.minecraft.nbt.NBTTagCompound;
import teamUnknown.immersion.core.meta.Names;

public class EnergyBar {
    private int maxEnergyLevel = 0;
    private int defaultMaxEnergyLevel;
    private int energyLevel = 0;

    public EnergyBar(int maxEnergyLevel, boolean shouldStartOfWithMaxEnergy) {
        this.maxEnergyLevel = defaultMaxEnergyLevel = maxEnergyLevel;
        if (shouldStartOfWithMaxEnergy) this.energyLevel = maxEnergyLevel;
    }

    public EnergyBar(int maxEnergyLevel) {
        this(maxEnergyLevel, false);
    }

    public void addEnergy(int amount) {
        energyLevel += amount;
    }

    public void removeEnergy(int amount) {
        energyLevel -= amount;
    }

    public boolean canAddEnergy(int amount) {
        return (energyLevel + amount) <= maxEnergyLevel;
    }

    public boolean canRemoveEnergy(int amount) {
        return (energyLevel - amount) >= 0;
    }

    public void setMaxEnergyLevel(int newMax) {
        this.maxEnergyLevel = newMax;
    }

    public int getMaxEnergyLevel() {
        return maxEnergyLevel;
    }

    public void setEnergyLevel(int amount) {
        energyLevel = amount;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void writeToNBT(NBTTagCompound tag) {
        tag.setInteger(Names.NBT.POWER, energyLevel);
    }

    public void readFromNBT(NBTTagCompound tag) {
        this.energyLevel = tag.getInteger(Names.NBT.POWER);
    }

    public int getEnergyLevelScaled(int scale) {
        return energyLevel * scale / maxEnergyLevel;
    }

    public int addEnergyWithRemaining(int amount) {
        energyLevel += amount;
        if (energyLevel > maxEnergyLevel) {
            int powerRemaining = energyLevel - maxEnergyLevel;
            energyLevel -= powerRemaining;
            return powerRemaining;
        }
        return 0;
    }

    public void resetMaxEnergyLevel() {
        maxEnergyLevel = defaultMaxEnergyLevel;
    }
}
