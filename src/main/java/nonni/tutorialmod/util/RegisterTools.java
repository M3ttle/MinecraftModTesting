package nonni.tutorialmod.util;

import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import nonni.tutorialmod.TutorialMod;
import nonni.tutorialmod.tools.ModItemTier;

public class RegisterTools {


	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.modid);
	
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	// Tools
	public static final RegistryObject<SwordItem> BLOOD_SWORD = ITEMS.register("blood_sword", () -> new SwordItem(ModItemTier.BLOOD, 2, 0.0F, new Item.Properties().group(TutorialMod.TAB)));// To get longer cooldown on attackspeed make substract from base attackSpeed (3rd parameter)
	public static final RegistryObject<PickaxeItem> BLOOD_PICKAXE = ITEMS.register("blood_pickaxe", () -> new PickaxeItem(ModItemTier.BLOOD, 0, -1.0F, new Item.Properties().group(TutorialMod.TAB)));
	public static final RegistryObject<AxeItem> BLOOD_AXE = ITEMS.register("blood_axe", () -> new AxeItem(ModItemTier.BLOOD, 0, -1.0F, new Item.Properties().group(TutorialMod.TAB)));
	public static final RegistryObject<ShovelItem> BLOOD_SHOVEL = ITEMS.register("blood_shovel", () -> new ShovelItem(ModItemTier.BLOOD, 0.1F, 0, new Item.Properties().group(TutorialMod.TAB)));
	public static final RegistryObject<HoeItem> BLOOD_HOE = ITEMS.register("blood_hoe", () -> new HoeItem(ModItemTier.BLOOD, 0, -1.0F, new Item.Properties().group(TutorialMod.TAB)));


}
