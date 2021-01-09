package com.x_j0nnay_x.defincraft.items;

import com.x_j0nnay_x.defincraft.definecraftCore;
import com.x_j0nnay_x.defincraft.util.RegHandler;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class DCBasicItemDust extends Item {

    public DCBasicItemDust() {
        super(new Properties().group(definecraftCore.TAB));
    }

    public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
        super.addInformation(itemstack, world, list, flag);
        if (this.equals(RegHandler.GOLDSTICK)){
        list.add(new StringTextComponent("It's almost a stick but better"));}
        if (this.equals(RegHandler.OBSIDIANSTICK)){
            list.add(new StringTextComponent("It's almost a stick but better"));}
        if (this.equals(RegHandler.GOLDDUST)){
            list.add(new StringTextComponent("you doubled it now you just gotta smelt it "));}
        if (this.equals(RegHandler.IRONDUST)){
            list.add(new StringTextComponent("you doubled it now you just gotta smelt it "));}
        if (this.equals(RegHandler.DIAMONDDUST)){
            list.add(new StringTextComponent("you doubled it now you just gotta smelt it "));}
        if (this.equals(RegHandler.HELLSTONEDUST)){
            list.add(new StringTextComponent("you doubled it now you just gotta smelt it "));}
        if (this.equals(RegHandler.OBSIDIANDUST)){
            list.add(new StringTextComponent("you doubled it now you just gotta smelt it "));}
        if (this.equals(RegHandler.SILVERDUST)){
            list.add(new StringTextComponent("you doubled it now you just gotta smelt it "));}
        if (this.equals(RegHandler.TERBIUMDUST)){
            list.add(new StringTextComponent("you doubled it now you just gotta smelt it "));}
    }
}
