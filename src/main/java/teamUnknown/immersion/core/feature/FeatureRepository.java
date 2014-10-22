package teamUnknown.immersion.core.feature;

import net.minecraftforge.common.config.Configuration;
import teamUnknown.immersion.core.feature.Feature.FeatureData;
import teamUnknown.immersion.core.feature.Feature.FeatureData.Data;
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
    protected final ArrayList<IFeature> _fullFeatures;
	private ArrayList<IFeature> _alternateFeatures;
    private final ArrayList<IFeature> _activeFeatures;
    private Configuration configuration;


    public FeatureRepository(){
        this._possibleFeatures = new ArrayList<IFeature>();
        this._fullFeatures = new ArrayList<IFeature>();
        this._alternateFeatures = new ArrayList<IFeature>();
        this._activeFeatures = new ArrayList<IFeature>();
        this._logger = SubSystemLogger.getLoggerForSubsystem(this.getClass());
    }

    public void RegisterFeature(IFeature feature) 
    {
        this._possibleFeatures.add(feature);
    }

    public void runSetup(Configuration configuration)
    {
    	//Processing of Pre-Data Annotations
    	this.fillData(Data.PREFEATURELIST, this._possibleFeatures, this._possibleFeatures);
    	
    	
    	//Run Startup Code
    	for (IFeature feature: this._possibleFeatures)
    	{
    		feature.preSetup();
    	}
    	
    	//Getting all dependencies
    	HashMap<IFeature, IFeature[] > map = new HashMap<IFeature, IFeature[]>();
    	for (IFeature feature: this._possibleFeatures)
    	{
    		map.put(feature, feature.setup());
    	}
    	
    	//Find toplevels and ask about them. Goes to the smallest toplevel and then stops
    	int topFound;
		do {
			topFound = 0;
			Iterator<IFeature> iterator = this._possibleFeatures.iterator();
			do {
				IFeature feature = iterator.next();
				if (feature.getClass().getAnnotation(Feature.class).isBase()) {
					_fullFeatures.add(feature);
					iterator.remove();
					continue;
				} else {
					Boolean depFound = false;
					for (IFeature[] deplist : map.values()) {
						for (IFeature dependency : deplist) {
							if (dependency.getFeatureName() == feature
									.getFeatureName()) {
								depFound = true;
								break;
							}
						}
						if (depFound == true) {
							break;
						}
					}
					if (depFound == true) {
						continue;
					} else {
						topFound ++;
						Boolean active = configuration.get("Feature Activation", String.format("Feature '%1$s' active", feature.getFeatureName()), true).getBoolean(true);
						if (active) {
							_fullFeatures.add(feature);
							iterator.remove();
							continue;
						} else {
							iterator.remove();
							map.remove(feature);
							continue;
						}
					}
				}
			} while (iterator.hasNext());
		} while (topFound > 0);
		
		//Finishes by adding all remaining if no alternate and asks about alternates
		for (IFeature feature : _possibleFeatures)
		{
			if (feature.getClass().getAnnotation(Feature.class).hasDisabledCompatility()) 
			{
				Boolean active = configuration.get("Feature Activation", String.format("Feature '%1$s' active", feature.getFeatureName()), true).getBoolean(true);
				if (active)
				{
					_fullFeatures.add(feature);
					continue;
				}
				else
				{
					_alternateFeatures.add(feature);
					continue;
				}
			}
			else
			{
				_fullFeatures.add(feature);
				continue;
			}
		}
		
		//Create a cumulative list of features
		for (IFeature feature : this._fullFeatures)
		{
			this._activeFeatures.add(feature);
		}
		for (IFeature feature : this._alternateFeatures)
		{
			this._activeFeatures.add(feature);
		}
		
		//Filling of Booleans and Lists to be filled now
		this.fillData(Data.ALTERNATE, false, this._fullFeatures);
		this.fillData(Data.ALTERNATE, true, this._alternateFeatures);
		this.fillData(Data.ALTFEATURELIST, this._alternateFeatures, this._activeFeatures);
		this.fillData(Data.FULLFEATURELIST, this._activeFeatures, this._activeFeatures);
		this.fillData(Data.FEATURELIST, this._activeFeatures, this._activeFeatures);
		
		//Finishing Setup by calling post setup
		for (IFeature feature : _fullFeatures)
		{
			feature.postSetup();
		}
    	
    }
    public void runPreInitialization() {

        ILogger log = this._logger;

        log.info("Running Pre-Initialization of all features");

        for (Map.Entry<String, FeatureEntry> entry: this._fullFeatures.entrySet()){
            Class c = entry.getValue().feature.getClass();
            Method[] m = c.getDeclaredMethods();
            for (Method method : m)
            {
            	
            }
        }
    }

    public void runInitialization() {
        this._logger.info("Running Initialization of all features");
        for (Map.Entry<String, FeatureEntry> entry: this._fullFeatures.entrySet()){
            FeatureEntry featureEntry = entry.getValue();
            featureEntry.feature.runFeatureInitialization(featureEntry.context);
        }
    }

    public void runPostInitialization() {
        this._logger.info("Running Post-Initialization of all features");
        for (Map.Entry<String, FeatureEntry> entry: this._fullFeatures.entrySet()){
            FeatureEntry featureEntry = entry.getValue();
            featureEntry.feature.runFeaturePostInitialization(featureEntry.context);
        }
    }
    
    public <T> void fillData(Feature.FeatureData.Data element, T fill, ArrayList<IFeature> list)
    {
    	for (IFeature feature: list)
    	{
    		for (Field feild : feature.getClass().getFields())
    		{
    			try
    			{
    				FeatureData data = feild.getAnnotation(Feature.FeatureData.class);
    				if (data.value() == element)
    				{
    					feild.set(feature, fill);
    				}
    			}
    			catch (Throwable e)
    			{
    				this._logger.info("Scanning for feilds resulted in '%1$s' from feature '%2$s' for feild '%3$s' from declared class '%4$s'.", e.toString(), feature.getFeatureName(), feild.getName(), feild.getClass().getPackage());
    			}	
    		}
    	}
    }

    public <T extends IFeature> T getFeature(Class<T> featureClass) {
        IFeature featureInstance = this._fullFeatures.get(featureClass.getSimpleName()).feature;
        if (featureClass.isInstance(featureInstance))
            return featureClass.cast(featureInstance);
        else
            return null;
    }
}

