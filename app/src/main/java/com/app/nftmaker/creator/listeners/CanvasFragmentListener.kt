package com.app.nftmaker.creator.listeners

import com.app.nftmaker.creator.models.Coordinates

interface CanvasFragmentListener {
    fun onPixelTapped(coordinatesTapped: Coordinates)
    fun onActionUp()
}