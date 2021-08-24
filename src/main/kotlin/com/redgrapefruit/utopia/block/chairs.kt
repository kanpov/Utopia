package com.redgrapefruit.utopia.block

import com.redgrapefruit.utopia.util.createCuboidShape
import net.minecraft.block.BlockState
import net.minecraft.block.ShapeContext
import net.minecraft.util.function.BooleanBiFunction
import net.minecraft.util.math.BlockPos
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView

// Chairs

/**
 * A normal, not so comfy, chair
 */
class ChairBlock(settings: Settings) : DirectionalBlock(settings) {
    override fun getOutlineShape(
        state: BlockState?,
        world: BlockView?,
        pos: BlockPos?,
        context: ShapeContext?
    ): VoxelShape {
        return setOf(
            createCuboidShape(3, 0, 3, 5, 5, 5),
            createCuboidShape(3, 0, 11, 5, 5, 13),
            createCuboidShape(11, 0, 11, 13, 5, 13),
            createCuboidShape(11, 0, 3, 13, 5, 5),
            createCuboidShape(2, 5, 2, 14, 7, 14),
            createCuboidShape(11, 7, 11, 13, 14, 13),
            createCuboidShape(7, 7, 11, 9, 14, 13),
            createCuboidShape(3, 7, 11, 5, 14, 13),
            createCuboidShape(3, 14, 11, 13, 16, 13)
        ).reduce { v1, v2 -> VoxelShapes.combineAndSimplify(v1, v2, BooleanBiFunction.OR) }
    }
}
