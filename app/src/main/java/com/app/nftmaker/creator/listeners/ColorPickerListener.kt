package com.app.nftmaker.creator.listeners

import android.view.View
import com.app.nftmaker.creator.models.ColorPalette

interface ColorPickerListener {
    fun onColorTapped(colorTapped: Int, view: View)
    fun onColorLongTapped(paletteId: Int, colorTapped: Int, view: View)
    fun onColorAdded(colorPalette: ColorPalette)
}