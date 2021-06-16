package com.redgrapefruit.utopia.mixin;

import com.redgrapefruit.utopia.common.core.FoodProfile;
import com.redgrapefruit.utopia.common.core.FridgeState;
import com.redgrapefruit.utopia.common.item.FoodItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Provides serialization of {@link FoodProfile}s.<br>
 * No CCA for me, I'm doing this the hard way (I'm proud of myself).
 */
@Mixin(ItemStack.class)
public class ItemStackMixin {
    @Shadow
    @Final
    private Item item;

    @Inject(method = "<init>(Lnet/minecraft/nbt/NbtCompound;)V", at = @At("TAIL"))
    private void constructor(NbtCompound nbt, CallbackInfo ci) {
        if (!(item instanceof FoodItem)) return;

        FoodProfile profile = ((FoodItem) item).getProfile();

        profile.setRotProgress(nbt.getInt("Rot Progress"));
        //profile.setOverdueProgress(tag.getInt("Overdue Progress"));
        profile.setPreviousTick(nbt.getLong("Previous World Tick"));
        profile.setInitialized(nbt.getBoolean("Is Initialized"));
        profile.setFridgeState(FridgeState.Serialization.fromTag("Fridge State", nbt));
    }

    @Inject(method = "writeNbt", at = @At("TAIL"))
    private void writeNbt(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cir) {
        if (!(item instanceof FoodItem)) return;

        FoodProfile profile = ((FoodItem) item).getProfile();

        nbt.putInt("Rot Progress", profile.getRotProgress());
        nbt.putInt("Overdue Progress", profile.getOverdueProgress());
        nbt.putLong("Previous World Tick", profile.getPreviousTick());
        nbt.putBoolean("Is Initialized", profile.isInitialized());
        FridgeState.Serialization.toTag("Fridge State", profile.getFridgeState(), nbt);
    }
}
