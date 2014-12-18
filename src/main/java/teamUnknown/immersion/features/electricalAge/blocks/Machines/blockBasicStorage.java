package teamUnknown.immersion.features.electricalAge.blocks.Machines;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import teamUnknown.immersion.Immersion;
import teamUnknown.immersion.core.feature.object.ImmersionContainer;
import teamUnknown.immersion.core.meta.GuiIds;
import teamUnknown.immersion.core.meta.ModMetadata;
import teamUnknown.immersion.features.electricalAge.tileEntitys.machine.TileEntityBasicStorage;

public class blockBasicStorage extends ImmersionContainer{

    public blockBasicStorage(String name, Material material){
        super(name, material);
    }

    public IIcon output;
    public IIcon base;

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityBasicStorage();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {

        if(!world.isRemote) {
            player.openGui(Immersion.instance, GuiIds.GUI_ENERGY_CELL_ID, world, x, y, z);
        }
        return true;//TODO
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    /**@Override
    public int getRenderType() {
    return -1;
    }**/

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        return output;
    }

    public void registerBlockIcons(IIconRegister iconRegister) {

        output = iconRegister.registerIcon(ModMetadata.MOD_ID + ":" + "tile.machineOutput");
        base = iconRegister.registerIcon(ModMetadata.MOD_ID + ":" + "tile.machineBase");
    }

    public IIcon getIcon(int side, int meta) {
        if (side == 3) return output;
        return base;
    }
}
