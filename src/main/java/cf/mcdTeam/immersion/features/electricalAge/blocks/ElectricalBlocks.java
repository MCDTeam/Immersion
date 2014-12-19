package cf.mcdTeam.immersion.features.electricalAge.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import cf.mcdTeam.immersion.features.electricalAge.blocks.Machines.blockBasicStorage;
import cf.mcdTeam.immersion.features.electricalAge.blocks.Machines.blockCreativeStorage;
import cf.mcdTeam.immersion.features.electricalAge.blocks.energy.blockElectricalWire;

public class ElectricalBlocks {

    public static final Block electricalBlock = new blockElectricalWire("electricalWire");

    public static final Block creativeStorage = new blockCreativeStorage("creativeStorage", Material.rock);
    public static final Block basicStorage = new blockBasicStorage("basicStorage", Material.rock);

    public static void init(){

        GameRegistry.registerBlock(electricalBlock, "electricalBlock");

        GameRegistry.registerBlock(creativeStorage, "creativeStorage");
        GameRegistry.registerBlock(basicStorage, "basicStorage");
    }

}
