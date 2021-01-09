package com.x_j0nnay_x.defincraft.enchantments;

import com.x_j0nnay_x.defincraft.definecraftCore;
import com.x_j0nnay_x.defincraft.util.RegHandler;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class flight extends Enchantment {



    public flight(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.ARMOR_HEAD, slots);
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
            if (living.abilities.isFlying != true) {
                living.abilities.allowFlying = true;
            } if (living.abilities.isFlying != true && living.isAirBorne) {
                living.fallDistance = 0f;
                living.isElytraFlying();
                living.getTicksElytraFlying(); }
            }

    }
}
