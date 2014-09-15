package bcwadsworth.bcwadsworthWorld.items.tools;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ToolUpgradeable extends Item 
{
	public enum Type
	{
		
	}

	public Type type;
	
	public ToolUpgradeable(Type type) 
	{
		maxStackSize = 1;
		setCreativeTab(CreativeTabs.tabTools);
		this.type = type;
		
		//External Registration
		GameRegistry.registerItem(this, this.getUnlocalizedName().substring(5));
	}

	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) 
	{
		itemIcon = register.registerIcon("bcwadsworthWorld:" + this.getUnlocalizedName().substring(5));
	}
	
	public void getUpgrades(ItemStack stack)
	{
		
	}
	
	public ItemStack addUpgrade(ItemStack stack, Type UpgradeType)
	{
		
	}
	
	public int itemFuelValue()
	{
		return 0;
	}
	
	public ItemStack addItemAsFuel(ItemStack item)
	{
		
	}
	
	public ItemStack removeFuel (int amount)
	{
		
	}
	
	public void getFuel
}
