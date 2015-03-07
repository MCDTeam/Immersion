package teamUnknown.immersion.core.utils;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockUtils {

    public static int determineMetadataBasedOnPlayerOrientation(EntityLivingBase player) {

        int rotation = MathHelper.floor_double((double) (player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        if (rotation == 0) {
            return 2;
        }
        if (rotation == 1) {
            return 5;
        }
        if (rotation == 2) {
            return 3;
        }
        if (rotation == 3) {
            return 4;
        }
        return 3;
    }

    /**
     * 1.8 Methods
     */

    public static TileEntity getTileEntity(World world, BlockPos blockPos){
        return world.getTileEntity(blockPos);
    }


}
