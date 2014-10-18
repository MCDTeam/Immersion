package teamUnknown.immersion;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import teamUnknown.immersion.core.meta.ModMetadata;
import teamUnknown.immersion.core.repositories.FeatureRepository;
import teamUnknown.immersion.features.oreGenFeature.oreGenFeature;
import teamUnknown.immersion.features.spawnFeature.SpawnFeature;
import teamUnknown.immersion.features.versionCheckerFeature.VersionFeature;


@Mod(modid = ModMetadata.MOD_ID, name = ModMetadata.NAME, version = ModMetadata.VERSION)
public class Immersion 
{
	public static Logger log = LogManager.getLogger(ModMetadata.MOD_ID);
	
	@Instance(ModMetadata.MOD_ID)
	public static Immersion instance;
    private final FeatureRepository _featureRepository;

    public Immersion(){
        this._featureRepository = new FeatureRepository();
        this._featureRepository.RegisterFeature(new SpawnFeature());
        this._featureRepository.RegisterFeature(new oreGenFeature());
        this._featureRepository.RegisterFeature(new VersionFeature());
    }

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{	
		log.info("Pre-Init Version: " + ModMetadata.VERSION);
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

        this._featureRepository.runPreInitialization(config);

		//ModMetadata.configLoad(config);
		//log.debug("Config Loaded");

        config.save();
		log.info("Pre-Init Finished");
	}

	@EventHandler
	public void init(FMLInitializationEvent event) 
	{
		log.info("Init Version: " + ModMetadata.VERSION);

		//OreGeneration generator = new OreGeneration();
	
		//GameRegistry.registerWorldGenerator(generator, 0);
		//log.debug("Ore Generator Loaded");
		
		//MinecraftForge.ORE_GEN_BUS.register(generator);
		//MinecraftForge.EVENT_BUS.register(new OreDropsHelper());
		//log.debug("Event Busses Loaded");
		
		//GameRegistry.registerFuelHandler(new FuelHandler());
		//log.debug("Fuel Handler Loaded");
				
		//this.craftingRegistration();
		//log.debug("Crafting/Smelting Loaded");
		
		//log.info(GameRegistry.getFuelValue(Stack.S(Blocks.coal_block)));

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