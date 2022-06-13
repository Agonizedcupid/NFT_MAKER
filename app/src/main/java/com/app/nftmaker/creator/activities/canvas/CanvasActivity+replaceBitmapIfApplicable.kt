package com.app.nftmaker.creator.activities.canvas

import com.app.nftmaker.creator.converters.BitmapConverter
import com.app.nftmaker.creator.database.AppData
import com.app.nftmaker.creator.utility.IntConstants

fun CanvasActivity.replaceBitmapIfApplicable() {
    if (index != -1) {
        AppData.pixelArtDB.pixelArtCreationsDao().getAllPixelArtCreations("").observe(context) {
            currentPixelArtObj = it[index!!]
            outerCanvasInstance.canvasFragment.myCanvasViewInstance.replaceBitmap(BitmapConverter.convertStringToBitmap(currentPixelArtObj.bitmap)!!)
            outerCanvasInstance.rotate(it[index!!].rotation.toInt(), false)
            IntConstants.SPAN_COUNT = currentPixelArtObj.width
        }
    }
}