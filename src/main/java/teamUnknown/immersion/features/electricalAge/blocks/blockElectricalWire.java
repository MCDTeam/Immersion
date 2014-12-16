package teamUnknown.immersion.features.electricalAge.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import teamUnknown.immersion.core.feature.object.ImmersionBlock;
import teamUnknown.immersion.core.meta.BBConstants;
import teamUnknown.immersion.features.electricalAge.energy.update.IEnergyConnection;
import teamUnknown.immersion.features.electricalAge.tileEntitys.TileEntityElectricalWire;

public class blockElectricalWire extends ImmersionBlock implements ITileEntityProvider{

    private float pixel = 1F / 16F;

    public blockElectricalWire(String name) {
        super(name, Material.rock);

        this.setCreativeTab(CreativeTabs.tabBlock);
        this.useNeighborBrightness = true;
        this.setBlockBounds(11 * pixel / 2, 11 * pixel / 2, 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2, 1 - 11 * pixel / 2);

    }

    @Override
    public TileEntity createNewTileEntity(World world, int p_149915_2_) {
        return new TileEntityElectricalWire();
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {

        boolean[] blockBounds = new boolean[6];
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) {
            blockBounds[direction.ordinal()] = world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ) instanceof IEnergyConnection && ((IEnergyConnection) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ)).canConnectEnergy(direction);
        }
        this.setBlockBounds(blockBounds[4] ? 0 : BBConstants.ELECTRICAL_WIRE_MIN_POS, blockBounds[0] ? 0 : BBConstants.ELECTRICAL_WIRE_MIN_POS, blockBounds[2] ? 0 : BBConstants.ELECTRICAL_WIRE_MIN_POS, blockBounds[5] ? 1 : BBConstants.ELECTRICAL_WIRE_MAX_POS, blockBounds[1] ? 1 : BBConstants.ELECTRICAL_WIRE_MAX_POS, blockBounds[3] ? 1 : BBConstants.ELECTRICAL_WIRE_MAX_POS);
    }

    @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {

        int meta = world.getBlockMetadata(x, y, z);
        boolean[] blockBounds = new boolean[6];
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) {

            blockBounds[direction.ordinal()] = world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ) instanceof IEnergyConnection && ((IEnergyConnection) world.getTileEntity(x + direction.offsetX, y + direction.offsetY, z + direction.offsetZ)).canConnectEnergy(direction);
        }
        if (meta == 0)
            return AxisAlignedBB.getBoundingBox(x + (blockBounds[4] ? 0 : BBConstants.ELECTRICAL_WIRE_MIN_POS), y + (blockBounds[0] ? 0 : BBConstants.ELECTRICAL_WIRE_MIN_POS), z + (blockBounds[2] ? 0 : 0.375F), x + (blockBounds[5] ? 1 : BBConstants.ELECTRICAL_WIRE_MAX_POS), y + (blockBounds[1] ? 1 : BBConstants.ELECTRICAL_WIRE_MAX_POS), z + (blockBounds[3] ? 1 : BBConstants.ELECTRICAL_WIRE_MAX_POS));
        return super.getCollisionBoundingBoxFromPool(world, x, y, z);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }
}
