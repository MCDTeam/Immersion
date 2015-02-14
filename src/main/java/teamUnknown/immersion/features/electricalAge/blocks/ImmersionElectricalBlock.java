package teamUnknown.immersion.features.electricalAge.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import teamUnknown.immersion.core.feature.object.ImmersionContainer;
import teamUnknown.immersion.core.utils.BlockUtils;
import teamUnknown.immersion.features.electricalAge.tileEntitys.TileEntityMachine;

public class ImmersionElectricalBlock extends ImmersionContainer {//TODO

    public static final PropertyDirection FACING = PropertyDirection.create("facing");

    public ImmersionElectricalBlock(String name, Material material) {
        super(name, material);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
    }

    public String playerOwner;

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        if (entityLivingBase instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entityLivingBase;

            if (world.getTileEntity(pos) instanceof TileEntityMachine) {


                this.playerOwner = player.getDisplayName().toString();

                TileEntityMachine tileEntity = (TileEntityMachine) world.getTileEntity(pos);
                //tileEntity.setOwner(this.playerOwner);
            }

            world.setBlockState(pos, state.withProperty(FACING, getFacingFromEntity(world, pos, entityLivingBase)), 2);
        }
    }

    public static EnumFacing getFacingFromEntity(World worldIn, BlockPos clickedBlock, EntityLivingBase entityIn) {

        if (MathHelper.abs((float) entityIn.posX - (float) clickedBlock.getX()) < 2.0F && MathHelper.abs((float) entityIn.posZ - (float) clickedBlock.getZ()) < 2.0F) {
            double d0 = entityIn.posY + (double) entityIn.getEyeHeight();

            if (d0 - (double) clickedBlock.getY() > 2.0D) {
                return EnumFacing.UP;
            }

            if ((double) clickedBlock.getY() - d0 > 0.0D) {
                return EnumFacing.DOWN;
            }
        }

        return entityIn.getHorizontalFacing().getOpposite();
    }

    //@Override
    public boolean canWrench(EntityPlayer player, World world, int x, int y, int z) {
        return true;
    }

    /*public IIcon getIcon(IBlockAccess world, IIcon[] icons, int activationTime, int x, int y, int z, int side) {
        int meta = world.getBlockMetadata(x, y, z);
        if (meta == 0) {
            TileEntityMachine macerator = (TileEntityMachine) world.getTileEntity(new BlockPos(x, y, z));

            if (side == macerator.rotation) {

                if (activationTime > 0) {
                    return icons[2];
                } else {
                    return icons[1];
                }
            }
        }
        return icons[0];
    }*/

    //@Override
    /*public void onWrenchUsed(EntityPlayer player, Block block, ItemStack itemStack, IBlockAccess world, BlockPos pos, IBlockState state) {
        for(int i = 0; i < block.getDrops(world, pos, state, 0).size(); i++){

            //Breaks the loop if i == size.
            for(int i = 0; i < block.getDrops(world, pos, state, 0).size(); i++){
                break;
            }

            //Spawns the drops into the world.
            world.spawnEntityInWorld(new EntityItem(world, x, y, z, block.getDrops(world, x, y, z, 0, 0).get(i)));
            world.setBlock(x, y, z, Blocks.air);
        }
    }*/
}
