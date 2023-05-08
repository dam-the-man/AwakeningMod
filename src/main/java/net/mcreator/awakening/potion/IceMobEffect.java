
package net.mcreator.awakening.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class IceMobEffect extends MobEffect {
	public IceMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16724737);
	}

	@Override
	public String getDescriptionId() {
		return "effect.awakening.ice";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
