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
        patch("candy_corn", "croptopia", ConfigRegistry.CANDY_CORN, ItemRegistry.OVERDUE_CANDY_CORN)
        patch("caramel", "croptopia", ConfigRegistry.CARAMEL, ItemRegistry.OVERDUE_CARAMEL)
        patch("cantaloupe", "croptopia", ConfigRegistry.CANTALOUPE, ItemRegistry.OVERDUE_CANTALOUPE)
        patch("carnitas", "croptopia", ConfigRegistry.CARNITAS, ItemRegistry.OVERDUE_CARNITAS)
        patch("cashew", "croptopia", ConfigRegistry.CASHEW, ItemRegistry.OVERDUE_CASHEW)
        patch("cashew_chicken", "croptopia", ConfigRegistry.CASHEW_CHICKEN, ItemRegistry.OVERDUE_CASHEW_CHICKEN)
        patch("cauliflower", "croptopia", ConfigRegistry.CAULIFLOWER, ItemRegistry.OVERDUE_CAULIFLOWER)
        patch("celery", "croptopia", ConfigRegistry.CELERY, ItemRegistry.OVERDUE_CELERY)
        patch("cheese", "croptopia", ConfigRegistry.CHEESE, ItemRegistry.OVERDUE_CHEESE)
        patch("cheese_cake", "croptopia", ConfigRegistry.CHEESE_CAKE, ItemRegistry.OVERDUE_CHEESE_CAKE)
        patch("cheese_pizza", "croptopia", ConfigRegistry.CHEESE_PIZZA, ItemRegistry.OVERDUE_CHEESE_PIZZA)
        patch("cheeseburger", "croptopia", ConfigRegistry.CHEESEBURGER, ItemRegistry.OVERDUE_CHEESEBURGER)
        patch("cherry", "croptopia", ConfigRegistry.CHERRY, ItemRegistry.OVERDUE_CHERRY)
        patch("cherry_jam", "croptopia", ConfigRegistry.CHERRY_JAM, ItemRegistry.OVERDUE_CHERRY_JAM)
        patch("cherry_pie", "croptopia", ConfigRegistry.CHERRY_PIE, ItemRegistry.OVERDUE_CHERRY_PIE)
        patch("chicken_and_dumplings", "croptopia", ConfigRegistry.CHICKEN_AND_DUMPLINGS, ItemRegistry.OVERDUE_CHICKEN_AND_DUMPLINGS)
        patch("chicken_and_noodles", "croptopia", ConfigRegistry.CHICKEN_AND_NOODLES, ItemRegistry.OVERDUE_CHICKEN_AND_NOODLES)
        patch("chicken_and_rice", "croptopia", ConfigRegistry.CHICKEN_AND_RICE, ItemRegistry.OVERDUE_CHICKEN_AND_RICE)
        patch("chile_pepper", "croptopia", ConfigRegistry.CHILE_PEPPER, ItemRegistry.OVERDUE_CHILE_PEPPER)
        patch("chili_relleno", "croptopia", ConfigRegistry.CHILI_RELLENO, ItemRegistry.OVERDUE_CHILI_RELLENO)
        patch("chimichanga", "croptopia", ConfigRegistry.CHIMICHANGA, ItemRegistry.OVERDUE_CHIMICHANGA)
        patch("chives", "croptopia", ConfigRegistry.CHIVES, ItemRegistry.OVERDUE_CHIVES)
        patch("chocolate", "croptopia", ConfigRegistry.CHOCOLATE, ItemRegistry.OVERDUE_CHOCOLATE)
        patch("chocolate_milkshake", "croptopia", ConfigRegistry.CHOCOLATE_MILKSHAKE, ItemRegistry.OVERDUE_CHOCOLATE_MILKSHAKE)
        patch("cinnamon", "croptopia", ConfigRegistry.CINNAMON, ItemRegistry.OVERDUE_CINNAMON)
        patch("coconut", "croptopia", ConfigRegistry.COCONUT, ItemRegistry.OVERDUE_COCONUT)
        patch("coffee", "croptopia", ConfigRegistry.COFFEE, ItemRegistry.OVERDUE_COFFEE)
        patch("coffee_beans", "croptopia", ConfigRegistry.COFFEE_BEANS, ItemRegistry.OVERDUE_COFFEE_BEANS)
        patch("corn", "croptopia", ConfigRegistry.CORN, ItemRegistry.OVERDUE_CORN)
        patch("cornish_pasty", "croptopia", ConfigRegistry.CORNISH_PASTY, ItemRegistry.OVERDUE_CORNISH_PASTY)
        patch("cranberry", "croptopia", ConfigRegistry.CRANBERRY, ItemRegistry.OVERDUE_CRANBERRY)
        patch("cranberry_juice", "croptopia", ConfigRegistry.CRANBERRY_JUICE, ItemRegistry.OVERDUE_CRANBERRY_JUICE)
        patch("crema", "croptopia", ConfigRegistry.CREMA, ItemRegistry.OVERDUE_CREMA)
        patch("cucumber", "croptopia", ConfigRegistry.CUCUMBER, ItemRegistry.OVERDUE_CUCUMBER)
        patch("cucumber_salad", "croptopia", ConfigRegistry.CUCUMBER_SALAD, ItemRegistry.OVERDUE_CUCUMBER_SALAD)
        patch("currant", "croptopia", ConfigRegistry.CURRANT, ItemRegistry.OVERDUE_CURRANT)
        patch("date", "croptopia", ConfigRegistry.DATE, ItemRegistry.OVERDUE_DATE)
        patch("donut", "croptopia", ConfigRegistry.DONUT, ItemRegistry.OVERDUE_DONUT)
        patch("dough", "croptopia", ConfigRegistry.DOUGH, ItemRegistry.OVERDUE_DOUGH)
        patch("doughnut", "croptopia", ConfigRegistry.DOUGHNUT, ItemRegistry.OVERDUE_DOUGHNUT)
        patch("dragonfruit", "croptopia", ConfigRegistry.DRAGONFRUIT, ItemRegistry.OVERDUE_DRAGONFRUIT)
        patch("egg_roll", "croptopia", ConfigRegistry.EGG_ROLL, ItemRegistry.OVERDUE_EGG_ROLL)
        patch("eggplant", "croptopia", ConfigRegistry.EGGPLANT, ItemRegistry.OVERDUE_EGGPLANT)
        patch("elderberry", "croptopia", ConfigRegistry.ELDERBERRY, ItemRegistry.OVERDUE_ELDERBERRY)
        patch("elderberry_jam", "croptopia", ConfigRegistry.ELDERBERRY_JAM, ItemRegistry.OVERDUE_ELDERBERRY_JAM)
        patch("enchilada", "croptopia", ConfigRegistry.ENCHILADA, ItemRegistry.OVERDUE_ENCHILADA)
        patch("eton_mess", "croptopia", ConfigRegistry.ETON_MESS, ItemRegistry.OVERDUE_ETON_MESS)
        patch("fajitas", "croptopia", ConfigRegistry.FAJITAS, ItemRegistry.OVERDUE_FAJITAS)
        patch("fig", "croptopia", ConfigRegistry.FIG, ItemRegistry.OVERDUE_FIG)
        patch("figgy_pudding", "croptopia", ConfigRegistry.FIGGY_PUDDING, ItemRegistry.OVERDUE_FIGGY_PUDDING)
        patch("fish_and_chips", "croptopia", ConfigRegistry.FISH_AND_CHIPS, ItemRegistry.OVERDUE_FISH_AND_CHIPS)
        patch("flour", "croptopia", ConfigRegistry.FLOUR, ItemRegistry.OVERDUE_FLOUR)
        patch("french_fries", "croptopia", ConfigRegistry.FRENCH_FRIES, ItemRegistry.OVERDUE_FRENCH_FRIES)
        patch("fried_chicken", "croptopia", ConfigRegistry.FRIED_CHICKEN, ItemRegistry.ROTTEN_FRIED_CHICKEN)
        patch("fruit_salad", "croptopia", ConfigRegistry.FRUIT_SALAD, ItemRegistry.OVERDUE_FRUIT_SALAD)
        patch("fruit_smoothie", "croptopia", ConfigRegistry.FRUIT_SMOOTHIE, ItemRegistry.OVERDUE_FRUIT_SMOOTHIE)
        patch("garlic", "croptopia", ConfigRegistry.GARLIC, ItemRegistry.OVERDUE_GARLIC)
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

        if (Registry.ITEM.containsId(id)) {
            return Registry.ITEM.get(id)
        } else {
            throw KotlinNullPointerException("Couldn't find registered item: $id")
        }
    }
}