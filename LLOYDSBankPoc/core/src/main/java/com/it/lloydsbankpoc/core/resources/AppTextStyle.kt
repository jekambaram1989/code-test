package com.it.lloydsbankpoc.core.resources

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign

fun bottomBarSelectedItemTextStyle() =
    TextStyle(
        fontSize = smallText,
        color = Color.Black,
        textAlign = TextAlign.Center,
        letterSpacing = smallSpacing,
        fontWeight = FontWeight.Normal
    )

fun bottomBarUnselectedItemTextStyle() =
    TextStyle(
        fontSize = smallText,
        color = Color.White,
        textAlign = TextAlign.Center,
        letterSpacing = smallSpacing,
        fontWeight = FontWeight.Normal
    )

fun headingTextStyle() =
    TextStyle(
        fontSize = headingText,
        color = appColor,
        textAlign = TextAlign.Start,
        letterSpacing = mediumSpacing,
        fontWeight = FontWeight.Bold,
    )


fun titleTextStyle() =
    TextStyle(
        fontSize = mediumText,
        color = Color.Black,
        textAlign = TextAlign.Start,
        letterSpacing = mediumSpacing,
        fontWeight = FontWeight.SemiBold
    )

fun subTitleTextStyle() =
    TextStyle(
        fontSize = smallText,
        color = liteGray,
        textAlign = TextAlign.Start,
        letterSpacing = smallSpacing,
        fontWeight = FontWeight.Medium
    )

fun detailsTitleTextStyle() =
    TextStyle(
        fontSize = extraLargeText,
        color = Color.Black,
        textAlign = TextAlign.Start,
        letterSpacing = mediumSpacing,
        fontWeight = FontWeight.SemiBold
    )

fun itemContentTextStyle() =
    TextStyle(
        fontSize = mediumText,
        color = mediumGray,
        textAlign = TextAlign.Start,
        letterSpacing = mediumSpacing,
        fontWeight = FontWeight.W600
    )

fun subItemContentTextStyle() =
    TextStyle(
        fontSize = smallText,
        color = Color.Gray,
        textAlign = TextAlign.Start,
        letterSpacing = smallSpacing,
        fontWeight = FontWeight.Medium
    )

fun scrollTabTextStyle() =
    TextStyle(
        fontSize = mediumText,
        color = Color.Black,
        textAlign = TextAlign.Center,
        letterSpacing = mediumSpacing,
        fontWeight = FontWeight.Medium,
    )