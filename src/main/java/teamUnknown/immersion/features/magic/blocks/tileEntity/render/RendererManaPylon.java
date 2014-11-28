package teamUnknown.immersion.features.magic.blocks.tileEntity.render;

import org.lwjgl.opengl.GL11;

import teamUnknown.immersion.features.magic.blocks.tileEntity.TileManaPylon;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RendererManaPylon extends TileEntitySpecialRenderer 
{
	private ModelManaPylon modelmain = new ModelManaPylon();
	private ModelManaPylonTop modeltop = new ModelManaPylonTop();
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float scale) 
	{
		if (tile.getWorldObj().getTileEntity(tile.xCoord, tile.yCoord + 1, tile.zCoord) instanceof TileManaPylon)
		{
			this.modelmain.render(x, y, z, new ResourceLocation("immersion:textures/blocks/model/ManaPylonDiamond.png"));
		}
		else
		{
			this.modeltop.render(x, y, z, new ResourceLocation("immersion:textures/blocks/model/ManaPylonTopDiamond.png"));
		}
	}

}
