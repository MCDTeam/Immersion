package teamUnknown.immersion.coreFeatures.debug.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamUnknown.immersion.coreFeatures.debug.api.IDebuggable;
import teamUnknown.immersion.core.feature.object.ImmersionItem;
import teamUnknown.immersion.core.utils.ChatHelper;

import java.util.List;

public class itemAdminDebug extends ImmersionItem{

    public itemAdminDebug(){
        super("adminDebug");

        this.setMaxStackSize(1);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack itemStack) {
        return true;
    }

    @Override
    public boolean onDroppedByPlayer(ItemStack item, EntityPlayer player) {

        return false;
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(pos.getX(), pos.getZ(), pos.getZ()));
        Block lookedAt = world.getBlockState(new BlockPos(pos.getX(), pos.getZ(), pos.getZ())).getBlock();

        if (!world.isRemote) {
            if (player.capabilities.isCreativeMode) {
                if (tileEntity instanceof IDebuggable) {
                    if (((IDebuggable) tileEntity).isDebuggable()) {
                        ((IDebuggable) tileEntity).getDebugMethod();

                        return true;
                    }

                } else {
                    ChatHelper.sendMessageToPlayer(player, "No recignised debug options for: " + EnumChatFormatting.BLUE + lookedAt.getLocalizedName());
                }
            } else {
                ChatHelper.sendMessageToPlayer(player, "You are not in Creative Mode");
            }
        }

        return false;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        list.add(EnumChatFormatting.GREEN + "[Admin debugging tool]");
        list.add(EnumChatFormatting.RED + "[Destroyed when dropped]");
    }
}
