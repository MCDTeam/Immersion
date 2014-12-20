package teamUnknown.immersion.features.electricalAge.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import teamUnknown.immersion.core.feature.object.ImmersionContainer;
import teamUnknown.immersion.core.utils.BlockUtils;
import teamUnknown.immersion.features.electricalAge.tileEntitys.TileEntityMachine;

public class ImmersionElectricalBlock extends ImmersionContainer {

    public ImmersionElectricalBlock(String name, Material material) {
        super(name, material);
    }

    public String playerOwner;

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityLivingBase, ItemStack itemStack) {
        if (entityLivingBase instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) entityLivingBase;

            if (world.getTileEntity(x, y, z) instanceof TileEntityMachine) {

                this.playerOwner = player.getDisplayName().toString();

                TileEntityMachine tileEntity = (TileEntityMachine) world.getTileEntity(x, y, z);
                //tileEntity.setOwner(this.playerOwner);
            }

            int meta = world.getBlockMetadata(x, y, z);
            if (meta == 0) {
                if(world.getTileEntity(x, y, z) instanceof TileEntityMachine) {
                    TileEntityMachine machine = (TileEntityMachine) world.getTileEntity(x, y, z);

                    //if (machine instanceof IRotatable) {
                    machine.rotation = BlockUtils.determineMetadataBasedOnPlayerOrientation(player);
                    //}
                }
            }
        }
    }

    //@Override
    public boolean canWrench (EntityPlayer player, World world,int x, int y, int z){
        return true;
    }

    public IIcon getIcon(IBlockAccess world, IIcon[] icons, int activationTime, int x, int y, int z, int side) {
        int meta = world.getBlockMetadata(x, y, z);
        if (meta == 0) {
            TileEntityMachine macerator = (TileEntityMachine) world.getTileEntity(x, y, z);

            if (side == macerator.rotation) {

                if (activationTime > 0) {
                    return icons[2];
                } else {
                    return icons[1];
                }
            }
        }
        return icons[0];
    }

    //@Override
    public void onWrenchUsed (EntityPlayer player, Block block, ItemStack itemStack, World world,int x, int y, int z, int side){
        for (int i = 0; i < block.getDrops(world, x, y, z, 0, 0).size(); i++) {
            //Breaks the loop if i == size.
            if (i == block.getDrops(world, x, y, z, 0, 0).size()) {
                break;
            }

            //Spawns the drops into the world.
            world.spawnEntityInWorld(new EntityItem(world, x, y, z, block.getDrops(world, x, y, z, 0, 0).get(i)));
            world.setBlock(x, y, z, Blocks.air);
        }
    }
}
