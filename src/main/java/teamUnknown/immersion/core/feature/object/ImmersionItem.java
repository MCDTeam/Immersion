package teamUnknown.immersion.core.feature.object;

import teamUnknown.immersion.core.meta.ModMetadata;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

public class ImmersionItem extends Item implements IImersionObject
{
	public ImmersionItem (String name)
	{
		this.setUnlocalizedName(name);
	}
	
	@Override
	public void craftingRegistration() 
	{

	}

	@Override
	public void forgeOreDict() 
	{

	}
	
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) 
	{
		itemIcon = register.registerIcon(ModMetadata.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}
}
