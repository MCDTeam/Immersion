package teamUnknown.immersion.features.magic.blocks.tileEntity.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelManaPylon extends ModelBase
{
  //fields
    ModelRenderer Main;
    ModelRenderer Gem_1;
    ModelRenderer Gem_2;
    ModelRenderer Gem_3;
    ModelRenderer Gem_4;
  
  public ModelManaPylon()
  {
    textureWidth = 32;
    textureHeight = 32;
    
      Main = new ModelRenderer(this, 0, 0);
      Main.addBox(0F, 0F, 0F, 8, 16, 8);
      Main.setRotationPoint(-4F, 8F, -4F);
      Main.setTextureSize(32, 32);
      Main.mirror = true;
      setRotation(Main, 0F, 0F, 0F);
      Gem_1 = new ModelRenderer(this, 0, 0);
      Gem_1.addBox(0F, 0F, 0F, 2, 2, 2);
      Gem_1.setRotationPoint(-5F, 15F, -1F);
      Gem_1.setTextureSize(32, 32);
      Gem_1.mirror = true;
      setRotation(Gem_1, 0F, 0F, 0F);
      Gem_2 = new ModelRenderer(this, 0, 0);
      Gem_2.addBox(0F, 0F, 0F, 2, 2, 2);
      Gem_2.setRotationPoint(-1F, 15F, -5F);
      Gem_2.setTextureSize(32, 32);
      Gem_2.mirror = true;
      setRotation(Gem_2, 0F, 0F, 0F);
      Gem_3 = new ModelRenderer(this, 0, 0);
      Gem_3.addBox(0F, 0F, 0F, 2, 2, 2);
      Gem_3.setRotationPoint(3F, 15F, -1F);
      Gem_3.setTextureSize(32, 32);
      Gem_3.mirror = true;
      setRotation(Gem_3, 0F, 0F, 0F);
      Gem_4 = new ModelRenderer(this, 0, 0);
      Gem_4.addBox(0F, 0F, 0F, 2, 2, 2);
      Gem_4.setRotationPoint(-1F, 15F, 3F);
      Gem_4.setTextureSize(32, 32);
      Gem_4.mirror = true;
      setRotation(Gem_4, 0F, 0F, 0F);
  }
  
  public void render(double x, double y, double z, ResourceLocation rl)
  {
	  GL11.glPushMatrix();
	  Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("immersion:textures/blocks/model/ManaPylonBasic.png"));
	  GL11.glTranslatef((float) x + .5F, (float) y + 1.501F, (float) z + .5F);
	  GL11.glRotatef(180, 1, 0, 1);
	  GL11.glPushMatrix();
	  super.render(null, 0.0F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0625F);
	  setRotationAngles(0.0F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0625F, null);
	  Main.render(0.0625F);
	  Gem_1.render(0.0625F);
	  Gem_2.render(0.0625F);
	  Gem_3.render(0.0625F);
	  Gem_4.render(0.0625F);
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
