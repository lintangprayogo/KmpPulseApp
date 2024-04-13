package com.lintang.kmppulseapp.android.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import coil.size.Scale
import com.lintang.kmppulseapp.android.R
import com.lintang.kmppulseapp.android.screen.component.CustomAppBar
import com.lintang.kmppulseapp.android.screen.component.ErrorMessage
import com.lintang.kmppulseapp.android.screen.component.LoadingIndicator
import com.lintang.kmppulseapp.articles.Article
import com.lintang.kmppulseapp.articles.ArticlesState
import com.lintang.kmppulseapp.articles.ArticlesViewModel


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ArticlesScreen(article: ArticlesViewModel = ArticlesViewModel()) {
    val state by article.articlesState.collectAsState(ArticlesState())
    Scaffold(topBar = {
        CustomAppBar{

        }
    }) {
        when {
            state.loading -> {
                LoadingIndicator()
            }
            state.error.isNotEmpty() -> {
                ErrorMessage(state.error)
            }
            else -> {
                LazyColumn {
                    items(state.articles) { article ->
                        ArticleCard(article = article)
                    }
                }
            }
        }
    }
}

@Composable
fun ArticleCard(article: Article) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        AsyncImage(
            model = ImageRequest
                .Builder(LocalContext.current)
                .data(article.imageUrl)
                .placeholder(R.drawable.ic_image)
                .crossfade(true)
                .scale(Scale.FILL)
                .build(),
            contentDescription = article.title,
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = article.description)
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = article.date,
            style = TextStyle(color = Color.Gray),
            modifier = Modifier.align(Alignment.End)
        )
        Spacer(modifier = Modifier.height(4.dp))

    }
}