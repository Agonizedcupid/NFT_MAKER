package com.app.nftmaker.creator.listeners

interface ColorPickerFragmentListener {
    fun onDoneButtonPressed(selectedColor: Int, isColorPaletteMode: Boolean = false)
}