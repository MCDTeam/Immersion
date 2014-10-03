package teamUnknown.immersion.features.metallurgyFeature.items;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import teamUnknown.immersion.core.meta.ModMetadata;

public class ItemMaterial extends Item 
{
	public ItemMaterial(String type) 
	{
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName(type);
		
		//External Registration
		GameRegistry.registerItem(this, this.getUnlocalizedName().substring(5));
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) 
	{
		itemIcon = register.registerIcon(ModMetadata.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}
}
