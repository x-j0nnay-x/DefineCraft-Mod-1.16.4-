package com.x_j0nnay_x.defincraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DCOreBLock extends Block {

    public DCOreBLock() {
        super(Block.Properties.create(Material.ROCK)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.STONE)
                .harvestLevel(1)
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE)

        );
    }

}
