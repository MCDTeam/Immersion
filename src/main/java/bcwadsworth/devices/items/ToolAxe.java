package bcwadsworth.devices.items;

import net.minecraft.item.ItemAxe;

public class ToolAxe extends ItemAxe 
{
	public ToolAxe(ToolMaterial material) 
	{
		super(material);
		setUnlocalizedName("axe" + material.name());
	}
}
