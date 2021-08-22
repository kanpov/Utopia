package com.redgrapefruit.utopia.client.screen

import com.redgrapefruit.redmenu.redmenu.MenuScreen
import com.redgrapefruit.utopia.MOD_ID
import net.minecraft.entity.player.PlayerInventory
import net.minecraft.screen.ScreenHandler
import net.minecraft.text.Text
import net.minecraft.util.Identifier

/**
 * A fridge rendering screen implementing the Container API
 */
class FridgeScreen(handler: ScreenHandler, inventory: PlayerInventory, title: Text) :
    MenuScreen(handler, inventory, title) {

    override val texture: Identifier
        get() = Identifier(MOD_ID, "textures/gui/fridge.png")
}