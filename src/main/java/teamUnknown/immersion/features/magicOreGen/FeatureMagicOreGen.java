package teamUnknown.immersion.features.magicOreGen;

import teamUnknown.immersion.core.feature.Feature;
import teamUnknown.immersion.core.feature.FeatureCommon;
import teamUnknown.immersion.core.feature.Feature.FeatureElement.Element;

@Feature(name = "Magic Ore Gen", version = "1.0")
public class FeatureMagicOreGen extends FeatureCommon
{
	public static FeatureMagicOreGen instance;
	
	public FeatureMagicOreGen()
	{
		instance = this;
	}
}
