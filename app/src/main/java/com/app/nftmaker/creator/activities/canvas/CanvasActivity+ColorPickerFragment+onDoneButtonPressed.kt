package com.app.nftmaker.creator.activities.canvas

import android.graphics.Color
import android.view.View
import com.app.nftmaker.creator.adapters.ColorPickerAdapter
import com.app.nftmaker.creator.converters.JsonConverter
import com.app.nftmaker.creator.database.AppData
import com.app.nftmaker.creator.extensions.navigateHome
import com.app.nftmaker.data.StringConstants

fun CanvasActivity.extendedOnDoneButtonPressed(selectedColor: Int, colorPaletteMode: Boolean) {
    showMenuItems()
    setPixelColor(selectedColor)
    val newData = JsonConverter.convertJsonStringToListOfInt(fromDB!!.colorPaletteColorData).toMutableList()
    if(!newData.contains(selectedColor)){
        newData.add(selectedColor)
        newData.removeIf { it == Color.TRANSPARENT }
        newData.add(Color.TRANSPARENT)

        AppData.colorPalettesDB.colorPalettesDao().updateColorPaletteColorData(JsonConverter.convertListOfIntToJsonString(newData.toList()), fromDB!!.objId)
        AppData.colorPalettesDB.colorPalettesDao().getAllColorPalettes().observe(this) {
            binding.activityCanvasColorPickerRecyclerView.adapter =
                ColorPickerAdapter(fromDB!!, this)
            binding.activityCanvasColorPickerRecyclerView.scrollToPosition(
                JsonConverter.convertJsonStringToListOfInt(
                    fromDB!!.colorPaletteColorData
                ).size
            )
        }
    }

    currentFragmentInstance = null
    navigateHome(supportFragmentManager, colorPickerFragmentInstance, binding.activityCanvasRootLayout, binding.activityCanvasPrimaryFragmentHost, intent.getStringExtra(
        StringConstants.PROJECT_TITLE_EXTRA)!!)

    if (isPrimaryColorSelected) {
        binding.activityCanvasColorPrimaryViewIndicator.visibility = View.VISIBLE
    } else {
        binding.activityCanvasColorPrimaryViewIndicator.visibility = View.INVISIBLE
    }
}