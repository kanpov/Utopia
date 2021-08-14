package com.redgrapefruit.utopia.mixin;

import com.redgrapefruit.utopia.core.FoodProfile;
import com.redgrapefruit.utopia.util.ItemNBT;
import com.redgrapefruit.utopia.util.ItemNBTManager;
import com.redgrapefruit.utopia.util.NBTSearchResult;
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

import java.util.Objects;
import java.util.function.Consumer;

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
    private void utopia$constructor(NbtCompound nbt, CallbackInfo ci) {
        ifEntryRegistered((itemNBT -> itemNBT.getDeserializer().invoke(item, nbt)));
    }

    @Inject(method = "writeNbt", at = @At("TAIL"))
    private void utopia$writeNbt(NbtCompound nbt, CallbackInfoReturnable<NbtCompound> cir) {
        ifEntryRegistered((itemNBT -> itemNBT.getSerializer().invoke(item, nbt)));
    }

    private void ifEntryRegistered(Consumer<ItemNBT> consumer) {
        NBTSearchResult result = ItemNBTManager.INSTANCE.searchEntry(item);

        if (result.getSuccess()) {
            ItemNBT itemNBT = result.getFound();
            Objects.requireNonNull(itemNBT, "Found ItemNBT is null with successful NBTSearchResult");

            consumer.accept(itemNBT);
        }
    }
}
