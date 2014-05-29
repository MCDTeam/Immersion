package bcwadsworth.devices.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemToolBase extends Item
{
	String type;
	public ItemToolBase(String type) 
	{
		maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("toolBase" + type);
		this.type = type;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) 
	{
		itemIcon = iconRegister.registerIcon("devices:tool"+ type);
	}
}
