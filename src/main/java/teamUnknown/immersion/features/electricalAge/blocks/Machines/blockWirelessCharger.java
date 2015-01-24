package teamUnknown.immersion.features.electricalAge.blocks.Machines;

import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import teamUnknown.immersion.core.providers.resources.ResourceProvider;
import teamUnknown.immersion.features.electricalAge.blocks.ImmersionElectricalBlock;
import teamUnknown.immersion.features.electricalAge.tileEntitys.machine.TileEntityWirelessCharger;

public class blockWirelessCharger extends ImmersionElectricalBlock {

    public IIcon enabled;
    public IIcon disabled;

    public blockWirelessCharger(String name, Material material) {
        super(name, material);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int meta) {
        return new TileEntityWirelessCharger();
    }

    public IIcon getIcon(IBlockAccess world, int x, int y, int z, int side) {
        if((world.getTileEntity(x, y, z) != null) && (world.getTileEntity(x, y, z) instanceof TileEntityWirelessCharger)){
            TileEntityWirelessCharger tileEntity = (TileEntityWirelessCharger) world.getTileEntity(x, y, z);

            if(tileEntity.isCharging){
                return enabled;
            }else{
                return disabled;
            }
        }
        return disabled;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return true;
    }

    @Override
    public int getRenderType() {
        return 0;
    }

    public void registerBlockIcons(IIconRegister iconRegister) {

        //enabled = iconRegister.registerIcon(ModMetadata.MOD_ID + ":" + "tile.wirelessChargerEnabled");
        //disabled = iconRegister.registerIcon(ModMetadata.MOD_ID + ":" + "tile.wirelessChargerDisabled");
        enabled = iconRegister.registerIcon(ResourceProvider.getTextureName("wirelessChargerEnabled"));
        disabled = iconRegister.registerIcon(ResourceProvider.getTextureName("wirelessChargerDisabled"));
    }
}
