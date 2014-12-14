package teamUnknown.immersion.features.electricalAge.energy;

import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class EnergyNet {

    /**
     * A utility method for distributing energy to the surrounding
     * machines/cables.
     *
     * @param world         Self-explainatory
     * @param x             Self-explainatory
     * @param y             Self-explainatory
     * @param z             Self-explainatory
     * @param lastDirection The direction the energy was set from last time, so it
     *                      prevents back and forth looping of cables. Please use one of
     *                      the six valid directions ({@link net.minecraftforge.common.util.ForgeDirection}), or UNKNOWN
     *                      of you don't have a last direction.
     * @param energyBar     The energyBar object to take the energy from.
     */
    public static void distributeEnergyToSurrounding(World world, int x, int y, int z, ForgeDirection lastDirection, EnergyStorage energyBar) {
        distributeEnergyToSurroundingWithLoss(world, x, y, z, lastDirection, energyBar, 0);
    }

    /**
     * A utility method for distributing energy to the surrounding
     * machines/cables.
     *
     * @param world     Self-explainatory
     * @param x         Self-explainatory
     * @param y         Self-explainatory
     * @param z         Self-explainatory
     * @param energyBar The energyBar object to take the energy from.
     */

    public static void distributeEnergyToSurrounding(World world, int x, int y, int z, EnergyStorage energyBar) {
        distributeEnergyToSurrounding(world, x, y, z, ForgeDirection.UNKNOWN, energyBar);
    }

    public static void distributeEnergyToSide(World world, int x, int y, int z, ForgeDirection direction, EnergyStorage energyBar) {
        if (world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ) instanceof IEnergyHandler) {
            IEnergyHandler energyTileOnSide = (IEnergyHandler) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
            IEnergyHandler thisEnergyTile = (IEnergyHandler) world.getTileEntity(x, y, z);
            ForgeDirection invertedSide = ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]];
            if (thisEnergyTile.canConnectEnergy(invertedSide) && energyTileOnSide.canConnectEnergy(invertedSide)) {
                if (energyBar.getEnergyStored() - thisEnergyTile.getEnergyTransferRate() >= 0) {
                    if (energyTileOnSide.getEnergyStorage().canAddEnergy(thisEnergyTile.getEnergyTransferRate())) {
                        energyTileOnSide.getEnergyStorage().addEnergy(thisEnergyTile.getEnergyTransferRate());
                        energyBar.extractEnergy(thisEnergyTile.getEnergyTransferRate(), false);
                    } else {
                        int remaining = energyTileOnSide.getEnergyStorage().addEnergyWithRemaining(thisEnergyTile.getEnergyTransferRate());
                        energyBar.extractEnergy(thisEnergyTile.getEnergyTransferRate() - remaining, false);
                    }
                    energyTileOnSide.setLastReceivedDirection(ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]]);
                }
            }
        }
    }

    public static void distributeEnergyToSurroundingWithLoss(World world, int x, int y, int z, ForgeDirection lastDirection, EnergyStorage energyBar, int loss) {
        int sides = 0;
        boolean sidesCanOutput[] = new boolean[6];
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) {
            if (world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ) instanceof IEnergyHandler) {
                IEnergyHandler energyTileNextToIt = (IEnergyHandler) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
                IEnergyHandler thisEnergyTile = (IEnergyHandler) world.getTileEntity(x, y, z);
                ForgeDirection invertedSide = ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]];
                if (thisEnergyTile.canConnectEnergy(invertedSide) && energyTileNextToIt.canConnectEnergy(invertedSide) && direction != lastDirection) {
                    sidesCanOutput[direction.ordinal()] = true;
                    sides++;
                }
            }
        }
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) {
            if (sidesCanOutput[direction.ordinal()] && direction != lastDirection) {
                IEnergyHandler energyTile = (IEnergyHandler) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
                if (energyBar.getEnergyStored() - energyTile.getEnergyTransferRate() / sides >= 0) {
                    if (energyTile.getEnergyStorage().canAddEnergy(energyTile.getEnergyTransferRate() / sides - loss)) {
                        energyTile.getEnergyStorage().addEnergy(energyTile.getEnergyTransferRate() / sides - loss);
                        energyBar.extractEnergy(energyTile.getEnergyTransferRate() / sides, false);
                    } else {
                        int remaining = energyTile.addEnergyWithRemaining(energyTile.getEnergyTransferRate() / sides - loss);
                        energyBar.extractEnergy(energyTile.getEnergyTransferRate() / sides - remaining, false);
                    }
                    energyTile.setLastReceivedDirection(ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]]);
                }
            }
        }
    }    
}
