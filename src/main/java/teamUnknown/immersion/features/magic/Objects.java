package teamUnknown.immersion.features.magic;

import net.minecraft.init.Items;
import teamUnknown.immersion.core.feature.object.FeatureObjectRegister;
import teamUnknown.immersion.core.feature.object.ImmersionBlock;
import teamUnknown.immersion.core.feature.object.ImmersionItem;
import teamUnknown.immersion.features.magic.blocks.ManaPylonBasic;
import teamUnknown.immersion.features.magic.blocks.Plinth;
import teamUnknown.immersion.features.metallurgyFeature.items.ModBlocks;

public class Objects extends FeatureObjectRegister 
{
	public static Objects INSTANCE = new Objects();
	@Override
	public void startRegistry() 
	{
		register(((ImmersionBlock) new ManaPylonBasic().setBlockTextureName("glass")).get());
		register(new ImmersionBlock("blockBrickMagic"));
		register(new Plinth());
	}

}
