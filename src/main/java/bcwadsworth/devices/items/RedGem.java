package bcwadsworth.devices.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RedGem extends Item 
{
	public RedGem() 
	{
		maxStackSize = 64;
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("redGem");
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister) 
	{
		itemIcon = iconRegister.registerIcon("devices:redGem");
	}
}
