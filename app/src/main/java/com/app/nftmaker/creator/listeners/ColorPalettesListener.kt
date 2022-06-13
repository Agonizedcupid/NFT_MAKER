package com.app.nftmaker.creator.listeners

import com.app.nftmaker.creator.models.ColorPalette

interface ColorPalettesListener {
    fun onColorPaletteTapped(selectedColorPalette: ColorPalette)
    fun onColorPaletteLongTapped(selectedColorPalette: ColorPalette)
}