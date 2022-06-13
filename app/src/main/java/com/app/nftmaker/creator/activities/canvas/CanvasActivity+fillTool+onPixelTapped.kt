package com.app.nftmaker.creator.activities.canvas

import com.app.nftmaker.creator.algorithms.AlgorithmInfoParameter
import com.app.nftmaker.creator.algorithms.FloodFillAlgorithm
import com.app.nftmaker.creator.models.Coordinates

fun CanvasActivity.fillToolOnPixelTapped(coordinatesTapped: Coordinates) {
    val floodFillAlgorithmInstance = FloodFillAlgorithm(AlgorithmInfoParameter(outerCanvasInstance.canvasFragment.myCanvasViewInstance.pixelGridViewBitmap, outerCanvasInstance.canvasFragment.myCanvasViewInstance.currentBitmapAction!!, getSelectedColor()))
    floodFillAlgorithmInstance.compute(Coordinates(coordinatesTapped.x, coordinatesTapped.y))
}