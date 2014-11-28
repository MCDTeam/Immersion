package teamUnknown.immersion.features.magic.blocks.tileEntity.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelPlinth extends ModelBase
{
  //fields
    ModelRenderer Base;
    ModelRenderer Display;
  
  public ModelPlinth()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      Base = new ModelRenderer(this, 0, 12);
      Base.addBox(0F, 0F, 0F, 16, 4, 16);
      Base.setRotationPoint(-8F, 20F, -8F);
      Base.setTextureSize(64, 32);
      Base.mirror = true;
      setRotation(Base, 0F, 0F, 0F);
      Display = new ModelRenderer(this, 0, 0);
      Display.addBox(-3F, -3F, -3F, 6, 6, 6);
      Display.setRotationPoint(0F, 9F, 0F);
      Display.setTextureSize(64, 32);
      Display.mirror = true;
      setRotation(Display, 0F, 0F, 0F);
  }
  
  public void render(double x, double y, double z, ResourceLocation rl, float x2, float y2, float z2)
  {
	  setRotation(Display, x2, y2, z2);
	  GL11.glPushMatrix();
	  Minecraft.getMinecraft().renderEngine.bindTexture(rl);
	  GL11.glTranslatef((float) x + .5F, (float) y + 1.501F, (float) z + .5F);
	  GL11.glRotatef(180, 1, 0, 1);
	  GL11.glPushMatrix();
	  super.render(null, 0.0F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0625F);
	  setRotationAngles(0.0F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0625F, null);
	  Base.render(0.0625F);
	  Display.render(0.0625F);
	  GL11.glPopMatrix();
	  GL11.glPopMatrix();
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
