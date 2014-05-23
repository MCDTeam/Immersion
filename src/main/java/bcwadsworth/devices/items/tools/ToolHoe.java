package bcwadsworth.devices.items.tools;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item.ToolMaterial;

public class ToolHoe extends ItemHoe 
{
	public ToolHoe(ToolMaterial material) 
	{
		super(material);
		setUnlocalizedName("hoe" + material.name());
	}
	public void registerIcons(IIconRegister iconRegister) 
	{
		itemIcon = iconRegister.registerIcon("devices:" + this.getUnlocalizedName().substring(5));
	}
}
