
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.awakening.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.awakening.network.OpenSSMessage;
import net.mcreator.awakening.AwakeningMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class AwakeningModKeyMappings {
	public static final KeyMapping OPEN_SS = new KeyMapping("key.awakening.open_ss", GLFW.GLFW_KEY_O, "key.categories.misc");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(OPEN_SS);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == OPEN_SS.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						AwakeningMod.PACKET_HANDLER.sendToServer(new OpenSSMessage(0, 0));
						OpenSSMessage.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
