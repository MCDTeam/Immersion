package teamUnknown.immersion.features.common;

import teamUnknown.immersion.Immersion;
import teamUnknown.immersion.core.logging.IGameLogger;
import teamUnknown.immersion.core.providers.IConfigurationProvider;

/**
 *  Feature context - for quick access to Mod instance, logging and configuration in features
 */
public class FeatureContext {
    private Immersion _modInstance;
    private IGameLogger _logger;
    private IConfigurationProvider _configuration;

    public FeatureContext(IGameLogger logger, IConfigurationProvider configuration) {
        this._modInstance = Immersion.instance;
        this._logger = logger;
        this._configuration = configuration;
    }

    public Immersion getModInstance() {
        return this._modInstance;
    }

    public IGameLogger getLogger() {
        return this._logger;
    }

    public IConfigurationProvider getConfiguration(){
        return this._configuration;
    }
}
