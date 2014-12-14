package teamUnknown.immersion.features.electricalAge.thirdParty;

import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaDataAccessor;
import mcp.mobius.waila.api.IWailaDataProvider;
import mcp.mobius.waila.api.SpecialChars;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import teamUnknown.immersion.features.electricalAge.energy.EnergyHelper;
import teamUnknown.immersion.features.electricalAge.energy.IEnergyStorage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WailaHandler implements IWailaDataProvider {

    @Override
    public ItemStack getWailaStack(IWailaDataAccessor accessor, IWailaConfigHandler config){
        return null;
    }

    @Override
    public List<String> getWailaHead(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config){

        return currenttip;
    }

    @Override
    public List<String> getWailaBody(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config){
        addTipToMachine(currenttip, accessor);
        return currenttip;
    }

    public static void addTipToMachine(List<String> currenttip, IWailaDataAccessor accessor){
        //This is used so that we can split values later easier and have them all in the same layout.
        Map<String, String> values = new HashMap<String, String>();

        TileEntity tileEntity = accessor.getTileEntity();

        if(tileEntity instanceof IEnergyStorage) {
            String energyLevel = String.valueOf(EnergyHelper.getStoredEnergy(tileEntity));
            String maxEnergyLevel = String.valueOf(EnergyHelper.getMaxEnergyStored(tileEntity));

            values.put(EnumChatFormatting.GREEN + "Energy Level: ", energyLevel + " / " + maxEnergyLevel);
        }

        //Get all the values from the map and put them in the list.
        for(Map.Entry<String, String> entry : values.entrySet()) {
            currenttip.add(entry.getKey() + ": " + /*SpecialChars.ALIGNRIGHT +*/SpecialChars.WHITE + entry.getValue());
        }
    }

    @Override
    public List<String> getWailaTail(ItemStack itemStack, List<String> currenttip, IWailaDataAccessor accessor, IWailaConfigHandler config) {
        return currenttip;
    }
}
