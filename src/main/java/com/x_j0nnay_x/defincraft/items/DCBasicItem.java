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

public class DCBasicItem extends Item {

    public DCBasicItem(int itemnumber) {
        super(new Item.Properties().group(definecraftCore.TAB));
        this.itemname = itemnumber;
    }
public int itemname;
    public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
        super.addInformation(itemstack, world, list, flag);

        if (this.itemname == 0){
        list.add(new StringTextComponent("It's almost a stick but better"));}
        if (this.itemname == 1){
            list.add(new StringTextComponent("you doubled it now you just gotta smelt it "));}
        if (this.itemname == 2){
            list.add(new StringTextComponent("Its just a simple ingot added by definecraft"));}
        if (this.itemname == 3){
            list.add(new StringTextComponent("Its just a simple nugget added by definecraft"));}

    }
}
