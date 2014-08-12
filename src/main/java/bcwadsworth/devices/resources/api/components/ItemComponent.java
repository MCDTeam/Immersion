package bcwadsworth.devices.resources.api.components;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemComponent extends Item 
{
	int tier;
	public ItemComponent(String name, int reqtier)
	{
		tier = reqtier;
		maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName(name);
	}
	
	public boolean isAllowed (int invUpgradeTier)
	{
		if (tier == 0 && invUpgradeTier > 0) 
		{
			if (invUpgradeTier >= tier) 
			{
				return true;
			}
		}
		else
		{
			return false;
		}
		return false;
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) 
	{
			itemIcon = iconRegister.registerIcon("devices:upgradeTeir" + tier);
	}
}