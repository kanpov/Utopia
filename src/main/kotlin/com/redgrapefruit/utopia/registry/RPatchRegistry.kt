package com.redgrapefruit.utopia.registry

import com.redgrapefruit.utopia.core.RFoodConfig
import com.redgrapefruit.utopia.core.RFoodProfile
import com.redgrapefruit.utopia.item.ROverdueFoodItem
import com.redgrapefruit.utopia.item.RRottenFoodItem
import com.redgrapefruit.utopia.module.Module
import com.redgrapefruit.utopia.module.ModuleFeature
import com.redgrapefruit.utopia.util.ItemMixinAccess
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object RPatchRegistry : ModuleFeature() {
    override val module: Module
        get() = Module.REALISM

    override fun run() {

    }

    /**
     * Patches a Croptopia item with rotten variant
     * @param name Unique name of the patched item
     * @param config Linked [RFoodConfig]
     * @param rottenVariant Linked [RRottenFoodItem]
     */
    private fun patch(name: String, config: RFoodConfig, rottenVariant: RRottenFoodItem) {
        // Try to discover item and cast it
        val access = discover(name, "croptopia") as ItemMixinAccess
        // Add all needed properties
        access.activate()
        access.setConfig(config)
        access.setProfile(RFoodProfile())
        access.setRottenVariant(rottenVariant)
    }

    /**
     * Patches a Croptopia item with overdue variant
     * @param name Unique name of the patched item
     * @param config Linked [RFoodConfig]
     * @param overdueVariant Linked [ROverdueFoodItem]
     */
    private fun patch(name: String, config: RFoodConfig, overdueVariant: ROverdueFoodItem) {
        // Try to discover item and cast it
        val access = discover(name, "croptopia") as ItemMixinAccess
        // Add all needed properties
        access.activate()
        access.setConfig(config)
        access.setProfile(RFoodProfile())
        access.setOverdueVariant(overdueVariant)
    }

    /**
     * Tries to discover the item at given ID
     * @param name Unique name
     * @param namespace Base namespace
     * @return Discovered item or my middle finger with [KotlinNullPointerException]
     */
    private fun discover(name: String, namespace: String): Item {
        val id = Identifier(name, namespace)

        if (Registry.ITEM.containsId(Identifier(namespace, name))) {
            return Registry.ITEM.get(id)
        } else {
            throw KotlinNullPointerException("Couldn't find registered item: $id")
        }
    }
}