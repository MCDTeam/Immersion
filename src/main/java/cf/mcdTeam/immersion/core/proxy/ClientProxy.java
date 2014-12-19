package cf.mcdTeam.immersion.core.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;
import cf.mcdTeam.immersion.features.electricalAge.blocks.ElectricalBlocks;
import cf.mcdTeam.immersion.features.electricalAge.client.render.item.ItemRenderElectricalWire;
import cf.mcdTeam.immersion.features.electricalAge.client.render.tileEntity.TileEntityRenderElectricalWireBasic;
import cf.mcdTeam.immersion.features.electricalAge.tileEntitys.TileEntityElectricalWire;

public class ClientProxy extends CommonProxy{

    @SideOnly(Side.CLIENT)
    @Override
    public void registerRendering() {

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityElectricalWire.class, new TileEntityRenderElectricalWireBasic());

        MinecraftForgeClient.registerItemRenderer(Item.getItemFromBlock(ElectricalBlocks.electricalBlock), ItemRenderElectricalWire.instance);
    }

    @Override
    public void registerTileEntitys() {

    }
}
