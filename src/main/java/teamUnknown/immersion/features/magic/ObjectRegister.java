package teamUnknown.immersion.features.magic;

import net.minecraft.init.Items;
import teamUnknown.immersion.core.feature.object.FeatureObjectRegister;
import teamUnknown.immersion.core.feature.object.ImmersionBlock;
import teamUnknown.immersion.core.feature.object.ImmersionItem;
import teamUnknown.immersion.features.magic.blocks.ManaPylonBasic;
import teamUnknown.immersion.features.magic.blocks.Plinth;
import teamUnknown.immersion.features.metallurgyFeature.items.ModBlocks;

public class ObjectRegister extends FeatureObjectRegister {

	@Override
	public void startRegistry() 
	{
		register(new ManaPylonBasic());
		register(new ImmersionBlock("blockBrickMagic"));
		register(new Plinth());
	}

}
