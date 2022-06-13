package com.app.nftmaker.creator.fragments.colorpicker

import com.app.nftmaker.R
import com.app.nftmaker.creator.fragments.colorpicker.rgb.RGBColorPickerFragment

fun ColorPickerFragment.setOnClickListeners() {
    rgbFragmentInstance = RGBColorPickerFragment.newInstance()
    activity!!.supportFragmentManager.beginTransaction().add(R.id.fragmentColorPicker_tabLayoutFragmentHost, rgbFragmentInstance!!).commit()
}