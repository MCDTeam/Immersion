package teamUnknown.immersion.features.magic.blocks.tileEntity.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RendererManaPylonTopBasic extends TileEntitySpecialRenderer 
{
	private ModelManaPylonTop model = new ModelManaPylonTop();
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float scale) 
	{
		this.model.render(x, y, z, new ResourceLocation("immersion:textures/blocks/model/ManaPylonTopDiamond.png"));
	}

}
