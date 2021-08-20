package com.redgrapefruit.utopia

import com.redgrapefruit.utopia.registry.*
import com.redgrapefruit.utopia.util.FoodConfigReloader
import com.redgrapefruit.utopia.util.GOLD
import com.redgrapefruit.utopia.util.breakLine
import com.redgrapefruit.utopia.util.loadConfig
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback
import net.minecraft.item.Items
import net.minecraft.text.LiteralText
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

val LOG: Logger = LogManager.getLogger()

class Utopia : ModInitializer {
    override fun onInitialize() {
        FoodConfigReloader.register()
        loadConfig()

        // Marks GApple and GodApple as resistant
        ItemTooltipCallback.EVENT.register { stack, _, lines ->
            if (stack.item == Items.GOLDEN_APPLE || stack.item == Items.ENCHANTED_GOLDEN_APPLE) {
                breakLine(lines)
                lines += LiteralText(GOLD + "Completely resistant to all food damage")
            }
        }

        FoodRegistry.run()
        DrinkRegistry.run()
        BlockRegistry.run()
        PatchRegistry.run()
        ScreenHandlerRegistry.run()
    }
}