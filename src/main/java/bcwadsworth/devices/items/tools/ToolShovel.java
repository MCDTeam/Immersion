package bcwadsworth.devices.items.tools;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item.ToolMaterial;

public class ToolShovel extends ItemSpade
 {
	public ToolShovel(ToolMaterial material) {
		super(material);
		setUnlocalizedName("shovel" + material.name());
	}

	public void registerIcons(IIconRegister iconRegister) {
		itemIcon = iconRegister.registerIcon("devices:" + this.getUnlocalizedName().substring(5));
	}
}