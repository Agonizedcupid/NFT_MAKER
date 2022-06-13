package com.app.nftmaker.creator.activities.canvas

import com.app.nftmaker.advertise.AdNetworkHelper
import com.app.nftmaker.data.AppConfig

fun CanvasActivity.prepareAds() {
    val adNetworkHelper = AdNetworkHelper(this)
    adNetworkHelper.showGDPR()
    adNetworkHelper.loadBannerAd(AppConfig.ADS_CREATOR_BANNER)
}