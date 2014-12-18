package teamUnknown.immersion.features.electricalAge.blocks.Machines;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import teamUnknown.immersion.core.meta.ModMetadata;
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
        return disabled;
    }

    public void registerBlockIcons(IIconRegister iconRegister) {

        enabled = iconRegister.registerIcon(ModMetadata.MOD_ID + ":" + "tile.wirelessChargerEnabled");
        disabled = iconRegister.registerIcon(ModMetadata.MOD_ID + ":" + "tile.wirelessChargerDisabled");
    }
}
