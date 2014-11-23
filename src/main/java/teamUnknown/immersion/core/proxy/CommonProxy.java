package teamUnknown.immersion.core.proxy;

import teamUnknown.immersion.features.magic.blocks.tileEntity.TileManaPylonBasic;
import teamUnknown.immersion.features.magic.blocks.tileEntity.TileManaPylonTopBasic;
import cpw.mods.fml.common.registry.GameRegistry;

public abstract class CommonProxy implements IProxy{

    @Override
    public void registerTileEntitys() 
    {
    	GameRegistry.registerTileEntity(TileManaPylonBasic.class, "ManaPylonBasic");
    	GameRegistry.registerTileEntity(TileManaPylonTopBasic.class, "ManaPylonTopBasic");
    }
}
