package teamUnknown.immersion.features.electricalAge.client.render.item;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.opengl.GL11;
import teamUnknown.immersion.core.meta.Textures;
import teamUnknown.immersion.features.electricalAge.model.ModelElectricalWireBasic;

public class ItemRenderElectricalWire implements IItemRenderer{

    public static ItemRenderElectricalWire instance = new ItemRenderElectricalWire();

    @Override
    public boolean handleRenderType(ItemStack itemstack, ItemRenderType type) {
        return true;
    }

    @Override
    public void renderItem(ItemRenderType type, ItemStack itemstack, Object... object) {
        GL11.glPushMatrix();
        GL11.glTranslatef(0.5F, 1.5F, 0.5F);
        GL11.glRotatef(180, 0, 0, 1);

        Minecraft.getMinecraft().getTextureManager().bindTexture(Textures.MODEL_ELECTRICAL_WIRE_BASIC);

        ModelElectricalWireBasic.instance.renderMiddle();
        ModelElectricalWireBasic.instance.renderDown(false);
        ModelElectricalWireBasic.instance.renderUp(false);
        ModelElectricalWireBasic.instance.renderNorth(false);
        ModelElectricalWireBasic.instance.renderSouth(false);
        ModelElectricalWireBasic.instance.renderWest(false);
        ModelElectricalWireBasic.instance.renderEast(false);

        GL11.glPopMatrix();
    }

    @Override
    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack itemstack, ItemRendererHelper helper) {
        return true;
    }
}
