package com.redgrapefruit.utopia.block

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.ShapeContext
import net.minecraft.block.TransparentBlock
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.function.BooleanBiFunction
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView
import net.minecraft.world.World
import java.util.stream.Stream

/**
 * A base class for all windows providing opening and closing functionality
 */
@Suppress("DEPRECATION")
sealed class WindowBlock(settings: Settings) : TransparentBlock(settings) {
    protected val openProperty: BooleanProperty = BooleanProperty.of("open")

    init {
        defaultState = stateManager.defaultState.with(openProperty, false)
    }

    /**
     * A function reserved for generating a Minecraft block [VoxelShape]
     */
    protected abstract fun generateVoxelShape(state: BlockState, world: BlockView, pos: BlockPos, context: ShapeContext): VoxelShape

    override fun getOutlineShape(
        state: BlockState,
        world: BlockView,
        pos: BlockPos,
        context: ShapeContext
    ): VoxelShape = generateVoxelShape(state, world, pos, context)

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        super.appendProperties(builder)

        builder.add(openProperty)
    }

    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hand: Hand,
        hit: BlockHitResult
    ): ActionResult {
        // Open/close the window by inverting the value (opened => closed, closed => opened)
        world.setBlockState(pos, state.with(openProperty, !state.get(openProperty)))

        return super.onUse(state, world, pos, player, hand, hit)
    }
}

/**
 * A window with a single pane covering the entire inner surface
 */
class FullWindowBlock(settings: Settings) : WindowBlock(settings) {
    override fun generateVoxelShape(
        state: BlockState,
        world: BlockView,
        pos: BlockPos,
        context: ShapeContext
    ): VoxelShape {
        val i = if (state.get(openProperty)) 8.0 else 1.0

        return listOf(
            createCuboidShape(1.0, 15.0, 6.0, 15.0, 16.0, 10.0),
            createCuboidShape(0.0, 0.0, 6.0, 16.0, 1.0, 10.0),
            createCuboidShape(0.0, 1.0, 6.0, 1.0, 16.0, 10.0),
            createCuboidShape(15.0, 1.0, 6.0, 16.0, 16.0, 10.0),
            createCuboidShape(1.0, i, 7.0, 15.0, 15.0, 9.0)
        ).reduce { t, u -> VoxelShapes.combineAndSimplify(t, u, BooleanBiFunction.OR) }
    }
}
