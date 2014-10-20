package teamUnknown.immersion.core.logging;

import teamUnknown.immersion.core.feature.IFeature;

/**
 *
 */
public class FeatureLogger extends SubSystemLogger implements IGameLogger {

    protected FeatureLogger(IFeature feature){
        super("Feature/" + feature.getFeatureName());
    }

    public static IGameLogger getLoggerForFeature(IFeature feature){
        return new FeatureLogger(feature);
    }

    @Override
    public void announce(String format, Object... args) {
        // TODO
    }

}
