package bcwadsworth.devices.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCircuit extends Item 
{
	public ItemCircuit(String name, String itemIcon, int tier) //QuartzGem
	{
		private int tier = tier;
		private String icon = itemIcon
		maxStackSize = 16;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(name);
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) 
	{
		itemIcon = iconRegister.registerIcon(icon);
	}

	public Boolean isOfTier (int askTeir)
	{
		if (askTeir >= tier)
		{
			return true;
		}
	}
}