package com.redgrapefruit.utopia.util

import net.minecraft.text.LiteralText
import net.minecraft.text.Text

// Color codes
const val BLACK = "§0"
const val DARK_BLUE = "§1"
const val DARK_GREEN = "§2"
const val DARK_AQUA = "§3"
const val DARK_RED = "§4"
const val DARK_PURPLE = "§5"
const val GOLD = "§6"
const val GRAY = "§7"
const val DARK_GRAY = "§8"
const val BLUE = "§9"
const val GREEN = "§a"
const val AQUA = "§b"
const val RED = "§c"
const val LIGHT_PURPLE = "§d"
const val YELLOW = "§e"
const val WHITE = "§f"

// Formatting codes
const val OBFUSCATED = "§k"
const val BOLD = "§l"
const val STRIKE_THROUGH = "§m"
const val UNDERLINE = "§n"
const val ITALIC = "§o"
const val RESET = "§r"
const val NEW_LINE = "\n"

fun breakLine(tooltip: MutableList<Text>) {
    tooltip += LiteralText("")
}
