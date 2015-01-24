package teamUnknown.immersion.features.electricalAge.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.registry.GameRegistry;
import teamUnknown.immersion.features.electricalAge.blocks.Machines.blockBasicStorage;
import teamUnknown.immersion.features.electricalAge.blocks.Machines.blockCreativeStorage;
import teamUnknown.immersion.features.electricalAge.blocks.Machines.blockWirelessCharger;
import teamUnknown.immersion.features.electricalAge.blocks.energy.blockElectricalWire;

public class ElectricalBlocks {

    public static final Block electricalWire = new blockElectricalWire("electricalWire");
    public static final Block wirelessCharger = new blockWirelessCharger("wirelessCharger", Material.rock);

    public static final Block creativeStorage = new blockCreativeStorage("creativeStorage", Material.rock);
    public static final Block basicStorage = new blockBasicStorage("basicStorage", Material.rock);

    public static void init(){

        GameRegistry.registerBlock(electricalWire, "electricalWire");
        GameRegistry.registerBlock(wirelessCharger, "wirelessCharger");

        GameRegistry.registerBlock(creativeStorage, "creativeStorage");
        GameRegistry.registerBlock(basicStorage, "basicStorage");
    }

}
