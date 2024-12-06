package com.it.lloydsbankpoc.features.presentation.view.news

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp

@Composable
fun LoadingView(innerPadding: PaddingValues) {
    Column(modifier = Modifier.padding(innerPadding)) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier
                    .align(Alignment.Center)
                    .drawBehind {
                        drawCircle(
                            Color.Black,
                            radius = size.width / 2 - 5.dp.toPx() / 2,
                            style = Stroke(5.dp.toPx())
                        )
                    },
                color = Color.LightGray,
                strokeWidth = 5.dp
            )
        }
    }
}