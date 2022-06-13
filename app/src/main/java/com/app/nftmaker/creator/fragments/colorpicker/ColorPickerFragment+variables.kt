package com.app.nftmaker.creator.fragments.colorpicker

import android.graphics.Color
import com.app.nftmaker.databinding.FragmentColorPickerBinding
import com.app.nftmaker.creator.fragments.colorpicker.picker.ColorPickerPickerFragment
import com.app.nftmaker.creator.fragments.colorpicker.rgb.RGBColorPickerFragment
import com.app.nftmaker.creator.listeners.ColorPickerFragmentListener

var binding_: FragmentColorPickerBinding? = null

var oldColor_ = Color.BLACK
var colorPaletteMode_: Boolean = false

val binding get() = binding_!!

lateinit var caller: ColorPickerFragmentListener

var rgbFragmentInstance: RGBColorPickerFragment? = null
var pickerFragmentInstance: ColorPickerPickerFragment? = null
