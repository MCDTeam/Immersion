package teamUnknown.immersion.features.electricalAge.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import teamUnknown.immersion.core.meta.GuiIds;
import teamUnknown.immersion.features.electricalAge.client.gui.GuiEnergyCell;
import teamUnknown.immersion.features.electricalAge.container.ContainerEnergyCell;
import teamUnknown.immersion.features.electricalAge.tileEntitys.machine.TileEntityCreativeStorage;

public class ElectricalFeatureGuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));
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

        TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

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
