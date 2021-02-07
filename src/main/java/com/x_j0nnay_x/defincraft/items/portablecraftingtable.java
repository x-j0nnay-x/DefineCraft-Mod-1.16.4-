package com.x_j0nnay_x.defincraft.items;

import com.x_j0nnay_x.defincraft.definecraftCore;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.SimpleNamedContainerProvider;
import net.minecraft.inventory.container.WorkbenchContainer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

import java.util.List;

public class portablecraftingtable extends Item {
    private static final ITextComponent CONTAINER_NAME = new TranslationTextComponent("container.crafting");

    public portablecraftingtable() {
        super(new Properties().group(definecraftCore.TAB));

    }


    public void onItemRightClick(World world, PlayerEntity entityPlayer) {
       BlockState state =  Blocks.CRAFTING_TABLE.getDefaultState();
        entityPlayer.openContainer(state.getContainer(world, entityPlayer.getPosition()));
        entityPlayer.addStat(Stats.INTERACT_WITH_CRAFTING_TABLE);

       }
    public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
        return new SimpleNamedContainerProvider((id, inventory, player) -> {
            return new WorkbenchContainer(id, inventory, IWorldPosCallable.of(worldIn, pos));
        }, CONTAINER_NAME);
    }
    public void addInformation(ItemStack itemstack, World world, List<ITextComponent> list, ITooltipFlag flag) {
        super.addInformation(itemstack, world, list, flag);
        list.add(new StringTextComponent("take a little crafting table with you"));}

}
