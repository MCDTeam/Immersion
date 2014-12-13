package teamUnknown.immersion.features.electricalAge.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import teamUnknown.immersion.features.electricalAge.blocks.Machines.blockCreativeStorage;

public class ElectricalBlocks {

    public static final Block electricalBlock = new blockElectricalWire("electricalWire");
    public static final Block creativeStorage = new blockCreativeStorage("creativeStorage");

    public static void init(){
        GameRegistry.registerBlock(electricalBlock, "electricalBlock");
        GameRegistry.registerBlock(creativeStorage, "creativeStorage");
    }

}
