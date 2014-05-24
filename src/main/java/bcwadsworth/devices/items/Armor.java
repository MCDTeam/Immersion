package bcwadsworth.devices.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemArmor;

public class Armor extends ItemArmor
{
	public Armor(ArmorMaterial material, int type) 
	{
		super(material, type, 3);
		setUnlocalizedName("armor" + material.name() + type);
	}
	public void registerIcons(IIconRegister iconRegister) 
	{
		itemIcon = iconRegister.registerIcon("devices:" + this.getUnlocalizedName().substring(5));
	}
}
