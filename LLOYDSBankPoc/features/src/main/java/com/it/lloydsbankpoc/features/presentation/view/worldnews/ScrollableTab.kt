package com.it.lloydsbankpoc.features.presentation.view.worldnews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import androidx.compose.ui.zIndex
import androidx.navigation.NavController
import com.it.lloydsbankpoc.core.resources.appColor
import com.it.lloydsbankpoc.core.resources.scrollTabTextStyle
import com.it.lloydsbankpoc.features.domain.model.WorldNews

@Composable
fun ScrollableTab(
    navController: NavController,
    categories: List<WorldNews>
) {
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    val pagerState = rememberPagerState {
        categories.size
    }
    Column(modifier = Modifier.fillMaxSize()) {
        ScrollableTabRow(containerColor = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp),
            selectedTabIndex = selectedIndex,
            edgePadding = 0.dp,
            divider = {},
            indicator = { tabPositions ->
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedIndex])
                        .fillMaxSize()
                        .padding(2.dp)
                        .background(
                            appColor,
                            RoundedCornerShape(50),
                        )
                )
            }) {
            categories.fastForEachIndexed { tabIndex, item ->
                FilterChip(modifier = Modifier
                    .wrapContentSize()
                    .zIndex(2f),
                    selected = false,
                    border = null,
                    onClick = { selectedIndex = tabIndex },
                    label = {
                        Text(
                            text = item.country,
                            style = scrollTabTextStyle(),
                        )
                    })
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            userScrollEnabled = true
        ) {
            LaunchedEffect(pagerState) {
                snapshotFlow { pagerState.currentPage }.collect { currentPage ->
                    selectedIndex = currentPage
                    pagerState.animateScrollToPage(currentPage)
                }
            }
            WorldNewsItem(navController, categories[selectedIndex].articles)
        }
    }
}