package com.x_j0nnay_x.defincraft.items;

import com.x_j0nnay_x.defincraft.definecraftCore;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class coaldust extends Item {

    public coaldust() {
        super(new Properties().group(definecraftCore.TAB));

    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 1600;
    }

    public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
        super.addInformation(itemstack, world, list, flag);

     list.add(new StringTextComponent("yep you doubled coal."));

    }
}
