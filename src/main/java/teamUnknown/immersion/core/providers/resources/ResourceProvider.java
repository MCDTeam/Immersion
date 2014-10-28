package teamUnknown.immersion.core.providers.resources;

import teamUnknown.immersion.core.meta.ModMetadata;

/**
 *
 */
public class ResourceProvider {

    protected static String getNameForRegistration(String name){
        return ModMetadata.MOD_ID + "." + name;
    }

    public static String getItemName(String name){
        return getNameForRegistration(name);
    }

    public static String getBlockName(String name){
        return getNameForRegistration(name);
    }

    public static String getLocalizationStringName(String name){
        return getNameForRegistration(name);
    }

    public static String getTextureName(String name){
        return ModMetadata.MOD_ID + ":" + name;
    }
}
