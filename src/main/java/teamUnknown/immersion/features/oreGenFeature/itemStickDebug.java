package teamUnknown.immersion.features.oreGenFeature;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class itemStickDebug extends Item {

    public itemStickDebug(){
        super();

        this.setCreativeTab(CreativeTabs.tabMisc);
        this.setUnlocalizedName("worldGenDebug");

    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {

        if(player.isSneaking()){
            for(int x1 = 0; x1 <= 100; x1++){
                for(int z1 = 0; z1 <= 100; z1++){
                    for(int y1 = 0; y1 <= 50; y1++){
                        if((world.getBlock(x + x1, y + y1, z + z1).equals(Blocks.dirt)) || (world.getBlock(x + x1, y + y1, z + z1).equals(Blocks.stone))){
                            world.setBlock(x + x1, y - y1, z + z1, Blocks.air);
                        }
                    }
                }
            }
        }

        return false;
    }
}
