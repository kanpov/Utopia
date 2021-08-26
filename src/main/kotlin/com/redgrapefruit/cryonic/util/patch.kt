package com.redgrapefruit.cryonic.util

import com.redgrapefruit.cryonic.LOG
import com.redgrapefruit.cryonic.item.OverdueFoodItem
import com.redgrapefruit.cryonic.item.RancidDrinkItem
import com.redgrapefruit.cryonic.item.RottenFoodItem
import com.redgrapefruit.cryonic.mixin.ItemAccessor
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

// <---- Patch Platform ---->

// <--- API --->

fun addComponent(name: String, namespace: String, component: FoodComponent) {
    addComponentInternal(name, namespace, component)
}

fun configureFood(name: String, namespace: String, variant: OverdueFoodItem) {
    configureFoodInternal(name, namespace, Either<OverdueFoodItem, RottenFoodItem>().first { variant })
}

fun configureFood(name: String, namespace: String, variant: RottenFoodItem) {
    configureFoodInternal(name, namespace, Either<OverdueFoodItem, RottenFoodItem>().second { variant })
}

fun configureDrink(name: String, namespace: String, variant: RancidDrinkItem) {
    configureDrinkInternal(name, namespace, variant)
}

// <--- Internal --->

private fun addComponentInternal(name: String, namespace: String, component: FoodComponent) {
    // Validate & get
    if (!validate(name, namespace, "add FoodComponent")) return
    val target = fetchItemFromRegistry(name, namespace)
    // Safe-cast to accessor
    if (target !is ItemAccessor) {
        LOG.error("Could not add FoodComponent to $namespace:$name: critical mixin failure")
        return
    }
    // Assign component via the accessor
    target.setFoodComponent(component)
}

private fun configureFoodInternal(name: String, namespace: String, variantEither: Either<OverdueFoodItem, RottenFoodItem>) {
    // Validate & get
    if (!validate(name, namespace, "apply food patch")) return
    val target = fetchItemFromRegistry(name, namespace)
    // Safe-cast to MDI
    if (target !is ItemFoodMixinAccess) {
        LOG.error("Could not apply patch to $namespace:$name: critical mixin failure")
        return
    }

    // Assign main properties
    target.activateFood()
    target.named(name) // this also registers to the init callback with the given name for later
    // Assign variants
    if (variantEither.areNeitherPresent()) {
        LOG.error("Could not apply patch to $namespace:$name: neither variants are present")
        return
    }
    if (variantEither.isFirstPresent()) {
        target.setOverdueVariant(variantEither.first!!)
    }
    if (variantEither.isSecondPresent()) {
        target.setRottenVariant(variantEither.second!!)
    }
}

private fun configureDrinkInternal(name: String, namespace: String, variant: RancidDrinkItem) {
    // Validate & get
    if (!validate(name, namespace, "apply drink patch")) return
    val target = fetchItemFromRegistry(name, namespace)
    // Safe-cast to MDI
    if (target !is ItemDrinkMixinAccess) {
        LOG.error("Could not apply patch to $namespace:$name: critical mixin failure")
        return
    }

    // Assign properties
    target.activateDrink()
    target.setComponent(variant.component)
    target.setRancidVariant(variant)
    target.setRancidSpeed(variant.rancidSpeed)
    target.setRancidState(variant.rancidState)
}

private fun validate(name: String, namespace: String, message: String): Boolean {
    val id = Identifier(namespace, name)

    // Check if the target item exists in the global registry
    if (!Registry.ITEM.containsId(id)) {
        LOG.error("Could not $message to $id: the target does not exist or isn't registered at the time of execution")
        return false
    }

    return true
}

private fun fetchItemFromRegistry(name: String, namespace: String): Item = Registry.ITEM.get(Identifier(namespace, name))
