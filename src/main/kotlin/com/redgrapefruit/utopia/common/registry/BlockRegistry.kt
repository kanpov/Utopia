package com.redgrapefruit.utopia.common.registry

import com.redgrapefruit.utopia.common.GROUP
import com.redgrapefruit.utopia.common.MOD_ID
import com.redgrapefruit.utopia.common.block.FridgeBlock
import com.redgrapefruit.utopia.common.block.entity.FridgeBlockEntity
import com.redgrapefruit.utopia.common.io.Module
import com.redgrapefruit.utopia.common.io.moduleSpecific
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.block.entity.BlockEntity
import net.minecraft.block.entity.BlockEntityType
import net.minecraft.item.BlockItem
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

/**
 * Furniture's block registry
 */
object BlockRegistry {
    // Blocks
    val FRIDGE_BLOCK =
        FridgeBlock(FabricBlockSettings.of(Material.METAL).hardness(3.5f).breakByTool(FabricToolTags.PICKAXES, 2))

    // Block entities
    val FRIDGE_BLOCK_ENTITY: BlockEntityType<FridgeBlockEntity> =
        BlockEntityType.Builder.create(::FridgeBlockEntity, FRIDGE_BLOCK).build(null)

    fun run(): Unit = moduleSpecific(Module.REALISM) {
        register("fridge", FRIDGE_BLOCK, FRIDGE_BLOCK_ENTITY)
    }

    /**
     * Registers a block, a [BlockEntity] and a [BlockItem]
     * @param name Name for these three resources
     * @param block The actual block
     * @param type The [BlockEntityType] which is a registry wrapper for the [BlockEntity]
     * @param TBlockEntity The generic for the registered [BlockEntity] to pass to [type]
     */
    private fun <TBlockEntity> register(
        name: String,
        block: Block,
        type: BlockEntityType<TBlockEntity>
    ) where TBlockEntity : BlockEntity {
        val id = Identifier(MOD_ID, name)

        Registry.register(Registry.BLOCK, id, block)
        Registry.register(Registry.BLOCK_ENTITY_TYPE, id, type)
        Registry.register(Registry.ITEM, id, BlockItem(block, Item.Settings().group(GROUP)))
    }
}