package com.redgrapefruit.utopia.mixin;

import com.redgrapefruit.utopia.common.core.data.RFoodConfig;
import com.redgrapefruit.utopia.common.core.RFoodEngine;
import com.redgrapefruit.utopia.common.core.state.RFoodProfile;
import com.redgrapefruit.utopia.common.core.state.RFoodState;
import com.redgrapefruit.utopia.common.item.RFoodItem;
import com.redgrapefruit.utopia.common.item.ROverdueFoodItem;
import com.redgrapefruit.utopia.common.item.RRottenFoodItem;
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
 * Provides the mixin (patch) implementation of {@link RFoodItem}
 *
 * Also writing Java code is terrible after Kotlin
 */
@Mixin(Item.class)
public class ItemMixin implements ItemMixinAccess {
    // Data structures & patching data
    @Unique @Nullable private RFoodConfig config = null;
    @Unique @Nullable private RFoodProfile profile = null;
    @Unique private boolean isActivated = false;
    // Variants
    @Unique @Nullable private ROverdueFoodItem overdueVariant = null;
    @Unique @Nullable private RRottenFoodItem rottenVariant = null;

    // Injects
    @Inject(method = "inventoryTick", at = @At("TAIL"))
    private void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected, CallbackInfo ci) {
        if (!isActivated || !(entity instanceof PlayerEntity) || config == null || profile == null) return;

        RFoodEngine.INSTANCE.inventoryTick(config, profile, (PlayerEntity) entity, slot, world, rottenVariant, overdueVariant, false);
    }

    @Inject(method = "appendTooltip", at = @At("TAIL"))
    private void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context, CallbackInfo ci) {
        if (!isActivated || config == null || profile == null) return;

        RFoodEngine.INSTANCE.appendTooltip(tooltip, config, profile, RFoodState.FRESH);
    }

    // Duck interface implementations
    @Override
    public void activate() {
        isActivated = true;
    }

    @Override
    public void setProfile(@NotNull RFoodProfile profile) {
        this.profile = profile;
    }

    @Override
    public void setConfig(@NotNull RFoodConfig config) {
        this.config = config;
    }

    @Override
    public void setOverdueVariant(@NotNull ROverdueFoodItem overdueVariant) {
        this.overdueVariant = overdueVariant;
    }

    @Override
    public void setRottenVariant(@NotNull RRottenFoodItem rottenVariant) {
        this.rottenVariant = rottenVariant;
    }

    @Nullable @Override
    public RFoodProfile getProfile() {
        return profile;
    }

    @Override
    public boolean isActivated() {
        return isActivated;
    }
}
