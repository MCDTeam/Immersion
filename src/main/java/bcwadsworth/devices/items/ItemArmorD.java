package bcwadsworth.devices.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ItemArmorD extends ItemArmor
{
	public ItemArmorD(ArmorMaterial material, int type) 
	{
		super(material, type, 3);
		setUnlocalizedName("armor" + material.name() + type);
	}
	public void registerIcons(IIconRegister iconRegister) 
	{
		itemIcon = iconRegister.registerIcon("devices:" + this.getUnlocalizedName().substring(5));
	}
}
