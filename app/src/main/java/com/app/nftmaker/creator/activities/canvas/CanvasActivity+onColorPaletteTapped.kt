package com.app.nftmaker.creator.activities.canvas

import com.app.nftmaker.creator.adapters.ColorPickerAdapter
import com.app.nftmaker.creator.models.ColorPalette

fun CanvasActivity.extendedOnColorPaletteTapped(selectedColorPalette: ColorPalette) {
    binding.activityCanvasColorPickerRecyclerView.adapter = ColorPickerAdapter(selectedColorPalette, this)
}