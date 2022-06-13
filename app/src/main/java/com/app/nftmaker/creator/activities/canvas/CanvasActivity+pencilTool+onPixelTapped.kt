package com.app.nftmaker.creator.activities.canvas

import com.app.nftmaker.creator.algorithms.LineAlgorithm
import com.app.nftmaker.creator.algorithms.AlgorithmInfoParameter
import com.app.nftmaker.creator.models.BitmapAction
import com.app.nftmaker.creator.models.BitmapActionData
import com.app.nftmaker.creator.models.Coordinates

fun CanvasActivity.pencilToolOnPixelTapped(coordinatesTapped: Coordinates) {
    if (outerCanvasInstance.canvasFragment.myCanvasViewInstance.currentBitmapAction != null) {
        outerCanvasInstance.canvasFragment.myCanvasViewInstance.currentBitmapAction!!.actionData.add(BitmapActionData(
            coordinatesTapped,
            outerCanvasInstance.canvasFragment.myCanvasViewInstance.pixelGridViewBitmap.getPixel(
                coordinatesTapped.x,
                coordinatesTapped.y,
            ),
        ))
    } else {
        outerCanvasInstance.canvasFragment.myCanvasViewInstance.currentBitmapAction = BitmapAction(mutableListOf())
        outerCanvasInstance.canvasFragment.myCanvasViewInstance.currentBitmapAction!!.actionData.add(BitmapActionData(
            coordinatesTapped,
            outerCanvasInstance.canvasFragment.myCanvasViewInstance.pixelGridViewBitmap.getPixel(
                coordinatesTapped.x,
                coordinatesTapped.y,
            ),
        ))
    }

    if ( outerCanvasInstance.canvasFragment.myCanvasViewInstance.prevX != null &&  outerCanvasInstance.canvasFragment.myCanvasViewInstance.prevY != null) {
        val lineAlgorithmInstance = LineAlgorithm(AlgorithmInfoParameter( outerCanvasInstance.canvasFragment.myCanvasViewInstance.pixelGridViewBitmap, outerCanvasInstance.canvasFragment.myCanvasViewInstance.currentBitmapAction!!, getSelectedColor()))

        lineAlgorithmInstance.compute(Coordinates( outerCanvasInstance.canvasFragment.myCanvasViewInstance.prevX!!,  outerCanvasInstance.canvasFragment.myCanvasViewInstance.prevY!!), coordinatesTapped)
    }

    outerCanvasInstance.canvasFragment.myCanvasViewInstance.overrideSetPixel(coordinatesTapped.x, coordinatesTapped.y, getSelectedColor())

    outerCanvasInstance.canvasFragment.myCanvasViewInstance.prevX = coordinatesTapped.x
    outerCanvasInstance.canvasFragment.myCanvasViewInstance.prevY = coordinatesTapped.y
}