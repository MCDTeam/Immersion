package teamUnknown.immersion.features.common;

import teamUnknown.immersion.Immersion;
import teamUnknown.immersion.features.IFeature;

/**
 * This is the basic feature, which includes common logic and stage separation for feature registration.
 * It is advised to extend this class when creating new features.
 */
public abstract class CommonFeatureBase implements IFeature {
    protected final Immersion _mod;
    protected final String _featureName;
    private final FeatureProperties _properties;

    public CommonFeatureBase(){
        this._mod = Immersion.instance;

        this._properties = this.getClass().getAnnotation(FeatureProperties.class);
        this._featureName = _properties.name();
    }

    @Override
    public void runFeaturePreInitialization(FeatureContext context) {
        context.getLogger().info(String.format("Running Pre-Initialization of feature '%1$s'", this._featureName));

        if (this._properties.doConfigurationRegistration())
            this.registerConfiguration(context);

        if (this._properties.doBlocksRegistration())
            this.registerBlocks(context);

        if (this._properties.doItemsRegistration())
            this.registerItems(context);

        if (this._properties.doWorldGenerationRegistration())
            this.registerWorldGeneration(context);

        context.getLogger().info(String.format("Pre-Initialization of feature '%1$s' completed", this._featureName));
    }

    @Override
    public void runFeatureInitialization(FeatureContext context) {
        context.getLogger().info(String.format("Running Initialization of feature '%1$s'", this._featureName));

        if (this._properties.doEntitiesRegistration())
            this.registerEntities(context);

        if (this._properties.doCraftingRegistration())
            this.registerCraftingRecipes(context);

        if (this._properties.doEventListenersRegistration())
            this.registerEventListeners(context);

        context.getLogger().info(String.format("Initialization of feature '%1$s' completed", this._featureName));
    }

    @Override
    public void runFeaturePostInitialization(FeatureContext context) {
        context.getLogger().info(String.format("Running Post-Initialization of feature '%1$s'", this._featureName));

        if (this._properties.doModCompatibilityRegistration())
            this.registerModCompatibility(context);

        context.getLogger().info(String.format("Post-Initialization of feature '%1$s' completed", this._featureName));
    }

    @Override
    public void runFeatureServerStarting(FeatureContext context) {
        context.getLogger().info(String.format("Running Server Starting of feature '%1$s'", this._featureName));

        if(this._properties.doCommandRegistration())
            this.registerServerCommands(context);

        context.getLogger().info(String.format("Server Starting of feature '%1$s' completed", this._featureName));
    }

    @Override
    public String getFeatureName() {
        return this._featureName;
    }

    protected abstract void registerConfiguration(FeatureContext context);
    protected abstract void registerBlocks(FeatureContext context);
    protected abstract void registerItems(FeatureContext context);
    protected abstract void registerWorldGeneration(FeatureContext context);
    protected abstract void registerEventListeners(FeatureContext context);
    protected abstract void registerEntities(FeatureContext context);
    protected abstract void registerCraftingRecipes(FeatureContext context);
    protected abstract void registerModCompatibility(FeatureContext context);
    protected abstract void registerServerCommands(FeatureContext context);
}
