package bcwadsworth.devices;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.IFuelHandler;

public class FuelHandler implements IFuelHandler
{
	@Override
	public int getBurnTime (ItemStack fuel)
	{
		Item fuelItem = fuel.getItem();
		if (fuelItem == Item.getItemFromBlock(Devices.fuelEnrichedCoal))
		{
			return 12800;
		}
		else if (fuelItem == Items.paper)
		{
			return 50;
		}
		return 0;
	}
}
