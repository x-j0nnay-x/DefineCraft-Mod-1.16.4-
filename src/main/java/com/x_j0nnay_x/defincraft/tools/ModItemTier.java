package com.x_j0nnay_x.defincraft.tools;

import com.x_j0nnay_x.defincraft.util.RegHandler;
import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ModItemTier implements IItemTier {

    Silver(2, 350, 7.0f, 3.0f, 15, () -> {
        return Ingredient.fromItems(RegHandler.SILVERBAR.get());
    }),

    Terbium(3, 550, 7.5f, 3.5f, 17, () -> {
        return Ingredient.fromItems(RegHandler.TERBIUMBAR.get());
    }),

    Obsidian(4, 2000, 8.0f, 4.3f, 38, () -> {
        return Ingredient.fromItems(RegHandler.OBSIDIANBAR.get());
    }),
    Hellstone(5, 4000, 9.0f, 5.5f, 50, () -> {
        return Ingredient.fromItems(RegHandler.HELLSTONEBAR.get());
    }),
    Hellspawn(6, 6000, 14.0f, 8.5f, 50, () -> {
        return Ingredient.fromItems(RegHandler.HELLSPAWNBAR.get());
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repirMaterial;

    ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repirMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repirMaterial = repirMaterial;
    }

    @Override
    public int getMaxUses() {
        return maxUses;
    }

    @Override
    public float getEfficiency() {
        return efficiency;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repirMaterial.get();
    }
}
