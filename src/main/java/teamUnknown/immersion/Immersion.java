package teamUnknown.immersion;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import teamUnknown.immersion.core.commands.CommandHandler;
import teamUnknown.immersion.core.feature.FeatureDataCollector;
import teamUnknown.immersion.core.feature.FeatureRepository;
import teamUnknown.immersion.core.meta.ModMetadata;
import teamUnknown.immersion.core.network.message.MessageSocialPacket;
import teamUnknown.immersion.core.proxy.IProxy;
import teamUnknown.immersion.coreFeatures.debug.FeatureDebugging;
import teamUnknown.immersion.coreFeatures.oreGen.FeatureOreGen;
import teamUnknown.immersion.coreFeatures.social.FeatureSocial;
import teamUnknown.immersion.coreFeatures.versionCheck.FeatureVersion;
import teamUnknown.immersion.features.blacksmithFeature.BlacksmithFeature;
import teamUnknown.immersion.features.spawnFeature.FeatureSpawning;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;


@Mod(modid = ModMetadata.MOD_ID, name = ModMetadata.NAME, version = ModMetadata.VERSION)
public class Immersion 
{
	public static Logger log = LogManager.getLogger(ModMetadata.MOD_ID);
	
	@Instance(ModMetadata.MOD_ID)
	public static Immersion instance;
    private final FeatureRepository _featureRepository;

    @SidedProxy(clientSide = ModMetadata.CLIENT_PROXY_CLASS, serverSide = ModMetadata.SERVER_PROXY_CLASS)
    public static IProxy proxy;

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
		ModMetadata.CONF_DIR = event.getModConfigurationDirectory();

		//Put feature register together
        _featureRepository.RegisterFeature(new FeatureDataCollector()); // this need to be first entry, as other features will not work without it
        _featureRepository.RegisterFeature(new FeatureOreGen());
        _featureRepository.RegisterFeature(new FeatureSpawning());
        _featureRepository.RegisterFeature(new FeatureVersion());
        _featureRepository.RegisterFeature(new BlacksmithFeature());
        _featureRepository.RegisterFeature(new FeatureDebugging());
        _featureRepository.RegisterFeature(new FeatureSocial());
        
        //get config to send to features
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

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