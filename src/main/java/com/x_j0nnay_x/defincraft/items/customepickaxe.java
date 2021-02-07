package com.x_j0nnay_x.defincraft.items;

import com.x_j0nnay_x.defincraft.util.RegHandler;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.world.World;

public class customepickaxe extends PickaxeItem {
    public customepickaxe(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    public void onCreated(ItemStack par1ItemStack, World par2World, PlayerEntity par3EntityPlayer) {
        if (this.equals(RegHandler.OBSIDIANPICKAXE.get())) {
            par1ItemStack.addEnchantment(Enchantments.UNBREAKING, 2);
        }
        if (this.equals(RegHandler.HELLSTONEPICKAXE.get())) {
            par1ItemStack.addEnchantment(Enchantments.MENDING, 2);
            par1ItemStack.addEnchantment(Enchantments.UNBREAKING, 3);
        }
        if (this.equals(RegHandler.HELLSPAWNPICKAXE.get())) {
            par1ItemStack.addEnchantment(Enchantments.MENDING, 4);
            par1ItemStack.addEnchantment(Enchantments.UNBREAKING, 4);
            par1ItemStack.addEnchantment(Enchantments.FORTUNE, 3);

        }
    }
    @Override
    public boolean isImmuneToFire() {
        return true;
    }
}
