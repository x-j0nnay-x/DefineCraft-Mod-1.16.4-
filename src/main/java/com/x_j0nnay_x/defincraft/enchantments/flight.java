package com.x_j0nnay_x.defincraft.enchantments;

import com.x_j0nnay_x.defincraft.definecraftCore;
import com.x_j0nnay_x.defincraft.util.RegHandler;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.jar.Attributes;

public class flight extends Enchantment {



    public flight(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.ARMOR_CHEST, slots);
    }

    @Override
    public int getMinEnchantability(int enchantmentLevel) {
        return enchantmentLevel * 10;
    }
    @Override
    public int getMaxEnchantability(int enchantmentLevel) {
        return this.getMinEnchantability(enchantmentLevel) + 15;
    }
    @Override
    public int getMaxLevel() {
        return 1;
    }


    @Mod.EventBusSubscriber(modid = definecraftCore.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class FlightEquiped {


        @SubscribeEvent
        public static void allowflight(TickEvent.PlayerTickEvent event) {
            PlayerEntity living = event.player;
            World worldIn = living.world;
                if (EnchantmentHelper.getEnchantmentLevel(RegHandler.Flight.get(),
                     living.getItemStackFromSlot(EquipmentSlotType.CHEST)) >0 &&
                        living.hasItemInSlot(EquipmentSlotType.CHEST)) {
                             if (living.abilities.allowFlying != true) {
                                 living.abilities.allowFlying = true;
                                 living.abilities.setFlySpeed(0.15f); }
                            if (living.abilities.isFlying != true && living.isAirBorne) {
                                living.fallDistance = 0f; }
                }else{
                    living.abilities.allowFlying = false;
                }
        }
    }
}
