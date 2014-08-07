package com.hathoward.letsmodreboot.client.renderer.tileentity;

import org.lwjgl.opengl.GL11;

import com.hathoward.letsmodreboot.reference.Textures;

import assets.letsmodreboot.models.ModelLocomotiveCoupleRod;
import assets.letsmodreboot.models.ModelLocomotiveFrame;
import assets.letsmodreboot.models.ModelLocomotiveLeftPiston;
import assets.letsmodreboot.models.ModelLocomotivePushRod;
import assets.letsmodreboot.models.ModelLocomotiveRightPiston;
import assets.letsmodreboot.models.ModelLocomotiveWheel;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityRendererLocomotive extends TileEntitySpecialRenderer
{
	private final ModelLocomotiveFrame modelLocomotiveFrame = new ModelLocomotiveFrame();
	private final ModelLocomotiveWheel modelLocomotiveWheel = new ModelLocomotiveWheel();
	private final ModelLocomotiveRightPiston modelLocomotiveRightPiston = new ModelLocomotiveRightPiston();
	private final ModelLocomotiveLeftPiston modelLocomotiveLeftPiston = new ModelLocomotiveLeftPiston();
	private final ModelLocomotiveCoupleRod modelLocomotiveCoupleRod = new ModelLocomotiveCoupleRod();
	private final ModelLocomotivePushRod modelLocomotivePushRod = new ModelLocomotivePushRod();
	
	private float wa;
	private float speed;
	
	public TileEntityRendererLocomotive()
	{
		wa = 0.1F;
		speed = 5.0F;
	}
	
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float tick)
	{
		
        GL11.glPushMatrix();

        // Scale, Translate, Rotate
        GL11.glScalef(1.0F, 1.0F, 1.0F);
        GL11.glTranslatef((float) x + 0.0F, (float) y + 0.0F, (float) z + 1.0F);
        
        wa += tick*-speed; //<- increase the angel and reset it once it has reached more than 360 degrees so the variable won't flow over
        if (wa <= 360) {
            wa -= 360;
        }
        
        // Bind texture
        this.bindTexture(Textures.Model.LOCOMOTIVE);

        // Render
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glTranslatef(-0.5F, 0.0F, -0.5F);
        this.modelLocomotiveFrame.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, -0.3125F, 0.375F);
        GL11.glRotatef(-wa, 1.0F, 0.0F, 0.0F);
        this.modelLocomotiveWheel.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        
        GL11.glPushMatrix();
        GL11.glTranslatef(-0.4375F, 0.09375F, 0.0F);
        GL11.glRotatef(wa, 1.0F, 0.0F, 0.0F);
        this.modelLocomotiveCoupleRod.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        
        GL11.glPushMatrix();
        GL11.glTranslatef(0.375F, 0.0F, -0.09375F);
        GL11.glRotatef(wa, 1.0F, 0.0F, 0.0F);
        this.modelLocomotiveCoupleRod.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        
        GL11.glPushMatrix();
        GL11.glTranslatef(-0.4375F, 0.09375F, 0.0F);
        GL11.glRotatef(wa, 1.0F, 0.0F, 0.0F);
        float offset = 0.5F;
        float radius = 1.5F;
        float flyrod_length = 15F;
        float degrees_right = (float)Math.toDegrees((-Math.asin(((Math.sin(Math.toRadians(wa + 90.0F)) * radius) + offset) / flyrod_length)));
        GL11.glRotatef(degrees_right, 1.0F, 0.0F, 0.0F);
        this.modelLocomotivePushRod.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        
        GL11.glPushMatrix();
        GL11.glTranslatef(0.5F, 0.0F, -0.09375F);
        GL11.glRotatef(wa, 1.0F, 0.0F, 0.0F);
        float degrees_left = (float)Math.toDegrees((-Math.asin(((Math.sin(Math.toRadians(wa + 180.0F)) * radius) + offset) / flyrod_length)));
        GL11.glRotatef(degrees_left, 1.0F, 0.0F, 0.0F);
        this.modelLocomotivePushRod.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        
        GL11.glPopMatrix();
        
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, -0.3125F, -0.375F);
        GL11.glRotatef(-wa, 1.0F, 0.0F, 0.0F);
        this.modelLocomotiveWheel.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 0.0F, (float)(-(24.067F - Math.acos(Math.toRadians(degrees_left)) * flyrod_length) / 16));
        this.modelLocomotiveRightPiston.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
        
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 0.0F, (float)((24.067F - Math.acos(Math.toRadians(degrees_right)) * flyrod_length) / 16));
        this.modelLocomotiveLeftPiston.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();

        GL11.glPopMatrix();
	}
}