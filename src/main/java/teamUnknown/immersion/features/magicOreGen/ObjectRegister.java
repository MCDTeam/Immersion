package teamUnknown.immersion.features.magicOreGen;

import net.minecraft.init.Items;
import teamUnknown.immersion.core.feature.object.FeatureObjectRegister;
import teamUnknown.immersion.core.feature.object.ImmersionItem;
import teamUnknown.immersion.features.metallurgyFeature.items.ModBlocks;

public class ObjectRegister extends FeatureObjectRegister {

	@Override
	public void startRegistry() 
	{
	    // Current Gems
	    register(new ImmersionItem("gemEnd"));	    
	    register(new ImmersionItem("gemGlow"));
	    register(new ImmersionItem("gemQuartz"));
	    register(new ImmersionItem("gemRed"));
	    //Implied: Diamond
	    //Implied: Emerald
	    
	    //Imperfect versions of all gems
	    register(new ImmersionItem("gemImperfectDiamond"));
	    register(new ImmersionItem("gemImperfectEmerald"));
	    register(new ImmersionItem("gemImperfectEnd"));
	    //Implied: Redstone
	    //Implied: Glowstone
	    //Implied: NetherQuartz	    
	    
	    //GemOre Blocks
	    register(new BlockGemOre("End", this.readItem("gemEnd")));
	    register(new BlockGemOre("Glow", this.readItem("gemGlow")));
	    register(new BlockGemOre("Quartz", this.readItem("gemQuartz")));
	    register(new BlockGemOre("Red", this.readItem("gemRed")));
	    register(new BlockGemOre("Diamond", Items.diamond));
	    register(new BlockGemOre("Emerald", Items.emerald));
	}

}
