package com.x_j0nnay_x.defincraft.enchantments;

import com.x_j0nnay_x.defincraft.definecraftCore;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class godmode extends Enchantment {



    public godmode(Rarity rarityIn, EquipmentSlotType... slots) {
        super(rarityIn, EnchantmentType.ARMOR_HEAD, slots);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }


    @Mod.EventBusSubscriber(modid = definecraftCore.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class godmodeEquiped {


        @SubscribeEvent
        public static void godmodeallowed(TickEvent.PlayerTickEvent event) {
            PlayerEntity living = event.player;
            World worldIn = living.world;
            if (living.isBurning() && living.getFireTimer() >= 0) {
                living.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 100, 4, false, false, true));
                living.extinguish();}
            if (living.isInWater() == true) {
                living.setAir(300); }
            if (living.getHealth() <= .5*living.getMaxHealth()){
                living.addPotionEffect(new EffectInstance(Effects.REGENERATION, 100, 4, false, false, true));
                living.addPotionEffect(new EffectInstance(Effects.STRENGTH, 100, 4, false, false, true));}


        }}
}
