package com.x_j0nnay_x.defincraft.items;


import com.x_j0nnay_x.defincraft.util.RegHandler;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;


public class customearmor extends ArmorItem {
    public customearmor(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builderIn, int toollevel) {
        super(materialIn, slot, builderIn);
        this.ArmorLevel = toollevel;
    }
    private  int ArmorLevel;
    public void onCreated(ItemStack par1ItemStack, World par2World, PlayerEntity par3EntityPlayer)
    {
        if (ArmorLevel == 0){
            par1ItemStack.addEnchantment(Enchantments.MENDING, 1);
            par1ItemStack.addEnchantment(Enchantments.UNBREAKING, 1);}
        if (ArmorLevel == 1){
            par1ItemStack.addEnchantment(Enchantments.MENDING, 2);
            par1ItemStack.addEnchantment(Enchantments.UNBREAKING, 2);
            par1ItemStack.addEnchantment(Enchantments.THORNS, 1);}
        if (ArmorLevel == 2){
            par1ItemStack.addEnchantment(Enchantments.MENDING, 4);
            par1ItemStack.addEnchantment(Enchantments.UNBREAKING, 4);
            par1ItemStack.addEnchantment(Enchantments.THORNS, 4); }
        if (this.slot == EquipmentSlotType.FEET) {
            par1ItemStack.addEnchantment(RegHandler.LiquidWalker.get(), 2);}

    }


}
