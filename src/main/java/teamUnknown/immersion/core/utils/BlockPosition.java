package teamUnknown.immersion.core.utils;

import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

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

    public int getZ() {
        return this._z;
    }

    public int getY() {
        return this._y;
    }

    public int getX() {
        return this._x;
    }

    public BlockPosition direction(ForgeDirection direction) {
        return direction(direction, 1);
    }

    public BlockPosition direction(ForgeDirection direction, int count){
        return new BlockPosition(this._x + direction.offsetX * count, this._y + direction.offsetY * count, this._z + direction.offsetZ * count);
    }

    public BlockPosition top(){
        return this.direction(ForgeDirection.UP);
    }

    public BlockPosition bottom(){
        return this.direction(ForgeDirection.DOWN);
    }

    public BlockPosition north(){
        return this.direction(ForgeDirection.NORTH);
    }

    public BlockPosition west(){
        return this.direction(ForgeDirection.WEST);
    }

    public BlockPosition south(){
        return this.direction(ForgeDirection.SOUTH);
    }

    public BlockPosition east(){
        return this.direction(ForgeDirection.EAST);
    }

    public BlockPosition topWorldBlock(World world, int x, int z){
        int y = world.getTopSolidOrLiquidBlock(x, z);
        return new BlockPosition(x, y, z);
    }

    public BlockPosition topTerrainBlock(World world, int x, int z){
        int y = world.getHeightValue(x, z);
        return new BlockPosition(x, y, z);
    }

    //TODO the as much world function as possible


}
