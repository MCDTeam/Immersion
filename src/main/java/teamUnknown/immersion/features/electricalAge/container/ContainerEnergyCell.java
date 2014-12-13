package teamUnknown.immersion.features.electricalAge.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import teamUnknown.immersion.features.electricalAge.tileEntitys.machine.TileEntityCreativeStorage;

public class ContainerEnergyCell extends Container {

    public final EntityPlayer player;
    public final World world;
    public final int x;
    public final int y;
    public final int z;

    public ContainerEnergyCell(EntityPlayer player, World world, int x, int y, int z) {

        this.player = player;
        this.world = world;
        this.x = x;
        this.y = y;
        this.z = z;

    }

    public boolean canInteractWith(EntityPlayer player)
    {
        return true;
    }

    public ItemStack transferStackInSlot(EntityPlayer player, int slotId)
    {
        return null;
    }

}
