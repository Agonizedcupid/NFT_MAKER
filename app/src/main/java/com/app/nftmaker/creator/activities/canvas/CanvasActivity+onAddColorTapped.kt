package com.app.nftmaker.creator.activities.canvas

import com.app.nftmaker.creator.database.AppData
import com.app.nftmaker.creator.models.ColorPalette

var fromDB: ColorPalette? = null

fun CanvasActivity.extendedOnAddColorTapped(colorPalette: ColorPalette) {
    hideMenuItems()

    AppData.colorPalettesDB.colorPalettesDao().getAllColorPalettes().observe(this) {
        for (data in it) {
            if (data.objId == colorPalette.objId) {
                fromDB = data
                break
            }
        }
    }
    openColorPickerDialog(true)
}