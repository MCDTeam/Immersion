package teamUnknown.immersion.core.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import teamUnknown.immersion.features.electricalAge.client.render.tileEntity.TileEntityRenderElectricalWireBasic;
import teamUnknown.immersion.features.electricalAge.tileEntitys.TileEntityElectricalWire;

@SideOnly(Side.CLIENT)
public class ClientProxy extends CommonProxy{

    @SideOnly(Side.CLIENT)
    @Override
    public void registerRendering() {

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectricalWire.class, new TileEntityRenderElectricalWireBasic());
    }

    @Override
    public void registerTileEntitys() {

    }
}
