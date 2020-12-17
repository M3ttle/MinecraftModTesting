package nonni.tutorialmod.client.render;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import nonni.tutorialmod.TutorialMod;
import nonni.tutorialmod.client.model.HogModel;
import nonni.tutorialmod.entities.HogEntity;

public class HogRenderer extends MobRenderer<HogEntity, HogModel<HogEntity>> {

    protected  static final ResourceLocation TEXTURE = new ResourceLocation(TutorialMod.MODID, "textures/entity/hog.png");
    // Connect our hog to the model and set shadow to it
    public HogRenderer(EntityRendererManager renderManagerIn) {
        super(renderManagerIn, new HogModel<>(), 0.5F);// shadow
    }

    @Override
    public ResourceLocation getEntityTexture(HogEntity entity) {
        return TEXTURE;
    }
}