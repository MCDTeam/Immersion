package teamUnknown.immersion.features.magic.blocks.tileEntity.render;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import teamUnknown.immersion.features.magic.blocks.tileEntity.TileManaPylon;
import teamUnknown.immersion.features.magic.blocks.tileEntity.TilePlinth;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class RendererPlinth extends TileEntitySpecialRenderer 
{
	private ModelPlinth model = new ModelPlinth();
	
	@Override
	public void renderTileEntityAt(TileEntity tile, double x, double y, double z, float scale) 
	{
		if (Minecraft.getMinecraft().gameSettings.fancyGraphics) 
		{
			TilePlinth convertedtile = (TilePlinth) tile;
			convertedtile.x = convertedtile.x + convertedtile.mx;
			if (convertedtile.x >= 3.1415F) 
			{
				convertedtile.x = -3.1415F;
			}
			convertedtile.y = convertedtile.y + convertedtile.my;
			if (convertedtile.y >= 3.1415F) 
			{
				convertedtile.y = -3.1415F;
			}
			convertedtile.z = convertedtile.z + convertedtile.mz;
			if (convertedtile.z >= 3.1415F) 
			{
				convertedtile.z = -3.1415F;
			}
			model.render(x, y, z, new ResourceLocation("immersion:textures/blocks/model/Plinth.png"), convertedtile.x, convertedtile.y, convertedtile.z);
		}
		else
		{
			model.render(x, y, z, new ResourceLocation("immersion:textures/blocks/model/Plinth.png"), 0F, 0F, 0F);
		}
	}

}
