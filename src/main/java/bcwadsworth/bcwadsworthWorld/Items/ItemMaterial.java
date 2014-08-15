package bcwadsworth.bcwadsworthWorld.Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemMaterial extends Item 
{
	public ItemMaterial(String type) 
	{
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMaterials);
		setUnlocalizedName(type);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) 
	{
		itemIcon = register.registerIcon("bcwadsworthWorld:" + this.getUnlocalizedName().substring(5));
	}
}
