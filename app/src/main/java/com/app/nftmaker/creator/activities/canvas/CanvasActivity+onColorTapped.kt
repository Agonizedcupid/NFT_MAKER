package com.app.nftmaker.creator.activities.canvas

import android.view.View

fun CanvasActivity.extendedOnColorTapped(color: Int, it: View) {
    setPixelColor(color)

    isSelected = if (!isSelected) {
        updateColorSelectedIndicator(it)
        true
    } else {
        updateColorSelectedIndicator(it)
        false
    }
}