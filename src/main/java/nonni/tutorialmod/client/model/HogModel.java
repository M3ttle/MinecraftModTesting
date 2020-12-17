package nonni.tutorialmod.client.model;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import nonni.tutorialmod.entities.HogEntity;

public class HogModel<T extends HogEntity> extends EntityModel<T> {

    private final ModelRenderer left_foot;
    private final ModelRenderer right_toe2;
    private final ModelRenderer left_toe2;
    private final ModelRenderer right_foot;
    private final ModelRenderer right_toe;
    private final ModelRenderer left_toe;
    private final ModelRenderer body;
    private final ModelRenderer left_arm;
    private final ModelRenderer right_arm;
    private final ModelRenderer head;
    private final ModelRenderer left_thigh;
    private final ModelRenderer right_thigh;

    public HogModel() {
        textureWidth = 64;
        textureHeight = 32;

        left_foot = new ModelRenderer(this);
        left_foot.setRotationPoint(-3.0F, 17.5F, 6.2F);
        left_foot.setTextureOffset(26, 24).addBox(-1.0F, 3.5F, -3.7F, 2.0F, 1.0F, 7.0F, 0.0F, false);

        right_toe2 = new ModelRenderer(this);
        right_toe2.setRotationPoint(6.0F, 4.0F, -0.2F);
        left_foot.addChild(right_toe2);
        setRotationAngle(right_toe2, 0.0F, -0.829F, 0.0F);
        right_toe2.setTextureOffset(52, 20).addBox(-5.0535F, -0.5F, 0.9237F, 2.0F, 1.0F, 4.0F, 0.0F, false);

        left_toe2 = new ModelRenderer(this);
        left_toe2.setRotationPoint(6.0F, 4.0F, -0.2F);
        left_foot.addChild(left_toe2);
        setRotationAngle(left_toe2, 0.0F, 0.7418F, 0.0F);
        left_toe2.setTextureOffset(52, 15).addBox(-5.4237F, -0.5F, -7.5535F, 2.0F, 1.0F, 4.0F, 0.0F, false);

        right_foot = new ModelRenderer(this);
        right_foot.setRotationPoint(3.0F, 17.5F, 6.2F);
        right_foot.setTextureOffset(8, 24).addBox(-1.0F, 3.5F, -3.7F, 2.0F, 1.0F, 7.0F, 0.0F, false);

        right_toe = new ModelRenderer(this);
        right_toe.setRotationPoint(0.0F, 4.0F, -0.2F);
        right_foot.addChild(right_toe);
        setRotationAngle(right_toe, 0.0F, -0.829F, 0.0F);
        right_toe.setTextureOffset(52, 20).addBox(-1.0F, -0.5F, -3.5F, 2.0F, 1.0F, 4.0F, 0.0F, false);

        left_toe = new ModelRenderer(this);
        left_toe.setRotationPoint(0.0F, 4.0F, -0.2F);
        right_foot.addChild(left_toe);
        setRotationAngle(left_toe, 0.0F, 0.7418F, 0.0F);
        left_toe.setTextureOffset(52, 15).addBox(-1.0F, -0.5F, -3.5F, 2.0F, 1.0F, 4.0F, 0.0F, false);

        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, 15.0F, 9.0F);
        body.setTextureOffset(0, 0).addBox(-3.0F, -2.0F, -10.0F, 6.0F, 5.0F, 10.0F, 0.0F, false);

        left_arm = new ModelRenderer(this);
        left_arm.setRotationPoint(-3.0F, 17.0F, -1.0F);
        left_arm.setTextureOffset(8, 15).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

        right_arm = new ModelRenderer(this);
        right_arm.setRotationPoint(3.0F, 17.0F, -1.0F);
        right_arm.setTextureOffset(0, 15).addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, false);

        head = new ModelRenderer(this);
        head.setRotationPoint(0.0F, 14.0F, -1.0F);


        left_thigh = new ModelRenderer(this);
        left_thigh.setRotationPoint(-3.0F, 17.0F, 4.5F);
        left_thigh.setTextureOffset(16, 15).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 4.0F, 5.0F, 0.0F, false);

        right_thigh = new ModelRenderer(this);
        right_thigh.setRotationPoint(3.0F, 17.0F, 6.5F);
        right_thigh.setTextureOffset(30, 15).addBox(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 5.0F, 0.0F, false);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        // Default: QuadrupedModel
        this.head.rotateAngleX = headPitch * ((float)Math.PI / 180F);
        this.head.rotateAngleY = netHeadYaw * ((float)Math.PI / 180F);
        this.body.rotateAngleX = ((float)Math.PI / 2F);
        this.right_foot.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.left_foot.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        //this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        //this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;

        /*this.legBackRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
        this.legBackLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legFrontRight.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
        this.legFrontLeft.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;*/
    }


    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        left_foot.render(matrixStack, buffer, packedLight, packedOverlay);
        right_foot.render(matrixStack, buffer, packedLight, packedOverlay);
        body.render(matrixStack, buffer, packedLight, packedOverlay);
        left_arm.render(matrixStack, buffer, packedLight, packedOverlay);
        right_arm.render(matrixStack, buffer, packedLight, packedOverlay);
        head.render(matrixStack, buffer, packedLight, packedOverlay);
        left_thigh.render(matrixStack, buffer, packedLight, packedOverlay);
        right_thigh.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
