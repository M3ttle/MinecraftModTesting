package nonni.tutorialmod.util;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import nonni.tutorialmod.TutorialMod;
import nonni.tutorialmod.client.render.HogRenderer;
import nonni.tutorialmod.init.ModEntityTypes;


// Client based rendering
@Mod.EventBusSubscriber(modid = TutorialMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {

    // Runs every time forge mod loader sets up its clients
    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        // For every new entity, register it
        RenderingRegistry.registerEntityRenderingHandler(ModEntityTypes.HOG.get(), HogRenderer::new);
    }
}
