package com.redgrapefruit.utopia.block

import net.minecraft.block.Block
import net.minecraft.block.BlockState
import net.minecraft.item.ItemPlacementContext
import net.minecraft.state.StateManager
import net.minecraft.state.property.DirectionProperty
import net.minecraft.state.property.Properties
import net.minecraft.util.BlockMirror
import net.minecraft.util.BlockRotation
import net.minecraft.util.math.Direction

/**
 * A block that rotates according to the player's rotation when placed
 */
open class DirectionalBlock(settings: Settings) : Block(settings) {
    private lateinit var facingProperty: DirectionProperty

    init {
        defaultState = stateManager.defaultState.with(facingProperty, Direction.NORTH)
    }

    override fun appendProperties(builder: StateManager.Builder<Block, BlockState>) {
        facingProperty = Properties.HORIZONTAL_FACING
        builder.add(facingProperty)
    }

    override fun rotate(state: BlockState, rotation: BlockRotation): BlockState =
        state.with(facingProperty, rotation.rotate(state.get(facingProperty)))

    override fun mirror(state: BlockState, mirror: BlockMirror): BlockState =
        state.rotate(mirror.getRotation(state.get(facingProperty)))

    override fun getPlacementState(context: ItemPlacementContext): BlockState =
        defaultState.with(facingProperty, context.playerFacing.opposite)
}
