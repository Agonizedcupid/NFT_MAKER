package com.app.nftmaker.creator.activities.canvas

import android.graphics.Bitmap
import com.app.nftmaker.utils.PermissionUtil

fun CanvasActivity.extendedOnRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
) {

    if (requestCode == 500) {
        for (perm in permissions) {
            val rationale = shouldShowRequestPermissionRationale(perm)
            sharedPref?.setNeverAskAgain(perm, !rationale)
        }

        if (PermissionUtil().isStorageGranted(this)) {
            outerCanvasInstance.canvasFragment.myCanvasViewInstance.saveAsImage(Bitmap.CompressFormat.PNG)
        }
    } else {
        onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}