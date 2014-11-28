package teamUnknown.immersion.core.proxy;

import teamUnknown.immersion.features.magic.blocks.tileEntity.TileManaPylon;
import teamUnknown.immersion.features.magic.blocks.tileEntity.TilePlinth;
import cpw.mods.fml.common.registry.GameRegistry;

public abstract class CommonProxy implements IProxy{

    @Override
    public void registerTileEntitys() 
    {
    	GameRegistry.registerTileEntity(TileManaPylon.class, "ManaPylonBasic");
    	GameRegistry.registerTileEntity(TilePlinth.class, "Plinth");
    }
}
