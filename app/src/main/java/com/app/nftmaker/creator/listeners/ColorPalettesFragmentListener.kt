package com.app.nftmaker.creator.listeners

import com.app.nftmaker.creator.models.ColorPalette

interface ColorPalettesFragmentListener {
    fun onColorPaletteTapped(selectedColorPalette: ColorPalette)
}