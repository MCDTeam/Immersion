package teamUnknown.immersion.core.utils;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

/**
 *
 */
public class BlockPosition {

    private int _x;
    private int _y;
    private int _z;

    public BlockPosition(int x, int y, int z){
        this._x = x;
        this._y = y;
        this._z = z;
    }

    public boolean isAir(World world) {
        return world.isAirBlock(new BlockPos(this._x, this._y, this._z));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlockPosition that = (BlockPosition) o;

        if (_x != that._x) return false;
        if (_y != that._y) return false;
        if (_z != that._z) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = _x;
        result = 31 * result + _y;
        result = 31 * result + _z;
        return result;
    }


    //TODO the as much world function as possible
    /**
     * 1.8 Functions
     */

    public static BlockPos createPosFromCoords(int x, int y, int z){
        return new BlockPos(x, y, z);
    }

    public static TileEntity getTileEntity(World world, BlockPos pos){
        return world.getTileEntity(pos);
    }

    public static Block getBlock(World world, BlockPos pos){
        return world.getBlockState(pos).getBlock();
    }
}
