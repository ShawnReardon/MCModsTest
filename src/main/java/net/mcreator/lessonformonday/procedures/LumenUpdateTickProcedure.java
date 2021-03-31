package net.mcreator.lessonformonday.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.lessonformonday.LessonformondayModElements;

import java.util.Map;

@LessonformondayModElements.ModElement.Tag
public class LumenUpdateTickProcedure extends LessonformondayModElements.ModElement {
	public LumenUpdateTickProcedure(LessonformondayModElements instance) {
		super(instance, 27);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure LumenUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure LumenUpdateTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		if ((!(world.getWorld().isDaytime()))) {
			if (entity instanceof LivingEntity) {
				entity.setNoGravity((true));
			}
		}
	}
}
