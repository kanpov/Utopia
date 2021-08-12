package com.redgrapefruit.utopia.common.patch

import com.redgrapefruit.utopia.common.item.OverdueFoodItem
import com.redgrapefruit.utopia.common.item.RottenFoodItem
import com.redgrapefruit.utopia.common.util.Either

/**
 * A patch to an external food item.
 */
internal data class Patch(
    /**
     * The name of the target item, like `onion` or `strawberry`
     */
    val name: String,
    /**
     * The namespace of the target item (target mod essentially), like `minecraft` and `croptopia`
     */
    val namespace: String,
    /**
     * The linked variant [OverdueFoodItem] or [RottenFoodItem]
     */
    val variantEither: Either<OverdueFoodItem, RottenFoodItem>
)
