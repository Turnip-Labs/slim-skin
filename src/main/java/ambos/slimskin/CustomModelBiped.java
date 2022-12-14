package ambos.slimskin;

import net.minecraft.src.MathHelper;
import net.minecraft.src.ModelBiped;
import net.minecraft.src.ModelRenderer;

public class CustomModelBiped extends ModelBiped {
    public final CustomModelRenderer bipedLeftLeg;
    public final CustomModelRenderer bipedRightLeg;
    public final CustomModelSlimArms bipedLeftArm;
    public final CustomModelSlimArms bipedRightArm;
    public final CustomModelRenderer bipedBody;
    public final CustomModelRenderer bipedHead;
    public final CustomModelRenderer bipedEars;
    public final CustomModelRenderer bipedHeadwear;
    public final CustomModelRenderer bipedCloak;
    public final CustomModelSlimArms bipedLeftArmwear;
    public final CustomModelSlimArms bipedRightArmwear;
    public final CustomModelRenderer bipedLeftLegwear;
    public final CustomModelRenderer bipedRightLegwear;
    public final CustomModelRenderer bipedBodyWear;
    public boolean isSneak = false;
    public float scale;

    public CustomModelBiped (float scale, float f) {
        this.scale = scale;
        this.bipedCloak = new CustomModelRenderer(0, 0);
        this.bipedCloak.addBox(-5.0F, 0.0F, -1.0F, 10, 16, 1, scale, 64, 64);

        this.bipedEars = new CustomModelRenderer(0, 0);
        this.bipedEars.addBox(-3.0F, -6.0F, -1.0F, 6, 6, 1, scale, 14, 7);

        this.bipedHead = new CustomModelRenderer(0, 0);
        this.bipedHead.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, scale, 64, 64);
        this.bipedHead.setRotationPoint(0.0F, 0.0F + f, 0.0F);
        this.bipedHeadwear = new CustomModelRenderer(32, 0);
        this.bipedHeadwear.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, scale + 0.5F, 64, 64);
        this.bipedHeadwear.setRotationPoint(0.0F, 0.0F + f, 0.0F);

        this.bipedBody = new CustomModelRenderer(16, 16);
        this.bipedBody.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scale, 64, 64);
        this.bipedBody.setRotationPoint(0.0F, 0.0F + f, 0.0F);
        this.bipedRightArm = new CustomModelSlimArms(40, 16, scale, f, false);
        this.bipedLeftArm = new CustomModelSlimArms(32, 48, scale, f, false);
        this.bipedLeftArm.mirror = true;
        this.bipedRightLeg = new CustomModelRenderer(0, 16);
        this.bipedRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, scale, 64, 64);
        this.bipedRightLeg.setRotationPoint(-2.0F, 12.0F + f, 0.0F);
        this.bipedLeftLeg = new CustomModelRenderer(0, 16);
        this.bipedLeftLeg.mirror = true;
        this.bipedLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, scale, 64, 64);
        this.bipedLeftLeg.setRotationPoint(2.0F, 12.0F + f, 0.0F);

        this.bipedLeftArmwear = new CustomModelSlimArms(48, 48, scale, f, true);
        this.bipedRightArmwear = new CustomModelSlimArms(40, 32, scale, f, true);
        this.bipedRightArmwear.mirror = true;
        this.bipedLeftLegwear = new CustomModelRenderer(0, 48);
        this.bipedLeftLegwear.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, scale + 0.25F, 64, 64);
        this.bipedLeftLegwear.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.bipedRightLegwear = new CustomModelRenderer(0, 32);
        this.bipedRightLegwear.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, scale + 0.25F, 64, 64);
        this.bipedRightLegwear.setRotationPoint(-1.9F, 12.0F, 0.0F);

        this.bipedBodyWear = new CustomModelRenderer(16, 32);
        this.bipedBodyWear.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, scale + 0.25F, 64, 64);
        this.bipedBodyWear.setRotationPoint(0.0F, 0.0F, 0.0F);
    }

    public void render(float var1, float var2, float var3, float var4, float var5, float scale) {
        this.setRotationAngles(var1, var2, var3, var4, var5, scale);
        this.bipedHead.render(scale);
        this.bipedBody.render(scale);

        this.bipedLeftArm.render(scale);
        this.bipedRightArm.render(scale);
        this.bipedLeftArmwear.render(scale);
        this.bipedRightArmwear.render(scale);

        this.bipedRightLeg.render(scale);
        this.bipedLeftLeg.render(scale);
        this.bipedLeftLegwear.render(scale);
        this.bipedRightLegwear.render(scale);
        this.bipedBodyWear.render(scale);

        copyModelAngles(bipedHead, bipedHeadwear);
        this.bipedHeadwear.render(scale);
    }

    public void setSlim(boolean isSlim) {
        this.bipedLeftArm.setSlim(isSlim);
        this.bipedRightArm.setSlim(isSlim);
        this.bipedLeftArmwear.setSlim(isSlim);
        this.bipedRightArmwear.setSlim(isSlim);
    }

    public void copyModelAngles(CustomModelSlimArms source, CustomModelSlimArms dest) {
        dest.rotateAngleX = source.rotateAngleX;
        dest.rotateAngleY = source.rotateAngleY;
        dest.rotateAngleZ = source.rotateAngleZ;
        dest.rotationPointX = source.rotationPointX;
        dest.rotationPointY = source.rotationPointY;
        dest.rotationPointZ = source.rotationPointZ;
    }
    public void copyModelAngles(ModelRenderer source, CustomModelRenderer dest) {
        dest.rotateAngleX = source.rotateAngleX;
        dest.rotateAngleY = source.rotateAngleY;
        dest.rotateAngleZ = source.rotateAngleZ;
        dest.rotationPointX = source.rotationPointX;
        dest.rotationPointY = source.rotationPointY;
        dest.rotationPointZ = source.rotationPointZ;
    }

    public void setRotationAngles(float var1, float var2, float var3, float var4, float var5, float var6) {
        this.bipedHead.rotateAngleY = var4 / 57.295776F;
        this.bipedHead.rotateAngleX = var5 / 57.295776F;
        this.bipedHeadwear.rotateAngleY = this.bipedHead.rotateAngleY;
        this.bipedHeadwear.rotateAngleX = this.bipedHead.rotateAngleX;
        this.bipedRightArm.rotateAngleX = MathHelper.cos(var1 * 0.6662F + 3.1415927F) * 2.0F * var2 * 0.5F;
        this.bipedLeftArm.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 2.0F * var2 * 0.5F;
        this.bipedRightArm.rotateAngleZ = 0.0F;
        this.bipedLeftArm.rotateAngleZ = 0.0F;
        this.bipedRightLeg.rotateAngleX = MathHelper.cos(var1 * 0.6662F) * 1.4F * var2;
        this.bipedLeftLeg.rotateAngleX = MathHelper.cos(var1 * 0.6662F + 3.1415927F) * 1.4F * var2;
        this.bipedRightLeg.rotateAngleY = 0.0F;
        this.bipedLeftLeg.rotateAngleY = 0.0F;
        if (this.isRiding) {
            this.bipedRightArm.rotateAngleX += -0.62831855F;
            this.bipedLeftArm.rotateAngleX += -0.62831855F;
            this.bipedRightLeg.rotateAngleX = -1.2566371F;
            this.bipedLeftLeg.rotateAngleX = -1.2566371F;
            this.bipedRightLeg.rotateAngleY = 0.31415927F;
            this.bipedLeftLeg.rotateAngleY = -0.31415927F;
        }

        if (this.field_1279_h) {
            this.bipedLeftArm.rotateAngleX = this.bipedLeftArm.rotateAngleX * 0.5F - 0.31415927F;
        }

        if (this.field_1278_i) {
            this.bipedRightArm.rotateAngleX = this.bipedRightArm.rotateAngleX * 0.5F - 0.31415927F;
        }

        this.bipedRightArm.rotateAngleY = 0.0F;
        this.bipedLeftArm.rotateAngleY = 0.0F;
        if (this.onGround > -9990.0F) {
            float var7 = this.onGround;
            this.bipedBody.rotateAngleY = MathHelper.sin(MathHelper.sqrt_float(var7) * 3.1415927F * 2.0F) * 0.2F;
            this.bipedRightArm.rotationPointZ = MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
            this.bipedRightArm.rotationPointX = -MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
            this.bipedLeftArm.rotationPointZ = -MathHelper.sin(this.bipedBody.rotateAngleY) * 5.0F;
            this.bipedLeftArm.rotationPointX = MathHelper.cos(this.bipedBody.rotateAngleY) * 5.0F;
            this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY;
            this.bipedLeftArm.rotateAngleY += this.bipedBody.rotateAngleY;
            this.bipedLeftArm.rotateAngleX += this.bipedBody.rotateAngleY;
            var7 = 1.0F - this.onGround;
            var7 *= var7;
            var7 *= var7;
            var7 = 1.0F - var7;
            float var8 = MathHelper.sin(var7 * 3.1415927F);
            float var9 = MathHelper.sin(this.onGround * 3.1415927F) * -(this.bipedHead.rotateAngleX - 0.7F) * 0.75F;
            this.bipedRightArm.rotateAngleX = (float)((double)this.bipedRightArm.rotateAngleX - ((double)var8 * 1.2D + (double)var9));
            this.bipedRightArm.rotateAngleY += this.bipedBody.rotateAngleY * 2.0F;
            this.bipedRightArm.rotateAngleZ = MathHelper.sin(this.onGround * 3.1415927F) * -0.4F;
        }

        if (this.isSneak)
        {
            this.bipedBody.rotateAngleX = 0.5F;
            this.bipedRightArm.rotateAngleX += 0.4F;
            this.bipedLeftArm.rotateAngleX += 0.4F;
            this.bipedRightLeg.rotationPointZ = 4.0F;
            this.bipedLeftLeg.rotationPointZ = 4.0F;
            this.bipedRightLeg.rotationPointY = 9.0F;
            this.bipedLeftLeg.rotationPointY = 9.0F;
            this.bipedHead.rotationPointY = 1.0F;
        }
        else
        {
            this.bipedBody.rotateAngleX = 0.0F;
            this.bipedRightLeg.rotationPointZ = 0.1F;
            this.bipedLeftLeg.rotationPointZ = 0.1F;
            this.bipedRightLeg.rotationPointY = 12.0F;
            this.bipedLeftLeg.rotationPointY = 12.0F;
            this.bipedHead.rotationPointY = 0.0F;
        }

        this.bipedRightArm.rotateAngleZ += MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.bipedLeftArm.rotateAngleZ -= MathHelper.cos(var3 * 0.09F) * 0.05F + 0.05F;
        this.bipedRightArm.rotateAngleX += MathHelper.sin(var3 * 0.067F) * 0.05F;
        this.bipedLeftArm.rotateAngleX -= MathHelper.sin(var3 * 0.067F) * 0.05F;

        copyModelAngles(this.bipedLeftLeg, this.bipedLeftLegwear);
        copyModelAngles(this.bipedRightLeg, this.bipedRightLegwear);
        copyModelAngles(this.bipedLeftArm, this.bipedLeftArmwear);
        copyModelAngles(this.bipedRightArm, this.bipedRightArmwear);
        copyModelAngles(this.bipedBody, this.bipedBodyWear);
    }

    public void renderEars(float var1) {
        this.bipedEars.rotateAngleY = this.bipedHead.rotateAngleY;
        this.bipedEars.rotateAngleX = this.bipedHead.rotateAngleX;
        this.bipedEars.rotationPointX = 0.0F;
        this.bipedEars.rotationPointY = 0.0F;
        this.bipedEars.render(var1);
    }

    public void renderCloak(float var1) {
        this.bipedCloak.render(var1);
    }
}