package com.redgrapefruit.utopia.registry

import com.redgrapefruit.utopia.MOD_ID
import com.redgrapefruit.utopia.item.OverdueFoodItem
import com.redgrapefruit.utopia.item.RottenFoodItem
import com.redgrapefruit.utopia.item.SaltedFoodItem
import com.redgrapefruit.utopia.util.IRegistry
import com.redgrapefruit.utopia.util.Module
import com.redgrapefruit.utopia.util.moduleSpecific
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

/**
 * A registry for foods
 */
@Suppress("MemberVisibilityCanBePrivate")
object FoodRegistry : IRegistry {
    // Rotten food
    val ROTTEN_BEEF_JERKY = RottenFoodItem("beef_jerky")
    val ROTTEN_BEEF_WELLINGTON = RottenFoodItem("beef_wellington")
    val ROTTEN_FRIED_CHICKEN = RottenFoodItem("fried_chicken")
    val ROTTEN_LEMON_CHICKEN = RottenFoodItem("lemon_chicken")
    val ROTTEN_PORK_JERKY = RottenFoodItem("pork_jerky")

    // Overdue food
    val OVERDUE_ALMOND = OverdueFoodItem("almond")
    val OVERDUE_ALMOND_BRITTLE = OverdueFoodItem("almond_brittle")
    val OVERDUE_APPLE_PIE = OverdueFoodItem("apple_pie")
    val OVERDUE_APRICOT = OverdueFoodItem("apricot")
    val OVERDUE_ARTICHOKE = OverdueFoodItem("artichoke")
    val OVERDUE_ARTICHOKE_DIP = OverdueFoodItem("artichoke_dip")
    val OVERDUE_ASPARAGUS = OverdueFoodItem("asparagus")
    val OVERDUE_AVOCADO = OverdueFoodItem("avocado")
    val OVERDUE_BAKED_BEANS = OverdueFoodItem("baked_beans")
    val OVERDUE_BANANA = OverdueFoodItem("banana")
    val OVERDUE_BANANA_CREAM_PIE = OverdueFoodItem("banana_cream_pie")
    val OVERDUE_BANANA_NUT_BREAD = OverdueFoodItem("banana_nut_bread")
    val OVERDUE_BARLEY = OverdueFoodItem("barley")
    val OVERDUE_BASIL = OverdueFoodItem("basil")
    val OVERDUE_BELLPEPPER = OverdueFoodItem("bellpepper")
    val OVERDUE_BLACKBEAN = OverdueFoodItem("blackbean")
    val OVERDUE_BLACKBERRY = OverdueFoodItem("blackberry")
    val OVERDUE_BLT = OverdueFoodItem("blt")
    val OVERDUE_BLUEBERRY = OverdueFoodItem("blueberry")
    val OVERDUE_BROCCOLI = OverdueFoodItem("broccoli")
    val OVERDUE_BROWNIES = OverdueFoodItem("brownies")
    val OVERDUE_BURRITO = OverdueFoodItem("burrito")
    val OVERDUE_BUTTER = OverdueFoodItem("butter")
    val OVERDUE_BUTTERED_TOAST = OverdueFoodItem("buttered_toast")
    val OVERDUE_CABBAGE = OverdueFoodItem("cabbage")
    val OVERDUE_CAESAR_SALAD = OverdueFoodItem("caesar_salad")
    val OVERDUE_CANDIED_NUTS = OverdueFoodItem("candied_nuts")
    val OVERDUE_CANDY_CORN = OverdueFoodItem("candy_corn")
    val OVERDUE_CARAMEL = OverdueFoodItem("caramel")
    val OVERDUE_CANTALOUPE = OverdueFoodItem("cantaloupe")
    val OVERDUE_CARNITAS = OverdueFoodItem("carnitas")
    val OVERDUE_CASHEW = OverdueFoodItem("cashew")
    val OVERDUE_CASHEW_CHICKEN = OverdueFoodItem("cashew_chicken")
    val OVERDUE_CAULIFLOWER = OverdueFoodItem("cauliflower")
    val OVERDUE_CELERY = OverdueFoodItem("celery")
    val OVERDUE_CHEESE = OverdueFoodItem("cheese")
    val OVERDUE_CHEESE_CAKE = OverdueFoodItem("cheese_cake")
    val OVERDUE_CHEESE_PIZZA = OverdueFoodItem("cheese_pizza")
    val OVERDUE_CHEESEBURGER = OverdueFoodItem("cheeseburger")
    val OVERDUE_CHERRY = OverdueFoodItem("cherry")
    val OVERDUE_CHERRY_PIE = OverdueFoodItem("cherry_pie")
    val OVERDUE_CHICKEN_AND_DUMPLINGS = OverdueFoodItem("chicken_and_dumplings")
    val OVERDUE_CHICKEN_AND_NOODLES = OverdueFoodItem("chicken_and_noodles")
    val OVERDUE_CHICKEN_AND_RICE = OverdueFoodItem("chicken_and_rice")
    val OVERDUE_CHILE_PEPPER = OverdueFoodItem("chile_pepper")
    val OVERDUE_CHILI_RELLENO = OverdueFoodItem("chili_relleno")
    val OVERDUE_CHIMICHANGA = OverdueFoodItem("chimichanga")
    val OVERDUE_CHOCOLATE = OverdueFoodItem("chocolate")
    val OVERDUE_CINNAMON = OverdueFoodItem("cinnamon")
    val OVERDUE_COCONUT = OverdueFoodItem("coconut")
    val OVERDUE_COFFEE_BEANS = OverdueFoodItem("coffee_beans")
    val OVERDUE_CORN = OverdueFoodItem("corn")
    val OVERDUE_CORNISH_PASTY = OverdueFoodItem("cornish_pasty")
    val OVERDUE_CRANBERRY = OverdueFoodItem("cranberry")
    val OVERDUE_CREMA = OverdueFoodItem("crema")
    val OVERDUE_CUCUMBER = OverdueFoodItem("cucumber")
    val OVERDUE_CUCUMBER_SALAD = OverdueFoodItem("cucumber_salad")
    val OVERDUE_CURRANT = OverdueFoodItem("currant")
    val OVERDUE_DATE = OverdueFoodItem("date")
    val OVERDUE_DOUGH = OverdueFoodItem("dough")
    val OVERDUE_DOUGHNUT = OverdueFoodItem("doughnut")
    val OVERDUE_DRAGONFRUIT = OverdueFoodItem("dragonfruit")
    val OVERDUE_EGG_ROLL = OverdueFoodItem("egg_roll")
    val OVERDUE_EGGPLANT = OverdueFoodItem("eggplant")
    val OVERDUE_ELDERBERRY = OverdueFoodItem("elderberry")
    val OVERDUE_ENCHILADA = OverdueFoodItem("enchilada")
    val OVERDUE_ETON_MESS = OverdueFoodItem("eton_mess")
    val OVERDUE_FAJITAS = OverdueFoodItem("fajitas")
    val OVERDUE_FIG = OverdueFoodItem("fig")
    val OVERDUE_FIGGY_PUDDING = OverdueFoodItem("figgy_pudding")
    val OVERDUE_FISH_AND_CHIPS = OverdueFoodItem("fish_and_chips")
    val OVERDUE_FLOUR = OverdueFoodItem("flour")
    val OVERDUE_FRENCH_FRIES = OverdueFoodItem("french_fries")
    val OVERDUE_FRUIT_SALAD = OverdueFoodItem("fruit_salad")
    val OVERDUE_GARLIC = OverdueFoodItem("garlic")
    val OVERDUE_GINGER = OverdueFoodItem("ginger")
    val OVERDUE_GRAPE = OverdueFoodItem("grape")
    val OVERDUE_GRAPEFRUIT = OverdueFoodItem("grapefruit")
    val OVERDUE_GREENBEAN = OverdueFoodItem("greenbean")
    val OVERDUE_GREENONION = OverdueFoodItem("greenonion")
    val OVERDUE_GRILLED_CHEESE = OverdueFoodItem("grilled_cheese")
    val OVERDUE_HAM_SANDWICH = OverdueFoodItem("ham_sandwich")
    val OVERDUE_HAMBURGER = OverdueFoodItem("hamburger")
    val OVERDUE_HOPS = OverdueFoodItem("hops")
    val OVERDUE_KALE = OverdueFoodItem("kale")
    val OVERDUE_KALE_CHIPS = OverdueFoodItem("kale_chips")
    val OVERDUE_KIWI = OverdueFoodItem("kiwi")
    val OVERDUE_KUMQUAT = OverdueFoodItem("kumquat")
    val OVERDUE_LEAFY_SALAD = OverdueFoodItem("leafy_salad")
    val OVERDUE_LEEK = OverdueFoodItem("leek")
    val OVERDUE_LEEK_SOUP = OverdueFoodItem("leek_soup")
    val OVERDUE_LEMON = OverdueFoodItem("lemon")
    val OVERDUE_LETTUCE = OverdueFoodItem("lettuce")
    val OVERDUE_LIME = OverdueFoodItem("lime")
    val OVERDUE_MANGO = OverdueFoodItem("mango")
    val OVERDUE_MANGO_ICE_CREAM = OverdueFoodItem("mango_ice_cream")
    val OVERDUE_MOLASSES = OverdueFoodItem("molasses")
    val OVERDUE_MUSTARD = OverdueFoodItem("mustard")
    val OVERDUE_NECTARINE = OverdueFoodItem("nectarine")
    val OVERDUE_NOODLE = OverdueFoodItem("noodle")
    val OVERDUE_NOUGAT = OverdueFoodItem("nougat")
    val OVERDUE_NUTMEG = OverdueFoodItem("nutmeg")
    val OVERDUE_NUTTY_COOKIE = OverdueFoodItem("nutty_cookie")
    val OVERDUE_OAT = OverdueFoodItem("oat")
    val OVERDUE_OATMEAL = OverdueFoodItem("oatmeal")
    val OVERDUE_OLIVE = OverdueFoodItem("olive")
    val OVERDUE_ONION = OverdueFoodItem("onion")
    val OVERDUE_ONION_RINGS = OverdueFoodItem("onion_rings")
    val OVERDUE_ORANGE = OverdueFoodItem("orange")
    val OVERDUE_PAPRIKA = OverdueFoodItem("paprika")
    val OVERDUE_PEACH = OverdueFoodItem("peach")
    val OVERDUE_PEANUT = OverdueFoodItem("peanut")
    val OVERDUE_PEANUT_BUTTER_AND_JAM = OverdueFoodItem("peanut_butter_and_jam")
    val OVERDUE_PEAR = OverdueFoodItem("pear")
    val OVERDUE_PECAN = OverdueFoodItem("pecan")
    val OVERDUE_PECAN_ICE_CREAM = OverdueFoodItem("pecan_ice_cream")
    val OVERDUE_PECAN_PIE = OverdueFoodItem("pecan_pie")
    val OVERDUE_PEPPER = OverdueFoodItem("pepper")
    val OVERDUE_PEPPERONI = OverdueFoodItem("pepperoni")
    val OVERDUE_PERSIMMON = OverdueFoodItem("persimmon")
    val OVERDUE_PINEAPPLE = OverdueFoodItem("pineapple")
    val OVERDUE_PINEAPPLE_PEPPERONI_PIZZA = OverdueFoodItem("pineapple_pepperoni_pizza")
    val OVERDUE_PIZZA = OverdueFoodItem("pizza")
    val OVERDUE_PLUM = OverdueFoodItem("plum")
    val OVERDUE_POPCORN = OverdueFoodItem("popcorn")
    val OVERDUE_PORK_AND_BEANS = OverdueFoodItem("pork_and_beans")
    val OVERDUE_POTATO_CHIPS = OverdueFoodItem("potato_chips")
    val OVERDUE_PROTEIN_BAR = OverdueFoodItem("protein_bar")
    val OVERDUE_QUESADILLA = OverdueFoodItem("quesadilla")
    val OVERDUE_RADISH = OverdueFoodItem("radish")
    val OVERDUE_RAISIN_OATMEAL_COOKIE = OverdueFoodItem("raisin_oatmeal_cookie")
    val OVERDUE_RAISINS = OverdueFoodItem("raisins")
    val OVERDUE_RASPBERRY = OverdueFoodItem("raspberry")
    val OVERDUE_RAVIOLI = OverdueFoodItem("ravioli")
    val OVERDUE_REFRIED_BEANS = OverdueFoodItem("refried_beans")
    val OVERDUE_RHUBARB = OverdueFoodItem("rhubarb")

    // Salted food
    val SALTED_ALMOND = SaltedFoodItem("almond")
    val SALTED_ALMOND_BRITTLE = SaltedFoodItem("almond_brittle")
    val SALTED_APRICOT = SaltedFoodItem("apricot")
    val SALTED_ARTICHOKE = SaltedFoodItem("artichoke")
    val SALTED_ARTICHOKE_DIP = SaltedFoodItem("artichoke_dip")
    val SALTED_ASPARAGUS = SaltedFoodItem("asparagus")
    val SALTED_AVOCADO = SaltedFoodItem("avocado")
    val SALTED_BAKED_BEANS = SaltedFoodItem("baked_beans")
    val SALTED_BANANA_NUT_BREAD = SaltedFoodItem("banana_nut_bread")
    val SALTED_BASIL = SaltedFoodItem("basil")
    val SALTED_BEEF_JERKY = SaltedFoodItem("beef_jerky")
    val SALTED_BEEF_WELLINGTON = SaltedFoodItem("beef_wellington")
    val SALTED_BLACKBEAN = SaltedFoodItem("blackbean")
    val SALTED_BROCCOLI = SaltedFoodItem("broccoli")
    val SALTED_CABBAGE = SaltedFoodItem("cabbage")
    val SALTED_CAESAR_SALAD = SaltedFoodItem("caesar_salad")
    val SALTED_CANTALOUPE = SaltedFoodItem("cantaloupe")
    val SALTED_CARNITAS = SaltedFoodItem("carnitas")
    val SALTED_CASHEW = SaltedFoodItem("cashew")
    val SALTED_CASHEW_CHICKEN = SaltedFoodItem("cashew_chicken")
    val SALTED_CAULIFLOWER = SaltedFoodItem("cauliflower")
    val SALTED_CELERY = SaltedFoodItem("celery")
    val SALTED_CHICKEN_AND_DUMPLINGS = SaltedFoodItem("chicken_and_dumplings")
    val SALTED_CHICKEN_AND_NOODLES = SaltedFoodItem("chicken_and_noodles")
    val SALTED_CHICKEN_AND_RICE = SaltedFoodItem("chicken_and_rice")
    val SALTED_CHIMICHANGA = SaltedFoodItem("chimichanga")
    val SALTED_CORN = SaltedFoodItem("corn")
    val SALTED_CREMA = SaltedFoodItem("crema")
    val SALTED_CUCUMBER = SaltedFoodItem("cucumber")
    val SALTED_CUCUMBER_SALAD = SaltedFoodItem("cucumber_salad")
    val SALTED_EGG_ROLL = SaltedFoodItem("egg_roll")
    val SALTED_EGGPLANT = SaltedFoodItem("eggplant")
    val SALTED_FIG = SaltedFoodItem("fig")
    val SALTED_FISH_AND_CHIPS = SaltedFoodItem("fish_and_chips")
    val SALTED_FRENCH_FRIES = SaltedFoodItem("french_fries")
    val SALTED_FRIED_CHICKEN = SaltedFoodItem("fried_chicken")
    val SALTED_GARLIC = SaltedFoodItem("garlic")
    val SALTED_GREENBEAN = SaltedFoodItem("greenbean")
    val SALTED_KALE = SaltedFoodItem("kale")
    val SALTED_KALE_CHIPS = SaltedFoodItem("kale_chips")
    val SALTED_KUMQUAT = SaltedFoodItem("kumquat")
    val SALTED_LEAFY_SALAD = SaltedFoodItem("leafy_salad")
    val SALTED_LEEK = SaltedFoodItem("leek")
    val SALTED_LEEK_SOUP = SaltedFoodItem("leek_soup")
    val SALTED_LETTUCE = SaltedFoodItem("lettuce")
    val SALTED_NUTMEG = SaltedFoodItem("nutmeg")
    val SALTED_OAT = SaltedFoodItem("oat")
    val SALTED_OLIVE = SaltedFoodItem("olive")
    val SALTED_ONION_RINGS = SaltedFoodItem("onion_rings")
    val SALTED_PAPRIKA = SaltedFoodItem("paprika")
    val SALTED_PEANUT = SaltedFoodItem("peanut")
    val SALTED_PECAN = SaltedFoodItem("pecan")
    val SALTED_PEPPERONI = SaltedFoodItem("pepperoni")
    val SALTED_PINEAPPLE = SaltedFoodItem("pineapple")
    val SALTED_POPCORN = SaltedFoodItem("popcorn")
    val SALTED_POTATO_CHIPS = SaltedFoodItem("potato_chips")
    val SALTED_RAISINS = SaltedFoodItem("raisins")
    val SALTED_REFRIED_BEANS = SaltedFoodItem("refried_beans")

    // Fresh food

    override fun run(): Unit = moduleSpecific(Module.REALISM) {
        register("rotten_beef_jerky", ROTTEN_BEEF_JERKY)
        register("rotten_beef_wellington", ROTTEN_BEEF_WELLINGTON)
        register("rotten_fried_chicken", ROTTEN_FRIED_CHICKEN)
        register("rotten_lemon_chicken", ROTTEN_LEMON_CHICKEN)
        register("rotten_pork_jerky", ROTTEN_PORK_JERKY)
        register("overdue_almond", OVERDUE_ALMOND)
        register("overdue_almond_brittle", OVERDUE_ALMOND_BRITTLE)
        register("overdue_apple_pie", OVERDUE_APPLE_PIE)
        register("overdue_apricot", OVERDUE_APRICOT)
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
        register("overdue_blt", OVERDUE_BLT)
        register("overdue_blueberry", OVERDUE_BLUEBERRY)
        register("overdue_broccoli", OVERDUE_BROCCOLI)
        register("overdue_brownies", OVERDUE_BROWNIES)
        register("overdue_burrito", OVERDUE_BURRITO)
        register("overdue_butter", OVERDUE_BUTTER)
        register("overdue_buttered_toast", OVERDUE_BUTTERED_TOAST)
        register("overdue_cabbage", OVERDUE_CABBAGE)
        register("overdue_caesar_salad", OVERDUE_CAESAR_SALAD)
        register("overdue_candied_nuts", OVERDUE_CANDIED_NUTS)
        register("overdue_candy_corn", OVERDUE_CANDY_CORN)
        register("overdue_caramel", OVERDUE_CARAMEL)
        register("overdue_cantaloupe", OVERDUE_CANTALOUPE)
        register("overdue_carnitas", OVERDUE_CARNITAS)
        register("overdue_cashew", OVERDUE_CASHEW)
        register("overdue_cashew_chicken", OVERDUE_CASHEW_CHICKEN)
        register("overdue_cauliflower", OVERDUE_CAULIFLOWER)
        register("overdue_celery", OVERDUE_CELERY)
        register("overdue_cheese", OVERDUE_CHEESE)
        register("overdue_cheese_cake", OVERDUE_CHEESE_CAKE)
        register("overdue_cheese_pizza", OVERDUE_CHEESE_PIZZA)
        register("overdue_cheeseburger", OVERDUE_CHEESEBURGER)
        register("overdue_cherry", OVERDUE_CHERRY)
        register("overdue_cherry_pie", OVERDUE_CHERRY_PIE)
        register("overdue_chicken_and_dumplings", OVERDUE_CHICKEN_AND_DUMPLINGS)
        register("overdue_chicken_and_noodles", OVERDUE_CHICKEN_AND_NOODLES)
        register("overdue_chicken_and_rice", OVERDUE_CHICKEN_AND_RICE)
        register("overdue_chile_pepper", OVERDUE_CHILE_PEPPER)
        register("overdue_chili_relleno", OVERDUE_CHILI_RELLENO)
        register("overdue_chimichanga", OVERDUE_CHIMICHANGA)
        register("overdue_chocolate", OVERDUE_CHOCOLATE)
        register("overdue_cinnamon", OVERDUE_CINNAMON)
        register("overdue_coconut", OVERDUE_COCONUT)
        register("overdue_coffee_beans", OVERDUE_COFFEE_BEANS)
        register("overdue_corn", OVERDUE_CORN)
        register("overdue_cornish_pasty", OVERDUE_CORNISH_PASTY)
        register("overdue_cranberry", OVERDUE_CRANBERRY)
        register("overdue_crema", OVERDUE_CREMA)
        register("overdue_cucumber", OVERDUE_CUCUMBER)
        register("overdue_cucumber_salad", OVERDUE_CUCUMBER_SALAD)
        register("overdue_currant", OVERDUE_CURRANT)
        register("overdue_date", OVERDUE_DATE)
        register("overdue_dough", OVERDUE_DOUGH)
        register("overdue_doughnut", OVERDUE_DOUGHNUT)
        register("overdue_dragonfruit", OVERDUE_DRAGONFRUIT)
        register("overdue_egg_roll", OVERDUE_EGG_ROLL)
        register("overdue_eggplant", OVERDUE_EGGPLANT)
        register("overdue_elderberry", OVERDUE_ELDERBERRY)
        register("overdue_enchilada", OVERDUE_ENCHILADA)
        register("overdue_eton_mess", OVERDUE_ETON_MESS)
        register("overdue_fajitas", OVERDUE_FAJITAS)
        register("overdue_fig", OVERDUE_FIG)
        register("overdue_figgy_pudding", OVERDUE_FIGGY_PUDDING)
        register("overdue_fish_and_chips", OVERDUE_FISH_AND_CHIPS)
        register("overdue_flour", OVERDUE_FLOUR)
        register("overdue_french_fries", OVERDUE_FRENCH_FRIES)
        register("overdue_fruit_salad", OVERDUE_FRUIT_SALAD)
        register("overdue_garlic", OVERDUE_GARLIC)
        register("overdue_ginger", OVERDUE_GINGER)
        register("overdue_grape", OVERDUE_GRAPE)
        register("overdue_grapefruit", OVERDUE_GRAPEFRUIT)
        register("overdue_greenbean", OVERDUE_GREENBEAN)
        register("overdue_greenonion", OVERDUE_GREENONION)
        register("overdue_grilled_cheese", OVERDUE_GRILLED_CHEESE)
        register("overdue_ham_sandwich", OVERDUE_HAM_SANDWICH)
        register("overdue_hamburger", OVERDUE_HAMBURGER)
        register("overdue_hops", OVERDUE_HOPS)
        register("overdue_kale", OVERDUE_KALE)
        register("overdue_kale_chips", OVERDUE_KALE_CHIPS)
        register("overdue_kiwi", OVERDUE_KIWI)
        register("overdue_kumquat", OVERDUE_KUMQUAT)
        register("overdue_leafy_salad", OVERDUE_LEAFY_SALAD)
        register("overdue_leek", OVERDUE_LEEK)
        register("overdue_leek_soup", OVERDUE_LEEK_SOUP)
        register("overdue_lemon", OVERDUE_LEMON)
        register("overdue_lettuce", OVERDUE_LETTUCE)
        register("overdue_lime", OVERDUE_LIME)
        register("overdue_mango", OVERDUE_MANGO)
        register("overdue_mango_ice_cream", OVERDUE_MANGO_ICE_CREAM)
        register("overdue_molasses", OVERDUE_MOLASSES)
        register("overdue_mustard", OVERDUE_MUSTARD)
        register("overdue_nectarine", OVERDUE_NECTARINE)
        register("overdue_noodle", OVERDUE_NOODLE)
        register("overdue_nougat", OVERDUE_NOUGAT)
        register("overdue_nutmeg", OVERDUE_NUTMEG)
        register("overdue_nutty_cookie", OVERDUE_NUTTY_COOKIE)
        register("overdue_oat", OVERDUE_OAT)
        register("overdue_oatmeal", OVERDUE_OATMEAL)
        register("overdue_olive", OVERDUE_OLIVE)
        register("overdue_onion", OVERDUE_ONION)
        register("overdue_onion_rings", OVERDUE_ONION_RINGS)
        register("overdue_orange", OVERDUE_ORANGE)
        register("overdue_paprika", OVERDUE_PAPRIKA)
        register("overdue_peach", OVERDUE_PEACH)
        register("overdue_peanut", OVERDUE_PEANUT)
        register("overdue_peanut_butter_and_jam", OVERDUE_PEANUT_BUTTER_AND_JAM)
        register("overdue_pear", OVERDUE_PEAR)
        register("overdue_pecan", OVERDUE_PECAN)
        register("overdue_pecan_ice_cream", OVERDUE_PECAN_ICE_CREAM)
        register("overdue_pecan_pie", OVERDUE_PECAN_PIE)
        register("overdue_pepper", OVERDUE_PEPPER)
        register("overdue_pepperoni", OVERDUE_PEPPERONI)
        register("overdue_persimmon", OVERDUE_PERSIMMON)
        register("overdue_pineapple", OVERDUE_PINEAPPLE)
        register("overdue_pineapple_pepperoni_pizza", OVERDUE_PINEAPPLE_PEPPERONI_PIZZA)
        register("overdue_pizza", OVERDUE_PIZZA)
        register("overdue_plum", OVERDUE_PLUM)
        register("overdue_popcorn", OVERDUE_POPCORN)
        register("overdue_pork_and_beans", OVERDUE_PORK_AND_BEANS)
        register("overdue_potato_chips", OVERDUE_POTATO_CHIPS)
        register("overdue_protein_bar", OVERDUE_PROTEIN_BAR)
        register("overdue_quesadilla", OVERDUE_QUESADILLA)
        register("overdue_radish", OVERDUE_RADISH)
        register("overdue_raisin_oatmeal_cookie", OVERDUE_RAISIN_OATMEAL_COOKIE)
        register("overdue_raisins", OVERDUE_RAISINS)
        register("overdue_raspberry", OVERDUE_RASPBERRY)
        register("overdue_ravioli", OVERDUE_RAVIOLI)
        register("overdue_refried_beans", OVERDUE_REFRIED_BEANS)
        register("overdue_rhubarb", OVERDUE_RHUBARB)
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
        register("salted_broccoli", SALTED_BROCCOLI)
        register("salted_cabbage", SALTED_CABBAGE)
        register("salted_caesar_salad", SALTED_CAESAR_SALAD)
        register("salted_cantaloupe", SALTED_CANTALOUPE)
        register("salted_carnitas", SALTED_CARNITAS)
        register("salted_cashew", SALTED_CASHEW)
        register("salted_cashew_chicken", SALTED_CASHEW_CHICKEN)
        register("salted_cauliflower", SALTED_CAULIFLOWER)
        register("salted_celery", SALTED_CELERY)
        register("salted_chicken_and_dumplings", SALTED_CHICKEN_AND_DUMPLINGS)
        register("salted_chicken_and_noodles", SALTED_CHICKEN_AND_NOODLES)
        register("salted_chicken_and_rice", SALTED_CHICKEN_AND_RICE)
        register("salted_chimichanga", SALTED_CHIMICHANGA)
        register("salted_corn", SALTED_CORN)
        register("salted_crema", SALTED_CREMA)
        register("salted_cucumber", SALTED_CUCUMBER)
        register("salted_cucumber_salad", SALTED_CUCUMBER_SALAD)
        register("salted_egg_roll", SALTED_EGG_ROLL)
        register("salted_eggplant", SALTED_EGGPLANT)
        register("salted_fig", SALTED_FIG)
        register("salted_fish_and_chips", SALTED_FISH_AND_CHIPS)
        register("salted_french_fries", SALTED_FRENCH_FRIES)
        register("salted_fried_chicken", SALTED_FRIED_CHICKEN)
        register("salted_garlic", SALTED_GARLIC)
        register("salted_greenbean", SALTED_GREENBEAN)
        register("salted_kale", SALTED_KALE)
        register("salted_kale_chips", SALTED_KALE_CHIPS)
        register("salted_kumquat", SALTED_KUMQUAT)
        register("salted_leafy_salad", SALTED_LEAFY_SALAD)
        register("salted_leek", SALTED_LEEK)
        register("salted_leek_soup", SALTED_LEEK_SOUP)
        register("salted_lettuce", SALTED_LETTUCE)
        register("salted_nutmeg", SALTED_NUTMEG)
        register("salted_oat", SALTED_OAT)
        register("salted_olive", SALTED_OLIVE)
        register("salted_onion_rings", SALTED_ONION_RINGS)
        register("salted_paprika", SALTED_PAPRIKA)
        register("salted_peanut", SALTED_PEANUT)
        register("salted_pecan", SALTED_PECAN)
        register("salted_pepperoni", SALTED_PEPPERONI)
        register("salted_pineapple", SALTED_PINEAPPLE)
        register("salted_popcorn", SALTED_POPCORN)
        register("salted_potato_chips", SALTED_POTATO_CHIPS)
        register("salted_raisins", SALTED_RAISINS)
        register("salted_refried_beans", SALTED_REFRIED_BEANS)
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