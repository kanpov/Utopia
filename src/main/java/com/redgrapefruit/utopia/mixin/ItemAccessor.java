package com.redgrapefruit.utopia.mixin;

import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

/**
 * FoodComponent access
 */
@Mixin(Item.class)
public interface ItemAccessor {
    @Accessor("foodComponent")
    @Mutable
    void setFoodComponent(FoodComponent foodComponent);
}
