package net.mcreator.awakening.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.Advancement;

import net.mcreator.awakening.network.AwakeningModVariables;

import javax.annotation.Nullable;

import java.util.Random;
import java.util.Iterator;

@Mod.EventBusSubscriber
public class AuraTypeOnJoinProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getPlayer());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		for (int index0 = 0; index0 < (int) (2); index0++) {
			if (entity instanceof ServerPlayer _plr && _plr.level instanceof ServerLevel
					? _plr.getAdvancements().getOrStartProgress(_plr.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:aura_unlock_on_join"))).isDone()
					: false) {
				break;
			} else {
				if (0 == (entity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).AuraType) {
					{
						double _setval = Mth.nextDouble(new Random(), 1, 13);
						entity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
							capability.AuraType = _setval;
							capability.syncPlayerVariables(entity);
						});
					}
				} else {
					if ((entity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).AuraType == 1) {
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_abyss"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemainingCriteria().iterator();
								while (_iterator.hasNext())
									_player.getAdvancements().award(_adv, (String) _iterator.next());
							}
						}
					}
					if ((entity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).AuraType == 2) {
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_astral"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemainingCriteria().iterator();
								while (_iterator.hasNext())
									_player.getAdvancements().award(_adv, (String) _iterator.next());
							}
						}
					}
					if ((entity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).AuraType == 3) {
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_blood"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemainingCriteria().iterator();
								while (_iterator.hasNext())
									_player.getAdvancements().award(_adv, (String) _iterator.next());
							}
						}
					}
					if ((entity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).AuraType == 4) {
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_crystal"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemainingCriteria().iterator();
								while (_iterator.hasNext())
									_player.getAdvancements().award(_adv, (String) _iterator.next());
							}
						}
					}
					if ((entity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).AuraType == 5) {
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_dust"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemainingCriteria().iterator();
								while (_iterator.hasNext())
									_player.getAdvancements().award(_adv, (String) _iterator.next());
							}
						}
					}
					if ((entity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).AuraType == 6) {
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_fire"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemainingCriteria().iterator();
								while (_iterator.hasNext())
									_player.getAdvancements().award(_adv, (String) _iterator.next());
							}
						}
					}
					if ((entity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).AuraType == 7) {
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_ice"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemainingCriteria().iterator();
								while (_iterator.hasNext())
									_player.getAdvancements().award(_adv, (String) _iterator.next());
							}
						}
					}
					if ((entity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).AuraType == 8) {
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_lightning"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemainingCriteria().iterator();
								while (_iterator.hasNext())
									_player.getAdvancements().award(_adv, (String) _iterator.next());
							}
						}
					}
					if ((entity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).AuraType == 9) {
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_plasma"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemainingCriteria().iterator();
								while (_iterator.hasNext())
									_player.getAdvancements().award(_adv, (String) _iterator.next());
							}
						}
					}
					if ((entity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).AuraType == 10) {
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_steel"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemainingCriteria().iterator();
								while (_iterator.hasNext())
									_player.getAdvancements().award(_adv, (String) _iterator.next());
							}
						}
					}
					if ((entity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).AuraType == 11) {
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_storm"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemainingCriteria().iterator();
								while (_iterator.hasNext())
									_player.getAdvancements().award(_adv, (String) _iterator.next());
							}
						}
					}
					if ((entity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).AuraType == 12) {
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_water"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemainingCriteria().iterator();
								while (_iterator.hasNext())
									_player.getAdvancements().award(_adv, (String) _iterator.next());
							}
						}
					}
					if ((entity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).AuraType == 13) {
						if (entity instanceof ServerPlayer _player) {
							Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:ad_wind"));
							AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
							if (!_ap.isDone()) {
								Iterator _iterator = _ap.getRemainingCriteria().iterator();
								while (_iterator.hasNext())
									_player.getAdvancements().award(_adv, (String) _iterator.next());
							}
						}
					}
					if (entity instanceof ServerPlayer _player) {
						Advancement _adv = _player.server.getAdvancements().getAdvancement(new ResourceLocation("awakening:aura_unlock_on_join"));
						AdvancementProgress _ap = _player.getAdvancements().getOrStartProgress(_adv);
						if (!_ap.isDone()) {
							Iterator _iterator = _ap.getRemainingCriteria().iterator();
							while (_iterator.hasNext())
								_player.getAdvancements().award(_adv, (String) _iterator.next());
						}
					}
				}
			}
		}
	}
}
