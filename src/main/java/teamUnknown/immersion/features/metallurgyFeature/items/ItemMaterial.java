package teamUnknown.immersion.features.metallurgyFeature.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import teamUnknown.immersion.core.feature.object.ImmersionItem;
import teamUnknown.immersion.core.meta.ModMetadata;

public class ItemMaterial extends ImmersionItem 
{
	public ItemMaterial(String type) 
	{
		super(type);
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
