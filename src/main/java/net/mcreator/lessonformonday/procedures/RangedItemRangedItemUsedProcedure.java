package net.mcreator.lessonformonday.procedures;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.lessonformonday.item.RangedItemItem;
import net.mcreator.lessonformonday.LessonformondayModElements;

import java.util.Random;
import java.util.Map;

@LessonformondayModElements.ModElement.Tag
public class RangedItemRangedItemUsedProcedure extends LessonformondayModElements.ModElement {
	public RangedItemRangedItemUsedProcedure(LessonformondayModElements instance) {
		super(instance, 5);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure RangedItemRangedItemUsed!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure RangedItemRangedItemUsed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if (world instanceof World && !world.getWorld().isRemote && entity instanceof LivingEntity) {
			RangedItemItem.shoot(world.getWorld(), (LivingEntity) entity, new Random(), (float) 1, (float) 5, (int) 5);
		}
	}
}
