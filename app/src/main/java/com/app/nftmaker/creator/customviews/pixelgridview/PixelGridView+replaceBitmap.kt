package com.app.nftmaker.creator.customviews.pixelgridview

import android.graphics.Bitmap
import android.graphics.Canvas
import com.app.nftmaker.creator.customviews.transparentbackgroundview.TransparentBackgroundView
import com.app.nftmaker.creator.fragments.outercanvas.binding

fun PixelGridView.extendedReplaceBitmap(newBitmap: Bitmap) {
    pixelGridViewBitmap = Bitmap.createBitmap(newBitmap.width, newBitmap.height, Bitmap.Config.ARGB_8888)
    pixelGridViewCanvas = Canvas(pixelGridViewBitmap)
    canvasSize = newBitmap.width
    pixelGridViewCanvas.drawBitmap(newBitmap, 0f, 0f, null)

    val transparent = TransparentBackgroundView(this.context, canvasSize)
    binding.defsq2.addView(transparent)

    invalidate()
}