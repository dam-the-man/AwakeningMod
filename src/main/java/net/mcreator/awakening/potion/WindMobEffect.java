
package net.mcreator.awakening.potion;

public class WindMobEffect extends MobEffect {

	public WindMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.awakening.wind";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

}
