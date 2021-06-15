package com.redgrapefruit.utopia.client.screen

import com.redgrapefruit.utopia.api.ContainerScreen
import com.redgrapefruit.utopia.common.MOD_ID
import net.minecraft.client.util.math.MatrixStack
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandler
import net.minecraft.text.Text
import net.minecraft.util.Identifier

/**
 * A fridge rendering screen implementing the Container API
 */
class FridgeScreen(handler: ScreenHandler, inventory: PlayerInventory, title: Text) :
    ContainerScreen(handler, inventory, title) {
    override fun getTexture(): Identifier {
        return Identifier(MOD_ID, "textures/gui/fridge.png")
    }

    override fun onRender(matrices: MatrixStack) = Unit
}