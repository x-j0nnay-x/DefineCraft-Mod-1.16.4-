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
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class lightbringer extends Enchantment {



    public lightbringer(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.ARMOR_HEAD, slots);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }


    @Mod.EventBusSubscriber(modid = definecraftCore.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class LightBringerEquiped {


        @SubscribeEvent
        public static void placeLight(TickEvent.PlayerTickEvent event) {
            PlayerEntity living = event.player;
            World worldIn = living.world;
            BlockPos pos = living.getPosition().add(0,1,0);
            BlockState blockstate = RegHandler.VANISHINGLIGHT.get().getDefaultState();
            if (living.isOnGround()){
                if (living.hasItemInSlot(EquipmentSlotType.HEAD)
                   && EnchantmentHelper.getEnchantmentLevel(RegHandler.LightBringer.get(),
                    living.getItemStackFromSlot(EquipmentSlotType.HEAD)) > 0){
                    if (worldIn.getLight(pos) <= 4){
                       worldIn.setBlockState(pos, blockstate);
                    }}
                }
            }

    }
}
