package teamUnknown.immersion.features.magicOreGen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import teamUnknown.immersion.core.feature.object.ImmersionBlock;
import teamUnknown.immersion.coreFeatures.oreGen.BlockOre;
import teamUnknown.immersion.features.metallurgyFeature.items.ModBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



public class BlockGemOre extends BlockOre
{
	@SideOnly(Side.CLIENT)
	protected IIcon texture;
	
	protected Item dropone;
	protected Item droptwo;
	
	public BlockGemOre(String type, Item dropone, Item droptwo) 
	{
		super("Gem" + type, 9.0F, 3);
		this.dropone = dropone;
		this.droptwo = droptwo;
		if (type == "Glow")
		{
			lightValue = 10;
		}
		else if (type == "Red")
		{
			lightValue = 5;
		}
	}

	public Item getItemDropped(int meta, Random random, int fortune)
    {
		if (blockConstructorCalled) 
		{
			switch (fortune) 
			{
			case 0:
				if (random.nextInt(100) >= 33) 
				{

				} 
				else 
				{

				}
				break;
			}
		}
    }
}
