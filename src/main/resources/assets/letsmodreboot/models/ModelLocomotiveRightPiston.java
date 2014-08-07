// Date: 7/25/2014 11:39:21 PM
// Template version 1.1
// Java generated by Techne
// Keep in mind that you still need to fill in some blanks
// - ZeuX






package assets.letsmodreboot.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLocomotiveRightPiston extends ModelBase
{
  //fields
    ModelRenderer RightRodSleeve;
    ModelRenderer RightPistonRod;
  
  public ModelLocomotiveRightPiston()
  {
    textureWidth = 128;
    textureHeight = 128;
    
      RightRodSleeve = new ModelRenderer(this, 28, 58);
      RightRodSleeve.addBox(-1F, -2F, -1F, 2, 3, 2);
      RightRodSleeve.setRotationPoint(-8F, -5F, -9F);
      RightRodSleeve.setTextureSize(64, 32);
      RightRodSleeve.mirror = true;
      setRotation(RightRodSleeve, 0F, 0F, 0F);
      RightPistonRod = new ModelRenderer(this, 36, 58);
      RightPistonRod.addBox(-1F, 0F, -5F, 1, 1, 5);
      RightPistonRod.setRotationPoint(-7F, -6F, -10F);
      RightPistonRod.setTextureSize(64, 32);
      RightPistonRod.mirror = true;
      setRotation(RightPistonRod, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    RightRodSleeve.render(f5);
    RightPistonRod.render(f5);
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
