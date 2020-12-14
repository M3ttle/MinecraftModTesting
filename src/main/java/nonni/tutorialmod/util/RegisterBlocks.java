package nonni.tutorialmod.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import nonni.tutorialmod.TutorialMod;
import nonni.tutorialmod.blocks.BlockItemBase;
import nonni.tutorialmod.blocks.BloodBlock;

public class RegisterBlocks {
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, TutorialMod.modid);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.modid);

	public static void init() {
		BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	// Block
	public static final RegistryObject<Block> BLOOD_BLOCK = BLOCKS.register("blood_block", BloodBlock::new);

	// Block Items
	public static final RegistryObject<Item> BLOOD_BLOCK_ITEM = ITEMS.register("blood_block", () -> new BlockItemBase(TutorialMod.TAB, BLOOD_BLOCK.get()));

}
