
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.awakening.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.awakening.potion.StormMobEffect;
import net.mcreator.awakening.potion.PlasmaMobEffect;
import net.mcreator.awakening.potion.IceMobEffect;
import net.mcreator.awakening.potion.FireMobEffect;
import net.mcreator.awakening.potion.DustMobEffect;
import net.mcreator.awakening.potion.BloodMobEffect;
import net.mcreator.awakening.AwakeningMod;

public class AwakeningModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, AwakeningMod.MODID);
	public static final RegistryObject<MobEffect> ICE = REGISTRY.register("ice", () -> new IceMobEffect());
	public static final RegistryObject<MobEffect> FIRE = REGISTRY.register("fire", () -> new FireMobEffect());
	public static final RegistryObject<MobEffect> BLOOD = REGISTRY.register("blood", () -> new BloodMobEffect());
	public static final RegistryObject<MobEffect> PLASMA = REGISTRY.register("plasma", () -> new PlasmaMobEffect());
	public static final RegistryObject<MobEffect> STORM = REGISTRY.register("storm", () -> new StormMobEffect());
	public static final RegistryObject<MobEffect> DUST = REGISTRY.register("dust", () -> new DustMobEffect());
}
