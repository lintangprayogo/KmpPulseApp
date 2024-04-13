package com.lintang.kmppulseapp.android.screen.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.lintang.kmppulseapp.android.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar(onAboutButtonClick: () -> Unit) {
    TopAppBar(title = {
        Text(
            text = stringResource(id = R.string.articles_text),
        )
    },
        actions = {
            IconButton(onClick = onAboutButtonClick) {
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "About Device Button",
                )
            }
        }
    )
}