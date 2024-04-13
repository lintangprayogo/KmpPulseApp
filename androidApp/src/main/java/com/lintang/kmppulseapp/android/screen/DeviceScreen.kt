package com.lintang.kmppulseapp.android.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.lintang.kmppulseapp.Platform

@Composable
fun DeviceScreen() {
    ToolBar()
    DeviceContent()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ToolBar() {
    TopAppBar(title = { Text(text = "Device Info") })
}

@Composable
private fun DeviceContent() {
    val information = makeItems()
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(information) {
            RowItem(title = it.first, subtitle = it.second)
        }
    }

}

@Composable
private fun RowItem(title: String, subtitle: String) {
    Column {
        Column(Modifier.padding(8.dp)) {
            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.bodyLarge,
            )
        }
        HorizontalDivider()
    }

}

fun makeItems(): List<Pair<String, String>> {
    val platform = Platform()
    return listOf(
        Pair("Os Name", platform.osName),
        Pair("Os Version", platform.osVersion),
        Pair("Device Name", platform.deviceModel),
        Pair("Density", platform.density.toString()),
    )
}