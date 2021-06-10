package com.redgrapefruit.utopia.common.registry

import com.redgrapefruit.utopia.common.core.data.RFoodConfig
import com.redgrapefruit.utopia.common.core.state.RFoodProfile
import com.redgrapefruit.utopia.common.item.ROverdueFoodItem
import com.redgrapefruit.utopia.common.item.RRottenFoodItem
import com.redgrapefruit.utopia.common.module.Module
import com.redgrapefruit.utopia.common.module.ModuleFeature
import com.redgrapefruit.utopia.common.util.ItemMixinAccess
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object RPatchRegistry : ModuleFeature {
    override val module: Module = Module.REALISM
    override val isClientSide: Boolean = false

    override fun run() {
        patch("almond", "croptopia", RConfigRegistry.ALMOND, RItemRegistry.OVERDUE_ALMOND)
        patch("almond_brittle", "croptopia", RConfigRegistry.ALMOND_BRITTLE, RItemRegistry.OVERDUE_ALMOND_BRITTLE)
        patch("apple_juice", "croptopia", RConfigRegistry.APPLE_JUICE, RItemRegistry.OVERDUE_APPLE_JUICE)
        patch("apple_pie", "croptopia", RConfigRegistry.APPLE_PIE, RItemRegistry.OVERDUE_APPLE_PIE)
        patch("apricot", "croptopia", RConfigRegistry.APRICOT, RItemRegistry.OVERDUE_APRICOT)
        patch("apricot_jam", "croptopia", RConfigRegistry.APRICOT_JAM, RItemRegistry.OVERDUE_APRICOT_JAM)
        patch("artichoke", "croptopia", RConfigRegistry.ARTICHOKE, RItemRegistry.OVERDUE_ARTICHOKE)
        patch("artichoke_dip", "croptopia", RConfigRegistry.ARTICHOKE_DIP, RItemRegistry.OVERDUE_ARTICHOKE_DIP)
        //patch("artichoke_dip_chips", "croptopia", RConfigRegistry.ARTICHOKE_DIP_CHIPS, RItemRegistry.OVERDUE_ARTICHOKE_DIP_CHIPS)
        patch("asparagus", "croptopia", RConfigRegistry.ASPARAGUS, RItemRegistry.OVERDUE_ASPARAGUS)
    }

    /**
     * Patches a Croptopia item with rotten variant
     * @param name Unique name of the patched item
     * @param namespace Namespace of the target mod. Usually 'croptopia' (patching the foundation mod) or 'minecraft' (patching vanilla)
     * @param config Linked [RFoodConfig]
     * @param rottenVariant Linked [RRottenFoodItem]
     */
    private fun patch(name: String, namespace: String, config: RFoodConfig, rottenVariant: RRottenFoodItem) {
        // Try to discover item and cast it
        val access = discover(name, namespace) as ItemMixinAccess
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
    private fun patch(name: String, namespace: String, config: RFoodConfig, overdueVariant: ROverdueFoodItem) {
        // Try to discover item and cast it
        val access = discover(name, namespace) as ItemMixinAccess
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
        val id = Identifier(namespace, name)

        if (Registry.ITEM.containsId(Identifier(namespace, name))) {
            return Registry.ITEM.get(id)
        } else {
            throw KotlinNullPointerException("Couldn't find registered item: $id")
        }
    }
}