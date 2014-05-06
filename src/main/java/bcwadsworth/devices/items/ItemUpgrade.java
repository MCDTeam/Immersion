package bcwadsworth.devices.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemUpgrade extends Item 
{
	int tier;
	public ItemUpgrade(String name, int reqtier)
	{
		tier = reqtier;
		maxStackSize = 16;
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
		if (tier == 0)
		{
			itemIcon = iconRegister.registerIcon("devices:" + this.getUnlocalizedName());
		}
		else
		{
			itemIcon = iconRegister.registerIcon("devices:upgradeTeir" + tier);
		}
	}
	
	public void installationEvent(String inventoryID, String inventoryType) 
	{
		
	};

	public void deinstallationEvent(String inventoryID, String inventoryType) 
	{
		
	};

	public void inventoryOpenEvent(String inventoryID, String inventoryType) 
	{
		
	};

	public void inventoryCloseEvent(String inventoryID, String inventoryType) 
	{
		
	};

	public void inventoryTickEvent(String inventoryID, String inventoryType) 
	{
		
	};

	public ItemStack[] getRecipie() 
	{
		return null;
	}

}