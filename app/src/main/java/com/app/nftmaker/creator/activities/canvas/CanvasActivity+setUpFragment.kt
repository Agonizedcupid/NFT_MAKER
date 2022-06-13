package com.app.nftmaker.creator.activities.canvas

import com.app.nftmaker.R
import com.app.nftmaker.creator.fragments.outercanvas.OuterCanvasFragment

fun CanvasActivity.setUpFragment() {
    outerCanvasInstance = if (index == -1) {
        OuterCanvasFragment.newInstance(spanCount)
    } else {
        OuterCanvasFragment.newInstance(spanCount, true)
    }
    supportFragmentManager.beginTransaction().add(R.id.activityCanvas_outerCanvasFragmentHost, outerCanvasInstance).commit()
}