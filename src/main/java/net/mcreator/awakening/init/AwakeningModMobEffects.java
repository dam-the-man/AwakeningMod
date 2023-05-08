
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.awakening.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.awakening.potion.FireMobEffect;
import net.mcreator.awakening.AwakeningMod;

public class AwakeningModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AwakeningMod.MODID);
	public static final RegistryObject<MobEffect> FIRE = REGISTRY.register("fire", () -> new FireMobEffect());
}
