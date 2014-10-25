package teamUnknown.immersion;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.*;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import teamUnknown.immersion.core.commands.CommandHandler;
import teamUnknown.immersion.core.feature.FeatureRepository;
import teamUnknown.immersion.core.meta.ModMetadata;
import teamUnknown.immersion.features.spawnFeature.FeatureSpawning;
import teamUnknown.immersion.features.versionCheckerFeature.FeatureVersion;

@Mod(modid = ModMetadata.MOD_ID, name = ModMetadata.NAME, version = ModMetadata.VERSION)
public class Immersion 
{
	public static Logger log = LogManager.getLogger(ModMetadata.MOD_ID);
	
	@Instance(ModMetadata.MOD_ID)
	public static Immersion instance;
    private final FeatureRepository _featureRepository;

    public Immersion()
    {
        this._featureRepository = new FeatureRepository();
    }

    @EventHandler
    public void serverStarting(FMLServerStartingEvent event){

        // Initialize the custom commands
        CommandHandler.initCommands(event);
    }

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{	
		log.info("Pre-Init Version: " + ModMetadata.VERSION);
		
		//Put feature register together
        _featureRepository.RegisterFeature(new FeatureSpawning());
        _featureRepository.RegisterFeature(new FeatureVersion());
        
        //get config to send to features
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		this._featureRepository.runSetup(config);
        this._featureRepository.runPreInitialization(config);
        config.save();
        
		log.info("Pre-Init Finished");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) 
	{
		log.info("Init Version: " + ModMetadata.VERSION);

        this._featureRepository.runInitialization();

        log.info("Init Finished");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		log.info("Post-Init Version: " + ModMetadata.VERSION);
        this._featureRepository.runPostInitialization();
		log.info("Post-Init Finished");
	}

}