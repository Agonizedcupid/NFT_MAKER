package com.app.nftmaker.creator.activities.canvas

import android.graphics.drawable.ColorDrawable
import com.app.nftmaker.creator.algorithms.RectangleAlgorithm
import com.app.nftmaker.creator.algorithms.AlgorithmInfoParameter
import com.app.nftmaker.creator.models.Coordinates

fun CanvasActivity.rectangleToolOnPixelTapped(coordinatesTapped: Coordinates, hasBorder: Boolean) {

    val rectangleAlgorithmInstance: RectangleAlgorithm = if (!hasBorder) {
        RectangleAlgorithm(AlgorithmInfoParameter(outerCanvasInstance.canvasFragment.myCanvasViewInstance.pixelGridViewBitmap,  outerCanvasInstance.canvasFragment.myCanvasViewInstance.currentBitmapAction!!, getSelectedColor()))
    } else {
        RectangleAlgorithm(AlgorithmInfoParameter(outerCanvasInstance.canvasFragment.myCanvasViewInstance.pixelGridViewBitmap,  outerCanvasInstance.canvasFragment.myCanvasViewInstance.currentBitmapAction!!, (binding.activityCanvasColorPrimaryView.background as ColorDrawable).color))
    }

    if (!rectangleMode_hasLetGo) {
        if (!first)  outerCanvasInstance.canvasFragment.myCanvasViewInstance.undo()
        outerCanvasInstance.canvasFragment.myCanvasViewInstance.bitmapActionData.add( outerCanvasInstance.canvasFragment.myCanvasViewInstance.currentBitmapAction!!)
        first = false
    } else {
        outerCanvasInstance.canvasFragment.myCanvasViewInstance.currentBitmapAction = null
        rectangleMode_hasLetGo = false
        first = true
    }

    if (rectangleOrigin == null) {
        rectangleOrigin = coordinatesTapped
    } else {
        rectangleAlgorithmInstance.compute(rectangleOrigin!!, coordinatesTapped)
    }
}