package teamUnknown.immersion.features.blacksmithFeature.blocks;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import teamUnknown.immersion.core.blocks.ImmersionBlock;

import java.util.Random;

/**
 * Fake air to prevent block placing
 */
public class BlockFakeAir extends ImmersionBlock {
    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean canCollideCheck(int meta, boolean b)
    {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }
}
