package net.mcreator.lessonformonday.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.IProperty;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.lessonformonday.LessonformondayModElements;

import java.util.Map;

@LessonformondayModElements.ModElement.Tag
public class MagicWandReplaceProcedure extends LessonformondayModElements.ModElement {
	public MagicWandReplaceProcedure(LessonformondayModElements instance) {
		super(instance, 6);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure MagicWandReplace!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure MagicWandReplace!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		{
			BlockPos _bp = new BlockPos(
					(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100, entity.getLook(1f).z * 100),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX()),
					(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100, entity.getLook(1f).z * 100),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY()),
					(int) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
							entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100, entity.getLook(1f).z * 100),
							RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ()));
			BlockState _bs = /* @BlockState */(new Object() {
				public BlockState toBlock(ItemStack _stk) {
					if (_stk.getItem() instanceof BlockItem) {
						return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
					}
					return Blocks.AIR.getDefaultState();
				}
			}.toBlock(((entity instanceof LivingEntity) ? ((LivingEntity) entity).getHeldItemOffhand() : ItemStack.EMPTY)));
			BlockState _bso = world.getBlockState(_bp);
			for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
				IProperty _property = _bs.getBlock().getStateContainer().getProperty(entry.getKey().getName());
				if (_bs.has(_property))
					_bs = _bs.with(_property, (Comparable) entry.getValue());
			}
			TileEntity _te = world.getTileEntity(_bp);
			CompoundNBT _bnbt = null;
			if (_te != null) {
				_bnbt = _te.write(new CompoundNBT());
				_te.remove();
			}
			world.setBlockState(_bp, _bs, 3);
			if (_bnbt != null) {
				_te = world.getTileEntity(_bp);
				if (_te != null) {
					try {
						_te.read(_bnbt);
					} catch (Exception ignored) {
					}
				}
			}
		}
	}
}
