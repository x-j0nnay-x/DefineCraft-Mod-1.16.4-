package com.x_j0nnay_x.defincraft.tools;

import com.x_j0nnay_x.defincraft.definecraftCore;
import com.x_j0nnay_x.defincraft.util.RegHandler;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum modarmor implements IArmorMaterial {

    Silver(definecraftCore.MODID + ":silver", 20, new int[]{2, 5, 7, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.5f, () ->
    {
        return Ingredient.fromItems(RegHandler.SILVERBAR.get());
    }, 0),
    Terbium(definecraftCore.MODID + ":terbium", 25, new int[]{3, 6, 7, 2}, 17, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.9f, () ->
    {
        return Ingredient.fromItems(RegHandler.TERBIUMBAR.get());
    }, 0),
    Obsidian(definecraftCore.MODID + ":obsidian", 30, new int[]{4, 6, 7, 4}, 24, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.9f, () ->
    {
        return Ingredient.fromItems(RegHandler.OBSIDIANBAR.get());
    }, 1),
    Hellstone(definecraftCore.MODID + ":hellstone", 40, new int[]{5, 7, 8, 5}, 30, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 4.5f, () ->
    {
        return Ingredient.fromItems(RegHandler.HELLSTONEBAR.get());
    }, 2),
    HellSpawn(definecraftCore.MODID + ":hellspawn", 40, new int[]{9, 11, 12, 9}, 30, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 4.5f, () ->
    {
        return Ingredient.fromItems(RegHandler.HELLSPAWNBAR.get());
    }, 3);

    private static final int[] MAX_DAMAGE_ARRAY = new int[]{11, 16, 15, 13};
    private final String name;
    private final int maxDamgaeFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Supplier<Ingredient> repairMaterial;
    private final float knockbackResestents;

    modarmor(String name, int maxDamgaeFactor, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, float toughness, Supplier<Ingredient> repairMaterial, float knockbackResestents) {
        this.name = name;
        this.maxDamgaeFactor = maxDamgaeFactor;
        this.damageReductionAmountArray = damageReductionAmountArray;
        this.enchantability = enchantability;
        this.soundEvent = soundEvent;
        this.toughness = toughness;
        this.repairMaterial = repairMaterial;
        this.knockbackResestents = knockbackResestents;
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamgaeFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.get();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResestents;
    }


}
