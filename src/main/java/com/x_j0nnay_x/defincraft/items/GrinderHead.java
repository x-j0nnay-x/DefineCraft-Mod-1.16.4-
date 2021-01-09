package com.x_j0nnay_x.defincraft.items;

import com.x_j0nnay_x.defincraft.definecraftCore;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import java.util.List;

public class GrinderHead extends Item {

 int MaxUse;
    public GrinderHead(int maxuses) {
        super(new Item.Properties().group(definecraftCore.TAB)
                .maxStackSize(1)
                .maxDamage(maxuses)
                .setNoRepair());
                this.MaxUse = maxuses;

    }

    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack) {
        if (itemStack.getDamage() > itemStack.getMaxDamage()) {
            return itemStack;
        }
        ItemStack ret = new ItemStack(this);
        ret.setDamage(itemStack.getDamage() + 1);
        return ret;

    }
    public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
        super.addInformation(itemstack, world, list, flag);
        list.add(new StringTextComponent("The Grinder is for simple Ore Doubling. this one has "+ this.MaxUse + " uses"));
        list.add(new StringTextComponent("simply just place this on top of your ore of chose in a crafting table"));
    }
}


