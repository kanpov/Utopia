package com.redgrapefruit.utopia.block

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.block.ShapeContext
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.BooleanProperty
import net.minecraft.state.property.DirectionProperty
import net.minecraft.state.property.Properties
import net.minecraft.util.ActionResult
import net.minecraft.util.BlockMirror
import net.minecraft.util.BlockRotation
import net.minecraft.util.Hand
import net.minecraft.util.function.BooleanBiFunction
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.Direction
import net.minecraft.util.shape.VoxelShape
import net.minecraft.util.shape.VoxelShapes
import net.minecraft.world.BlockView
import net.minecraft.world.World

/**
 * A base class for all windows providing opening and closing functionality
 */
@Suppress("DEPRECATION")
sealed class WindowBlock(settings: Settings) : Block(settings) {
    protected lateinit var openProperty: BooleanProperty
    private lateinit var facingProperty : DirectionProperty

    init {
        defaultState = stateManager.defaultState
            .with(openProperty, false)
            .with(facingProperty, Direction.NORTH)
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

        openProperty = BooleanProperty.of("open")
        facingProperty = Properties.HORIZONTAL_FACING
        builder.add(openProperty)
        builder.add(facingProperty)
    }

    override fun rotate(state: BlockState, rotation: BlockRotation): BlockState =
        state.with(facingProperty, rotation.rotate(state.get(facingProperty)))

    override fun mirror(state: BlockState, mirror: BlockMirror): BlockState =
        state.rotate(mirror.getRotation(state.get(facingProperty)))

    override fun getPlacementState(context: ItemPlacementContext): BlockState =
        defaultState.with(facingProperty, context.playerFacing.opposite)

    override fun onUse(
        state: BlockState,
        world: World,
        pos: BlockPos,
        player: PlayerEntity,
        hand: Hand,
        hit: BlockHitResult
    ): ActionResult {
        // Open/close the window by inverting the value (opened => closed, closed => opened)
        if (world.isClient) {
            world.setBlockState(pos, state.with(openProperty, !state.get(openProperty)))
        }
        return super.onUse(state, world, pos, player, hand, hit)
    }

    override fun isSideInvisible(state: BlockState, stateFrom: BlockState, direction: Direction): Boolean {
        if (stateFrom.isOf(this)) {
            val facing = state.get(facingProperty)
            return direction == facing || direction == facing.opposite
        }

        return super.isSideInvisible(state, stateFrom, direction)
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
