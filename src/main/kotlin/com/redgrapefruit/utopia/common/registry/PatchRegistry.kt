package com.redgrapefruit.utopia.common.registry

import com.redgrapefruit.utopia.common.core.FoodConfig
import com.redgrapefruit.utopia.common.core.FoodProfile
import com.redgrapefruit.utopia.common.item.OverdueFoodItem
import com.redgrapefruit.utopia.common.item.RottenFoodItem
import com.redgrapefruit.utopia.common.util.ItemMixinAccess
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

object PatchRegistry {
    fun run() {
        patch("almond", "croptopia", ConfigRegistry.ALMOND, ItemRegistry.OVERDUE_ALMOND)
        patch("almond_brittle", "croptopia", ConfigRegistry.ALMOND_BRITTLE, ItemRegistry.OVERDUE_ALMOND_BRITTLE)
        patch("apple_juice", "croptopia", ConfigRegistry.APPLE_JUICE, ItemRegistry.OVERDUE_APPLE_JUICE)
        patch("apple_pie", "croptopia", ConfigRegistry.APPLE_PIE, ItemRegistry.OVERDUE_APPLE_PIE)
        patch("apricot", "croptopia", ConfigRegistry.APRICOT, ItemRegistry.OVERDUE_APRICOT)
        patch("apricot_jam", "croptopia", ConfigRegistry.APRICOT_JAM, ItemRegistry.OVERDUE_APRICOT_JAM)
        patch("artichoke", "croptopia", ConfigRegistry.ARTICHOKE, ItemRegistry.OVERDUE_ARTICHOKE)
        patch("artichoke_dip", "croptopia", ConfigRegistry.ARTICHOKE_DIP, ItemRegistry.OVERDUE_ARTICHOKE_DIP)
        patch("asparagus", "croptopia", ConfigRegistry.ASPARAGUS, ItemRegistry.OVERDUE_ASPARAGUS)
        patch("avocado", "croptopia", ConfigRegistry.AVOCADO, ItemRegistry.OVERDUE_AVOCADO)
        patch("baked_beans", "croptopia", ConfigRegistry.BAKED_BEANS, ItemRegistry.OVERDUE_BAKED_BEANS)
        patch("banana", "croptopia", ConfigRegistry.BANANA, ItemRegistry.OVERDUE_BANANA)
        patch("banana_cream_pie", "croptopia", ConfigRegistry.BANANA_CREAM_PIE, ItemRegistry.OVERDUE_BANANA_CREAM_PIE)
        patch("banana_nut_bread", "croptopia", ConfigRegistry.BANANA_NUT_BREAD, ItemRegistry.OVERDUE_BANANA_NUT_BREAD)
        patch("barley", "croptopia", ConfigRegistry.BARLEY, ItemRegistry.OVERDUE_BARLEY)
        patch("basil", "croptopia", ConfigRegistry.BASIL, ItemRegistry.OVERDUE_BASIL)
        patch("beef_jerky", "croptopia", ConfigRegistry.BEEF_JERKY, ItemRegistry.ROTTEN_BEEF_JERKY)
        patch("beef_wellington", "croptopia", ConfigRegistry.BEEF_WELLINGTON, ItemRegistry.ROTTEN_BEEF_WELLINGTON)
        patch("bellpepper", "croptopia", ConfigRegistry.BELLPEPPER, ItemRegistry.OVERDUE_BELLPEPPER)
        patch("blackbean", "croptopia", ConfigRegistry.BLACKBEAN, ItemRegistry.OVERDUE_BLACKBEAN)
        patch("blackberry", "croptopia", ConfigRegistry.BLACKBERRY, ItemRegistry.OVERDUE_BLACKBERRY)
        patch("blackberry_jam", "croptopia", ConfigRegistry.BLACKBERRY_JAM, ItemRegistry.OVERDUE_BLACKBERRY_JAM)
        patch("blt", "croptopia", ConfigRegistry.BLT, ItemRegistry.OVERDUE_BLT)
        patch("blueberry", "croptopia", ConfigRegistry.BLUEBERRY, ItemRegistry.OVERDUE_BLUEBERRY)
        patch("blueberry_jam", "croptopia", ConfigRegistry.BLUEBERRY_JAM, ItemRegistry.OVERDUE_BLUEBERRY_JAM)
        patch("broccoli", "croptopia", ConfigRegistry.BROCCOLI, ItemRegistry.OVERDUE_BROCCOLI)
        patch("brownies", "croptopia", ConfigRegistry.BROWNIES, ItemRegistry.OVERDUE_BROWNIES)
        patch("burrito", "croptopia", ConfigRegistry.BURRITO, ItemRegistry.OVERDUE_BURRITO)
        patch("butter", "croptopia", ConfigRegistry.BUTTER, ItemRegistry.OVERDUE_BUTTER)
        patch("buttered_toast", "croptopia", ConfigRegistry.BUTTERED_TOAST, ItemRegistry.OVERDUE_BUTTERED_TOAST)
        patch("cabbage", "croptopia", ConfigRegistry.CABBAGE, ItemRegistry.OVERDUE_CABBAGE)
        patch("caesar_salad", "croptopia", ConfigRegistry.CAESAR_SALAD, ItemRegistry.OVERDUE_CAESAR_SALAD)
        patch("candied_nuts", "croptopia", ConfigRegistry.CANDIED_NUTS, ItemRegistry.OVERDUE_CANDIED_NUTS)
    }

    /**
     * Patches a Croptopia item with rotten variant
     * @param name Unique name of the patched item
     * @param namespace Namespace of the target mod. Usually 'croptopia' (patching the foundation mod) or 'minecraft' (patching vanilla)
     * @param config Linked [FoodConfig]
     * @param rottenVariant Linked [RottenFoodItem]
     */
    private fun patch(name: String, namespace: String, config: FoodConfig, rottenVariant: RottenFoodItem) {
        // Try to discover item and cast it
        val access = discover(name, namespace) as ItemMixinAccess
        // Add all needed properties
        access.activate()
        access.setConfig(config)
        access.setProfile(FoodProfile())
        access.setRottenVariant(rottenVariant)
    }

    /**
     * Patches a Croptopia item with overdue variant
     * @param name Unique name of the patched item
     * @param config Linked [FoodConfig]
     * @param overdueVariant Linked [OverdueFoodItem]
     */
    private fun patch(name: String, namespace: String, config: FoodConfig, overdueVariant: OverdueFoodItem) {
        // Try to discover item and cast it
        val access = discover(name, namespace) as ItemMixinAccess
        // Add all needed properties
        access.activate()
        access.setConfig(config)
        access.setProfile(FoodProfile())
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