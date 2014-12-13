package teamUnknown.immersion.features.electricalAge.client.render.tileEntity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import org.lwjgl.opengl.GL11;
import teamUnknown.immersion.core.meta.Textures;
import teamUnknown.immersion.features.electricalAge.energy.IEnergy;
import teamUnknown.immersion.features.electricalAge.model.ModelElectricalWireBasic;
import teamUnknown.immersion.features.electricalAge.tileEntitys.TileEntityElectricalWire;

public class TileEntityRenderElectricalWireBasic extends TileEntitySpecialRenderer {

    public static TileEntityRenderElectricalWireBasic instance = new TileEntityRenderElectricalWireBasic();

    public void renderTileEntityAt(TileEntity tileentity, double xOffset, double yOffset, double zOffset, float partialTickTime) {

        boolean[] sides = new boolean[6];
        boolean[] cables = new boolean[6];
        for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) {
            sides[direction.ordinal()] = tileentity.getWorldObj().getTileEntity(tileentity.xCoord + direction.offsetX, tileentity.yCoord + direction.offsetY, tileentity.zCoord + direction.offsetZ) instanceof IEnergy && ((IEnergy) tileentity.getWorldObj().getTileEntity(tileentity.xCoord + direction.offsetX, tileentity.yCoord + direction.offsetY, tileentity.zCoord + direction.offsetZ)).canConnect(direction);
            cables[direction.ordinal()] = tileentity.getWorldObj().getTileEntity(tileentity.xCoord + direction.offsetX, tileentity.yCoord + direction.offsetY, tileentity.zCoord + direction.offsetZ) instanceof IEnergy && !(((IEnergy) tileentity.getWorldObj().getTileEntity(tileentity.xCoord + direction.offsetX, tileentity.yCoord + direction.offsetY, tileentity.zCoord + direction.offsetZ)) instanceof TileEntityElectricalWire);
        }

        GL11.glPushMatrix();
        GL11.glTranslatef((float) (xOffset + 0.5F), (float) (yOffset + 1.5F), (float) (zOffset + 0.5F));
        GL11.glRotatef(180, 0, 0, 1);

        Minecraft.getMinecraft().getTextureManager().bindTexture(Textures.MODEL_ELECTRICAL_WIRE_BASIC);
        
        ModelElectricalWireBasic.instance.renderMiddle();
        if (sides[0]) ModelElectricalWireBasic.instance.renderDown(cables[0]);
        if (sides[1]) ModelElectricalWireBasic.instance.renderUp(cables[1]);
        if (sides[2]) ModelElectricalWireBasic.instance.renderNorth(cables[2]);
        if (sides[3]) ModelElectricalWireBasic.instance.renderSouth(cables[3]);
        if (sides[4]) ModelElectricalWireBasic.instance.renderWest(cables[4]);
        if (sides[5]) ModelElectricalWireBasic.instance.renderEast(cables[5]);

        GL11.glPopMatrix();
    }
}
