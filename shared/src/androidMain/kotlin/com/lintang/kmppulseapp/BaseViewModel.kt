package com.lintang.kmppulseapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import androidx.lifecycle.viewModelScope

actual open class BaseViewModel:ViewModel() {
    actual val scope = viewModelScope
}