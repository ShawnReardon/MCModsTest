package net.mcreator.lessonformonday.procedures;

import net.minecraft.util.Hand;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.lessonformonday.LessonformondayModElements;

import java.util.Map;

@LessonformondayModElements.ModElement.Tag
public class RapidswordEntitySwingsItemProcedure extends LessonformondayModElements.ModElement {
	public RapidswordEntitySwingsItemProcedure(LessonformondayModElements instance) {
		super(instance, 1);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure RapidswordEntitySwingsItem!");
			return;
		}
		if (dependencies.get("itemstack") == null) {
			if (!dependencies.containsKey("itemstack"))
				System.err.println("Failed to load dependency itemstack for procedure RapidswordEntitySwingsItem!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		ItemStack itemstack = (ItemStack) dependencies.get("itemstack");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).getCooldownTracker().setCooldown(((itemstack)).getItem(), (int) 100);
		if (entity instanceof LivingEntity) {
			((LivingEntity) entity).swing(Hand.MAIN_HAND, true);
		}
	}
}
