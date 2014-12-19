package cf.mcdTeam.immersion.core.feature.logging;

import cf.mcdTeam.immersion.core.feature.FeatureDataCollector;
import cf.mcdTeam.immersion.core.feature.IFeature;

/**
 *
 */
public class FeatureLogger extends SubSystemLogger implements IGameLogger {

    protected FeatureLogger(IFeature feature){
        super("Feature:" + FeatureDataCollector.instance.getFeatureName(feature));
    }

    public static IGameLogger getLoggerForFeature(IFeature feature){
        return new FeatureLogger(feature);
    }

    @Override
    public void announce(String format, Object... args) {
        // TODO
    }

}
