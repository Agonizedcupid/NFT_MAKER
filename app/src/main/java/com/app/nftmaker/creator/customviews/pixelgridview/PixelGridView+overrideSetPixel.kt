package com.app.nftmaker.creator.customviews.pixelgridview

import com.app.nftmaker.creator.activities.canvas.outerCanvasInstance
import com.app.nftmaker.creator.models.BitmapActionData
import com.app.nftmaker.creator.models.Coordinates

fun PixelGridView.extendedOverrideSetPixel(x: Int, y: Int, color: Int) {
    val coordinates = Coordinates(x, y)
    if (coordinatesInCanvasBounds(coordinates)) {
        pixelGridViewBitmap.setPixel(coordinates.x, coordinates.y, color)
        outerCanvasInstance.canvasFragment.myCanvasViewInstance.currentBitmapAction!!.actionData.add(BitmapActionData(coordinates, pixelGridViewBitmap.getPixel(coordinates.x, coordinates.y)))
    }
}