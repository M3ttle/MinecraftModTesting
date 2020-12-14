package nonni.tutorialmod.util;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import nonni.tutorialmod.TutorialMod;
import nonni.tutorialmod.armor.ModArmorMaterial;

public class RegisterArmor {


	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.modid);
	
	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	// Armor
	public static final RegistryObject<ArmorItem> BLOOD_HELMET = ITEMS.register("blood_helmet", () -> new ArmorItem(ModArmorMaterial.BLOOD, EquipmentSlotType.HEAD, new Item.Properties().group(TutorialMod.TAB)));
	public static final RegistryObject<ArmorItem> BLOOD_CHESTPLATE = ITEMS.register("blood_chestplate", () -> new ArmorItem(ModArmorMaterial.BLOOD, EquipmentSlotType.CHEST, new Item.Properties().group(TutorialMod.TAB)));
	public static final RegistryObject<ArmorItem> BLOOD_LEGGINGS = ITEMS.register("blood_leggings", () -> new ArmorItem(ModArmorMaterial.BLOOD, EquipmentSlotType.LEGS, new Item.Properties().group(TutorialMod.TAB)));
	public static final RegistryObject<ArmorItem> BLOOD_BOOTS = ITEMS.register("blood_boots", () -> new ArmorItem(ModArmorMaterial.BLOOD, EquipmentSlotType.FEET, new Item.Properties().group(TutorialMod.TAB)));


}
