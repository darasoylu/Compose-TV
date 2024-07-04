package com.darasoylu.newtvui.screens.movies.home

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.tv.material3.*
import coil.compose.AsyncImage
import com.darasoylu.newtvui.model.Contents
import com.darasoylu.newtvui.model.carouselList

@OptIn(ExperimentalTvMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun HomeCarousel() {
    val carouselState = rememberSaveable(saver = CarouselSaver) { CarouselState(0) }
    var isCarouselFocused by remember { mutableStateOf(false) }
    val alpha = if (isCarouselFocused) 1f else 0f

    Carousel(
        modifier = Modifier
            .border(
                width = 2.dp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = alpha),
                shape = ShapeDefaults.Medium,
            )
            .height(324.dp)
            .clip(ShapeDefaults.Medium)
            .focusProperties {
                right = FocusRequester.Cancel
            }
            .onFocusChanged {
                // Because the carousel itself never gets the focus
                isCarouselFocused = it.hasFocus
            },
        itemCount = carouselList.size,
        carouselState = carouselState,
        carouselIndicator = {
            CarouselIndicator(
                itemCount = carouselList.size,
                activeItemIndex = carouselState.activeItemIndex
            )
        },
        contentTransformStartToEnd = fadeIn(tween(durationMillis = 1000))
            .togetherWith(fadeOut(tween(durationMillis = 1000))),
        contentTransformEndToStart = fadeIn(tween(durationMillis = 1000))
            .togetherWith(fadeOut(tween(durationMillis = 1000))),
        content = { index ->
            val item = carouselList[index]
            // background
            CarouselItemBackground(item = item, modifier = Modifier.fillMaxSize())
            // foreground
            CarouselItemForeground(
                item = item,
                isCarouselFocused = isCarouselFocused,
                modifier = Modifier.fillMaxSize()
            )
        }
    )
}

@OptIn(ExperimentalTvMaterial3Api::class)
val CarouselSaver = Saver<CarouselState, Int>(
    save = { it.activeItemIndex },
    restore = { CarouselState(it) }
)

@Composable
private fun CarouselItemBackground(item: Contents.Carousel, modifier: Modifier = Modifier) {
    AsyncImage(
        model = item.image,
        contentDescription = item.label,
        modifier = modifier
            .drawWithContent {
                drawContent()
                drawRect(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black.copy(alpha = 0.5f)
                        )
                    )
                )
            },
        contentScale = ContentScale.FillBounds
    )
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun BoxScope.CarouselIndicator(
    itemCount: Int,
    activeItemIndex: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .padding(32.dp)
            .background(MaterialTheme.colorScheme.onSurface.copy(alpha = 0.1f))
            .graphicsLayer {
                clip = true
                shape = ShapeDefaults.ExtraSmall
            }
            .align(Alignment.BottomEnd)
    ) {
        CarouselDefaults.IndicatorRow(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(8.dp),
            itemCount = itemCount,
            activeItemIndex = activeItemIndex,
        )
    }
}

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
private fun CarouselItemForeground(
    item: Contents.Carousel,
    modifier: Modifier = Modifier,
    isCarouselFocused: Boolean = false
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomStart
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = item.label,
                style = MaterialTheme.typography.displayMedium.copy(
                    shadow = Shadow(
                        color = Color.Black.copy(alpha = 0.5f),
                        offset = Offset(x = 2f, y = 4f),
                        blurRadius = 2f
                    )
                ),
                maxLines = 1
            )
            AnimatedVisibility(
                visible = isCarouselFocused,
                content = {
                    WatchNowButton()
                }
            )
        }
    }
}

@Composable
private fun WatchNowButton() {
    Button(
        onClick = {},
        modifier = Modifier.padding(top = 8.dp),
        contentPadding = ButtonDefaults.ButtonWithIconContentPadding,
        shape = ButtonDefaults.shape(shape = ShapeDefaults.Medium),
        colors = ButtonDefaults.colors(
            containerColor = MaterialTheme.colorScheme.onSurface,
            contentColor = MaterialTheme.colorScheme.surface,
            focusedContentColor = MaterialTheme.colorScheme.surface,
        ),
        scale = ButtonDefaults.scale(scale = 1f)
    ) {
        Icon(
            imageVector = Icons.Outlined.PlayArrow,
            contentDescription = null,
        )
        Spacer(Modifier.size(8.dp))
        Text(
            text = "Watch Now",
            style = MaterialTheme.typography.titleSmall
        )
    }
}