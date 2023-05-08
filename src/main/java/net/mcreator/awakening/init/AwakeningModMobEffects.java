
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.awakening.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.awakening.potion.WindMobEffect;
import net.mcreator.awakening.potion.WaterMobEffect;
import net.mcreator.awakening.potion.StormMobEffect;
import net.mcreator.awakening.potion.SteelMobEffect;
import net.mcreator.awakening.potion.PlasmaMobEffect;
import net.mcreator.awakening.potion.LightningMobEffect;
import net.mcreator.awakening.potion.IceMobEffect;
import net.mcreator.awakening.potion.FireMobEffect;
import net.mcreator.awakening.potion.DustMobEffect;
import net.mcreator.awakening.potion.CrystalMobEffect;
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
	public static final RegistryObject<MobEffect> CRYSTAL = REGISTRY.register("crystal", () -> new CrystalMobEffect());
	public static final RegistryObject<MobEffect> LIGHTNING = REGISTRY.register("lightning", () -> new LightningMobEffect());
	public static final RegistryObject<MobEffect> WATER = REGISTRY.register("water", () -> new WaterMobEffect());
	public static final RegistryObject<MobEffect> WIND = REGISTRY.register("wind", () -> new WindMobEffect());
	public static final RegistryObject<MobEffect> STEEL = REGISTRY.register("steel", () -> new SteelMobEffect());
}
