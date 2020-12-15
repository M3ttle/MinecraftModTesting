package nonni.tutorialmod.armor;

import java.util.function.Supplier;


import nonni.tutorialmod.TutorialMod;
import nonni.tutorialmod.util.RegisterItems;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public enum ModArmorMaterial implements IArmorMaterial {
	
	BLOOD(TutorialMod.MODID + ":blood",				// layer name
			35,										// maxDmgFactor (iron is 15)
			new int[] { 2, 5, 6, 2 }, 				// dmgReductionArray (helm, leg, chest, boots)
			25, 									// enchantability
			SoundEvents.ITEM_ARMOR_EQUIP_GENERIC,	// sound
			2.0F,									// toughness. Multiplies and increases the dmgReductionArray (Not straight up dmgRedArray mulitply though)
			1.0F,									// knockback resistance
			() -> {									// Repair material
				return Ingredient.fromItems(RegisterItems.BLOOD_INGOT.get());
			}	
			);
	
															// helm, chest, leggings and boots (multiplies this number with maxDmgFactors) - Durability
	private static final int[] MAX_DAMAGE_ARRAY = new int[] { 11, 16, 15, 13 };
	private final String name;
	private final int maxDamageFactor;
	private final int[] damageReductionAmountArray;
	private final int enchantability;
	private final SoundEvent soundEvent;
	private final float toughness;
	private final float knockBackRestistance;
	private final Supplier<Ingredient> repairMaterial;
	
	
	ModArmorMaterial(String name, int maxDamagefactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, float knockBackResistance,
			Supplier<Ingredient> repairMaterial) {
		this.name = name;
		this.maxDamageFactor = maxDamagefactor;
		this.damageReductionAmountArray = damageReductionAmountArray;
		this.enchantability = enchantability;
		this.soundEvent = soundEvent;
		this.toughness = toughness;
		this.knockBackRestistance = knockBackResistance;
		this.repairMaterial = repairMaterial;
	};

	@Override
	public int getDurability(EquipmentSlotType slotIn) {
		return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
	}

	@Override
	public int getDamageReductionAmount(EquipmentSlotType slotIn) {
		return this.damageReductionAmountArray[slotIn.getIndex()];
	}

	@Override
	public int getEnchantability() {
		return this.enchantability;
	}

	@Override
	public SoundEvent getSoundEvent() {
		return this.soundEvent;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return this.repairMaterial.get();
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public float getToughness() {
		return this.toughness;
	}

	@Override
	public float getKnockbackResistance() {
		return this.knockBackRestistance;
	}
	
}
