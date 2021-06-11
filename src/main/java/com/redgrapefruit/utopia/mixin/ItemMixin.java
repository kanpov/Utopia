package com.redgrapefruit.utopia.mixin;

import com.redgrapefruit.utopia.common.core.data.FoodConfig;
import com.redgrapefruit.utopia.common.core.FoodEngine;
import com.redgrapefruit.utopia.common.core.state.FoodProfile;
import com.redgrapefruit.utopia.common.core.state.FoodState;
import com.redgrapefruit.utopia.common.item.FoodItem;
import com.redgrapefruit.utopia.common.item.OverdueFoodItem;
import com.redgrapefruit.utopia.common.item.RottenFoodItem;
import com.redgrapefruit.utopia.common.util.ItemMixinAccess;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

/**
 * Provides the mixin (patch) implementation of {@link FoodItem}
 *
 * Also writing Java code is terrible after Kotlin
 */
@Mixin(Item.class)
public class ItemMixin implements ItemMixinAccess {
    // Data structures & patching data
    @Unique @Nullable private FoodConfig config = null;
    @Unique @Nullable private FoodProfile profile = null;
    @Unique private boolean isActivated = false;
    // Variants
    @Unique @Nullable private OverdueFoodItem overdueVariant = null;
    @Unique @Nullable private RottenFoodItem rottenVariant = null;

    // Injects
    @Inject(method = "inventoryTick", at = @At("TAIL"))
    private void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected, CallbackInfo ci) {
        if (!isActivated || !(entity instanceof PlayerEntity) || config == null || profile == null) return;

        FoodEngine.INSTANCE.inventoryTick(config, profile, (PlayerEntity) entity, slot, world, rottenVariant, overdueVariant, false);
    }

    @Inject(method = "appendTooltip", at = @At("TAIL"))
    private void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        if (!isActivated || config == null || profile == null) return;

        FoodEngine.INSTANCE.appendTooltip(tooltip, config, profile, FoodState.FRESH);
    }

    // Duck interface implementations
    @Override
    public void activate() {
        isActivated = true;
    }

    @Override
    public void setProfile(@NotNull FoodProfile profile) {
        this.profile = profile;
    }

    @Override
    public void setConfig(@NotNull FoodConfig config) {
        this.config = config;
    }

    @Override
    public void setOverdueVariant(@NotNull OverdueFoodItem overdueVariant) {
        this.overdueVariant = overdueVariant;
    }

    @Override
    public void setRottenVariant(@NotNull RottenFoodItem rottenVariant) {
        this.rottenVariant = rottenVariant;
    }

    @Nullable @Override
    public FoodProfile getProfile() {
        return profile;
    }

    @Override
    public boolean isActivated() {
        return isActivated;
    }
}
