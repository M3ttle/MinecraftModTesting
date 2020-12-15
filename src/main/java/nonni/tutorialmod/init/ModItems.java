package nonni.tutorialmod.init;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import nonni.tutorialmod.TutorialMod;
import nonni.tutorialmod.objects.blocks.BlockItemBase;
import nonni.tutorialmod.objects.items.ItemBase;
import nonni.tutorialmod.objects.items.SuperApple;
import nonni.tutorialmod.util.enums.ModArmorMaterial;
import nonni.tutorialmod.util.enums.ModItemTier;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TutorialMod.MODID);

    // Block Items
    public static final RegistryObject<Item> BLOOD_BLOCK_ITEM = ITEMS.register("blood_block", () -> new BlockItemBase(TutorialMod.TAB, ModBlocks.BLOOD_BLOCK.get()));
    public static final RegistryObject<Item> BLOOD_ORE_ITEM = ITEMS.register("blood_ore", () -> new BlockItemBase(TutorialMod.TAB, ModBlocks.BLOOD_ORE.get()));

    // Items
    public static final RegistryObject<Item> BLOOD_INGOT = ITEMS.register("blood_ingot",
            () -> new ItemBase(TutorialMod.TAB));
    public static final RegistryObject<SuperApple> SUPER_APPLE = ITEMS.register("super_apple", SuperApple::new);


    // Armor
    public static final RegistryObject<ArmorItem> BLOOD_HELMET = ITEMS.register("blood_helmet",
            () -> new ArmorItem(ModArmorMaterial.BLOOD, EquipmentSlotType.HEAD, new Item.Properties().group(TutorialMod.TAB)));

    public static final RegistryObject<ArmorItem> BLOOD_CHESTPLATE = ITEMS.register("blood_chestplate",
            () -> new ArmorItem(ModArmorMaterial.BLOOD, EquipmentSlotType.CHEST, new Item.Properties().group(TutorialMod.TAB)));

    public static final RegistryObject<ArmorItem> BLOOD_LEGGINGS = ITEMS.register("blood_leggings",
            () -> new ArmorItem(ModArmorMaterial.BLOOD, EquipmentSlotType.LEGS, new Item.Properties().group(TutorialMod.TAB)));

    public static final RegistryObject<ArmorItem> BLOOD_BOOTS = ITEMS.register("blood_boots",
            () -> new ArmorItem(ModArmorMaterial.BLOOD, EquipmentSlotType.FEET, new Item.Properties().group(TutorialMod.TAB)));

    // Tools
    public static final RegistryObject<SwordItem> BLOOD_SWORD = ITEMS.register("blood_sword",
            () -> new SwordItem(ModItemTier.BLOOD, 2, 0.0F, new Item.Properties().group(TutorialMod.TAB)));// To get longer cooldown on attackspeed make substract from base attackSpeed (3rd parameter)

    public static final RegistryObject<PickaxeItem> BLOOD_PICKAXE = ITEMS.register("blood_pickaxe",
            () -> new PickaxeItem(ModItemTier.BLOOD, 0, -1.0F, new Item.Properties().group(TutorialMod.TAB)));

    public static final RegistryObject<AxeItem> BLOOD_AXE = ITEMS.register("blood_axe",
            () -> new AxeItem(ModItemTier.BLOOD, 0, -1.0F, new Item.Properties().group(TutorialMod.TAB)));

    public static final RegistryObject<ShovelItem> BLOOD_SHOVEL = ITEMS.register("blood_shovel",
            () -> new ShovelItem(ModItemTier.BLOOD, 0.1F, 0, new Item.Properties().group(TutorialMod.TAB)));

    public static final RegistryObject<HoeItem> BLOOD_HOE = ITEMS.register("blood_hoe",
            () -> new HoeItem(ModItemTier.BLOOD, 0, -1.0F, new Item.Properties().group(TutorialMod.TAB)));


}
