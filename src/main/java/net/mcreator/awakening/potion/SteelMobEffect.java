
package net.mcreator.awakening.potion;

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
