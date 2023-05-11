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
			clone.Swordsmanship = original.Swordsmanship;
			clone.Strenght = original.Strenght;
			clone.Emission = original.Emission;
			clone.Concentration = original.Concentration;
			clone.Vitality = original.Vitality;
			clone.Demonic = original.Demonic;
			clone.Domination = original.Domination;
			clone.Soul = original.Soul;
			clone.Manipulation = original.Manipulation;
			clone.Agility = original.Agility;
			clone.Transmutation = original.Transmutation;
			clone.Willpower = original.Willpower;
			clone.Aura = original.Aura;
			clone.Pure = original.Pure;
			clone.Vampirism = original.Vampirism;
			clone.MaxAura = original.MaxAura;
			clone.MaxHealth = original.MaxHealth;
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
		public double Swordsmanship = 0;
		public double Strenght = 1.0;
		public double Emission = 0;
		public double Concentration = 0;
		public double Vitality = 0;
		public double Demonic = 0.0;
		public double Domination = 0;
		public double Soul = 0;
		public double Manipulation = 0;
		public double Agility = 0;
		public double Transmutation = 0;
		public double Willpower = 0;
		public double Aura = 1.0;
		public double Pure = 0.0;
		public double Vampirism = 0;
		public double MaxAura = 10.0;
		public double MaxHealth = 20.0;

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				AwakeningMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> serverPlayer), new PlayerVariablesSyncMessage(this));
		}

		public Tag writeNBT() {
			CompoundTag nbt = new CompoundTag();
			nbt.putDouble("Swordsmanship", Swordsmanship);
			nbt.putDouble("Strenght", Strenght);
			nbt.putDouble("Emission", Emission);
			nbt.putDouble("Concentration", Concentration);
			nbt.putDouble("Vitality", Vitality);
			nbt.putDouble("Demonic", Demonic);
			nbt.putDouble("Domination", Domination);
			nbt.putDouble("Soul", Soul);
			nbt.putDouble("Manipulation", Manipulation);
			nbt.putDouble("Agility", Agility);
			nbt.putDouble("Transmutation", Transmutation);
			nbt.putDouble("Willpower", Willpower);
			nbt.putDouble("Aura", Aura);
			nbt.putDouble("Pure", Pure);
			nbt.putDouble("Vampirism", Vampirism);
			nbt.putDouble("MaxAura", MaxAura);
			nbt.putDouble("MaxHealth", MaxHealth);
			return nbt;
		}

		public void readNBT(Tag Tag) {
			CompoundTag nbt = (CompoundTag) Tag;
			Swordsmanship = nbt.getDouble("Swordsmanship");
			Strenght = nbt.getDouble("Strenght");
			Emission = nbt.getDouble("Emission");
			Concentration = nbt.getDouble("Concentration");
			Vitality = nbt.getDouble("Vitality");
			Demonic = nbt.getDouble("Demonic");
			Domination = nbt.getDouble("Domination");
			Soul = nbt.getDouble("Soul");
			Manipulation = nbt.getDouble("Manipulation");
			Agility = nbt.getDouble("Agility");
			Transmutation = nbt.getDouble("Transmutation");
			Willpower = nbt.getDouble("Willpower");
			Aura = nbt.getDouble("Aura");
			Pure = nbt.getDouble("Pure");
			Vampirism = nbt.getDouble("Vampirism");
			MaxAura = nbt.getDouble("MaxAura");
			MaxHealth = nbt.getDouble("MaxHealth");
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
					variables.Swordsmanship = message.data.Swordsmanship;
					variables.Strenght = message.data.Strenght;
					variables.Emission = message.data.Emission;
					variables.Concentration = message.data.Concentration;
					variables.Vitality = message.data.Vitality;
					variables.Demonic = message.data.Demonic;
					variables.Domination = message.data.Domination;
					variables.Soul = message.data.Soul;
					variables.Manipulation = message.data.Manipulation;
					variables.Agility = message.data.Agility;
					variables.Transmutation = message.data.Transmutation;
					variables.Willpower = message.data.Willpower;
					variables.Aura = message.data.Aura;
					variables.Pure = message.data.Pure;
					variables.Vampirism = message.data.Vampirism;
					variables.MaxAura = message.data.MaxAura;
					variables.MaxHealth = message.data.MaxHealth;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
