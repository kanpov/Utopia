package com.redgrapefruit.utopia.util

import com.redgrapefruit.utopia.LOG
import com.redgrapefruit.utopia.core.FoodProfile
import com.redgrapefruit.utopia.item.OverdueFoodItem
import com.redgrapefruit.utopia.item.RottenFoodItem
import com.redgrapefruit.utopia.mixin.ItemAccessor
import net.minecraft.item.FoodComponent
import net.minecraft.item.Item
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

// <---- Patch Platform ---->

// <--- API --->

fun addComponent(name: String, namespace: String, component: FoodComponent) {
    addComponentInternal(name, namespace, component)
}

fun activate(name: String, namespace: String, variant: OverdueFoodItem) {
    activateInternal(name, namespace, Either<OverdueFoodItem, RottenFoodItem>().first { variant })
}

fun activate(name: String, namespace: String, variant: RottenFoodItem) {
    activateInternal(name, namespace, Either<OverdueFoodItem, RottenFoodItem>().second { variant })
}

// <--- Internal --->

private fun addComponentInternal(name: String, namespace: String, component: FoodComponent) {
    // Validate & get
    if (!validate(name, namespace, "add FoodComponent")) return
    val target = getFromRegistry(name, namespace)
    // Safe-cast to accessor
    if (target !is ItemAccessor) {
        LOG.error("Could not add FoodComponent to $namespace:$name: critical mixin failure")
        return
    }
    // Assign component via the accessor
    target.setFoodComponent(component)
}

private fun activateInternal(name: String, namespace: String, variantEither: Either<OverdueFoodItem, RottenFoodItem>) {
    // Validate & get
    if (!validate(name, namespace, "apply patch")) return
    val target = getFromRegistry(name, namespace)
    // Safe-cast to MDI
    if (target !is ItemFoodMixinAccess) {
        LOG.error("Could not apply patch to $namespace:$name: critical mixin failure")
        return
    }

    // Assign main properties
    target.activate()
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

private fun validate(name: String, namespace: String, message: String): Boolean {
    val id = Identifier(namespace, name)

    // Check if the target item exists in the global registry
    if (!Registry.ITEM.containsId(id)) {
        LOG.error("Could not $message to $id: the target does not exist or isn't registered at the time of execution")
        return false
    }

    return true
}

private fun getFromRegistry(name: String, namespace: String): Item = Registry.ITEM.get(Identifier(namespace, name))
