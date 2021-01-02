package com.x_j0nnay_x.defincraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class DCHellOreBLock extends Block {

    public DCHellOreBLock() {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(5.0f, 6.0f)
                .sound(SoundType.STONE)
                .harvestLevel(4)
                .setRequiresTool()
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
