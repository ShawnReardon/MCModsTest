package net.mcreator.lessonformonday.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.entity.Entity;
import net.minecraft.entity.AgeableEntity;

import net.mcreator.lessonformonday.LessonformondayModElements;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;
import net.minecraft.entity.LivingEntity;

@LessonformondayModElements.ModElement.Tag
public class RapidswordGetAttackTargetProcedure extends LessonformondayModElements.ModElement {
	public RapidswordGetAttackTargetProcedure(LessonformondayModElements instance) {
		super(instance, 18);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure RapidswordGetAttackTarget!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure RapidswordGetAttackTarget!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		((Entity) world
				.getEntitiesWithinAABB(AgeableEntity.class,
						new AxisAlignedBB(
								(entity.world.rayTraceBlocks(
										new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100,
														entity.getLook(1f).z * 100),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getX()) - (415 / 2d),
								(entity.world
										.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f)
														.add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100, entity.getLook(1f).z * 100),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getY())
										- (415 / 2d),
								(entity.world
										.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f)
														.add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100, entity.getLook(1f).z * 100),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getZ())
										- (415 / 2d),
								(entity.world
										.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f)
														.add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100, entity.getLook(1f).z * 100),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getX()) + (415 / 2d),
								(entity.world
										.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
												entity.getEyePosition(1f)
														.add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100, entity.getLook(1f).z * 100),
												RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity))
										.getPos().getY()) + (415 / 2d),
								(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
										entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100,
												entity.getLook(1f).z * 100),
										RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()) + (415 / 2d)),
						null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf(
						(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100, entity.getLook(1f).z * 100),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
						(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100, entity.getLook(1f).z * 100),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
						(entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
								entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100, entity.getLook(1f).z * 100),
								RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ())))
				.findFirst().orElse((AgeableEntity) entity)).attackEntityFrom(DamageSource.GENERIC, (float) 50);
	}
}
