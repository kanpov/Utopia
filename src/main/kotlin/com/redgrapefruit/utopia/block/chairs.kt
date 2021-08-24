package com.redgrapefruit.utopia.block

import com.redgrapefruit.utopia.util.voxelShape
import net.minecraft.block.BlockState
import net.minecraft.block.ShapeContext
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.shape.VoxelShape
import net.minecraft.world.BlockView

// Chairs

/**
 * A normal, not so comfy, chair
 */
class ChairBlock(settings: Settings) : DirectionalBlock(settings) {
    override fun getOutlineShape(
        state: BlockState,
        world: BlockView,
        pos: BlockPos,
        context: ShapeContext
    ): VoxelShape {
        return when (state.get(facingProperty)) {
            Direction.NORTH -> NORTH_SHAPE
            Direction.SOUTH -> SOUTH_SHAPE
            Direction.EAST -> EAST_SHAPE
            Direction.WEST -> WEST_SHAPE
            else -> NORTH_SHAPE
        }
    }

    companion object {
        private val NORTH_SHAPE = voxelShape {
            shape(3, 0, 3, 5, 5, 5)
            shape(3, 0, 11, 5, 5, 13)
            shape(11, 0, 11, 13, 5, 13)
            shape(11, 0, 3, 13, 5, 5)
            shape(2, 5, 2, 14, 7, 14)
            shape(11, 7, 11, 13, 14, 13)
            shape(7, 7, 11, 9, 14, 13)
            shape(3, 7, 11, 5, 14, 13)
            shape(3, 14, 11, 13, 16, 13)
        }

        private val SOUTH_SHAPE = voxelShape {
            shape(11, 0, 11, 13, 5, 13)
            shape(11, 0, 3, 13, 5, 5)
            shape(3, 0, 3, 5, 5, 5)
            shape(3, 0, 11, 5, 5, 13)
            shape(2, 5, 2, 14, 7, 14)
            shape(3, 7, 3, 5, 14, 5)
            shape(7, 7, 3, 9, 14, 5)
            shape(11, 7, 3, 13, 14, 5)
            shape(3, 14, 3, 13, 16, 5)
        }

        private val EAST_SHAPE = voxelShape {
            shape(11, 0, 3, 13, 5, 5)
            shape(3, 0, 3, 5, 5, 5)
            shape(3, 0, 11, 5, 5, 13)
            shape(11, 0, 11, 13, 5, 13)
            shape(2, 5, 2, 14, 7, 14)
            shape(3, 7, 11, 5, 14, 13)
            shape(3, 7, 7, 5, 14, 9)
            shape(3, 7, 3, 5, 14, 5)
            shape(3, 14, 3, 5, 16, 13)
        }

        private val WEST_SHAPE = voxelShape {
            shape(3, 0, 11, 5, 5, 13)
            shape(11, 0, 11, 13, 5, 13)
            shape(11, 0, 3, 13, 5, 5)
            shape(3, 0, 3, 5, 5, 5)
            shape(2, 5, 2, 14, 7, 14)
            shape(11, 7, 3, 13, 14, 5)
            shape(11, 7, 7, 13, 14, 9)
            shape(11, 7, 11, 13, 14, 13)
            shape(11, 14, 3, 13, 16, 13)
        }
    }
}
