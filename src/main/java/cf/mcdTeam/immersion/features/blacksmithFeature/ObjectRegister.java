package cf.mcdTeam.immersion.features.blacksmithFeature;

import cf.mcdTeam.immersion.core.feature.object.FeatureObjectRegister;
import cf.mcdTeam.immersion.features.blacksmithFeature.blocks.BlockFakeAir;
import cf.mcdTeam.immersion.features.blacksmithFeature.blocks.BlockHeatedCoal;

public class ObjectRegister extends FeatureObjectRegister {

	@Override
	public void startRegistry() 
	{
        register(new BlockHeatedCoal());
        register(new BlockFakeAir());
	}

}
