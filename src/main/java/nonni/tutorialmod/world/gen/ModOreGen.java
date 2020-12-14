package nonni.tutorialmod.world.gen;

import net.minecraft.block.BlockState;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;
import nonni.tutorialmod.TutorialMod;
import nonni.tutorialmod.util.RegisterBlocks;

// Add a event subscriber
@Mod.EventBusSubscriber(modid = TutorialMod.modid, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModOreGen {

    @SubscribeEvent
    public static void generateOres(FMLLoadCompleteEvent event){
        // Loop through each biome in the game
        for(Biome biome : ForgeRegistries.BIOMES) {

            if (biome.getCategory() == Biome.Category.NETHER) {

            } else if (biome.getCategory() == Biome.Category.THEEND) {

            } else { // Overworld generation
                // biome, rarity (20 = very common)
                // bottomOffset = lowest Y you can find the ore
                // TopOffset = top possible Y generation (It will substract that number from the max
                // max = Max Y value. 50 - 5 = 45.
                // will spawn between 8 - 45 Y
                // size = max ore together in a chunk

                //genOre(biome, 15, 8, 5, 50, OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD,
                //        RegisterBlocks.BLOOD_ORE.get().getDefaultState(), 8);
            }
        }
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
}
