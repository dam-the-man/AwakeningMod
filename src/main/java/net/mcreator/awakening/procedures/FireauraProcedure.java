package net.mcreator.awakening.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.awakening.network.AwakeningModVariables;
import net.mcreator.awakening.init.AwakeningModMobEffects;

public class FireauraProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _livEnt ? _livEnt.hasEffect(AwakeningModMobEffects.FIRE.get()) : false) {
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(
						new MobEffectInstance(MobEffects.DAMAGE_BOOST, (int) ((entity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).Aura + 600), 1, (false), (false)));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(
						new MobEffectInstance(MobEffects.MOVEMENT_SPEED, (int) ((entity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).Aura + 600), 1, (false), (false)));
			if (entity instanceof LivingEntity _entity)
				_entity.addEffect(new MobEffectInstance(MobEffects.JUMP, (int) ((entity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).Aura + 600), 1, (false), (false)));
		}
	}
}
