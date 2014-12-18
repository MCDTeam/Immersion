package teamUnknown.immersion.core.utils;

import net.minecraft.util.ResourceLocation;
import teamUnknown.immersion.core.meta.ModMetadata;

public class ResourceLocationHelper {

    public static ResourceLocation getResourceLocation(String modId, String path) {
        return new ResourceLocation(modId, path);
    }

    public static ResourceLocation getResourceLocation(String path) {
        return getResourceLocation(ModMetadata.MOD_ID, path);
    }
}
