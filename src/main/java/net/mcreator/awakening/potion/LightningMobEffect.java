
package net.mcreator.awakening.potion;

public class LightningMobEffect extends MobEffect {

	public LightningMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -16724788);
	}

	@Override
	public String getDescriptionId() {
		return "effect.awakening.lightning";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

}
