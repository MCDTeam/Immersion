package teamUnknown.immersion.features.electricalAge.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ElectricalBlocks {

    public static final Block electricalBlock = new blockElectricalWire().setBlockName("electricalWire");

    public static void init(){
        GameRegistry.registerBlock(electricalBlock, "electricalBlock");
    }
}
