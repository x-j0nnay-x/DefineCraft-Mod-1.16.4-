package com.x_j0nnay_x.defincraft.items;

import com.x_j0nnay_x.defincraft.util.RegHandler;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShovelItem;
import net.minecraft.world.World;

public class customspade extends ShovelItem {
    public customspade(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);
    }

    public void onCreated(ItemStack par1ItemStack, World par2World, PlayerEntity par3EntityPlayer) {
        if (par1ItemStack.getStack().getItem() == RegHandler.OBSIDIANSPADE.get()) {
            par1ItemStack.addEnchantment(Enchantments.UNBREAKING, 2);
        }
        if (this.equals(RegHandler.HELLSTONESPADE.get())) {
            par1ItemStack.addEnchantment(Enchantments.MENDING, 2);
            par1ItemStack.addEnchantment(Enchantments.UNBREAKING, 3);
            par1ItemStack.addEnchantment(Enchantments.EFFICIENCY, 2);

        }
        if (this.equals(RegHandler.HELLSPAWNSPADE.get())) {
            par1ItemStack.addEnchantment(Enchantments.MENDING, 4);
            par1ItemStack.addEnchantment(Enchantments.UNBREAKING, 4);
            par1ItemStack.addEnchantment(Enchantments.EFFICIENCY, 4);
        }
    }
}
