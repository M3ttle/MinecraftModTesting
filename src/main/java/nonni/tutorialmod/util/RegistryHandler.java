package nonni.tutorialmod.util;

import net.minecraft.block.Block;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import nonni.tutorialmod.TutorialMod;
import nonni.tutorialmod.armor.ModArmorMaterial;
import nonni.tutorialmod.blocks.BlockItemBase;
import nonni.tutorialmod.blocks.BloodBlock;
import nonni.tutorialmod.items.ItemBase;
import nonni.tutorialmod.items.SuperApple;
import nonni.tutorialmod.tools.ModItemTier;

//@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class RegistryHandler {
	
	public static void init() {
		// Fill with block register and so on
		RegisterItems.init();
		RegisterBlocks.init();
		RegisterTools.init();
		RegisterArmor.init();
	}
}
