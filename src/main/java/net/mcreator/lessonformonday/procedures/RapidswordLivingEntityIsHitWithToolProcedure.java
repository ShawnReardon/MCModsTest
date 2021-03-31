package net.mcreator.lessonformonday.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.server.MinecraftServer;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;

import net.mcreator.lessonformonday.enchantment.EwanEnchantment;
import net.mcreator.lessonformonday.LessonformondayModElements;

import java.util.Map;
import java.util.HashMap;

@LessonformondayModElements.ModElement.Tag
public class RapidswordLivingEntityIsHitWithToolProcedure extends LessonformondayModElements.ModElement {
	public RapidswordLivingEntityIsHitWithToolProcedure(LessonformondayModElements instance) {
		super(instance, 2);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure RapidswordLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemInHand = ItemStack.EMPTY;
		boolean player = false;
		String EvilDoer = "";
		String players = "";
		if ((!(((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) == (null)))) {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("USED"));
			}
			itemInHand = ((((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) instanceof LivingEntity)
					? ((LivingEntity) ((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null)).getHeldItemMainhand()
					: ItemStack.EMPTY);
			if (((EnchantmentHelper.getEnchantmentLevel(EwanEnchantment.enchantment, (itemInHand))) > 0)) {
				if (((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null) instanceof LivingEntity)
					((LivingEntity) ((entity instanceof MobEntity) ? ((MobEntity) entity).getAttackTarget() : null))
							.setHealth((float) (((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHealth() : -1) + 50));
				{
					MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
					if (mcserv != null)
						mcserv.getPlayerList().sendMessage(new StringTextComponent("EXECUTED"));
				}
			}
		}
	}

	@SubscribeEvent
	public void onEntityAttacked(LivingAttackEvent event) {
		if (event != null && event.getEntity() != null) {
			Entity entity = event.getEntity();
			Entity sourceentity = event.getSource().getTrueSource();
			Entity imediatesourceentity = event.getSource().getImmediateSource();
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			double amount = event.getAmount();
			World world = entity.world;
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("amount", amount);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("sourceentity", sourceentity);
			dependencies.put("imediatesourceentity", imediatesourceentity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
