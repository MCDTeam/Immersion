package teamUnknown.immersion.features.magic;

import java.util.ArrayList;

import teamUnknown.immersion.core.feature.Feature;
import teamUnknown.immersion.core.feature.Feature.FeatureData;
import teamUnknown.immersion.core.feature.Feature.FeatureData.Data;
import teamUnknown.immersion.core.feature.FeatureCommon;
import teamUnknown.immersion.core.feature.FeatureDataCollector;
import teamUnknown.immersion.core.feature.IFeature;
import teamUnknown.immersion.features.magicOreGen.FeatureMagicOreGen;

@Feature(name = "Magic", version = "1.0")
public class FeatureMagic extends FeatureCommon 
{
	
	@Override
	public IFeature[] setup()
	{
		IFeature[] dep = {FeatureMagicOreGen.instance};
		return dep;
	}
}
