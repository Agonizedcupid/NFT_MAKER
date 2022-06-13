package com.app.nftmaker.creator.activities.canvas

fun CanvasActivity.onCreate() {
    getExtras()
    setUpFragment()
    setBindings()
    initSharedPreferenceObject()
}