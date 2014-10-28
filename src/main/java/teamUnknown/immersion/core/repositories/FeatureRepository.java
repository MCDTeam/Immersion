package teamUnknown.immersion.core.repositories;

import net.minecraftforge.common.config.Configuration;
import teamUnknown.immersion.core.logging.FeatureLogger;
import teamUnknown.immersion.core.logging.ILogger;
import teamUnknown.immersion.core.logging.SubSystemLogger;
import teamUnknown.immersion.core.providers.config.FeatureConfigurationProvider;
import teamUnknown.immersion.features.IFeature;
import teamUnknown.immersion.features.common.FeatureContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *  Feature Repository is used for registering, storing and retrieving of features, with automated initialization delegation
 */
public class FeatureRepository {
    private final SubSystemLogger _logger;
    private final HashMap<String, FeatureEntry> _activeFeatures;
    private final ArrayList<IFeature> _possibleFeatures;
    private Configuration configuration;

    public FeatureRepository(){
        this._possibleFeatures = new ArrayList<IFeature>();
        this._activeFeatures = new HashMap<String, FeatureEntry>();
        this._logger = SubSystemLogger.getLoggerForSubsystem(this.getClass());
    }

    public void RegisterFeature(IFeature feature) {
        this._possibleFeatures.add(feature);
    }

    public void runPreInitialization(Configuration configuration) {

        ILogger log = this._logger;

        this.configuration = configuration;

        log.info("Selecting activated features");

        for (IFeature feature: this._possibleFeatures){
            FeatureContext context = this.createFeatureContext(feature);
            boolean featureEnabled = context.getConfiguration().getConfig("Enabled", String.format("Enables the '%1$s' feature", feature.getFeatureName()), true);
            if (featureEnabled){
                log.info(String.format("Feature '%1$s' activated ", feature.getFeatureName()));
                this._activeFeatures.put(feature.getClass().getSimpleName(), new FeatureEntry(feature, context));
            } else {
                log.info(String.format("Feature '%1$s' deactivated ", feature.getFeatureName()));
            }
        }

        log.info("Running Pre-Initialization of all features");

        for (Map.Entry<String, FeatureEntry> entry: this._activeFeatures.entrySet()){
            FeatureEntry featureEntry = entry.getValue();
            featureEntry.feature.runFeaturePreInitialization(featureEntry.context);
        }
    }

    public void runInitialization() {
        this._logger.info("Running Initialization of all features");
        for (Map.Entry<String, FeatureEntry> entry: this._activeFeatures.entrySet()){
            FeatureEntry featureEntry = entry.getValue();
            featureEntry.feature.runFeatureInitialization(featureEntry.context);
        }
    }

    public void runPostInitialization() {
        this._logger.info("Running Post-Initialization of all features");
        for (Map.Entry<String, FeatureEntry> entry: this._activeFeatures.entrySet()){
            FeatureEntry featureEntry = entry.getValue();
            featureEntry.feature.runFeaturePostInitialization(featureEntry.context);
        }
    }

    public void runServerStarting() {
        this._logger.info("Running Server Starting of all features");
        for (Map.Entry<String, FeatureEntry> entry: this._activeFeatures.entrySet()){
            FeatureEntry featureEntry = entry.getValue();
            featureEntry.feature.runFeatureServerStarting(featureEntry.context);
        }
    }

    public <T extends IFeature> T getFeature(Class<T> featureClass) {
        IFeature featureInstance = this._activeFeatures.get(featureClass.getSimpleName()).feature;
        if (featureClass.isInstance(featureInstance))
            return featureClass.cast(featureInstance);
        else
            return null;
    }

    private FeatureContext createFeatureContext(IFeature feature){
        return new FeatureContext(
                FeatureLogger.getLoggerForFeature(feature),
                FeatureConfigurationProvider.getFeatureConfigurationForFeature(feature, this.configuration));
    }

    private static class FeatureEntry{
        public IFeature feature;
        public FeatureContext context;

        private FeatureEntry(IFeature feature, FeatureContext context) {
            this.feature = feature;
            this.context = context;
        }
    }
}
