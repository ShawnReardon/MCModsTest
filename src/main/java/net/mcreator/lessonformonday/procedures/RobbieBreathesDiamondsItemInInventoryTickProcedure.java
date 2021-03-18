package net.mcreator.lessonformonday.procedures;

import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.lessonformonday.item.RobbieBreathesDiamondsItem;
import net.mcreator.lessonformonday.LessonformondayModElements;

import java.util.Map;

@LessonformondayModElements.ModElement.Tag
public class RobbieBreathesDiamondsItemInInventoryTickProcedure extends LessonformondayModElements.ModElement {
	public RobbieBreathesDiamondsItemInInventoryTickProcedure(LessonformondayModElements instance) {
		super(instance, 20);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure RobbieBreathesDiamondsItemInInventoryTick!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).abilities.allowFlying = (((entity instanceof LivingEntity)
					? ((LivingEntity) entity).getHeldItemMainhand()
					: ItemStack.EMPTY).getItem() == new ItemStack(RobbieBreathesDiamondsItem.block, (int) (1)).getItem());
			((PlayerEntity) entity).sendPlayerAbilities();
		}
	}
}
