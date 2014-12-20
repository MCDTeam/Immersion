package teamUnknown.immersion.features.blacksmithFeature;

import teamUnknown.immersion.core.feature.object.FeatureObjectRegister;
import teamUnknown.immersion.features.blacksmithFeature.blocks.BlockFakeAir;
import teamUnknown.immersion.features.blacksmithFeature.blocks.BlockHeatedCoal;

public class ObjectRegister extends FeatureObjectRegister {

	@Override
	public void startRegistry() 
	{
        register(new BlockHeatedCoal());
        register(new BlockFakeAir());
	}

}
