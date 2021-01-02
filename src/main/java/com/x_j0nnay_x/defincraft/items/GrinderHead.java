package com.x_j0nnay_x.defincraft.items;

import com.x_j0nnay_x.defincraft.definecraftCore;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class GrinderHead extends Item {


    public GrinderHead(int maxuses) {
        super(new Item.Properties().group(definecraftCore.TAB)
                .maxStackSize(1)
                .maxDamage(maxuses)
                .setNoRepair()

        );
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
}


