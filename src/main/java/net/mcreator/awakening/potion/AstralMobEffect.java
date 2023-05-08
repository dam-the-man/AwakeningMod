
package net.mcreator.awakening.potion;

public class AstralMobEffect extends MobEffect {

	public AstralMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public String getDescriptionId() {
		return "effect.awakening.astral";
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}

}
