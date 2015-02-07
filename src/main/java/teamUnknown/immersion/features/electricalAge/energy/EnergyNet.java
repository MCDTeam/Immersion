package teamUnknown.immersion.features.electricalAge.energy;

import net.minecraft.util.EnumFacing;
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
     * @param storage     The energyBar object to take the energy from.
     */
    public static void distributeEnergyToSurrounding(World world, int x, int y, int z, EnumFacing lastDirection, IEnergyStorage storage) {
        distributeEnergyToSurroundingWithLoss(world, x, y, z, lastDirection, storage, 0);
    }

    /**
     * A utility method for distributing energy to the surrounding
     * machines/cables.
     *
     * @param world     Self-explainatory
     * @param x         Self-explainatory
     * @param y         Self-explainatory
     * @param z         Self-explainatory
     * @param storage The energyBar object to take the energy from.
     */

    public static void distributeEnergyToSurrounding(World world, int x, int y, int z, IEnergyStorage storage) {
        distributeEnergyToSurrounding(world, x, y, z, ForgeDirection.UNKNOWN, storage);
    }

    public static void distributeEnergyToSide(World world, int x, int y, int z, ForgeDirection direction, IEnergyStorage storage) {
        if (world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ) instanceof IEnergyHandler) {
            IEnergyHandler energyTileOnSide = (IEnergyHandler) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
            IEnergyHandler thisEnergyTile = (IEnergyHandler) world.getTileEntity(x, y, z);
            ForgeDirection invertedSide = ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]];
            if (thisEnergyTile.canConnectEnergy(invertedSide) && energyTileOnSide.canAddEnergyOnSide(invertedSide)) {
                if (storage.getEnergyStored() - thisEnergyTile.getEnergyStorage().getEnergyTransferRate() >= 0) {
                    if (energyTileOnSide.getEnergyStorage().canAddEnergy(thisEnergyTile.getEnergyStorage().getEnergyTransferRate())) {
                        energyTileOnSide.getEnergyStorage().addEnergy(thisEnergyTile.getEnergyStorage().getEnergyTransferRate());
                        storage.removeEnergy(thisEnergyTile.getEnergyStorage().getEnergyTransferRate());
                    } else {
                        int remaining = energyTileOnSide.getEnergyStorage().addEnergyWithRemaining(thisEnergyTile.getEnergyStorage().getEnergyTransferRate());
                        storage.removeEnergy(thisEnergyTile.getEnergyStorage().getEnergyTransferRate() - remaining);
                    }
                    energyTileOnSide.setLastReceivedDirection(ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]]);
                }
            }
        }
    }

    public static void distributeEnergyToSurroundingWithLoss(World world, int x, int y, int z, ForgeDirection lastDirection, IEnergyStorage storage, int loss) {
        int sides = 0;
        boolean sidesCanOutput[] = new boolean[6];
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) {
            if (world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ) instanceof IEnergyHandler) {
                IEnergyHandler energyTileNextToIt = (IEnergyHandler) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
                IEnergyHandler thisEnergyTile = (IEnergyHandler) world.getTileEntity(x, y, z);
                ForgeDirection invertedSide = ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]];
                if (thisEnergyTile.canConnectEnergy(invertedSide) && energyTileNextToIt.canAddEnergyOnSide(invertedSide) && direction != lastDirection) {
                    sidesCanOutput[direction.ordinal()] = true;
                    sides++;
                }
            }
        }
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) {
            if (sidesCanOutput[direction.ordinal()] && direction != lastDirection) {
                IEnergyHandler energyTile = (IEnergyHandler) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
                if (storage.getEnergyStored() - energyTile.getEnergyStorage().getEnergyTransferRate() / sides >= 0) {
                    if (energyTile.getEnergyStorage().canAddEnergy(energyTile.getEnergyStorage().getEnergyTransferRate() / sides - loss)) {
                        energyTile.getEnergyStorage().addEnergy(energyTile.getEnergyStorage().getEnergyTransferRate() / sides - loss);
                        storage.removeEnergy(energyTile.getEnergyStorage().getEnergyTransferRate() / sides);
                    } else {
                        int remaining = energyTile.getEnergyStorage().addEnergyWithRemaining(energyTile.getEnergyStorage().getEnergyTransferRate() / sides - loss);
                        storage.removeEnergy(energyTile.getEnergyStorage().getEnergyTransferRate() / sides - remaining);
                    }
                    energyTile.setLastReceivedDirection(ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]]);
                }
            }
        }
    }
}
