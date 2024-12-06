package com.it.lloydsbankpoc.features.presentation.view.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.it.lloydsbankpoc.core.resources.itemContentTextStyle
import com.it.lloydsbankpoc.core.resources.detailsTitleTextStyle
import com.it.lloydsbankpoc.core.resources.padding
import com.it.lloydsbankpoc.core.resources.subItemContentTextStyle
import com.it.lloydsbankpoc.features.domain.model.Article
import com.it.lloydsbankpoc.features.presentation.util.toLocalDate

@Composable
fun DetailsScreen(innerPadding: PaddingValues, article: Article, onClick: () -> Unit) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .padding(innerPadding)
    ) {
        Spacer(modifier = Modifier.padding(bottom = padding))
        Icon(
            imageVector = Icons.AutoMirrored.Default.ArrowBack,
            contentDescription = "Back",
            modifier = Modifier
                .padding(start = 15.dp)
                .height(30.dp)
                .width(30.dp)
                .clickable(onClick = onClick)
        )
        Spacer(modifier = Modifier.padding(bottom = padding))
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
        ) {
            Text(
                modifier = Modifier.padding(start = padding, end = padding),
                text = article.title!!,
                style = detailsTitleTextStyle(),
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.padding(bottom = padding))
            Text(
                modifier = Modifier.padding(start = padding, end = padding),
                text = article.description!!,
                style = itemContentTextStyle(),
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.padding(bottom = 25.dp))
            Text(
                modifier = Modifier.padding(start = padding, end = padding),
                text = "by ${article.author}",
                style = subItemContentTextStyle(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.padding(bottom = 5.dp))
            Text(
                modifier = Modifier.padding(start = padding, end = padding),
                text = article.publishedAt!!.toLocalDate(),
                style = subItemContentTextStyle(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.padding(bottom = 25.dp))
            AsyncImage(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp),
                model = ImageRequest.Builder(LocalContext.current).data(article.urlToImage)
                    .crossfade(true).build(),
                placeholder = painterResource(id = com.it.lloydsbankpoc.core.R.drawable.ic_launcher_background),
                contentScale = ContentScale.Crop,
                contentDescription = ""
            )
            Spacer(modifier = Modifier.padding(bottom = 25.dp))
            Text(
                modifier = Modifier.padding(start = padding, end = padding),
                text = article.content!!,
                style = itemContentTextStyle(),
            )
            Spacer(modifier = Modifier.padding(bottom = 25.dp))
        }
    }
}