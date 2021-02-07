package com.x_j0nnay_x.defincraft.items;

import com.x_j0nnay_x.defincraft.util.RegHandler;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.IItemTier;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class customaxe extends AxeItem {


    public customaxe(IItemTier tier, float attackDamageIn, float attackSpeedIn, Properties builder) {
        super(tier, attackDamageIn, attackSpeedIn, builder);

    }

    public void onCreated(ItemStack par1ItemStack, World par2World, PlayerEntity par3EntityPlayer) {

        if (this.equals(RegHandler.OBSIDIANAXE.get())) {
            par1ItemStack.addEnchantment(Enchantments.UNBREAKING, 2);
        }
        if (this.equals(RegHandler.HELLSTONEAXE.get())) {
            par1ItemStack.addEnchantment(Enchantments.MENDING, 2);
            par1ItemStack.addEnchantment(Enchantments.UNBREAKING, 2);
            par1ItemStack.addEnchantment(Enchantments.EFFICIENCY, 2);

        }
        if (this.equals(RegHandler.HELLSPAWNAXE.get())) {
            par1ItemStack.addEnchantment(Enchantments.MENDING, 4);
            par1ItemStack.addEnchantment(Enchantments.UNBREAKING, 4);
            par1ItemStack.addEnchantment(Enchantments.SHARPNESS, 4);
            par1ItemStack.addEnchantment(Enchantments.EFFICIENCY, 4);


        }
    }

    @Override
    public boolean isImmuneToFire() {
        if (this.equals(RegHandler.OBSIDIANAXE.get())){
            return true;
        }
        if (this.equals(RegHandler.HELLSTONEAXE.get())){
            return true;
        }
        if (this.equals(RegHandler.HELLSPAWNAXE.get())){
            return true;
        }
        else{
            return false;
        }
    }
}
