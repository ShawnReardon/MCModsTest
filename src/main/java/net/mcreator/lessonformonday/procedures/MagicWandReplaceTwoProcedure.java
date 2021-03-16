package net.mcreator.lessonformonday.procedures;

import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.state.IProperty;
import net.minecraft.server.MinecraftServer;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.item.ItemStack;
import net.minecraft.item.BlockItem;
import net.minecraft.entity.Entity;
import net.minecraft.block.Blocks;
import net.minecraft.block.BlockState;

import net.mcreator.lessonformonday.LessonformondayModElements;

import java.util.concurrent.atomic.AtomicReference;
import java.util.Map;

@LessonformondayModElements.ModElement.Tag
public class MagicWandReplaceTwoProcedure extends LessonformondayModElements.ModElement {
	public MagicWandReplaceTwoProcedure(LessonformondayModElements instance) {
		super(instance, 7);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure MagicWandReplaceTwo!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				System.err.println("Failed to load dependency world for procedure MagicWandReplaceTwo!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		double blockX = 0;
		double blockY = 0;
		double blockZ = 0;
		blockX = (double) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
				entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100, entity.getLook(1f).z * 100),
				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getX());
		blockY = (double) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
				entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100, entity.getLook(1f).z * 100),
				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getY());
		blockZ = (double) (entity.world.rayTraceBlocks(new RayTraceContext(entity.getEyePosition(1f),
				entity.getEyePosition(1f).add(entity.getLook(1f).x * 100, entity.getLook(1f).y * 100, entity.getLook(1f).z * 100),
				RayTraceContext.BlockMode.OUTLINE, RayTraceContext.FluidMode.NONE, entity)).getPos().getZ());
		{
			BlockPos _bp = new BlockPos((int) (blockX), (int) (blockY), (int) (blockZ));
			BlockState _bs = /* @BlockState */(new Object() {
				public BlockState toBlock(ItemStack _stk) {
					if (_stk.getItem() instanceof BlockItem) {
						return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
					}
					return Blocks.AIR.getDefaultState();
				}
			}.toBlock((new Object() {
				public ItemStack getItemStack(int sltid, Entity entity) {
					AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
					entity.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null).ifPresent(capability -> {
						_retval.set(capability.getStackInSlot(sltid).copy());
					});
					return _retval.get();
				}
			}.getItemStack((int) (0), entity))));
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
		if (((new ItemStack((world.getBlockState(new BlockPos((int) (blockX), (int) (blockY), (int) (blockZ)))).getBlock()))
				.getItem() == new ItemStack(Blocks.AIR, (int) (1)).getItem())) {
			{
				BlockPos _bp = new BlockPos((int) (blockX), (int) (blockY), (int) (blockZ));
				BlockState _bs = /* @BlockState */(new Object() {
					public BlockState toBlock(ItemStack _stk) {
						if (_stk.getItem() instanceof BlockItem) {
							return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
						}
						return Blocks.AIR.getDefaultState();
					}
				}.toBlock(new ItemStack(Blocks.MAGENTA_GLAZED_TERRACOTTA, (int) (1))));
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
		} else if (((new ItemStack((world.getBlockState(new BlockPos((int) (blockX), (int) (blockY), (int) (blockZ)))).getBlock()))
				.getItem() == new ItemStack(Blocks.VOID_AIR, (int) (1)).getItem())) {
			{
				BlockPos _bp = new BlockPos((int) (blockX), (int) (blockY), (int) (blockZ));
				BlockState _bs = /* @BlockState */(new Object() {
					public BlockState toBlock(ItemStack _stk) {
						if (_stk.getItem() instanceof BlockItem) {
							return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
						}
						return Blocks.AIR.getDefaultState();
					}
				}.toBlock(new ItemStack(Blocks.MAGENTA_GLAZED_TERRACOTTA, (int) (1))));
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
		} else if (((new ItemStack((world.getBlockState(new BlockPos((int) (blockX), (int) (blockY), (int) (blockZ)))).getBlock()))
				.getItem() == new ItemStack(Blocks.CAVE_AIR, (int) (1)).getItem())) {
			{
				BlockPos _bp = new BlockPos((int) (blockX), (int) (blockY), (int) (blockZ));
				BlockState _bs = /* @BlockState */(new Object() {
					public BlockState toBlock(ItemStack _stk) {
						if (_stk.getItem() instanceof BlockItem) {
							return ((BlockItem) _stk.getItem()).getBlock().getDefaultState();
						}
						return Blocks.AIR.getDefaultState();
					}
				}.toBlock(new ItemStack(Blocks.MAGENTA_GLAZED_TERRACOTTA, (int) (1))));
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
		} else {
			{
				MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
				if (mcserv != null)
					mcserv.getPlayerList().sendMessage(new StringTextComponent("FAILED"));
			}
		}
	}
}
