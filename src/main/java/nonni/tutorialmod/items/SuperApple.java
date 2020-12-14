package nonni.tutorialmod.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import nonni.tutorialmod.TutorialMod;

public class SuperApple extends Item {
	
	public SuperApple() {
		super(new Item.Properties()
				.group(TutorialMod.TAB)
				.food(new Food.Builder()
						.hunger(12)// number here is divided by 2. 8 = 4 hunger bar
						.saturation(3.5F)
						.effect(() -> new EffectInstance(Effects.NIGHT_VISION, 5*60*20, 3), 1.0f)// Night vision, duration, lvl +1
						.effect(() -> new EffectInstance(Effects.HASTE, 5*60*20, 3), 9.0f)
						.effect(() -> new EffectInstance(Effects.INVISIBILITY, 5*60*20), 1.0f)
						.effect(() -> new EffectInstance(Effects.RESISTANCE, 5*60*20), 9)
						.effect(() -> new EffectInstance(Effects.REGENERATION, 5*60*20), 9)
						.effect(() -> new EffectInstance(Effects.ABSORPTION, 5*60*20), 9)
						.effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 5*60*20), 9)
						.effect(() -> new EffectInstance(Effects.LUCK, 5*60*20), 9)
						.effect(() -> new EffectInstance(Effects.INSTANT_HEALTH, 5*60*20), 9)
						.setAlwaysEdible()
						.build()// Will finish the food object
						));
	}
}

// 20 ticks = 1 sec