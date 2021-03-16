
package net.mcreator.lessonformonday.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.mcreator.lessonformonday.LessonformondayModElements;

@LessonformondayModElements.ModElement.Tag
public class MusictestrItem extends LessonformondayModElements.ModElement {
	@ObjectHolder("lessonformonday:musictestr")
	public static final Item block = null;
	public MusictestrItem(LessonformondayModElements instance) {
		super(instance, 10);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, LessonformondayModElements.sounds.get(new ResourceLocation("lessonformonday:galaxy")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("musictestr");
		}
	}
}
