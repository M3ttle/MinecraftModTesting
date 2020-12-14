package nonni.tutorialmod.util;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import nonni.tutorialmod.TutorialMod;
import nonni.tutorialmod.items.ItemBase;
import nonni.tutorialmod.items.SuperApple;

public class RegisterItems {


	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.modid);
	
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	public static final RegistryObject<Item> BLOOD_INGOT = ITEMS.register("blood_ingot", () -> new ItemBase(TutorialMod.TAB));
	public static final RegistryObject<SuperApple> SUPER_APPLE = ITEMS.register("super_apple", SuperApple::new);
	
}
