package cf.mcdTeam.immersion.features.electricalAge.handler;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cf.mcdTeam.immersion.core.meta.GuiIds;
import cf.mcdTeam.immersion.features.electricalAge.client.gui.GuiEnergyCell;
import cf.mcdTeam.immersion.features.electricalAge.container.ContainerEnergyCell;
import cf.mcdTeam.immersion.features.electricalAge.tileEntitys.machine.TileEntityCreativeStorage;

public class ElectricalFeatureGuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tileEntity = world.getTileEntity(x, y, z);
        ItemStack heldItem = player.getHeldItem();

        switch (ID) {

            case GuiIds.GUI_ENERGY_CELL_ID:
                if (tileEntity instanceof TileEntityCreativeStorage) {//TODO
                    return new ContainerEnergyCell(player, world, x, y, z);
                }
                break;
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tileEntity = world.getTileEntity(x, y, z);

        switch (ID) {

            case GuiIds.GUI_ENERGY_CELL_ID:
                if (tileEntity instanceof TileEntityCreativeStorage) {
                    return new GuiEnergyCell(player, world, x, y, z);
                }
                break;
        }
        return null;

    }
}
