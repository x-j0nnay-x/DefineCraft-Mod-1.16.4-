package com.x_j0nnay_x.defincraft.blocks;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

public class invisLight extends BreakableBlock {

    protected static final VoxelShape SHAPE = Block.makeCuboidShape(2.0D, 0.0D, 2.0D, 2.0D, 2.0D, 2.0D);
    protected final IParticleData particleData;
    public static final IntegerProperty AGE = BlockStateProperties.AGE_0_3;
public int LightLevel;
    public invisLight(AbstractBlock.Properties properties, IParticleData particleData, int lightLevel) {
        super(properties.setLightLevel((state) -> {return lightLevel;}));
        this.particleData = particleData;
        this.LightLevel = lightLevel;
    }
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        this.tick(state, worldIn, pos, random);
    }

    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
       // this.properties.setLightLevel();
        if ((rand.nextInt(3) == 0 || this.shouldMelt(worldIn, pos, 4)) && worldIn.getLight(pos) >= 4 - state.get(AGE) - state.getOpacity(worldIn, pos) && this.slightlyMelt(state, worldIn, pos)) {
            BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

            for (Direction direction : Direction.values()) {
                blockpos$mutable.setAndMove(pos, direction);
                BlockState blockstate = worldIn.getBlockState(blockpos$mutable);
                if (blockstate.isIn(this) && !this.slightlyMelt(blockstate, worldIn, blockpos$mutable)) {
                    worldIn.getPendingBlockTicks().scheduleTick(blockpos$mutable, this, MathHelper.nextInt(rand, 60, 80));
                }
            }

        } else {
            worldIn.getPendingBlockTicks().scheduleTick(pos, this, MathHelper.nextInt(rand, 60, 80));
        }
    }

    private boolean slightlyMelt(BlockState state, World worldIn, BlockPos pos) {
        int i = state.get(AGE);
        if (i < 3) {
            worldIn.setBlockState(pos, state.with(AGE, Integer.valueOf(i + 1)), 2);
            this.LightLevel -= 2;
            return false;
        } else {
            this.turnIntoAir(state, worldIn, pos);
            return true;
        }
    }

    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        if (blockIn == this && this.shouldMelt(worldIn, pos, 2)) {
            this.turnIntoAir(state, worldIn, pos);
        }

        super.neighborChanged(state, worldIn, pos, blockIn, fromPos, isMoving);
    }

    private boolean shouldMelt(IBlockReader worldIn, BlockPos pos, int neighborsRequired) {
        int i = 0;
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        for (Direction direction : Direction.values()) {
            blockpos$mutable.setAndMove(pos, direction);
            if (worldIn.getBlockState(blockpos$mutable).isIn(this)) {
                ++i;
                if (i >= neighborsRequired) {
                    return false;
                }
            }
        }

        return true;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        return ItemStack.EMPTY;
    }

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }
    protected void turnIntoAir(BlockState state, World world, BlockPos pos) {
        if (world.getDimensionType().isUltrawarm()) {
            world.removeBlock(pos, false);
        }else {
            world.setBlockState(pos, Blocks.AIR.getDefaultState());
            world.neighborChanged(pos, Blocks.AIR, pos);
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {

        for(int i = 0; i < 4; ++i) {
            double d0 = (double) pos.getX() + rand.nextDouble();
            double d1 = (double) pos.getY() + rand.nextDouble();
            double d2 = (double) pos.getZ() + rand.nextDouble();
            double d3 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
            double d4 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
            double d5 = ((double) rand.nextFloat() - 0.5D) * 0.5D;
            int j = rand.nextInt(2) * 2 - 1;
            if (!worldIn.getBlockState(pos.west()).isIn(this) && !worldIn.getBlockState(pos.east()).isIn(this)) {
                d0 = (double) pos.getX() + 0.5D + 0.25D * (double) j;
                d3 = (double) (rand.nextFloat() * 2.0F * (float) j);
            } else {
                d2 = (double) pos.getZ() + 0.5D + 0.25D * (double) j;
                d5 = (double) (rand.nextFloat() * 2.0F * (float) j);
            }
            worldIn.addParticle(ParticleTypes.PORTAL, d0, d1, d2, d3, d4, d5);
        }
        double d6 = (double)pos.getX() + 0.5D;
        double d7 = (double)pos.getY() + 0.7D;
        double d8 = (double)pos.getZ() + 0.5D;
        worldIn.addParticle(ParticleTypes.SMOKE, d6, d7, d8, 0.0D, 0.0D, 0.0D);
        worldIn.addParticle(this.particleData, d6, d7, d8, 0.0D, 0.0D, 0.0D);
    }
}

