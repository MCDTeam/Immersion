package teamUnknown.immersion.features.metallurgyFeature.items;

import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamUnknown.immersion.core.feature.object.ImmersionBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class FuelEnrichedCoal extends ImmersionBlock
{
	@SideOnly(Side.CLIENT)
	protected IIcon texture;

	public FuelEnrichedCoal() {
        super("fuelEnrichedCoal", Material.rock);
        setHardness(2.0F);
        setStepSound(Block.soundTypeStone);
        setCreativeTab(CreativeTabs.tabBlock);
        setHarvestLevel("pickaxe", 1);
        setLightLevel(.5F);
    }
}