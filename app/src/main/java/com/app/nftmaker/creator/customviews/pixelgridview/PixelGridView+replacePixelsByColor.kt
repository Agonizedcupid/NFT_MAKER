package com.app.nftmaker.creator.customviews.pixelgridview

import com.app.nftmaker.creator.models.BitmapAction
import com.app.nftmaker.creator.models.BitmapActionData
import com.app.nftmaker.creator.models.Coordinates

fun PixelGridView.extendedReplacePixelsByColor(colorToFind: Int, colorToReplace: Int) {
    currentBitmapAction = BitmapAction(mutableListOf(), true)

    for (i_1 in 0 until pixelGridViewBitmap.width) {
        for (i_2 in 0 until pixelGridViewBitmap.height) {
            currentBitmapAction!!.actionData.add(
                BitmapActionData(
                Coordinates(i_1, i_2),
                pixelGridViewBitmap.getPixel(i_1, i_2),
            )
            )

            if (pixelGridViewBitmap.getPixel(i_1, i_2) == colorToFind) {
                pixelGridViewBitmap.setPixel(i_1, i_2, colorToReplace)
            }
        }
    }
    invalidate()
}