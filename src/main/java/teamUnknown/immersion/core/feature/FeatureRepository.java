package teamUnknown.immersion.core.feature;

import net.minecraftforge.common.config.Configuration;
import teamUnknown.immersion.core.logging.FeatureLogger;
import teamUnknown.immersion.core.logging.ILogger;
import teamUnknown.immersion.core.logging.SubSystemLogger;
import teamUnknown.immersion.core.providers.FeatureConfigurationProvider;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *  Feature Repository is used for registering, storing and retrieving of features, with automated initialization delegation
 */
public class FeatureRepository {
    private final SubSystemLogger _logger;
    protected final ArrayList<IFeature> _possibleFeatures;
    private final ArrayList<IFeature> _activeFeatures;
    private Configuration configuration;
	private ArrayList<IFeature> _activeAlternateFeatures;

    public FeatureRepository(){
        this._possibleFeatures = new ArrayList<IFeature>();
        this._activeFeatures = new ArrayList<IFeature>();
        this._activeAlternateFeatures = new ArrayList<IFeature>();
        this._logger = SubSystemLogger.getLoggerForSubsystem(this.getClass());
    }

    public void RegisterFeature(IFeature feature) 
    {
        this._possibleFeatures.add(feature);
    }

    public void runSetup(Configuration configuration)
    {
    	for (IFeature feature: this._possibleFeatures)
    	{
    		feature.preSetup();
    	}
    	//Processing of @FeatureData(Features_Possible) Annotations
    	for (IFeature feature: this._possibleFeatures)
    	{
    		for (Field feild : feature.getClass().getFields())
    		{
    			try
    			{
    				feild.getAnnotation(Feature.FeatureData.class);
    			}
    			
    		}
    	}
    	//Getting all dependencies
    	HashMap<IFeature, IFeature[] > map = new HashMap<IFeature, IFeature[]>();
    	for (IFeature feature: this._possibleFeatures)
    	{
    		map.put(feature, feature.setup());
    	}
    	
    	Iterator<IFeature> iterator = this._possibleFeatures.iterator();
    	do
    	{
    		IFeature feature = iterator.next();
    		if (feature.getClass().getAnnotation(Feature.class).isBase())
    		{
    			_activeFeatures.add(feature);
    			iterator.remove();
    			continue;
    		}
    		else
    		{
    			Boolean depFound = false;
    			for(IFeature[] deplist : map.values())
    			{
    				for (IFeature dependency: deplist)
    				{
    					if (dependency.getFeatureName() == feature.getFeatureName())
    					{
    						depFound = true;
    						break;
    					}
    				}
    				if (depFound == true)
    				{
    					break;
    				}
    			}
    			if (depFound == true)
    			{
    				continue;
    			}
    			else
    			{
    				Boolean active = configuration.get("Feature Activation", String.format("Feature '%1$s' active", feature.getFeatureName()), true).getBoolean(true);
    				if (active)
    				{
    					_activeFeatures.add(feature);
    					iterator.remove();
    					continue;
    				}
    				else
    				{
    					iterator.remove();
    					map.remove(feature);
    					continue;
    				}
    			}
    		}
    	} while (iterator.hasNext());
    	
    }
    public void runPreInitialization(Configuration configuration) {

        ILogger log = this._logger;

        this.configuration = configuration;

        log.info("Selecting activated features");

        for (IFeature feature: this._possibleFeatures)
        {
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
            Class c = entry.getValue().feature.getClass();
            Method[] m = c.getDeclaredMethods();
            for (Method method : m)
            {
            	
            }
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

    public <T extends IFeature> T getFeature(Class<T> featureClass) {
        IFeature featureInstance = this._activeFeatures.get(featureClass.getSimpleName()).feature;
        if (featureClass.isInstance(featureInstance))
            return featureClass.cast(featureInstance);
        else
            return null;
    }
}
