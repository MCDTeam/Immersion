package teamUnknown.immersion.features.magic.blocks.tileEntity.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelManaPylonTop extends ModelBase
{
	  //fields
    ModelRenderer Main;
    ModelRenderer Gem_1;
  
  public ModelManaPylonTop()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Main = new ModelRenderer(this, 0, 0);
      Main.addBox(0F, 0F, 0F, 8, 8, 8);
      Main.setRotationPoint(-4F, 16F, -4F);
      Main.setTextureSize(32, 32);
      Main.mirror = true;
      setRotation(Main, 0F, 0F, 0F);
      Gem_1 = new ModelRenderer(this, 0, 0);
      Gem_1.addBox(0F, 0F, 0F, 2, 6, 2);
      Gem_1.setRotationPoint(-1F, 12F, -1F);
      Gem_1.setTextureSize(32, 32);
      Gem_1.mirror = true;
      setRotation(Gem_1, 0F, 0F, 0F);
  }
  
  public void render(double x, double y, double z, ResourceLocation rl)
  {
	  GL11.glPushMatrix();
	  Minecraft.getMinecraft().renderEngine.bindTexture(rl);
	  GL11.glTranslatef((float) x + .5F, (float) y + 1.501F, (float) z + .5F);
	  GL11.glRotatef(180, 1, 0, 1);
	  GL11.glPushMatrix();
	  super.render(null, 0.0F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0625F);
	  setRotationAngles(0.0F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0625F, null);
	  Main.render(0.0625F);
	  Gem_1.render(0.0625F);
	  GL11.glPopMatrix();
	  GL11.glPopMatrix();
	  GL11.glPushMatrix();
	  GL11.glTranslatef((float) x + .5F, (float) y + 1.5011F, (float) z + .5F);
	  GL11.glRotatef(180, 0, 0, 0);
	  GL11.glPushMatrix();
	  super.render(null, 0.0F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0625F);
	  setRotationAngles(0.0F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0625F, null);
	  Main.render(0.0625F);
	  GL11.glPopMatrix();
	  GL11.glPopMatrix();
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

}
