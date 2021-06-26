package com.redgrapefruit.utopia.common.patch

import com.redgrapefruit.utopia.common.LOG
import com.redgrapefruit.utopia.common.core.FoodConfig
import com.redgrapefruit.utopia.common.core.FoodProfile
import com.redgrapefruit.utopia.common.item.OverdueFoodItem
import com.redgrapefruit.utopia.common.item.RottenFoodItem
import com.redgrapefruit.utopia.common.util.Either
import com.redgrapefruit.utopia.common.util.ItemMixinAccess
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

/**
 * A patch system controlling the patching process
 */
internal object PatchSystem {
    private val patchQuery: MutableSet<Patch> = mutableSetOf()

    fun apply() {
        patchQuery.forEach { patch ->
            val id = Identifier(patch.namespace, patch.name)

            // Check the existence of the target
            if (!Registry.ITEM.containsId(id)) {
                LOG.error("Couldn't apply patch to $id - the target doesn't exist or hasn't been registered yet")
                return
            }

            // Discover the item and cast it to the duck interface
            val targetItemUnchecked = Registry.ITEM.get(id)
            if (targetItemUnchecked !is ItemMixinAccess) {
                LOG.error("Couldn't apply patch to $id - a critical error in the mixin implementation has occurred")
                return
            }
            val targetItem = targetItemUnchecked as ItemMixinAccess

            // Patch the main properties
            targetItem.activate()
            targetItem.setConfig(patch.config)
            targetItem.setProfile(FoodProfile())

            // Patch the variants if they're present. Else throw an error
            if (patch.variantEither.areNeitherPresent()) {
                LOG.error("Couldn't apply patch to $id - neither food variants are present in the patch")
                return
            }
            if (patch.variantEither.isFirstPresent()) {
                targetItem.setOverdueVariant(patch.variantEither.first!!)
            }
            if (patch.variantEither.isSecondPresent()) {
                targetItem.setRottenVariant(patch.variantEither.second!!)
            }
        }
    }

    /**
     * Adds a Croptopia item with a rotten variant to the [patchQuery]
     * @param name Unique name of the patched item
     * @param namespace Namespace of the target mod. Usually 'croptopia' (patching the foundation mod) or 'minecraft' (patching vanilla)
     * @param config Linked [FoodConfig]
     * @param rottenVariant Linked [RottenFoodItem]
     */
    fun patch(name: String, namespace: String, config: FoodConfig, rottenVariant: RottenFoodItem) {
        patchQuery += Patch(name, namespace, config, Either<OverdueFoodItem, RottenFoodItem>().second { rottenVariant })
    }

    /**
     * Adds a Croptopia item with overdue variant to the [patchQuery]
     * @param name Unique name of the patched item
     * @param config Linked [FoodConfig]
     * @param overdueVariant Linked [OverdueFoodItem]
     */
    fun patch(name: String, namespace: String, config: FoodConfig, overdueVariant: OverdueFoodItem) {
        patchQuery += Patch(name, namespace, config, Either<OverdueFoodItem, RottenFoodItem>().first { overdueVariant })
    }
}