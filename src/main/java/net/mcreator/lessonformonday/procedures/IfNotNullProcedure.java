package net.mcreator.lessonformonday.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.entity.Entity;
import net.minecraft.entity.AgeableEntity;

import net.mcreator.lessonformonday.LessonformondayModElements;

import java.util.function.Function;
import java.util.Map;
import java.util.Comparator;

@LessonformondayModElements.ModElement.Tag
public class IfNotNullProcedure extends LessonformondayModElements.ModElement {
	public IfNotNullProcedure(LessonformondayModElements instance) {
		super(instance, 16);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				System.err.println("Failed to load dependency x for procedure IfNotNull!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				System.err.println("Failed to load dependency y for procedure IfNotNull!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				System.err.println("Failed to load dependency z for procedure IfNotNull!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure IfNotNull!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		((Entity) world
				.getEntitiesWithinAABB(AgeableEntity.class,
						new AxisAlignedBB(x - (50 / 2d), y - (50 / 2d), z - (50 / 2d), x + (50 / 2d), y + (50 / 2d), z + (50 / 2d)), null)
				.stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparing((Function<Entity, Double>) (_entcnd -> _entcnd.getDistanceSq(_x, _y, _z)));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).setMotion(0, 0, 0);
	}
}
