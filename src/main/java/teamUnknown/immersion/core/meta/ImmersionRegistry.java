package teamUnknown.immersion.core.meta;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import teamUnknown.immersion.Immersion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ImmersionRegistry {

    // Instance
    public static ImmersionRegistry registry = new ImmersionRegistry();

    private final ArrayList<Block> possibleBlocks;
    private final HashMap<String, Block> activeBlocks;

    private final ArrayList<Item> possibleItems;
    private final HashMap<String, Item> activeItems;

    public ImmersionRegistry(){

        this.possibleBlocks = new ArrayList<Block>();
        this.activeBlocks = new HashMap<String, Block>();

        this.possibleItems = new ArrayList<Item>();
        this.activeItems = new HashMap<String, Item>();
    }

    /**
     * Adds a block to the Immersion Registry
     * @param block
     */
    public void RegisterBlock(Block block){
        this.possibleBlocks.add(block);
    }

    /**
     * Adds a item to the Immersion Registry
     * @param item
     */
    public void RegisterItem(Item item){
        this.possibleItems.add(item);
    }

    private String getUnwrappedUnlocalizedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

    public void init(){

        // Blocks
        Immersion.log.info("Adding blocks to registry...");
        for(Block block : this.possibleBlocks){
            this.activeBlocks.put(block.getLocalizedName(), block);
        }

        RegisterAllBlocks();

        // Items
        Immersion.log.info("Adding items to registry...");
        for(Item item : this.possibleItems){
            this.activeItems.put(getUnwrappedUnlocalizedName(item.getUnlocalizedName()), item);
        }

        RegisterAllItems();
    }

    /**
     * Adds all blocks from the activeBlocks map to the GameRegistry
     */
    private void RegisterAllBlocks(){
        for(Map.Entry<String, Block> entry : this.activeBlocks.entrySet()){
            String name = entry.getKey();
            Block block = entry.getValue();

            GameRegistry.registerBlock(block, name);
        }
        Immersion.log.info("Finished adding blocks to registry");
    }

    /**
     * Adds all items from the activeBlocks map to the GameRegistry
     */
    private void RegisterAllItems(){
        for(Map.Entry<String, Item> entry : this.activeItems.entrySet()){
            String name = entry.getKey();
            Item item = entry.getValue();

            GameRegistry.registerItem(item, name);
        }
        Immersion.log.info("Finished adding items to registry");
    }
}
