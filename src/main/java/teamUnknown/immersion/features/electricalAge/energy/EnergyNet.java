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
    public static void distributeEnergyToSurrounding(World world, int x, int y, int z, ForgeDirection lastDirection, EnergyBar energyBar) {
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

    public static void distributeEnergyToSurrounding(World world, int x, int y, int z, EnergyBar energyBar) {
        distributeEnergyToSurrounding(world, x, y, z, ForgeDirection.UNKNOWN, energyBar);
    }

    public static void distributeEnergyToSide(World world, int x, int y, int z, ForgeDirection direction, EnergyBar energyBar) {
        if (world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ) instanceof IEnergy) {
            IEnergy energyTileOnSide = (IEnergy) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
            IEnergy thisEnergyTile = (IEnergy) world.getTileEntity(x, y, z);
            ForgeDirection invertedSide = ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]];
            if (thisEnergyTile.canConnect(invertedSide) && energyTileOnSide.canAddEnergyOnSide(invertedSide)) {
                if (energyBar.getEnergyLevel() - thisEnergyTile.getEnergyTransferRate() >= 0) {
                    if (energyTileOnSide.getEnergyBar().canAddEnergy(thisEnergyTile.getEnergyTransferRate())) {
                        energyTileOnSide.getEnergyBar().addEnergy(thisEnergyTile.getEnergyTransferRate());
                        energyBar.removeEnergy(thisEnergyTile.getEnergyTransferRate());
                    } else {
                        int remaining = energyTileOnSide.getEnergyBar().addEnergyWithRemaining(thisEnergyTile.getEnergyTransferRate());
                        energyBar.removeEnergy(thisEnergyTile.getEnergyTransferRate() - remaining);
                    }
                    energyTileOnSide.setLastReceivedDirection(ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]]);
                }
            }
        }
    }

    public static void distributeEnergyToSurroundingWithLoss(World world, int x, int y, int z, ForgeDirection lastDirection, EnergyBar energyBar, int loss) {
        int sides = 0;
        boolean sidesCanOutput[] = new boolean[6];
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) {
            if (world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ) instanceof IEnergy) {
                IEnergy energyTileNextToIt = (IEnergy) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
                IEnergy thisEnergyTile = (IEnergy) world.getTileEntity(x, y, z);
                ForgeDirection invertedSide = ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]];
                if (thisEnergyTile.canConnect(invertedSide) && energyTileNextToIt.canAddEnergyOnSide(invertedSide) && direction != lastDirection) {
                    sidesCanOutput[direction.ordinal()] = true;
                    sides++;
                }
            }
        }
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) {
            if (sidesCanOutput[direction.ordinal()] && direction != lastDirection) {
                IEnergy energyTile = (IEnergy) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ);
                if (energyBar.getEnergyLevel() - energyTile.getEnergyTransferRate() / sides >= 0) {
                    if (energyTile.getEnergyBar().canAddEnergy(energyTile.getEnergyTransferRate() / sides - loss)) {
                        energyTile.getEnergyBar().addEnergy(energyTile.getEnergyTransferRate() / sides - loss);
                        energyBar.removeEnergy(energyTile.getEnergyTransferRate() / sides);
                    } else {
                        int remaining = energyTile.getEnergyBar().addEnergyWithRemaining(energyTile.getEnergyTransferRate() / sides - loss);
                        energyBar.removeEnergy(energyTile.getEnergyTransferRate() / sides - remaining);
                    }
                    energyTile.setLastReceivedDirection(ForgeDirection.VALID_DIRECTIONS[ForgeDirection.OPPOSITES[direction.ordinal()]]);
                }
            }
        }
    }
}
