package com.app.nftmaker.data

import android.app.Application
import android.content.Context
import com.app.nftmaker.advertise.AdNetworkHelper
import com.app.nftmaker.creator.dao.PixelArtCreationsDao
import com.app.nftmaker.creator.database.AppData
import com.app.nftmaker.creator.database.ColorPalettesDatabase
import com.app.nftmaker.creator.database.PixelArtDatabase

class DataApp : Application() {

    lateinit var sharedPref: SharedPref
    lateinit var dao: PixelArtCreationsDao

    override fun onCreate() {
        super.onCreate()
        sharedPref = SharedPref(this)

        AppData.pixelArtDB = PixelArtDatabase.getDatabase(this)
        AppData.colorPalettesDB = ColorPalettesDatabase.getDatabase(this)

        dao = PixelArtDatabase.getDatabase(this).pixelArtCreationsDao()

        initAdNetwork(this)
    }

    private fun initAdNetwork(context: Context) {
        // Init ADS Admob
        AdNetworkHelper.init(this)
    }

}