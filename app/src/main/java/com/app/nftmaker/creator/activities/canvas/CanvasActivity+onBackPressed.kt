package com.app.nftmaker.creator.activities.canvas

import android.view.View
import com.app.nftmaker.creator.extensions.navigateHome
import com.app.nftmaker.creator.extensions.showDialog
import com.app.nftmaker.data.StringConstants

fun CanvasActivity.extendedOnBackPressed() {
    if (!saved && currentFragmentInstance == null) {
        showDialog(
            StringConstants.DIALOG_UNSAVED_CHANGES_TITLE,
            StringConstants.DIALOG_UNSAVED_CHANGES_MESSAGE,
            StringConstants.DIALOG_POSITIVE_BUTTON_TEXT,
            { _, _ ->
                finish()
            }, StringConstants.DIALOG_NEGATIVE_BUTTON_TEXT, { _, _ -> }, null)
    } else if (currentFragmentInstance != null) {
        navigateHome(supportFragmentManager, currentFragmentInstance!!, binding.activityCanvasRootLayout, binding.activityCanvasPrimaryFragmentHost, intent.getStringExtra("PROJECT_TITLE")!!)
        currentFragmentInstance = null
        showMenuItems()

        if (isPrimaryColorSelected) {
            binding.activityCanvasColorPrimaryViewIndicator.visibility = View.VISIBLE
        } else {
            binding.activityCanvasColorPrimaryViewIndicator.visibility = View.INVISIBLE
        }
    } else {
        finish()
    }
}