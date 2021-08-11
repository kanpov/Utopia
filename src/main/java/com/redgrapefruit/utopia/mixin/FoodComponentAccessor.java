package com.redgrapefruit.utopia.mixin;

import com.mojang.datafixers.util.Pair;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.FoodComponent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.List;

/**
 * Makes {@link FoodComponent} mutable, which is needed to perform some hacky, late-loading tricks
 */
@Mixin(FoodComponent.class)
public interface FoodComponentAccessor {
    @Accessor("hunger")
    void setHunger(int hunger);

    @Accessor("saturationModifier")
    void setSaturationModifier(float saturationModifier);

    @Accessor("meat")
    void setMeat(boolean meat);

    @Accessor("alwaysEdible")
    void setAlwaysEdible(boolean alwaysEdible);

    @Accessor("snack")
    void setSnack(boolean snack);

    @Accessor("statusEffects")
    void setStatusEffects(List<Pair<StatusEffectInstance, Float>> statusEffects);
}
