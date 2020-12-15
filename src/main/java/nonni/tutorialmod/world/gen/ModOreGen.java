package nonni.tutorialmod.world.gen;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import nonni.tutorialmod.TutorialMod;
import nonni.tutorialmod.util.RegisterBlocks;

import java.util.ArrayList;

// Add a event subscriber
//@Mod.EventBusSubscriber(modid = TutorialMod.modid, bus = Mod.EventBusSubscriber.Bus.MOD)
@Mod.EventBusSubscriber
public class ModOreGen {

    private static final ArrayList<ConfiguredFeature<?, ?>> overWorldOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<ConfiguredFeature<?, ?>>();

    public static void registerOres() {
        final int vein_size = 3;
        overWorldOres.add(register("blood_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegisterBlocks.BLOOD_ORE.get().getDefaultState(), vein_size))
                .range(20).square()// Spawn height start, right now 128 is the max
                .func_242731_b(25)// Chunk spawn frequency (How many ores spawn per chunk - Mapping
        ));

        // Generate ores in:
        // BASE_STONE_OVERWORLD = stone, granite, diorite and andesite
        // NETHERRACK = netherrack
        // BASE_STONE_NETHER = netherrack, basalt and blackstone
        // Can be replaced with new BlockMatchRuleTest(Blocks.END_STONE) for example

        // biome, rarity (20 = very common)
        // bottomOffset = lowest Y you can find the ore
        // TopOffset = top possible Y generation (It will substract that number from the max
        // max = Max Y value. 50 - 5 = 45.
        // will spawn between 8 - 45 Y
        // size = max ore together in a chunk
    }

    //@SubscribeEvent
    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void generateOres(final BiomeLoadingEvent event){
        BiomeGenerationSettingsBuilder generation = event.getGeneration();
        if(event.getCategory().equals(Biome.Category.NETHER)) {
            for (ConfiguredFeature<?, ?> ore : netherOres) {
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        } else if (event.getCategory().equals(Biome.Category.THEEND)) {
            for (ConfiguredFeature<?, ?> ore : endOres) {
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        } else {
            // We are in overworld
            for (ConfiguredFeature<?, ?> ore : overWorldOres) {
                if (ore != null) generation.withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, ore);
            }
        }
    }

    private static <FC extends IFeatureConfig>ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, TutorialMod.modid + ":" + name, configuredFeature);
    };
}
