package com.app.nftmaker.creator.activities.canvas

import android.util.Log
import com.app.nftmaker.creator.adapters.ColorPickerAdapter
import com.app.nftmaker.creator.converters.JsonConverter
import com.app.nftmaker.creator.database.AppData
import com.app.nftmaker.creator.models.ColorPalette

fun CanvasActivity.extendedOnColorLongTapped(objId: Int, color: Int) {
    var it:List<ColorPalette> = AppData.colorPalettesDB.colorPalettesDao().getListColorPalettes()

    for (data in it) {
        if (data.objId == objId) {
            fromDB = data
            break
        }
    }

    val newData = JsonConverter.convertJsonStringToListOfInt(fromDB!!.colorPaletteColorData).toMutableList()
    newData.remove(color)
    AppData.colorPalettesDB.colorPalettesDao().updateColorPaletteColorData(JsonConverter.convertListOfIntToJsonString(newData.toList()), fromDB!!.objId)
    AppData.colorPalettesDB.colorPalettesDao().getAllColorPalettes().observe(this) {
        binding.activityCanvasColorPickerRecyclerView.adapter = ColorPickerAdapter(fromDB!!, this)
        binding.activityCanvasColorPickerRecyclerView.scrollToPosition(
            JsonConverter.convertJsonStringToListOfInt(
                fromDB!!.colorPaletteColorData
            ).size
        )
    }

}