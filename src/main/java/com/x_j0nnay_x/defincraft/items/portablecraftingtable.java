package com.x_j0nnay_x.defincraft.items;

import com.x_j0nnay_x.defincraft.definecraftCore;
import com.x_j0nnay_x.defincraft.util.RegHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CraftingTableBlock;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class portablecraftingtable extends Item {

    public portablecraftingtable() {
        super(new Properties().group(definecraftCore.TAB));

    }

    public void onUse(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count, PlayerEntity player) {
      BlockState state = Blocks.CRAFTING_TABLE.getDefaultState();
        BlockPos pos = player.getPosition();
        if (worldIn.isRemote) {
            player.openContainer(state.getContainer(worldIn, pos));
            player.addStat(Stats.INTERACT_WITH_CRAFTING_TABLE);
        }
    }

    public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
        super.addInformation(itemstack, world, list, flag);
        list.add(new StringTextComponent("take a little crafting table with you"));}

}
