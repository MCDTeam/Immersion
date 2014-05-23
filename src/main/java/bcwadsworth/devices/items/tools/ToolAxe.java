package bcwadsworth.devices.items.tools;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemAxe;

public class ToolAxe extends ItemAxe 
{
	public ToolAxe(ToolMaterial material) 
	{
		super(material);
		setUnlocalizedName("axe" + material.name());
	}
	public void registerIcons(IIconRegister iconRegister) 
	{
		itemIcon = iconRegister.registerIcon("devices:" + this.getUnlocalizedName().substring(5));
	}
}
