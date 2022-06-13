package com.app.nftmaker.creator.fragments.canvas

import com.app.nftmaker.creator.customviews.pixelgridview.PixelGridView
import com.app.nftmaker.databinding.FragmentCanvasBinding
import com.app.nftmaker.creator.listeners.CanvasFragmentListener

var binding_: FragmentCanvasBinding? = null

val binding get() = binding_!!

lateinit var caller: CanvasFragmentListener

lateinit var myCanvasViewInstance: PixelGridView