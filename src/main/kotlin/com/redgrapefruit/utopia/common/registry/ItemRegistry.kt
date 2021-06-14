package com.redgrapefruit.utopia.common.registry

import com.redgrapefruit.utopia.common.MOD_ID
import com.redgrapefruit.utopia.common.item.OverdueFoodItem
import com.redgrapefruit.utopia.common.item.RottenFoodItem
import com.redgrapefruit.utopia.common.item.SaltedFoodItem
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

/**
 * Realism's item registry
 */
object ItemRegistry {
    // Rotten food
    val ROTTEN_BEEF_JERKY = RottenFoodItem(ConfigRegistry.BEEF_JERKY)
    val ROTTEN_BEEF_WELLINGTON = RottenFoodItem(ConfigRegistry.BEEF_WELLINGTON)

    // Overdue food
    val OVERDUE_ALMOND = OverdueFoodItem(ConfigRegistry.ALMOND)
    val OVERDUE_ALMOND_BRITTLE = OverdueFoodItem(ConfigRegistry.ALMOND_BRITTLE)
    val OVERDUE_APPLE_JUICE = OverdueFoodItem(ConfigRegistry.APPLE_JUICE)
    val OVERDUE_APPLE_PIE = OverdueFoodItem(ConfigRegistry.APPLE_PIE)
    val OVERDUE_APRICOT = OverdueFoodItem(ConfigRegistry.APRICOT)
    val OVERDUE_APRICOT_JAM = OverdueFoodItem(ConfigRegistry.APRICOT_JAM)
    val OVERDUE_ARTICHOKE = OverdueFoodItem(ConfigRegistry.ARTICHOKE)
    val OVERDUE_ARTICHOKE_DIP = OverdueFoodItem(ConfigRegistry.ARTICHOKE_DIP)
    val OVERDUE_ASPARAGUS = OverdueFoodItem(ConfigRegistry.ASPARAGUS)
    val OVERDUE_AVOCADO = OverdueFoodItem(ConfigRegistry.AVOCADO)
    val OVERDUE_BAKED_BEANS = OverdueFoodItem(ConfigRegistry.BAKED_BEANS)
    val OVERDUE_BANANA = OverdueFoodItem(ConfigRegistry.BANANA)
    val OVERDUE_BANANA_CREAM_PIE = OverdueFoodItem(ConfigRegistry.BANANA_CREAM_PIE)
    val OVERDUE_BANANA_NUT_BREAD = OverdueFoodItem(ConfigRegistry.BANANA_NUT_BREAD)
    val OVERDUE_BARLEY = OverdueFoodItem(ConfigRegistry.BARLEY)
    val OVERDUE_BASIL = OverdueFoodItem(ConfigRegistry.BASIL)
    val OVERDUE_BELLPEPPER = OverdueFoodItem(ConfigRegistry.BELLPEPPER)
    val OVERDUE_BLACKBEAN = OverdueFoodItem(ConfigRegistry.BLACKBEAN)
    val OVERDUE_BLACKBERRY = OverdueFoodItem(ConfigRegistry.BLACKBERRY)

    // Salted food
    val SALTED_ALMOND = SaltedFoodItem(ConfigRegistry.ALMOND)
    val SALTED_ALMOND_BRITTLE = SaltedFoodItem(ConfigRegistry.ALMOND_BRITTLE)
    val SALTED_APRICOT = SaltedFoodItem(ConfigRegistry.APRICOT)
    val SALTED_ARTICHOKE = SaltedFoodItem(ConfigRegistry.ARTICHOKE)
    val SALTED_ARTICHOKE_DIP = SaltedFoodItem(ConfigRegistry.ARTICHOKE_DIP)
    val SALTED_ASPARAGUS = SaltedFoodItem(ConfigRegistry.ASPARAGUS)
    val SALTED_AVOCADO = SaltedFoodItem(ConfigRegistry.AVOCADO)
    val SALTED_BAKED_BEANS = SaltedFoodItem(ConfigRegistry.BAKED_BEANS)
    val SALTED_BANANA_NUT_BREAD = SaltedFoodItem(ConfigRegistry.BANANA_NUT_BREAD)
    val SALTED_BASIL = SaltedFoodItem(ConfigRegistry.BASIL)
    val SALTED_BEEF_JERKY = SaltedFoodItem(ConfigRegistry.BEEF_JERKY)
    val SALTED_BEEF_WELLINGTON = SaltedFoodItem(ConfigRegistry.BEEF_WELLINGTON)
    val SALTED_BLACKBEAN = SaltedFoodItem(ConfigRegistry.BLACKBEAN)

    // Fresh food

    fun run() {
        register("rotten_beef_jerky", ROTTEN_BEEF_JERKY)
        register("rotten_beef_wellington", ROTTEN_BEEF_WELLINGTON)
        register("overdue_almond", OVERDUE_ALMOND)
        register("overdue_almond_brittle", OVERDUE_ALMOND_BRITTLE)
        register("overdue_apple_juice", OVERDUE_APPLE_JUICE)
        register("overdue_apple_pie", OVERDUE_APPLE_PIE)
        register("overdue_apricot", OVERDUE_APRICOT)
        register("overdue_apricot_jam", OVERDUE_APRICOT_JAM)
        register("overdue_artichoke", OVERDUE_ARTICHOKE)
        register("overdue_artichoke_dip", OVERDUE_ARTICHOKE_DIP)
        register("overdue_asparagus", OVERDUE_ASPARAGUS)
        register("overdue_avocado", OVERDUE_AVOCADO)
        register("overdue_baked_beans", OVERDUE_BAKED_BEANS)
        register("overdue_banana", OVERDUE_BANANA)
        register("overdue_banana_cream_pie", OVERDUE_BANANA_CREAM_PIE)
        register("overdue_banana_nut_bread", OVERDUE_BANANA_NUT_BREAD)
        register("overdue_barley", OVERDUE_BARLEY)
        register("overdue_basil", OVERDUE_BASIL)
        register("overdue_bellpepper", OVERDUE_BELLPEPPER)
        register("overdue_blackbean", OVERDUE_BLACKBEAN)
        register("overdue_blackberry", OVERDUE_BLACKBERRY)
        register("salted_almond", SALTED_ALMOND)
        register("salted_almond_brittle", SALTED_ALMOND_BRITTLE)
        register("salted_apricot", SALTED_APRICOT)
        register("salted_artichoke", SALTED_ARTICHOKE)
        register("salted_artichoke_dip", SALTED_ARTICHOKE_DIP)
        register("salted_asparagus", SALTED_ASPARAGUS)
        register("salted_avocado", SALTED_AVOCADO)
        register("salted_baked_beans", SALTED_BAKED_BEANS)
        register("salted_banana_nut_bread", SALTED_BANANA_NUT_BREAD)
        register("salted_basil", SALTED_BASIL)
        register("salted_beef_jerky", SALTED_BEEF_JERKY)
        register("salted_beef_wellington", SALTED_BEEF_WELLINGTON)
        register("salted_blackbean", SALTED_BLACKBEAN)
    }

    /**
     * Registers an item to Minecraft
     * @param name Item name
     * @param item Registered item
     */
    private fun register(name: String, item: Item) {
        Registry.register(Registry.ITEM, Identifier(MOD_ID, name), item)
    }
}