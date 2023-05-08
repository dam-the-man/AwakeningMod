
package net.mcreator.awakening.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class BloodMobEffect extends MobEffect {
	public BloodMobEffect() {
		super(MobEffectCategory.NEUTRAL, -10092544);
	}

	@Override
	public String getDescriptionId() {
		return "effect.awakening.blood";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
