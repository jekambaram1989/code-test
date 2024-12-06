package com.it.lloydsbankpoc.features.presentation.view.news

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.it.lloydsbankpoc.core.resources.padding
import com.it.lloydsbankpoc.core.resources.smallSpace
import com.it.lloydsbankpoc.core.resources.subTitleTextStyle
import com.it.lloydsbankpoc.core.resources.titleTextStyle
import com.it.lloydsbankpoc.features.domain.model.Article
import com.it.lloydsbankpoc.features.presentation.util.toLocalDate

@Composable
fun NewsItem(
    index: Int, size: Int,
    article: Article,
    onItemClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top,
        modifier = Modifier.clickable(onClick = onItemClick)
    ) {
        Column(
            modifier = Modifier
                .weight(3f)
                .padding(bottom = padding, end = padding)
        ) {
            Text(
                text = article.source!!.name!!,
                style = titleTextStyle(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.padding(top = smallSpace))
            Text(
                text = article.title!!,
                style = subTitleTextStyle(),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
            Spacer(modifier = Modifier.padding(smallSpace))
            Text(
                text = article.publishedAt!!.toLocalDate(),
                style = subTitleTextStyle(),
                maxLines = 3,
                overflow = TextOverflow.Ellipsis,
            )
        }
        AsyncImage(
            modifier = Modifier
                .weight(1.3f)
                .height(90.dp)
                .clip(RoundedCornerShape(10.dp)),
            model = ImageRequest.Builder(LocalContext.current)
                .data(article.urlToImage!!)
                .crossfade(true)
                .build(),
            placeholder = painterResource(id = com.it.lloydsbankpoc.core.R.drawable.ic_launcher_background),
            contentScale = ContentScale.Crop,
            contentDescription = "news image"
        )
    }
    if (index != size - 1) {
        HorizontalDivider(
            color = Color.LightGray,
            thickness = .8.dp,
            modifier = Modifier.padding(bottom = 20.dp)
        )
    }
}