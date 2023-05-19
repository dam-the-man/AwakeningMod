
package net.mcreator.awakening.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.Minecraft;

import net.mcreator.awakening.world.inventory.StatsScreenMenu;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class StatsScreenScreen extends AbstractContainerScreen<StatsScreenMenu> {
	private final static HashMap<String, Object> guistate = StatsScreenMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public StatsScreenScreen(StatsScreenMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 200;
		this.imageHeight = 176;
	}

	private static final ResourceLocation texture = new ResourceLocation("awakening:textures/screens/stats_screen.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, new TranslatableComponent("gui.awakening.stats_screen.label_aura"), 8, 11, -16750900);
		this.font.draw(poseStack, new TranslatableComponent("gui.awakening.stats_screen.label_e"), 72, 12, -65536);
		this.font.draw(poseStack, new TranslatableComponent("gui.awakening.stats_screen.label_vitality"), 8, 25, -3407821);
		this.font.draw(poseStack, new TranslatableComponent("gui.awakening.stats_screen.label_e1"), 72, 25, -65536);
		this.font.draw(poseStack, new TranslatableComponent("gui.awakening.stats_screen.label_agility"), 8, 40, -16738048);
		this.font.draw(poseStack, new TranslatableComponent("gui.awakening.stats_screen.label_e2"), 72, 40, -65536);
		this.font.draw(poseStack, new TranslatableComponent("gui.awakening.stats_screen.label_strength"), 7, 54, -16776961);
		this.font.draw(poseStack, new TranslatableComponent("gui.awakening.stats_screen.label_e3"), 72, 53, -65536);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
	}
}
