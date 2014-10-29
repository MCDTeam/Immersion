package teamUnknown.immersion.features.blacksmithFeature.blocks;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import teamUnknown.immersion.core.feature.object.ImmersionBlock;
import teamUnknown.immersion.core.utils.BlockPosition;
import teamUnknown.immersion.core.utils.WorldBlockPosition;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Random;

/**
 *
 */
public class BlockHeatedCoal extends ImmersionBlock {

    public BlockHeatedCoal(){
        super();
        this.setBlockBounds(0, 0, 0, 1, 7 / 8f, 1);
    }

    @Override
    public int getLightValue(IBlockAccess world, int x, int y, int z) {
        return 15;
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        WorldBlockPosition position = new WorldBlockPosition(world, x, y, z);

        if (!isPositionValid(position)){
            HashSet<BlockPosition> closed = new HashSet<BlockPosition>();
            ArrayDeque<WorldBlockPosition> open = new ArrayDeque<WorldBlockPosition>();

            open.add(position);

            while (!open.isEmpty()){
                WorldBlockPosition pos = open.removeFirst();
                if (!closed.contains(pos) && pos.is(this)){
                    closed.add(pos);

                    pos.setBlock(Blocks.flowing_lava, 1);

                    open.add(pos.north());
                    open.add(pos.east());
                    open.add(pos.south());
                    open.add(pos.west());
                }
            }
        }
    }

    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random random) {
        if (random.nextFloat() > 0.92){
            world.spawnParticle("lava", x + 0.5, y + 0.8, z + 0.5, 0, 0.05, 0);
            world.playSoundEffect(x + 0.5f, y + 0.8f, z + 0.5f, "liquid.lavapop", 1, 0.8f);
        }
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean isFlammable(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
        return false;
    }


    public void ignite(WorldBlockPosition position){
        this.propagateIgnition(position);
    }

    protected boolean isPositionValid(WorldBlockPosition position){
        return !position.bottom().isAir()
                && !position.north().isAir()
                && !position.east().isAir()
                && !position.south().isAir()
                && !position.west().isAir()
                && position.top().isAir();
    }

    protected boolean canBePropagatedTo(WorldBlockPosition position){
        return position.is(Blocks.coal_block) && this.isPositionValid(position);
    }

    protected void propagateIgnition(WorldBlockPosition position){
        HashSet<BlockPosition> closed = new HashSet<BlockPosition>();
        ArrayDeque<WorldBlockPosition> open = new ArrayDeque<WorldBlockPosition>();

        open.add(position);

        while (!open.isEmpty()){
            WorldBlockPosition pos = open.removeFirst();
            if (!closed.contains(pos) && this.canBePropagatedTo(pos)){
                closed.add(pos);

                pos.setBlock(this);

                open.add(pos.north());
                open.add(pos.east());
                open.add(pos.south());
                open.add(pos.west());
            }
        }
    }

}
