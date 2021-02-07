package com.x_j0nnay_x.defincraft.items;

import com.x_j0nnay_x.defincraft.util.RegHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class customHoe extends HoeItem {
    public customHoe(IItemTier itemTier, int attackDamage, float attackSpeed, Properties properties) {
        super(itemTier, attackDamage, attackSpeed, properties);
    }

    public void onCreated(ItemStack par1ItemStack, World par2World, PlayerEntity par3EntityPlayer) {
        if (this.equals(RegHandler.OBSIDIANHOE.get())) {
            par1ItemStack.addEnchantment(Enchantments.UNBREAKING, 2);
        }
        if (this.equals(RegHandler.HELLSTONEHOE.get())) {
            par1ItemStack.addEnchantment(Enchantments.MENDING, 2);
            par1ItemStack.addEnchantment(Enchantments.UNBREAKING, 2);
        }
        if (this.equals(RegHandler.HELLSPAWNHOE.get())) {
            par1ItemStack.addEnchantment(Enchantments.MENDING, 4);
            par1ItemStack.addEnchantment(Enchantments.UNBREAKING, 4);
        }
    }
    @Override
    public boolean isImmuneToFire() {
        return true;
    }
}
