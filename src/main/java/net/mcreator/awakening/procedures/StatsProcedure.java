package net.mcreator.awakening.procedures;

import net.minecraftforge.eventbus.api.Event;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class StatsProcedure {
	@SubscribeEvent
	public static void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			execute(event, event.getSource().getEntity());
		}
	}

	public static void execute(Entity sourceentity) {
		execute(null, sourceentity);
	}

	private static void execute(@Nullable Event event, Entity sourceentity) {
		if (sourceentity == null)
			return;
		if (sourceentity instanceof Player) {
			{
				double _setval = (sourceentity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).Strenght
						+ (sourceentity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new AwakeningModVariables.PlayerVariables())).Strenght * 0.01;
				sourceentity.getCapability(AwakeningModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.Strenght = _setval;
					capability.syncPlayerVariables(sourceentity);
				});
			}
		}
	}
}
