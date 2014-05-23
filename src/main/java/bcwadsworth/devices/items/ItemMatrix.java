package bcwadsworth.devices.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMatrix extends Item 
{
	public ItemMatrix(String type)
	{
		maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("matrix" + type);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) 
	{
			itemIcon = iconRegister.registerIcon("devices:" + this.getUnlocalizedName().substring(5));
	}
}

