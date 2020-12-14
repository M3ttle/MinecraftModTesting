package nonni.tutorialmod.world.gen;

import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;
import nonni.tutorialmod.TutorialMod;
import nonni.tutorialmod.util.RegisterBlocks;

import java.util.ArrayList;

// Add a event subscriber
@Mod.EventBusSubscriber(modid = TutorialMod.modid, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {

    private static final ArrayList<ConfiguredFeature<?, ?>> overWorldOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> netherOres = new ArrayList<ConfiguredFeature<?, ?>>();
    private static final ArrayList<ConfiguredFeature<?, ?>> endOres = new ArrayList<ConfiguredFeature<?, ?>>();


    public static void registerOres() {
        final int vein_size = 6;
        overWorldOres.add(register("blood_ore", Feature.ORE.withConfiguration(new OreFeatureConfig(
                OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, RegisterBlocks.BLOOD_ORE.get().getDefaultState(), vein_size))
                .range(64).square()// Spawn height start, right now 128 is the max
                .func_242731_b(64)// Chunk spawn frequency (How many ores spawn per chunk - Mapping
        ));

        // Generate ores in:
        // BASE_STONE_OVERWORLD = stone, granite, diorite and andesite
        // NETHERRACK = netherrack
        // BASE_STONE_NETHER = netherrack, basalt and blackstone
        // Can be replaced with new BlockMatchRuleTest(Blocks.END_STONE) for example

    }

    //@SubscribeEvent(priority = EventPriority.HIGHEST)
    @SubscribeEvent
    public static void generateOres(BiomeLoadingEvent event){

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

        // biome, rarity (20 = very common)
        // bottomOffset = lowest Y you can find the ore
        // TopOffset = top possible Y generation (It will substract that number from the max
        // max = Max Y value. 50 - 5 = 45.
        // will spawn between 8 - 45 Y
        // size = max ore together in a chunk
    }

    //
    private static void genOre(Biome biome, int count, int bottomOffset, int topOffset, int max, OreFeatureConfig.FillerBlockType filler, BlockState defaultBlockState, int size) {
        // ?

        /*

        CountRangeConfig range = new CountRangeConfig(count, bottomOffset, topOffset, ma);
        OreFeatureConfig feature = new OreFeatureConfig(filler, defaultBlockState, size);
        ConfiguredPlacement config = Placement.COUNT_RANGE.configure(range);

        // Now we add the feature
        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(feature).withPlacement(config));

        biome.getGenerationSettings().

         */


    }

    private static <FC extends IFeatureConfig>ConfiguredFeature<FC, ?> register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, TutorialMod.modid + ":" + name, configuredFeature);
    };
}
