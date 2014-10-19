package teamUnknown.immersion.features;

import teamUnknown.immersion.features.common.FeatureContext;

/**
 * Basic building block of the feature system.
 */
public interface IFeature {

    /**
     * Called on the mod pre initialization
     * Should contain the worldGen registration, as well as the item and block registration for this feature
     */
    public void runFeaturePreInitialization(FeatureContext context);

    /**
     * Called on the mod initialization
     * Should contain the eventListener, entities and crafting registration
     * */
    public void runFeatureInitialization(FeatureContext context);

    /**
     * Called on the mod post initialization
     * Used for registration for the mod compatibility items
     */
    public void runFeaturePostInitialization(FeatureContext context);

    /**
     * Called on Server Starting
     * Used to register server commands etc
     */
    public void runFeatureServerStarting(FeatureContext context);

    /**
     * Gets the feature name
     * @return Feature Name
     */
    public String getFeatureName();
}
