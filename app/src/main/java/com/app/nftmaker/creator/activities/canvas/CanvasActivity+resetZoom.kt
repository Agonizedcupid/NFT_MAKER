package com.app.nftmaker.creator.activities.canvas

fun resetZoom() {
    outerCanvasInstance.cardViewParent.apply {
        scaleX = 1f
        scaleY = 1f
    }
}