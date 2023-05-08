
package net.mcreator.awakening.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class FireMobEffect extends MobEffect {
	public FireMobEffect() {
		super(MobEffectCategory.NEUTRAL, -3407872);
	}

	@Override
	public String getDescriptionId() {
		return "effect.awakening.fire";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
