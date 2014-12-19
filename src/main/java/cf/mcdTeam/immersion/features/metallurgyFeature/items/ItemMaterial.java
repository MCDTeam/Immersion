package cf.mcdTeam.immersion.features.metallurgyFeature.items;

import net.minecraft.creativetab.CreativeTabs;
import cf.mcdTeam.immersion.core.feature.object.ImmersionItem;

public class ItemMaterial extends ImmersionItem 
{
	public ItemMaterial(String type) 
	{
		super(type);
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
