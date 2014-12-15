package teamUnknown.immersion.core.utils;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

/**
 *
 */
public class BlockPosition {

    public int x;
    public int y;
    public int z;
    public World w;

    public BlockPosition(World w, int y, int z, int x){
        this.x = x;
        this.y = y;
        this.z = z;
        this.w = w;
    }

    public int getZ() {
        return this.z;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

    public BlockPosition direction(ForgeDirection direction) {
        return direction(direction, 1);
    }

    public BlockPosition direction(ForgeDirection direction, int count){
        return new BlockPosition(w, this.x + direction.offsetX * count, this.y + direction.offsetY * count, this.z + direction.offsetZ * count);
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

    public static BlockPosition topWorldBlock(World world, int x, int z){
        int y = world.getTopSolidOrLiquidBlock(x, z);
        return new BlockPosition(world, y, z, x);
    }

    public static BlockPosition topTerrainBlock(World world, int x, int z){
        int y = world.getHeightValue(x, z);
        return new BlockPosition(world, y, z, x);
    }

    public Block getBlock(){
        return w.getBlock(x, y, z);
    }

    public boolean setBlock(Block block){
        return w.setBlock(x, y, z, block);
    }


    public boolean setBlock(Block block, int meta) {
        return w.setBlock(x, y, z, block, meta, 3);
    }
    
    public boolean setAir()
    {
    	return w.setBlockToAir(x, y, z);
    }

    public boolean isAir() {
        return w.isAirBlock(x, y, z);
    }

    public boolean is(Block block) {
        return this.getBlock() == block;
    }
    
    public boolean hasTileEntity()
    {
    	return w.getTileEntity(x, y, z) != null;
    }
    
    public TileEntity getTileEntity()
    {
    	return w.getTileEntity(x, y, z);
    }
    
    public static BlockPosition getPositonFromTile(TileEntity tile)
    {
    	return new BlockPosition(tile.getWorldObj(), tile.yCoord, tile.zCoord, tile.xCoord);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlockPosition that = (BlockPosition) o;

        if (x != that.x) return false;
        if (y != that.y) return false;
        if (z != that.z) return false;
        if (w != that.w) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }


    //TODO the as much world function as possible


}
