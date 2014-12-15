package teamUnknown.immersion.features.magic;

import java.util.ArrayList;

import net.minecraftforge.common.MinecraftForge;
import teamUnknown.immersion.core.feature.Feature;
import teamUnknown.immersion.core.feature.Feature.FeatureData;
import teamUnknown.immersion.core.feature.Feature.FeatureData.Data;
import teamUnknown.immersion.core.feature.Feature.FeatureElement;
import teamUnknown.immersion.core.feature.Feature.FeatureElement.Element;
import teamUnknown.immersion.core.feature.FeatureCommon;
import teamUnknown.immersion.core.feature.FeatureDataCollector;
import teamUnknown.immersion.core.feature.IFeature;
import teamUnknown.immersion.features.magic.Objects;
import teamUnknown.immersion.features.magicOreGen.FeatureMagicOreGen;

@Feature(name = "Magic", version = "1.0")
public class FeatureMagic extends FeatureCommon 
{
	
	/*@Override
	public IFeature[] setup()
	{
		IFeature[] dep = {FeatureMagicOreGen.instance};
		return dep;
	}*/
	
	@FeatureElement(Element.EVENTBUS_EVENT)
	public void XPRenderer()
	{
		MinecraftForge.EVENT_BUS.register(new GuiXPMagicBar());
	}
	
    @FeatureElement(Element.OBJECT)
    public Objects registerObjects() 
    {
        return new Objects();
    }
}
