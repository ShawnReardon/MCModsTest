package net.mcreator.lessonformonday.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.item.FireworkRocketEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Entity;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.block.Blocks;

import net.mcreator.lessonformonday.enchantment.EwanEnchantment;
import net.mcreator.lessonformonday.LessonformondayModElements;

import java.util.Map;

@LessonformondayModElements.ModElement.Tag
public class RapidswordLivingEntityIsHitWithToolProcedure extends LessonformondayModElements.ModElement {
	public RapidswordLivingEntityIsHitWithToolProcedure(LessonformondayModElements instance) {
		super(instance, 2);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure RapidswordLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure RapidswordLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure RapidswordLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure RapidswordLivingEntityIsHitWithTool!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure RapidswordLivingEntityIsHitWithTool!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		ItemStack itemInHand = ItemStack.EMPTY;
		{
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().sendMessage(new StringTextComponent("USED"));
		}
		if (world instanceof ServerWorld)
			((ServerWorld) world).addLightningBolt(new LightningBoltEntity(world.getWorld(),
					(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * 50, entity.getLook(1f).y * 50, entity.getLook(1f).z * 50),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
					(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * 50, entity.getLook(1f).y * 50, entity.getLook(1f).z * 50),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
					(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * 50, entity.getLook(1f).y * 50, entity.getLook(1f).z * 50),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()),
					false));
		if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
			ArrowEntity entityToSpawn = new ArrowEntity(world.getWorld(), (LivingEntity) entity);
			entityToSpawn.shoot(entity.getLookVec().x, entity.getLookVec().y, entity.getLookVec().z, (float) 1, 0);
			entityToSpawn.setDamage((float) 5);
			entityToSpawn.setKnockbackStrength((int) 5);
			world.addEntity(entityToSpawn);
		}
		if ((((itemInHand).getItem() == new ItemStack(Blocks.TNT, (int) (1)).getItem())
				&& ((EnchantmentHelper.getEnchantmentLevel(EwanEnchantment.enchantment, (itemInHand))) > 0))) {
			if (world instanceof World && !world.getWorld().isRemote) {
				Entity entityToSpawn = new FireworkRocketEntity(EntityType.FIREWORK_ROCKET, world.getWorld());
				entityToSpawn.setLocationAndAngles(x, y, z, world.getRandom().nextFloat() * 360F, 0);
				if (entityToSpawn instanceof MobEntity)
					((MobEntity) entityToSpawn).onInitialSpawn(world, world.getDifficultyForLocation(new BlockPos(entityToSpawn)),
							SpawnReason.MOB_SUMMONED, (ILivingEntityData) null, (CompoundNBT) null);
				world.addEntity(entityToSpawn);
			}
		}
	}
}
