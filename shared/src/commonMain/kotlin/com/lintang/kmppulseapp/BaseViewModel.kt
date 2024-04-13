package com.lintang.kmppulseapp

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {

    val scope:CoroutineScope
}