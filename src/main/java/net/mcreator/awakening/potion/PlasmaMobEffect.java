
package net.mcreator.awakening.potion;

import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

public class PlasmaMobEffect extends MobEffect {
	public PlasmaMobEffect() {
		super(MobEffectCategory.NEUTRAL, -26113);
	}

	@Override
	public String getDescriptionId() {
		return "effect.awakening.plasma";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
