package com.redgrapefruit.utopia.registry

import com.redgrapefruit.utopia.*
import com.redgrapefruit.utopia.item.RancidDrinkItem
import com.redgrapefruit.utopia.util.IRegistry
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

/**
 * Registry for drinks
 */
object DrinkRegistry : IRegistry {
    val RANCID_APPLE_JUICE = RancidDrinkItem(EDIBLE_5, 7, 85000)
    val RANCID_APRICOT_JAM = RancidDrinkItem(EDIBLE_5, 9, 95000)
    val RANCID_BLACKBERRY_JAM = RancidDrinkItem(EDIBLE_3, 6, 105000)
    val RANCID_BLUEBERRY_JAM = RancidDrinkItem(EDIBLE_3, 5, 115000)
    val RANCID_CHERRY_JAM = RancidDrinkItem(EDIBLE_3, 8, 90000)
    val RANCID_CHOCOLATE_MILKSHAKE = RancidDrinkItem(EDIBLE_5, 11, 120000)
    val RANCID_COFFEE = RancidDrinkItem(EDIBLE_3, 16, 75000)
    val RANCID_CRANBERRY_JUICE = RancidDrinkItem(EDIBLE_3, 9, 100000)
    val RANCID_ELDERBERRY_JAM = RancidDrinkItem(EDIBLE_3, 10, 80000)
    val RANCID_FRUIT_SMOOTHIE = RancidDrinkItem(EDIBLE_7, 18, 90000)
    val RANCID_GRAPE_JAM = RancidDrinkItem(EDIBLE_5, 8, 107500)
    val RANCID_HORCHATA = RancidDrinkItem(EDIBLE_1, 6, 127500)
    val RANCID_KALE_SMOOTHIE = RancidDrinkItem(EDIBLE_7, 17, 95000)
    val RANCID_LEMONADE = RancidDrinkItem(EDIBLE_3, 8, 90000)
    val RANCID_LIMEADE = RancidDrinkItem(EDIBLE_3, 7, 85000)
    val RANCID_MEAD = RancidDrinkItem(EDIBLE_1, 4, 170000)
    val RANCID_MELON_JUICE = RancidDrinkItem(EDIBLE_3, 10, 150000)
    val RANCID_MILK_BOTTLE = RancidDrinkItem(EDIBLE_5, 24, 105000)
    val RANCID_OLIVE_OIL = RancidDrinkItem(YUCK, 3, 235000)
    val RANCID_ORANGE_JUICE = RancidDrinkItem(EDIBLE_3, 6, 110000)
    val RANCID_PEACH_JAM = RancidDrinkItem(EDIBLE_3, 8, 90000)
    val RANCID_PINEAPPLE_JUICE = RancidDrinkItem(EDIBLE_3, 7, 120000)
    val RANCID_PUMPKIN_SPICE_LATTE = RancidDrinkItem(EDIBLE_3, 9, 135000)
    val RANCID_RASPBERRY_JAM = RancidDrinkItem(EDIBLE_5, 12, 145500)
    val RANCID_RUM = RancidDrinkItem(EDIBLE_5, 15, 190000)
    val RANCID_SAGUARO_JUICE = RancidDrinkItem(EDIBLE_3, 8, 127500)
    val RANCID_SOY_MILK = RancidDrinkItem(EDIBLE_5, 21, 110000)

    override fun run() {
        register("rancid_apple_juice", RANCID_APPLE_JUICE)
        register("rancid_apricot_jam", RANCID_APRICOT_JAM)
        register("rancid_blackberry_jam", RANCID_BLACKBERRY_JAM)
        register("rancid_blueberry_jam", RANCID_BLUEBERRY_JAM)
        register("rancid_cherry_jam", RANCID_CHERRY_JAM)
        register("rancid_chocolate_milkshake", RANCID_CHOCOLATE_MILKSHAKE)
        register("rancid_coffee", RANCID_COFFEE)
        register("rancid_cranberry_juice", RANCID_CRANBERRY_JUICE)
        register("rancid_elderberry_jam", RANCID_ELDERBERRY_JAM)
        register("rancid_fruit_smoothie", RANCID_FRUIT_SMOOTHIE)
        register("rancid_grape_jam", RANCID_GRAPE_JAM)
        register("rancid_horchata", RANCID_HORCHATA)
        register("rancid_kale_smoothie", RANCID_KALE_SMOOTHIE)
        register("rancid_lemonade", RANCID_LEMONADE)
        register("rancid_limeade", RANCID_LIMEADE)
        register("rancid_mead", RANCID_MEAD)
        register("rancid_melon_juice", RANCID_MELON_JUICE)
        register("rancid_milk_bottle", RANCID_MILK_BOTTLE)
        register("rancid_olive_oil", RANCID_OLIVE_OIL)
        register("rancid_orange_juice", RANCID_ORANGE_JUICE)
        register("rancid_peach_jam", RANCID_PEACH_JAM)
        register("rancid_pineapple_juice", RANCID_PINEAPPLE_JUICE)
        register("rancid_pumpkin_spice_latte", RANCID_PUMPKIN_SPICE_LATTE)
        register("rancid_raspberry_jam", RANCID_RASPBERRY_JAM)
        register("rancid_rum", RANCID_RUM)
        register("rancid_soy_milk", RANCID_SOY_MILK)
    }

    private fun register(name: String, item: Item) {
        Registry.register(Registry.ITEM, Identifier(MOD_ID, name), item)
    }
}
