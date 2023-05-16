package net.mcreator.awakening.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;

import net.mcreator.awakening.init.AwakeningModMobEffects;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class AuraEffectProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:aura_unlock_on_join"))).isDone() : false) {
			if (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_abyss"))).isDone() : false) {
				while (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_abyss"))).isDone() : false) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(AwakeningModMobEffects.ABYSS.get(), 600, 1));
				}
			}
			if (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_astral"))).isDone() : false) {
				while (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_astral"))).isDone() : false) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(AwakeningModMobEffects.ASTRAL.get(), 600, 1));
				}
			}
			if (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_blood"))).isDone() : false) {
				while (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_blood"))).isDone() : false) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(AwakeningModMobEffects.BLOOD.get(), 600, 1));
				}
			}
			if (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_crystal"))).isDone() : false) {
				while (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
						? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_crystal"))).isDone()
						: false) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(AwakeningModMobEffects.CRYSTAL.get(), 600, 1));
				}
			}
			if (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_dust"))).isDone() : false) {
				while (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_dust"))).isDone() : false) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(AwakeningModMobEffects.DUST.get(), 600, 1));
				}
			}
			if (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_fire"))).isDone() : false) {
				while (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_fire"))).isDone() : false) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(AwakeningModMobEffects.FIRE.get(), 600, 1));
				}
			}
			if (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_ice"))).isDone() : false) {
				while (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_ice"))).isDone() : false) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(AwakeningModMobEffects.ICE.get(), 600, 1));
				}
			}
			if (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_lightning"))).isDone() : false) {
				while (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
						? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_lightning"))).isDone()
						: false) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(AwakeningModMobEffects.LIGHTNING.get(), 600, 1));
				}
			}
			if (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_plasma"))).isDone() : false) {
				while (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_plasma"))).isDone() : false) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(AwakeningModMobEffects.PLASMA.get(), 600, 1));
				}
			}
			if (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_steel"))).isDone() : false) {
				while (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_steel"))).isDone() : false) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(AwakeningModMobEffects.STEEL.get(), 600, 1));
				}
			}
			if (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_storm"))).isDone() : false) {
				while (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_storm"))).isDone() : false) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(AwakeningModMobEffects.STORM.get(), 600, 1));
				}
			}
			if (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_water"))).isDone() : false) {
				while (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_water"))).isDone() : false) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(AwakeningModMobEffects.WATER.get(), 600, 1));
				}
			}
			if (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_wind"))).isDone() : false) {
				while (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel ? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_wind"))).isDone() : false) {
					if (entity instanceof LivingEntity _entity)
						_entity.addEffect(new MobEffectInstance(AwakeningModMobEffects.WIND.get(), 600, 1));
				}
			}
		}
	}
}
