package com.app.nftmaker.creator.activities.canvas

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.nftmaker.creator.adapters.ColorPickerAdapter
import com.app.nftmaker.creator.database.AppData

fun CanvasActivity.setUpRecyclerView() {
    val layoutManager = GridLayoutManager(this, 1)
    layoutManager.orientation = LinearLayoutManager.HORIZONTAL
    binding.activityCanvasColorPickerRecyclerView.layoutManager = layoutManager

    AppData.colorPalettesDB.colorPalettesDao().getAllColorPalettes().observe(this) {
        val toShow = if (fromDB != null) fromDB else it.firstOrNull()
        colorPickerAdapter = toShow?.let { obj ->
            selectedColorPalette = obj
            ColorPickerAdapter(obj, this)
        }
        binding.activityCanvasColorPickerRecyclerView.adapter = colorPickerAdapter
    }
}