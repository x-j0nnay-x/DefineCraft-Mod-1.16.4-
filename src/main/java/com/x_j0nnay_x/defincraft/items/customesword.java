package com.x_j0nnay_x.defincraft.items;

import com.x_j0nnay_x.defincraft.util.RegHandler;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.world.World;

public class customesword extends SwordItem {
    public customesword(IItemTier tier, int attackDamageIn, float attackSpeedIn, Properties builderIn) {
        super(tier, attackDamageIn, attackSpeedIn, builderIn);
    }

    public void onCreated(ItemStack par1ItemStack, World par2World, PlayerEntity par3EntityPlayer) {
        if (this.equals(RegHandler.OBSIDIANSWORD.get())) {
            par1ItemStack.addEnchantment(Enchantments.UNBREAKING, 2);
            par1ItemStack.addEnchantment(Enchantments.FIRE_ASPECT, 1);
            par1ItemStack.addEnchantment(Enchantments.SHARPNESS, 1);
        }
        if (this.equals(RegHandler.HELLSTONESWORD.get())) {
            par1ItemStack.addEnchantment(Enchantments.MENDING, 2);
            par1ItemStack.addEnchantment(Enchantments.UNBREAKING, 3);
            par1ItemStack.addEnchantment(Enchantments.FIRE_ASPECT, 3);
            par1ItemStack.addEnchantment(Enchantments.SHARPNESS, 3);
            par1ItemStack.addEnchantment(Enchantments.LOOTING, 2);
        }
        if (this.equals(RegHandler.HELLSPAWNSWORD.get())) {
            par1ItemStack.addEnchantment(Enchantments.MENDING, 4);
            par1ItemStack.addEnchantment(Enchantments.UNBREAKING, 4);
            par1ItemStack.addEnchantment(Enchantments.FIRE_ASPECT, 4);
            par1ItemStack.addEnchantment(Enchantments.KNOCKBACK, 4);
            par1ItemStack.addEnchantment(Enchantments.SHARPNESS, 4);
            par1ItemStack.addEnchantment(Enchantments.LOOTING, 4);
        }
    }
}
