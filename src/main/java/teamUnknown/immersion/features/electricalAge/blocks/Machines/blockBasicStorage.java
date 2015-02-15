package teamUnknown.immersion.features.electricalAge.blocks.Machines;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import teamUnknown.immersion.Immersion;
import teamUnknown.immersion.core.feature.object.ImmersionContainer;
import teamUnknown.immersion.core.meta.GuiIds;

public class blockBasicStorage extends ImmersionContainer{

    public blockBasicStorage(String name, Material material){
        super(name, material);
    }

    @Override
    /*public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityBasicStorage();
    }*/
    public TileEntity createNewTileEntity(World world, int meta) {
        return null;
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumFacing side, float hitX, float hitY, float hitZ) {
        if(!world.isRemote) {
            player.openGui(Immersion.instance, GuiIds.GUI_ENERGY_CELL_ID, world, pos.getX(), pos.getY(), pos.getZ());
        }
        return true;//TODO
    }

    /**@Override
    public int getRenderType() {
    return -1;
    }**/

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

}
