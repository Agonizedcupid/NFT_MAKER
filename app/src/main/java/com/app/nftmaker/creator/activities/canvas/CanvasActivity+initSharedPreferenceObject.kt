package com.app.nftmaker.creator.activities.canvas

import android.content.Context
import com.app.nftmaker.data.SharedPref

fun CanvasActivity.initSharedPreferenceObject() {
    sharedPreferenceObject = this.getPreferences(Context.MODE_PRIVATE)
    sharedPref = SharedPref(this)
}