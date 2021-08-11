package com.redgrapefruit.utopia.mixin;

import com.redgrapefruit.utopia.common.core.FoodConfig;
import com.redgrapefruit.utopia.common.core.FoodEngine;
import com.redgrapefruit.utopia.common.core.FoodProfile;
import com.redgrapefruit.utopia.common.core.FoodState;
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
 * <p>
 * Also writing Java code is terrible after Kotlin
 */
@Mixin(Item.class)
public class ItemMixin implements ItemMixinAccess {
    // Data structures & patching data
    @Unique
    @Nullable
    private FoodConfig utopia$config = null;
    @Unique
    @Nullable
    private FoodProfile utopia$profile = null;
    @Unique
    private boolean utopia$isActivated = false;
    // Variants
    @Unique
    @Nullable
    private OverdueFoodItem utopia$overdueVariant = null;
    @Unique
    @Nullable
    private RottenFoodItem utopia$rottenVariant = null;

    // Injects
    @Inject(method = "inventoryTick", at = @At("TAIL"))
    private void utopia$inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected, CallbackInfo ci) {
        if (!utopia$isActivated || !(entity instanceof PlayerEntity) || utopia$config == null || utopia$profile == null) return;

        FoodEngine.INSTANCE.inventoryTick(utopia$config, utopia$profile, (PlayerEntity) entity, slot, world, utopia$rottenVariant, utopia$overdueVariant, false);
    }

    @Inject(method = "appendTooltip", at = @At("TAIL"))
    private void utopia$appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        if (!utopia$isActivated || utopia$config == null || utopia$profile == null) return;

        FoodEngine.INSTANCE.appendTooltip(tooltip, utopia$config, utopia$profile, FoodState.FRESH);
    }

    // Duck interface implementations
    @Override
    public void activate() {
        utopia$isActivated = true;
    }

    @Override
    public void setConfig(@NotNull FoodConfig config) {
        this.utopia$config = config;
    }

    @Override
    public void setOverdueVariant(@NotNull OverdueFoodItem overdueVariant) {
        this.utopia$overdueVariant = overdueVariant;
    }

    @Override
    public void setRottenVariant(@NotNull RottenFoodItem rottenVariant) {
        this.utopia$rottenVariant = rottenVariant;
    }

    @Nullable
    @Override
    public FoodProfile getProfile() {
        return utopia$profile;
    }

    @Override
    public void setProfile(@NotNull FoodProfile profile) {
        this.utopia$profile = profile;
    }

    @Override
    public boolean isActivated() {
        return utopia$isActivated;
    }
}
