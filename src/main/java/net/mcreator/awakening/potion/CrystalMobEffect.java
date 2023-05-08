
package net.mcreator.awakening.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class CrystalMobEffect extends MobEffect {
	public CrystalMobEffect() {
		super(MobEffectCategory.NEUTRAL, -56164);
	}

	@Override
	public String getDescriptionId() {
		return "effect.awakening.crystal";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
