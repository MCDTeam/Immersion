package teamUnknown.immersion.core.utils;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;

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
}
