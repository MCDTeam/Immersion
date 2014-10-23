package teamUnknown.immersion.core.feature;

import net.minecraftforge.common.config.Configuration;
import teamUnknown.immersion.Immersion;
import teamUnknown.immersion.core.feature.Feature.FeatureData;
import teamUnknown.immersion.core.feature.Feature.FeatureData.Data;
import teamUnknown.immersion.core.feature.Feature.FeatureElement;
import teamUnknown.immersion.core.feature.Feature.FeatureElement.Element;
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
    private ArrayList<IFeature> _features;


    public FeatureRepository(){
        this._features = new ArrayList<IFeature>();
        this._logger = SubSystemLogger.getLoggerForSubsystem(this.getClass());
    }

    public void RegisterFeature(IFeature feature) 
    {
        this._features.add(feature);
        
    }

    public void runSetup(Configuration configuration)
    {
        ArrayList<IFeature> _fullFeatures = new ArrayList<IFeature>();
    	ArrayList<IFeature> _alternateFeatures = new ArrayList<IFeature>();
    	ArrayList<IFeature> _methodFeatureStorage = new ArrayList<IFeature>();
    	
    	//Processing of Pre-Data Annotations
    	this.fillData(Data.PREFEATURELIST, this._features, this._features);
    	this.fillData(Data.MODINSTANCE, Immersion.instance, this._features);
    	for (IFeature feature: this._features)
    	{
    		for (Field feild : feature.getClass().getFields())
    		{
    			try
    			{
    				FeatureData data = feild.getAnnotation(Feature.FeatureData.class);
    				if (data.value() == Data.LOGGER)
    				{
    					feild.set(feature, FeatureLogger.getLoggerForFeature(feature));
    					continue;
    				}
    			}
    			catch (Throwable e)
    			{
    				this._logger.info("Scanning for feilds resulted in '%1$s' from feature '%2$s' for feild '%3$s'.", e.toString(), feature.getFeatureName(), feild.getName());
    			}	
    		}
    	}
    	
    	//Run Startup Code
    	for (IFeature feature: this._features)
    	{
    		feature.preSetup();
    	}
    	
    	//Getting all dependencies
    	HashMap<IFeature, IFeature[]> map = new HashMap<IFeature, IFeature[]>();
    	for (IFeature feature: this._features)
    	{
    		IFeature[] features = feature.setup();
    		if (features != null)
    		{
    			map.put(feature, features);
    		}
    	}
    	
    	if (!map.isEmpty()) 
    	{
			//Find toplevels and ask about them. Goes to the smallest toplevel and then stops
			int topFound;
			do {
				topFound = 0;
				Iterator<IFeature> iterator = this._features.iterator();
				do {
					IFeature feature = iterator.next();
					if (feature.getClass().getAnnotation(Feature.class)
							.isBase()) {
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
							topFound++;
							Boolean active = configuration.get(
									"Feature Activation",
									String.format("Feature '%1$s' active",
											feature.getFeatureName()), true)
									.getBoolean(true);
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
		}
    	
		//Finishes by adding all remaining if no alternate and asks about alternates
		for (IFeature feature : _features)
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
		for (IFeature feature : _fullFeatures)
		{
			_methodFeatureStorage.add(feature);
		}
		for (IFeature feature : _alternateFeatures)
		{
			_methodFeatureStorage.add(feature);
		}
		
		//Filling of Booleans and Lists to be filled now
		this.fillData(Data.ALTERNATE, false, _fullFeatures);
		this.fillData(Data.ALTERNATE, true, _alternateFeatures);
		this.fillData(Data.ALTFEATURELIST, _alternateFeatures, _methodFeatureStorage);
		this.fillData(Data.FULLFEATURELIST, _fullFeatures, _methodFeatureStorage);
		this.fillData(Data.COMPLETEFEATURELIST, _methodFeatureStorage, _methodFeatureStorage);

		this._features = _methodFeatureStorage;
		
		//Finishing Setup by calling post setup
		for (IFeature feature : _fullFeatures)
		{
			feature.postSetup();
		}
    	
    }
    
    public void runPreInitialization(Configuration configuration) 
    {
        ILogger log = this._logger;

        log.info("Running Pre-Initialization of all features");

        for (IFeature feature : this._features)
        {
            Class c = feature.getClass();
            for (Method m : c.getDeclaredMethods())
            {
            	try 
            	{
					FeatureElement data = m.getAnnotation(Feature.FeatureElement.class);
					if (data.value() == Element.CONFIGURATION)
					{
						log.info("Invoking Configuration Element of '%1$s'", feature.getFeatureName());
						m.invoke(feature, FeatureConfigurationProvider.getFeatureConfigurationForFeature(feature, configuration));
						continue;
					}
					if (data.value() == Element.ITEMS)
					{
						log.info("Invoking Item Element of '%1$s'", feature.getFeatureName());
						m.invoke(feature);
						continue;
					}
					if (data.value() == Element.BLOCKS)
					{
						log.info("Invoking Item Element of '%1$s'", feature.getFeatureName());
						m.invoke(feature);
						continue;
					}
					if (data.value() == Element.PREINITIALIZATION)
					{
						log.info("Invoking Generic Pre-Initialization Element of '%1$s'. THIS IS NOT RECCOMENDED. REMOVE THIS IF POSSIBLE.", feature.getFeatureName());
						m.invoke(feature);
						continue;
					}
				} 
            	catch (Throwable e) 
            	{
					this._logger.info("Scanning for and Invoking methods resulted in '%1$s' from feature '%2$s' for feild '%3$s'.", e.toString(), feature.getFeatureName(), m.getName());
				}
            }
        }
        
        log.info("Finished Running Pre-Initialization of all features");
    }

    public void runInitialization() 
    {
        ILogger log = this._logger;

        log.info("Running Initialization of all features");

        for (IFeature feature : this._features)
        {
            Class c = feature.getClass();
            for (Method m : c.getDeclaredMethods())
            {
            	try 
            	{
					FeatureElement data = m.getAnnotation(Feature.FeatureElement.class);
					if (data.value() == Element.ENTITY)
					{
						log.info("Invoking Entity Element of '%1$s'", feature.getFeatureName());
						m.invoke(feature);
						continue;
					}
					if (data.value() == Element.CRAFTING)
					{
						log.info("Invoking Crafting Element of '%1$s'", feature.getFeatureName());
						m.invoke(feature);
						continue;
					}
					if (data.value() == Element.EVENTBUS_EVENT)
					{
						log.info("Invoking Event Bus - EVENT Element of '%1$s'", feature.getFeatureName());
						m.invoke(feature);
						continue;
					}
					if (data.value() == Element.EVENTBUS_ORE)
					{
						log.info("Invoking Event Bus - ORE Element of '%1$s'", feature.getFeatureName());
						m.invoke(feature);
						continue;
					}
					if (data.value() == Element.EVENTBUS_TERRAIN)
					{
						log.info("Invoking Event Bus - TERRAIN Element of '%1$s'", feature.getFeatureName());
						m.invoke(feature);
						continue;
					}
					if (data.value() == Element.INTITIALIZATION)
					{
						log.info("Invoking Generic Initialization Element of '%1$s'. THIS IS NOT RECCOMENDED. REMOVE THIS IF POSSIBLE.", feature.getFeatureName());
						m.invoke(feature);
						continue;
					}
				} 
            	catch (Throwable e) 
            	{
					this._logger.info("Scanning for and Invoking methods resulted in '%1$s' from feature '%2$s' for feild '%3$s'.", e.toString(), feature.getFeatureName(), m.getName());
				}
            }
        }
        
        log.info("Finished Running Initialization of all features");
    }

    public void runPostInitialization() 
    {
        ILogger log = this._logger;

        log.info("Running Post-Initialization of all features");

        for (IFeature feature : this._features)
        {
            Class c = feature.getClass();
            for (Method m : c.getDeclaredMethods())
            {
            	try 
            	{
					FeatureElement data = m.getAnnotation(Feature.FeatureElement.class);
					if (data.value() == Element.FORGE_DICTIONARY)
					{
						log.info("Invoking Forge Dictionary Element of '%1$s'", feature.getFeatureName());
						m.invoke(feature);
						continue;
					}
					if (data.value() == Element.MOD_COMPATIBILITY)
					{
						log.info("Invoking Mod Compatibility Element of '%1$s'", feature.getFeatureName());
						m.invoke(feature);
						continue;
					}
					if (data.value() == Element.POSTINITIALIZATION)
					{
						log.info("Invoking Generic POST-Initialization Element of '%1$s'. THIS IS NOT RECCOMENDED. REMOVE THIS IF POSSIBLE.", feature.getFeatureName());
						m.invoke(feature);
						continue;
					}
				} 
            	catch (Throwable e) 
            	{
					this._logger.info("Scanning for and Invoking methods resulted in '%1$s' from feature '%2$s' for feild '%3$s'.", e.toString(), feature.getFeatureName(), m.getName());
				}
            }
        }
        
        log.info("Finished Running Post-Initialization of all features");
    }
    
    public <T> void fillData(Feature.FeatureData.Data element, T fill, ArrayList<IFeature> list)
    {
    	for (IFeature feature: list)
    	{
    		for (Field f : feature.getClass().getFields())
    		{
    			try
    			{
    				FeatureData data = f.getAnnotation(Feature.FeatureData.class);
    				if (data.value() == element)
    				{
    					f.set(feature, fill);
    				}
    			}
    			catch (Throwable e)
    			{
    				this._logger.info("Scanning for feilds resulted in '%1$s' from feature '%2$s' for feild '%3$s' from declared class '%4$s'.", e.toString(), feature.getFeatureName(), f.getName(), f.getClass().getPackage());
    			}	
    		}
    	}
    }
}

