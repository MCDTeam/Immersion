package teamUnknown.immersion.features.magic;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiXPMagicBar extends Gui 
{
	private Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void onRenderExperienceBar(RenderGameOverlayEvent event)
	{
		if (event.type == ElementType.EXPERIENCE && !mc.thePlayer.isRidingHorse())
		{
			event.setCanceled(true);
			
			if (this.mc.playerController.gameIsSurvivalOrAdventure())
	        {
				ScaledResolution scaledresolution = new ScaledResolution(this.mc, this.mc.displayWidth, this.mc.displayHeight);
		        int w = scaledresolution.getScaledWidth();
		        int h = scaledresolution.getScaledHeight();
	            this.mc.getTextureManager().bindTexture(new ResourceLocation("immersion:textures/gui/magicbar.png"));
	            int cap = this.mc.thePlayer.xpBarCap();

	            if (cap > 0)
	            {
	                int expl = (int)(this.mc.thePlayer.experience * (float)(183));
	                int x = w / 2 - 92;
	                int y = h - 32 + 3;
	                this.drawTexturedModalRect(x, y, 0, 0, 182, 8);

	                if (expl > 0)
	                {
	                    this.drawTexturedModalRect(x, y, 0, 9, expl, 8);
	                }
	            }
	        }
		}
	}
}
