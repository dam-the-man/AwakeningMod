
package net.mcreator.awakening.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class SteelMobEffect extends MobEffect {
	public SteelMobEffect() {
		super(MobEffectCategory.NEUTRAL, -10066330);
	}

	@Override
	public String getDescriptionId() {
		return "effect.awakening.steel";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
