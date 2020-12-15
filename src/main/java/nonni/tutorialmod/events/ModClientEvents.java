package nonni.tutorialmod.events;

import net.minecraft.client.gui.screen.inventory.CraftingScreen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import nonni.tutorialmod.TutorialMod;
import nonni.tutorialmod.init.ModBlocks;
import nonni.tutorialmod.init.ModItems;

// EventBus is something that manages and fires events for you
// "Make sure to run this code when this event is fired"
// value Dist.CLIENT or Dist.DEDICATED_SERVER (Creates on server or client side)
@Mod.EventBusSubscriber(modid = TutorialMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ModClientEvents {

    // To find an event go to External Libraries -> Gradle.net.minecraftforge : mapped snapshot -> net -> minecraftforge ->
        // event -> AnvilUpdateEvent -> ctrl + click on Event class
        // Inside the Event class press ctrl + h (opens up Hierarchy window

    // Has to be static
    @SubscribeEvent
    public static void onJumpWithStick(LivingEvent.LivingJumpEvent event) {
        // Everytime a living entity jumps this is fired
        LivingEntity player = event.getEntityLiving();
        if (player.getHeldItemMainhand().getItem() == Items.STICK) {
            //TutorialMod.LOGGER.info("Player tried to jump with a stick!");

            World world = player.getEntityWorld();
            // add to player location -1 Y position
            world.setBlockState(player.getPosition().add(0, -1, 0), ModBlocks.BLOOD_ORE.get().getDefaultState());
        }
    }

    @SubscribeEvent
    public static void onDamageSheep(AttackEntityEvent event) {
        if (event.getEntityLiving().getHeldItemMainhand().getItem() == ModItems.SUPER_APPLE.get()) {
            if (event.getTarget().isAlive()) {
                LivingEntity target = (LivingEntity) event.getTarget();
                if (target instanceof SheepEntity) {

                    PlayerEntity player = event.getPlayer();
                    target.addPotionEffect(new EffectInstance(Effects.POISON, 10 * TutorialMod.oneSec, 1));
                    target.setGlowing(true);

                    // Send message to the player
                    // Check if the player is not remote (To only send the message one time)
                    if (!event.getPlayer().getEntityWorld().isRemote) {
                        String msg = TextFormatting.RED + "That sheep isn't feeling so well...";
                        player.sendMessage(new StringTextComponent(msg), player.getUniqueID());
                    }
                }
            }
        }
    }

    // Cancel an event
    @SubscribeEvent
    public static void onCraftingTableOpen(GuiOpenEvent event) {
        // Every time GUI is open - chest/crafting table....
        if (event.isCancelable()) { // Always check this
            if (event.getGui() instanceof CraftingScreen) {
                event.setCanceled(true);
                TutorialMod.LOGGER.info("Player tried to open a crafting table");
            }
        }
    }

}
