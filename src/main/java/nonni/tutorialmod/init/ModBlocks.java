package nonni.tutorialmod.init;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import nonni.tutorialmod.TutorialMod;
import nonni.tutorialmod.objects.blocks.BloodBlock;
import nonni.tutorialmod.objects.blocks.BloodOre;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.MODID);

    // Block
    public static final RegistryObject<Block> BLOOD_BLOCK = BLOCKS.register("blood_block", BloodBlock::new);
    public static final RegistryObject<Block> BLOOD_ORE = BLOCKS.register("blood_ore", BloodOre::new);
}
