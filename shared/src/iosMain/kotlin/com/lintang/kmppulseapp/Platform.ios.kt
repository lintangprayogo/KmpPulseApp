package com.lintang.kmppulseapp

import platform.Foundation.NSLog
import platform.UIKit.UIDevice
import platform.UIKit.UIScreen

actual class Platform() {
    actual val osName: String
        get() = "Ios"

    actual val osVersion: String
        get() = UIDevice.currentDevice.systemVersion

    actual val deviceModel: String
        get() = UIDevice.currentDevice.model

    actual val density: Int
        get() = UIScreen.mainScreen.scale.toInt()

    actual fun loadSystemInfo() {
        NSLog("($osName , $osVersion , $deviceModel $density)")

    }

}