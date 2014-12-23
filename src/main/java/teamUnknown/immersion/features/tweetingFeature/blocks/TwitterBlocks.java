package teamUnknown.immersion.features.tweetingFeature.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class TwitterBlocks {

    public static Block TwitterBlock = new blockTwitterBlock("TwitterBlock", Material.iron);

    // Register
    public static void init(){

        GameRegistry.registerBlock(TwitterBlock, "TwitterBlock");
    }
}
