package tsuteto.tofu.entity;

import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderZundaArrow extends Render
{
    private static final ResourceLocation texture = new ResourceLocation("tofucraft", "textures/entity/zundaarrow.png");

    public void renderZundaArrow(EntityZundaArrow par1EntityArrow, double par2, double par4, double par6, float par8, float par9)
    {
        this.bindEntityTexture(par1EntityArrow);
        GL11.glPushMatrix();
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glRotatef(par1EntityArrow.prevRotationYaw + (par1EntityArrow.rotationYaw - par1EntityArrow.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(par1EntityArrow.prevRotationPitch + (par1EntityArrow.rotationPitch - par1EntityArrow.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F);
        Tessellator var10 = Tessellator.instance;
        byte var11 = 0;
        float var12 = 0.0F;
        float var13 = 0.5F;
        float var14 = (0 + var11 * 10) / 32.0F;
        float var15 = (5 + var11 * 10) / 32.0F;
        float var16 = 0.0F;
        float var17 = 0.15625F;
        float var18 = (5 + var11 * 10) / 32.0F;
        float var19 = (10 + var11 * 10) / 32.0F;
        float var20 = 0.05625F;
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        float var21 = par1EntityArrow.arrowShake - par9;

        if (var21 > 0.0F)
        {
            float var22 = -MathHelper.sin(var21 * 3.0F) * var21;
            GL11.glRotatef(var22, 0.0F, 0.0F, 1.0F);
        }

        GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(var20, var20, var20);
        GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
        GL11.glNormal3f(var20, 0.0F, 0.0F);
        var10.startDrawingQuads();
        var10.addVertexWithUV(-7.0D, -2.0D, -2.0D, var16, var18);
        var10.addVertexWithUV(-7.0D, -2.0D, 2.0D, var17, var18);
        var10.addVertexWithUV(-7.0D, 2.0D, 2.0D, var17, var19);
        var10.addVertexWithUV(-7.0D, 2.0D, -2.0D, var16, var19);
        var10.draw();
        GL11.glNormal3f(-var20, 0.0F, 0.0F);
        var10.startDrawingQuads();
        var10.addVertexWithUV(-7.0D, 2.0D, -2.0D, var16, var18);
        var10.addVertexWithUV(-7.0D, 2.0D, 2.0D, var17, var18);
        var10.addVertexWithUV(-7.0D, -2.0D, 2.0D, var17, var19);
        var10.addVertexWithUV(-7.0D, -2.0D, -2.0D, var16, var19);
        var10.draw();

        for (int var23 = 0; var23 < 4; ++var23)
        {
            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glNormal3f(0.0F, 0.0F, var20);
            var10.startDrawingQuads();
            var10.addVertexWithUV(-8.0D, -2.0D, 0.0D, var12, var14);
            var10.addVertexWithUV(8.0D, -2.0D, 0.0D, var13, var14);
            var10.addVertexWithUV(8.0D, 2.0D, 0.0D, var13, var15);
            var10.addVertexWithUV(-8.0D, 2.0D, 0.0D, var12, var15);
            var10.draw();
        }

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function register does the actual work. In all probabilty, the class Render is generic
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    @Override
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.renderZundaArrow((EntityZundaArrow)par1Entity, par2, par4, par6, par8, par9);
    }

    @Override
    protected ResourceLocation getEntityTexture(Entity entity)
    {
        return texture;
    }
}
