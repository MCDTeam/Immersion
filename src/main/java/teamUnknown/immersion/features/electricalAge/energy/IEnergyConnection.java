package teamUnknown.immersion.features.electricalAge.energy;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Implement this interface on TileEntities which should connect to energy transportation blocks. This is intended for blocks which generate energy but do not
 * accept it; otherwise just use IEnergyHandler.
 * <p>
 * Note that {@link IEnergyHandler} is an extension of this.
 */

public interface IEnergyConnection {

    /**
     * Returns TRUE if the TileEntity can connect on a given side.
     */
    boolean canConnectEnergy(ForgeDirection from);

    /**
     * Sets the last recieved direction.
     * @param direction
     */
    void setLastReceivedDirection(ForgeDirection direction);
}
