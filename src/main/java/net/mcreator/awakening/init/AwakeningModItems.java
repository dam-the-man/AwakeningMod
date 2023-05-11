
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.awakening.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.mcreator.awakening.item.AuraItemItem;
import net.mcreator.awakening.AwakeningMod;

public class AwakeningModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, AwakeningMod.MODID);
	public static final RegistryObject<Item> AURA_ITEM = REGISTRY.register("aura_item", () -> new AuraItemItem());
}
