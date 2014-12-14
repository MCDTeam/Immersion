package teamUnknown.immersion.features.electricalAge.items;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import teamUnknown.immersion.core.meta.Names;
import teamUnknown.immersion.core.utils.ChatHelper;
import teamUnknown.immersion.core.utils.NBTHelper;
import teamUnknown.immersion.features.electricalAge.api.IWrenchable;
import teamUnknown.immersion.features.electricalAge.energy.IEnergyReceiver;
import teamUnknown.immersion.features.electricalAge.energy.IEnergyStorage;
import teamUnknown.immersion.features.electricalAge.energy.ItemEnergyContainer;
import teamUnknown.immersion.features.electricalAge.tileEntitys.TileEntityMachine;

import java.util.List;

public class ItemImmersionWrench extends ItemEnergyContainer{

    public ItemImmersionWrench(String name){
        super(name);

        this.setMaxStackSize(1);
        this.setFull3D();
        this.setNoRepair();
        this.isDamageable();
    }

    private static class WrenchModes {

        public static String BREAK = "break";
        public static String ROTATE = "rotate";
        public static String POWER_READER = "powerReader";
        public static String CHANGELOG = "changelog";
    }

    public static String DEFAULT_WRENCH_MODE = WrenchModes.BREAK;

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

        if (!world.isRemote) {
            checkFirstUse(itemStack, player);
            NBTHelper.setBoolean(itemStack, Names.NBT.ACTIVATED, true);

            if (!player.isSneaking()) {
                wrenchUsed(player, itemStack, world, x, y, z, side);
            } else {
                //player.openGui(Immersion.instance, guiIds.GUI_QUANTUM_WRENCH, world, x, y, z);
            }
        }

        return false;
    }

    public void checkFirstUse(ItemStack itemStack, EntityPlayer player) {
        if (!NBTHelper.getBoolean(itemStack, Names.NBT.ACTIVATED)) {
            if (!wrenchHasAllTags(itemStack)) {
                addRequiredNBT(player, itemStack);
            }
        }
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean p_77624_4_) {

        if (!NBTHelper.getBoolean(itemStack, Names.NBT.ACTIVATED)) {
            list.add(EnumChatFormatting.GRAY + "Right Click in hand to activate");

        } else {

            NBTHelper.setBoolean(itemStack, Names.NBT.ACTIVATED, true); //TODO not getting activated
            /** MODE **/
            list.add("Wrench Mode: " + EnumChatFormatting.BLUE + NBTHelper.getString(itemStack, Names.NBT.WRENCH_MODE).toUpperCase());

            /** CHARGE **/
            /**if (getChargeLevel(itemStack) >= 1000) {
             list.add("Charge Level: " + EnumChatFormatting.BLUE + this.getDamage(itemStack));
             } else if (getChargeLevel(itemStack) <= 999 && getChargeLevel(itemStack) >= 500) {
             list.add("Charge Level: " + EnumChatFormatting.YELLOW + this.getDamage(itemStack));
             } else if (getChargeLevel(itemStack) <= 499) {
             list.add("Charge Level: " + EnumChatFormatting.RED + this.getDamage(itemStack));
             }**/

            /** OWNER **/
            list.add("Owner: " + NBTHelper.getString(itemStack, Names.NBT.OWNER));
        }
    }

    public static void addRequiredNBT(EntityPlayer player, ItemStack itemStack) {

        NBTHelper.setString(itemStack, Names.NBT.WRENCH_MODE, DEFAULT_WRENCH_MODE);
        NBTHelper.setString(itemStack, Names.NBT.OWNER, player.getDisplayName());
        //NBTHelper.setInteger(itemStack, Names.NBT.CHARGE, DEFAULT_CHARGE_LEVEL);
    }

    private boolean wrenchHasAllTags(ItemStack itemStack) {
        if (NBTHelper.hasTag(itemStack, Names.NBT.WRENCH_MODE) && (NBTHelper.hasTag(itemStack, Names.NBT.OWNER) && (NBTHelper.hasTag(itemStack, Names.NBT.CHARGE)))) {
            return true;
        } else {
            return false;
        }
    }

    public static String getWrenchMode(ItemStack itemStack) {
        return NBTHelper.getString(itemStack, Names.NBT.WRENCH_MODE);
    }

    /**@Override
    public void doKeyBindingAction(EntityPlayer player, ItemStack itemStack, Key key) {
        changeWrenchMode(itemStack, player);
    }**/

    public static int getChargeLevel(ItemStack itemStack) {
        return NBTHelper.getInt(itemStack, Names.NBT.CHARGE);
    }

    public static void changeWrenchMode(ItemStack itemStack, EntityPlayer player) {
        if (getWrenchMode(itemStack).equals(WrenchModes.BREAK))
            NBTHelper.setString(itemStack, Names.NBT.WRENCH_MODE, WrenchModes.ROTATE);
        else if (getWrenchMode(itemStack).equals(WrenchModes.ROTATE))
            NBTHelper.setString(itemStack, Names.NBT.WRENCH_MODE, WrenchModes.POWER_READER);
        else if (getWrenchMode(itemStack).equals(WrenchModes.POWER_READER))
            NBTHelper.setString(itemStack, Names.NBT.WRENCH_MODE, WrenchModes.CHANGELOG);

        ChatHelper.sendMessageToPlayer(player, EnumChatFormatting.GRAY + "[Wrench Mode set to: " + EnumChatFormatting.GREEN + getWrenchMode(itemStack) + EnumChatFormatting.GRAY + "]");
    }

    public void wrenchUsed(EntityPlayer player, ItemStack itemStack, World world, int x, int y, int z, int side) {

        if (getWrenchMode(itemStack).equals(WrenchModes.BREAK)) modeBreak(itemStack, player, world, x, y, z, side);
        else if (getWrenchMode(itemStack).equals(WrenchModes.ROTATE)) modeRotate(world, x, y, z);
        else if (getWrenchMode(itemStack).equals(WrenchModes.POWER_READER)) modePowerReader(world, player, x, y, z);
    }

    public static void modeBreak(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side) {

        Block blockLookedAt = world.getBlock(x, y, z);

        if ((blockLookedAt instanceof IWrenchable)) {
            if (((IWrenchable) blockLookedAt).canWrench(player, world, x, y, z)) {
                ((IWrenchable) blockLookedAt).onWrenchUsed(player, blockLookedAt, itemStack, world, x, y, z, side);
            }
        }
    }

    public static void modeRotate(World world, int x, int y, int z) { //TODO
        TileEntity tileEntity = world.getTileEntity(x, y, z);

        if(tileEntity instanceof TileEntityMachine){

            int rotation = ((TileEntityMachine)tileEntity).getRotation();
            rotation++;

        }
    }

    public static void modePowerReader(World world, EntityPlayer player, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(x, y, z);
        if (tileEntity instanceof IEnergyReceiver) {
            //((IEnergy) tileEntity).getEnergyBar().setEnergyLevel(20);
            ChatHelper.sendMessageToPlayer(player, "Energy Level= " + EnumChatFormatting.YELLOW + ((IEnergyStorage) tileEntity).getEnergyStored() + "/" + ((IEnergyStorage) tileEntity).getMaxEnergyStored());
        }
    }
}
