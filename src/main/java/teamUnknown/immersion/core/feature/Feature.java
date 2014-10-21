package teamUnknown.immersion.core.feature;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The annotation that identifies a feature class
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Feature 
{
	/**
	 * The internal name of the feature
	 */
    public String name() default "UNNAMED";
    
    /**
     * The version of the feature
     */
    public String version() default "UNVERSIONED";
    
    /**
     * Whether or not the feature is a base feature
     * if enabled, cannot be turned off
     */
    public boolean isBase() default false;
    
    /**
     * If required and has this as true, code marked {@link @FeatureAlternate}
     * will run if the feature is disabled
     */
    public boolean hasDisabledCompatility() default false;
    
    /**
     * The interface responsible for telling the code how to use methods within the feature class
     * NOTE: EVERY METHOD WITHIN THE FEATURE THAT WILL BE USED BY BEGINNING CODE
     * MUST HAVE ONE OF THESE ANNOTATIONS
     * NONSETUP will not run
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface FeatureElement 
    {
    	/**
    	 * The Types of events
    	 * FORGE EVENT TYPES SHOULD ONLY BE USED IF WHAT
    	 * YOU WANT TO DO IS NOT INCLUDED ON THE LIST
    	 * NONSETUP is not called naturally
    	 */
    	public enum Element
    	{
    		CONFIGURATION,
    		BLOCKS,
    		ITEMS,
    		EVENTBUS_ORE,
    		EVENTBUS_TERRAIN,
    		EVENTBUS_EVENT,
    		FORGE_DICTIONARY,
    		ENTITY,
    		CRAFTING,
    		MOD_COMPATIBILITY,
    		PREINITIALIZATION,
    		INTITIALIZATION,
    		POSTINITIALIZATION,
    		SERVERABOUTTOSTART,
    		SERVERSTARTING,
    		SERVERSTARTED,
    		SERVERSTOPPING,
    		SERVERSTOPPED,
    		NONSETUP
    	}
    	
    	/**
    	 * The type of the method
    	 */
    	public Element value() default Element.NONSETUP; 
    }
    
    /**
     * This code will only run if the feature is disabled and
     * {@link hasDisabledCompatibility}, and is required
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    public @interface FeatureAlternate
    {
    	//This does not have any other calls or data
    }
    
    /**
     * This is used for marking variables for the populator to populate
     * during setup and beyond if needed. If your stuff is not the correct 
     * type or not public, crashes will result
     */
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    public @interface FeatureData
    {
    	/**
    	 * The Types of data given by the populator
    	 * NONDATA will not be populated
    	 */
    	public enum Data
    	{
    		CONFIGURATION,
    		LOGGER,
    		MODINSTANCE,
    		PREFEATURELIST,
    		FULLFEATURELIST,
    		ALTFEATURELIST,
    		FEATURELIST,
    		ALTERNATE,
    		NONDATA
    	}
    	
    	/**
    	 * The type of the method
    	 */
    	public Data value() default Data.NONDATA;
    }
}

