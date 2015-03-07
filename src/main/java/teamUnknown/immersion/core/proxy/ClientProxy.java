package teamUnknown.immersion.core.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import teamUnknown.immersion.features.electricalAge.blocks.ElectricalBlocks;
import teamUnknown.immersion.features.electricalAge.client.render.item.ItemRenderElectricalWire;
import teamUnknown.immersion.features.electricalAge.client.render.tileEntity.TileEntityRenderElectricalWireBasic;
import teamUnknown.immersion.features.electricalAge.items.ElectricalItems;
import teamUnknown.immersion.features.electricalAge.tileEntitys.TileEntityElectricalWire;

public class ClientProxy extends CommonProxy{

    @SideOnly(Side.CLIENT)
    @Override
    public void registerRendering() {

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectricalWire.class, new TileEntityRenderElectricalWireBasic());

        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ElectricalBlocks.electricalWire), ItemRenderElectricalWire.instance);
    }

    @Override
    public void registerTileEntitys() {

    }
}
