package com.x_j0nnay_x.defincraft.enchantments;

import com.x_j0nnay_x.defincraft.definecraftCore;
import com.x_j0nnay_x.defincraft.util.RegHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class LiquidWalker extends Enchantment {

    public LiquidWalker(Enchantment.Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.ARMOR_FEET, slots);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }

    @Override
    public boolean canApplyTogether(Enchantment ench) {
        return super.canApplyTogether(ench) && ench != Enchantments.DEPTH_STRIDER;
    }
    @Mod.EventBusSubscriber(modid = definecraftCore.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class EnchantmentEquiped {
        @SubscribeEvent
        public static void ChangeNearByLava(TickEvent.PlayerTickEvent event ) {
            PlayerEntity living = event.player;
            World worldIn = living.world;
            BlockPos pos = living.getPosition();
            if (living.isOnGround()) {
                if (living.hasItemInSlot(EquipmentSlotType.FEET)
                        && EnchantmentHelper.getEnchantmentLevel(RegHandler.LiquidWalker.get(),
                        living.getItemStackFromSlot(EquipmentSlotType.FEET)) > 0) {

                    BlockState blockstate = RegHandler.MELTINGOBSIDIANL.get().getDefaultState();
                    float f = (float) Math.min(16, 2);
                    BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

                    for (BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add((double) (-f), -1.0D, (double) (-f)), pos.add((double) f, -1.0D, (double) f))) {
                        if (blockpos.withinDistance(living.getPositionVec(), (double) f)) {
                            blockpos$mutable.setPos(blockpos.getX(), blockpos.getY() + 1, blockpos.getZ());
                            BlockState blockstate1 = worldIn.getBlockState(blockpos$mutable);
                            if (blockstate1.isAir(worldIn, blockpos$mutable)) {
                                BlockState blockstate2 = worldIn.getBlockState(blockpos);
                                boolean isFull = blockstate2.getBlock() == Blocks.LAVA && blockstate2.get(FlowingFluidBlock.LEVEL) == 0;
                                if (blockstate2.getMaterial() == Material.LAVA && isFull && blockstate.isValidPosition(worldIn, blockpos) && worldIn.placedBlockCollides(blockstate, blockpos, ISelectionContext.dummy()) && !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(living, net.minecraftforge.common.util.BlockSnapshot.create(worldIn.getDimensionKey(), worldIn, blockpos), net.minecraft.util.Direction.UP)) {
                                    worldIn.setBlockState(blockpos, blockstate);
                                    worldIn.getPendingBlockTicks().scheduleTick(blockpos, RegHandler.MELTINGOBSIDIANL.get(), MathHelper.nextInt(living.getRNG(), 60, 120));
                                }
                            }
                        }
                    }
                }
            }
        }
        @SubscribeEvent
        public static void ChangeNearByWater(TickEvent.PlayerTickEvent event ) {
            PlayerEntity living = event.player;
            World worldIn = living.world;
            BlockPos pos = living.getPosition();
            if (living.isOnGround()) {
                if (living.hasItemInSlot(EquipmentSlotType.FEET)
                        && EnchantmentHelper.getEnchantmentLevel(RegHandler.LiquidWalker.get(),
                        living.getItemStackFromSlot(EquipmentSlotType.FEET)) > 0) {

                    BlockState blockstate = RegHandler.MELTINGOBSIDIANW.get().getDefaultState();
                    float f = (float) Math.min(16, 2);
                    BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

                    for (BlockPos blockpos : BlockPos.getAllInBoxMutable(pos.add((double) (-f), -1.0D, (double) (-f)), pos.add((double) f, -1.0D, (double) f))) {
                        if (blockpos.withinDistance(living.getPositionVec(), (double) f)) {
                            blockpos$mutable.setPos(blockpos.getX(), blockpos.getY() + 1, blockpos.getZ());
                            BlockState blockstate1 = worldIn.getBlockState(blockpos$mutable);
                            if (blockstate1.isAir(worldIn, blockpos$mutable)) {
                                BlockState blockstate2 = worldIn.getBlockState(blockpos);
                                boolean isFull = blockstate2.getBlock() == Blocks.WATER && blockstate2.get(FlowingFluidBlock.LEVEL) == 0;
                                if (blockstate2.getMaterial() == Material.WATER && isFull && blockstate.isValidPosition(worldIn, blockpos) && worldIn.placedBlockCollides(blockstate, blockpos, ISelectionContext.dummy()) && !net.minecraftforge.event.ForgeEventFactory.onBlockPlace(living, net.minecraftforge.common.util.BlockSnapshot.create(worldIn.getDimensionKey(), worldIn, blockpos), net.minecraft.util.Direction.UP)) {
                                    worldIn.setBlockState(blockpos, blockstate);
                                    worldIn.getPendingBlockTicks().scheduleTick(blockpos, RegHandler.MELTINGOBSIDIANW.get(), MathHelper.nextInt(living.getRNG(), 60, 120));
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}
