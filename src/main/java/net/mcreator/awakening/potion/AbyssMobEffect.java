
package net.mcreator.awakening.potion;

public class AbyssMobEffect extends MobEffect {

	public AbyssMobEffect() {
		super(MobEffectCategory.NEUTRAL, -16777216);
	}

	@Override
	public String getDescriptionId() {
		return "effect.awakening.abyss";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

}
