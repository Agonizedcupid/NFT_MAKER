package com.app.nftmaker.creator.activities.canvas

import android.graphics.drawable.ColorDrawable
import android.view.View
import com.app.nftmaker.R
import com.app.nftmaker.creator.extensions.navigateTo
import com.app.nftmaker.creator.fragments.tools.ToolsFragment
import com.app.nftmaker.data.StringConstants


fun CanvasActivity.openColorPickerDialog(colorPaletteMode: Boolean = false) {
    colorPickerFragmentInstance = initColorPickerFragmentInstance(colorPaletteMode)
    currentFragmentInstance = colorPickerFragmentInstance
    navigateTo(
        supportFragmentManager,
        colorPickerFragmentInstance,
        R.id.activityCanvas_primaryFragmentHost,
        StringConstants.FRAGMENT_COLOR_PICKER_TITLE,
        binding.activityCanvasPrimaryFragmentHost,
        binding.activityCanvasRootLayout
    )
}

fun clearCanvas() {
    outerCanvasInstance.canvasFragment.myCanvasViewInstance.clearCanvas()
}

fun CanvasActivity.setOnClickListeners() {

    toolsFragmentInstance = ToolsFragment.newInstance()
    supportFragmentManager.beginTransaction()
        .add(R.id.activityCanvas_tabLayoutFragmentHost, toolsFragmentInstance!!).commit()


    binding.activityCanvasColorPrimaryView.setOnLongClickListener {
        isPrimaryColorSelected = true
        openColorPickerDialog()
        hideMenuItems()
        true
    }

    binding.activityCanvasColorPrimaryView.setOnClickListener {
        isPrimaryColorSelected = true
        binding.activityCanvasColorPrimaryViewIndicator.visibility = View.VISIBLE
        setPixelColor((binding.activityCanvasColorPrimaryView.background as ColorDrawable).color)
    }
}