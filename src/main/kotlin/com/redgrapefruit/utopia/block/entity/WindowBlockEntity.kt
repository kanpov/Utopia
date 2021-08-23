package com.redgrapefruit.utopia.block.entity

import com.redgrapefruit.utopia.registry.BlockRegistry
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.nbt.NbtCompound
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World

private const val TIMEOUT_FINISH = 10

class WindowBlockEntity(pos: BlockPos, state: BlockState) : BlockEntity(BlockRegistry.WINDOW_BLOCK_ENTITY, pos, state) {
    private var timer = 0
    private var timeoutOver = true

    fun tick(world: World, pos: BlockPos, state: BlockState, entity: WindowBlockEntity) {
        if (!timeoutOver) {
            if (timer >= TIMEOUT_FINISH) {
                timeoutOver = true
                timer = 0
            } else {
                ++timer
            }
        }
    }

    fun startTimeout() {
        timeoutOver = false
    }

    fun isTimedOut() = timeoutOver

    override fun readNbt(nbt: NbtCompound) {
        timer = nbt.getInt("Timer")

        super.readNbt(nbt)
    }

    override fun writeNbt(nbt: NbtCompound): NbtCompound {
        nbt.putInt("Timer", timer)

        return super.writeNbt(nbt)
    }
}