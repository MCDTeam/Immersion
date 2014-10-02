package teamUnknown.immersion.features.common;

/**
 * Including some more common functionality for feature activation
 */
public class CommonFeature extends CommonFeatureBase {

    @Override
    protected void registerConfiguration(FeatureContext context) {
        context.getLogger().info("Registering configuration");
    }

    @Override
    protected void registerBlocks(FeatureContext context) {
        context.getLogger().info("Registering blocks");
    }

    @Override
    protected void registerItems(FeatureContext context) {
        context.getLogger().info("Registering items");
    }

    @Override
    protected void registerWorldGeneration(FeatureContext context) {
        context.getLogger().info("Registering worldgen");
    }

    @Override
    protected void registerEventListeners(FeatureContext context) {
        context.getLogger().info("Registering event listeners");
    }

    @Override
    protected void registerEntities(FeatureContext context) {
        context.getLogger().info("Registering entities");
    }

    @Override
    protected void registerCraftingRecipes(FeatureContext context) {
        context.getLogger().info("Registering crafting");
    }

    @Override
    protected void registerModCompatibility(FeatureContext context) {
        context.getLogger().info("Registering mod compatibility");
    }
}
