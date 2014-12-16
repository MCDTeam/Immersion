package teamUnknown.immersion.features.electricalAge.energy;

import net.minecraft.tileentity.TileEntity;

public class EnergyHelper {

    // Gets the energy stored
    public static int getStoredEnergy(TileEntity tileEntity){
        if(tileEntity instanceof IEnergy){
            return ((IEnergy) tileEntity).getEnergyBar().getEnergyLevel();
        }
        return 0;
    }

    // Gets the max energy
    public static int getMaxEnergyStored(TileEntity tileEntity){
        if(tileEntity instanceof IEnergy){
            return ((IEnergy) tileEntity).getEnergyBar().getEnergyLevel();
        }
        return 0;
    }

    // Get the energy value scaled
    public static int getEnergyScaled(TileEntity tileEntity, int scale){
        return getStoredEnergy(tileEntity) * scale / getMaxEnergyStored(tileEntity);
    }
}
