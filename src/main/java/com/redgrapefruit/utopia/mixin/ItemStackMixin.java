package com.redgrapefruit.utopia.mixin;

import com.redgrapefruit.utopia.core.RFoodProfile;
import com.redgrapefruit.utopia.core.RFridgeState;
import com.redgrapefruit.utopia.item.RFoodItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Provides serialization of {@link RFoodProfile}s.<br>
 * No CCA for me, I'm doing this the hard way (I'm proud of myself).
 */
@Mixin(ItemStack.class)
public class ItemStackMixin {
    @Shadow
    @Final
    private Item item;

    @Inject(method = "<init>(Lnet/minecraft/nbt/CompoundTag;)V", at = @At("TAIL"))
    private void constructor(CompoundTag tag, CallbackInfo info) {
        if (!(item instanceof RFoodItem)) return;

        RFoodProfile profile = ((RFoodItem) item).getProfile();

        profile.setRotProgress(tag.getInt("Rot Progress"));
        profile.setOverdueProgress(tag.getInt("Overdue Progress"));
        profile.setPreviousTick(tag.getLong("Previous World Tick"));
        profile.setInitialized(tag.getBoolean("Is Initialized"));
        profile.setFridgeState(RFridgeState.Serialization.fromTag("Fridge State", tag));
    }

    @Inject(method = "toTag", at = @At("TAIL"))
    private void toTag(CompoundTag tag, CallbackInfoReturnable<CompoundTag> cir) {
        if (!(item instanceof RFoodItem)) return;

        RFoodProfile profile = ((RFoodItem) item).getProfile();

        tag.putInt("Rot Progress", profile.getRotProgress());
        tag.putInt("Overdue Progress", profile.getOverdueProgress());
        tag.putLong("Previous World Tick", profile.getPreviousTick());
        tag.putBoolean("Is Initialized", profile.isInitialized());
        RFridgeState.Serialization.toTag("Fridge State", profile.getFridgeState(), tag);
    }
}
