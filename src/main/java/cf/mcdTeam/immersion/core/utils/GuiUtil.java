package cf.mcdTeam.immersion.core.utils;

import net.minecraft.client.renderer.Tessellator;

public class GuiUtil {

    /**
     * A utility method for drawing rectangles of which the full image size
     * doesn't have to be a power of 2 size an doesn't have to be rectangle
     *
     * @param x
     * @param y
     * @param width
     * @param height
     * @param imageWidth
     * @param imageHeight
     * @param u
     * @param v
     */
    public static void drawRectangle(double x, double y, double width, double height, int imageWidth, int imageHeight, double u, double v) {
        Tessellator tessellator = Tessellator.instance;
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(x + 0, y + height, 0, u / imageWidth, height / imageHeight);
        tessellator.addVertexWithUV(x + width, y + height, 0, width / imageWidth, height / imageHeight);
        tessellator.addVertexWithUV(x + width, y + 0, 0, width / imageWidth, v / imageHeight);
        tessellator.addVertexWithUV(x + 0, y + 0, 0, u / imageWidth, v / imageHeight);
        tessellator.draw();
    }

}
