
package net.mcreator.awakening.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class StormMobEffect extends MobEffect {
	public StormMobEffect() {
		super(MobEffectCategory.NEUTRAL, -11183550);
	}

	@Override
	public String getDescriptionId() {
		return "effect.awakening.storm";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
