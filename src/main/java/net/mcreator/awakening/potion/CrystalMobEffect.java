
package net.mcreator.awakening.potion;

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
