package teamUnknown.immersion.features.electricalAge.api;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

    /**
     * Implement this interface on subclasses of Block to have to have that Block broken by the Quantum Energistics wrench
     */
    public interface IWrenchable {

        /**
         * Called to ensure that the wrench can be used. To get the ItemStack that is used, check player.inventory.getCurrentItem()
         *
         * @param player - The player doing the wrenching
         * @param world  - The world were the action took place
         * @param x,y,z  - The coordinates for the block being wrenched
         * @return true if wrenching is allowed, false if not
         */
        public boolean canWrench(EntityPlayer player, World world, int x, int y, int z);

        /**
         * Called to ensure that the wrench can be used. To get the ItemStack that is used, check player.inventory.getCurrentItem()
         *
         * @param player    - The player doing the wrenching
         * @param itemstack -  The itemStack
         * @param world     - The world were the action took place
         * @param x,y,z     - The coordinates for the block being wrenched
         * @param side      - The side of the block clicked
         * @return true if wrenching is allowed, false if not
         */
        public void onWrenchUsed(EntityPlayer player, Block block, ItemStack itemStack, World world, int x, int y, int z, EnumFacing side);
}
