package com.app.nftmaker.creator.activities.canvas

fun hideMenuItems() {
    for (i in 0 until menu.size()) {
        menu.getItem(i).isVisible = false
    }
}