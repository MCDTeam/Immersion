package cf.mcdTeam.immersion.features.blacksmithFeature.blocks;

import cf.mcdTeam.immersion.core.feature.object.ImmersionBlock;

/**
 * Fake air to prevent block placing ( just a placeholder for a workaround)
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
