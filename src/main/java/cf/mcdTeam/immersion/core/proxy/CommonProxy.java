package cf.mcdTeam.immersion.core.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import cf.mcdTeam.immersion.features.electricalAge.tileEntitys.TileEntityElectricalWire;
import cf.mcdTeam.immersion.features.electricalAge.tileEntitys.machine.TileEntityBasicStorage;
import cf.mcdTeam.immersion.features.electricalAge.tileEntitys.machine.TileEntityCreativeStorage;

public abstract class CommonProxy implements IProxy{

    @Override
    public void registerTileEntitys() {

        GameRegistry.registerTileEntity(TileEntityElectricalWire.class, "ElectricalWire");

        GameRegistry.registerTileEntity(TileEntityCreativeStorage.class, "CreativeStorage");
        GameRegistry.registerTileEntity(TileEntityBasicStorage.class, "BasicStorage");
    }
}
