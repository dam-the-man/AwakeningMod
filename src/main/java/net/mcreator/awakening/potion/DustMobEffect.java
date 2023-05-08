
package net.mcreator.awakening.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class DustMobEffect extends MobEffect {
	public DustMobEffect() {
		super(MobEffectCategory.NEUTRAL, -11975641);
	}

	@Override
	public String getDescriptionId() {
		return "effect.awakening.dust";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
