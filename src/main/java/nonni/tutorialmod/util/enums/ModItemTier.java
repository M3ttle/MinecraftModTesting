package nonni.tutorialmod.util.enums;

import java.util.function.Supplier;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import nonni.tutorialmod.init.ModItems;

public enum ModItemTier implements IItemTier {
	// https://mcreator.net/wiki/how-make-tool
	
	// harvest level, max uses, efficiency, base Attack damage, enchantability, repairMaterial
	// items have base attackDmg of 1 so: 1 + baseDamage(3) + addedDamage(2)
	// 6 damage = 3 hearts (Divided by 2)
	
	// Attackspeed has base value of 4, what is then sent in is substraced from that
	BLOOD(4, 1000, 20.0F, 33.0F, 50, () -> {
		return Ingredient.fromItems(ModItems.BLOOD_INGOT.get());
	});
	
	private final int harvestLevel;
	private final int maxUses;
	private final float efficiency;
	private final float attackDamage;
	private final int enchantability;
	private final Supplier<Ingredient> repairMaterial;
	
	ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial){
		this.harvestLevel = harvestLevel;
		this.maxUses = maxUses;
		this.efficiency = efficiency;
		this.attackDamage = attackDamage;
		this.enchantability = enchantability;
		this.repairMaterial = repairMaterial;
	}

	@Override
	public int getMaxUses() {
		return maxUses;
	}

	@Override
	public float getEfficiency() {
		return efficiency;
	}

	@Override
	public float getAttackDamage() {
		return attackDamage;
	}

	@Override
	public int getHarvestLevel() {
		return harvestLevel;
	}

	@Override
	public int getEnchantability() {
		return enchantability;
	}

	@Override
	public Ingredient getRepairMaterial() {
		return repairMaterial.get();
	}

}
