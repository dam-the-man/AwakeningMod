
package net.mcreator.awakening.potion;

public class WaterMobEffect extends MobEffect {

	public WaterMobEffect() {
		super(MobEffectCategory.BENEFICIAL, -10066177);
	}

	@Override
	public String getDescriptionId() {
		return "effect.awakening.water";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

}
