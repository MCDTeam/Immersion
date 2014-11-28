package teamUnknown.immersion.core.proxy;

import teamUnknown.immersion.features.magic.blocks.tileEntity.TileManaPylon;
import teamUnknown.immersion.features.magic.blocks.tileEntity.TilePlinth;
import teamUnknown.immersion.features.magic.blocks.tileEntity.render.RendererManaPylon;
import teamUnknown.immersion.features.magic.blocks.tileEntity.render.RendererPlinth;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends CommonProxy{

    @SideOnly(Side.CLIENT)
    @Override
    public void registerRendering() 
    {
    	ClientRegistry.bindTileEntitySpecialRenderer(TileManaPylon.class, new RendererManaPylon());
    	ClientRegistry.bindTileEntitySpecialRenderer(TilePlinth.class, new RendererPlinth());
    }
    
    @Override
    public void registerTileEntitys()
    {
    	super.registerTileEntitys();
    }
}
