package net.mcreator.awakening.network;

import org.checkerframework.dataflow.qual.Pure;

import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.Tag;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.Direction;
import net.minecraft.client.Minecraft;

import net.mcreator.awakening.AwakeningMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AwakeningModVariables {
	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		AwakeningMod.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new, PlayerVariablesSyncMessage::handler);
	}

	@SubscribeEvent
	public static void init(RegisterCapabilitiesEvent event) {
		event.register(PlayerVariables.class);
	}

	@Mod.EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (!event.getPlayer().level.isClientSide())
				((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables())).syncPlayerVariables(event.getPlayer());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			event.getOriginal().revive();
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
			clone.Strenght = original.Strenght;
			clone.Agility = original.Agility;
			clone.Aura = original.Aura;
			clone.Vitality = original.Vitality;
			clone.Soul = original.Soul;
			clone.Willpower = original.Willpower;
			clone.Demonic = original.Demonic;
			clone.Pure = original.Pure;
			clone.Vampirism = original.Vampirism;
			clone.Swordsmanship = original.Swordsmanship;
			clone.Concentration = original.Concentration;
			clone.Emission = original.Emission;
			clone.Transmutation = original.Transmutation;
			clone.Manipulation = original.Manipulation;
			clone.Domination = original.Domination;
			clone.MaxAura = original.MaxAura;
			clone.MaxHealth = original.MaxHealth;
			clone.karma = original.karma;
			clone.AuraType = original.AuraType;
			if (!event.isWasDeath()) {
			}
		}
	}

	public static final Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = CapabilityManager.get(new CapabilityToken<PlayerVariables>() {
	});

	@Mod.EventBusSubscriber
	private static class PlayerVariablesProvider implements ICapabilitySerializable<Tag> {
		@SubscribeEvent
		public static void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
			if (event.getObject() instanceof Player && !(event.getObject() instanceof FakePlayer))
				event.addCapability(new ResourceLocation("awakening", "player_variables"), new PlayerVariablesProvider());
		}

		private final PlayerVariables playerVariables = new PlayerVariables();
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(() -> playerVariables);

		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public Tag serializeNBT() {
			return playerVariables.writeNBT();
		}

		@Override
		public void deserializeNBT(Tag nbt) {
			playerVariables.readNBT(nbt);
		}
	}

	public static class PlayerVariables {
		public double Strenght = 0;
		public double Agility = 0;
		public double Aura = 0;
		public double Vitality = 0;
		public double Soul = 0;
		public double Willpower = 0;
		public double Demonic = 0;
		public double Pure = 0;
		public double Vampirism = 0;
		public double Swordsmanship = 0;
		public double Concentration = 0;
		public double Emission = 0;
		public double Transmutation = 0;
		public double Manipulation = 0;
		public double Domination = 0;
		public double MaxAura = 10.0;
		public double MaxHealth = 20.0;
		public double karma = 0;
		public double AuraType = 0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				AwakeningMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("Strenght", Strenght);
			nbt.putDouble("Agility", Agility);
			nbt.putDouble("Aura", Aura);
			nbt.putDouble("Vitality", Vitality);
			nbt.putDouble("Soul", Soul);
			nbt.putDouble("Willpower", Willpower);
			nbt.putDouble("Demonic", Demonic);
			nbt.putDouble("Pure", Pure);
			nbt.putDouble("Vampirism", Vampirism);
			nbt.putDouble("Swordsmanship", Swordsmanship);
			nbt.putDouble("Concentration", Concentration);
			nbt.putDouble("Emission", Emission);
			nbt.putDouble("Transmutation", Transmutation);
			nbt.putDouble("Manipulation", Manipulation);
			nbt.putDouble("Domination", Domination);
			nbt.putDouble("MaxAura", MaxAura);
			nbt.putDouble("MaxHealth", MaxHealth);
			nbt.putDouble("karma", karma);
			nbt.putDouble("AuraType", AuraType);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			Strenght = nbt.getDouble("Strenght");
			Agility = nbt.getDouble("Agility");
			Aura = nbt.getDouble("Aura");
			Vitality = nbt.getDouble("Vitality");
			Soul = nbt.getDouble("Soul");
			Willpower = nbt.getDouble("Willpower");
			Demonic = nbt.getDouble("Demonic");
			Pure = nbt.getDouble("Pure");
			Vampirism = nbt.getDouble("Vampirism");
			Swordsmanship = nbt.getDouble("Swordsmanship");
			Concentration = nbt.getDouble("Concentration");
			Emission = nbt.getDouble("Emission");
			Transmutation = nbt.getDouble("Transmutation");
			Manipulation = nbt.getDouble("Manipulation");
			Domination = nbt.getDouble("Domination");
			MaxAura = nbt.getDouble("MaxAura");
			MaxHealth = nbt.getDouble("MaxHealth");
			karma = nbt.getDouble("karma");
			AuraType = nbt.getDouble("AuraType");
		}
	}

	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;

		public PlayerVariablesSyncMessage(FriendlyByteBuf buffer) {
			this.data = new PlayerVariables();
			this.data.readNBT(buffer.readNbt());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, FriendlyByteBuf buffer) {
			buffer.writeNbt((CompoundTag) message.data.writeNBT());
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()));
					variables.Strenght = message.data.Strenght;
					variables.Agility = message.data.Agility;
					variables.Aura = message.data.Aura;
					variables.Vitality = message.data.Vitality;
					variables.Soul = message.data.Soul;
					variables.Willpower = message.data.Willpower;
					variables.Demonic = message.data.Demonic;
					variables.Pure = message.data.Pure;
					variables.Vampirism = message.data.Vampirism;
					variables.Swordsmanship = message.data.Swordsmanship;
					variables.Concentration = message.data.Concentration;
					variables.Emission = message.data.Emission;
					variables.Transmutation = message.data.Transmutation;
					variables.Manipulation = message.data.Manipulation;
					variables.Domination = message.data.Domination;
					variables.MaxAura = message.data.MaxAura;
					variables.MaxHealth = message.data.MaxHealth;
					variables.karma = message.data.karma;
					variables.AuraType = message.data.AuraType;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
