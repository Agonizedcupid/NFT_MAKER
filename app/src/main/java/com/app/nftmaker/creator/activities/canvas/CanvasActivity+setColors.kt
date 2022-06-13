package com.app.nftmaker.creator.activities.canvas

import android.content.Context
import android.graphics.Color
import androidx.core.content.ContextCompat
import com.app.nftmaker.R

fun setColors(context:Context) {
    setPrimaryPixelColor(ContextCompat.getColor(context, R.color.primary))
    setSecondaryPixelColor(Color.BLUE)
}