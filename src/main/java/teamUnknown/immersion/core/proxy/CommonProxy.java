package teamUnknown.immersion.core.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import teamUnknown.immersion.features.electricalAge.tileEntitys.TileEntityElectricalWire;
import teamUnknown.immersion.features.electricalAge.tileEntitys.machine.TileEntityBasicStorage;
import teamUnknown.immersion.features.electricalAge.tileEntitys.machine.TileEntityCreativeStorage;
import teamUnknown.immersion.features.electricalAge.tileEntitys.machine.TileEntityWirelessCharger;

public abstract class CommonProxy implements IProxy{

    @Override
    public void registerTileEntitys() {

        //GameRegistry.registerTileEntity(TileEntityElectricalWire.class, "ElectricalWire");
        //GameRegistry.registerTileEntity(TileEntityWirelessCharger.class, "WirelessCharger");

        //GameRegistry.registerTileEntity(TileEntityCreativeStorage.class, "CreativeStorage");
        //GameRegistry.registerTileEntity(TileEntityBasicStorage.class, "BasicStorage");
    }
}
