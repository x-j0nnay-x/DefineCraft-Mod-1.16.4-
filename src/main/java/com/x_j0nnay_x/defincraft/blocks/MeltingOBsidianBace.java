package com.x_j0nnay_x.defincraft.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BreakableBlock;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class MeltingOBsidianBace extends BreakableBlock {
    public int LiquidType;

    public MeltingOBsidianBace(AbstractBlock.Properties properties, int liquid) {
        super(properties);
         this.LiquidType = liquid;
    }


    public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, TileEntity te, ItemStack stack) {
        super.harvestBlock(worldIn, player, pos, state, te, stack);
        Material material = worldIn.getBlockState(pos.down()).getMaterial();
        if (material.blocksMovement() || material.isLiquid()) {
              if (LiquidType == 0) {
                  worldIn.setBlockState(pos, Blocks.WATER.getDefaultState());
               }
               else{
            worldIn.setBlockState(pos, Blocks.LAVA.getDefaultState());
               }
        }


    }


    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        if (worldIn.getLightFor(LightType.BLOCK, pos) >= 4 - state.getOpacity(worldIn, pos)) {
            this.turnIntoWater(state, worldIn, pos);
        }

    }

    protected void turnIntoWater(BlockState state, World world, BlockPos pos) {
        if (world.getDimensionType().isUltrawarm()) {
            world.removeBlock(pos, false);
        } if(LiquidType == 0) {
           world.setBlockState(pos, Blocks.WATER.getDefaultState());
            world.neighborChanged(pos, Blocks.WATER, pos);
         }
        else {
            world.setBlockState(pos, Blocks.LAVA.getDefaultState());
            world.neighborChanged(pos, Blocks.LAVA, pos);
        }
    }


    public PushReaction getPushReaction(BlockState state) {
        return PushReaction.NORMAL;
    }
}
