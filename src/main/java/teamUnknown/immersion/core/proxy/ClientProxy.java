package teamUnknown.immersion.core.proxy;

import teamUnknown.immersion.features.magic.blocks.tileEntity.TileManaPylonBasic;
import teamUnknown.immersion.features.magic.blocks.tileEntity.render.RendererManaPylonBasic;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy{

    @SideOnly(Side.CLIENT)
    @Override
    public void registerRendering() 
    {
    	ClientRegistry.bindTileEntitySpecialRenderer(TileManaPylonBasic.class, new RendererManaPylonBasic());
    }
    
    @Override
    public void registerTileEntitys()
    {
    	super.registerTileEntitys();
    }
}
