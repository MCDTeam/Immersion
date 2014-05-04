package bcwadsworth.devices.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class MatrixRandom extends Item 
	{
		public MatrixRandom() 
		{
			maxStackSize = 64;
			setCreativeTab(CreativeTabs.tabMisc);
			setUnlocalizedName("matrixRandom");
		}

		@SideOnly(Side.CLIENT)
		public void registerIcons(IIconRegister iconRegister) 
		{
			itemIcon = iconRegister.registerIcon("devices:matrixRandom");
		}
}
