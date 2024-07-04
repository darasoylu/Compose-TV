package com.darasoylu.newtvui.screens.movies.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.foundation.lazy.list.TvLazyColumn
import androidx.tv.foundation.lazy.list.TvLazyRow
import androidx.tv.foundation.lazy.list.itemsIndexed
import androidx.tv.material3.*
import coil.compose.AsyncImage
import com.darasoylu.newtvui.model.*
import com.darasoylu.newtvui.ui.theme.CardItemBackgroundColor
import com.darasoylu.newtvui.ui.theme.HomeScreenBackground

@Composable
fun HomeScreen() {
    val liveList = liveList
    val recommendedMovieList = recommendedMovieList
    val recommendedSeriesList = recommendedSeriesList
    val topMovieList = topMovieList

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = HomeScreenBackground)
    ) {
        TvLazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(10.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item(contentType = "Carousel") {
                HomeCarousel()
            }
            item(contentType = "Live") {
                ItemLiveCard(liveList)
            }
            item(contentType = "RecommendedMovies") {
                ItemMovieCard(recommendedMovieList)
            }
            item(contentType = "TopMovies") {
                ItemTopMovies(topMovieList)
            }
            item(contentType = "RecommendedSeries") {
                ItemSeriesCard(recommendedSeriesList)
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ItemLiveCard(liveList: List<Contents.Live>) {
    Text(
        "Last Watched Channels",
        fontSize = 20.sp,
        color = Color.White,
        modifier = Modifier
            .padding(start = 10.dp)
    )
    TvLazyRow {
        itemsIndexed(liveList) { index, item ->
            Card(
                border = CardDefaults.border(
                    focusedBorder = Border(
                        border = BorderStroke(
                            width = 1.dp,
                            color = Color.White
                        ),
                        shape = ShapeDefaults.Medium
                    )
                ),
                modifier = Modifier
                    .focusProperties {
                        right = if (index == liveList.size - 1) {
                            FocusRequester.Cancel
                        } else {
                            FocusRequester.Default
                        }
                    }
                    .size(100.dp)
                    .padding(10.dp),
                onClick = {}
            ) {
                AsyncImage(
                    model = item.image,
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null,
                    modifier = Modifier
                        .background(CardItemBackgroundColor)
                        .padding(5.dp)
                        .fillMaxSize()
                )
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ItemMovieCard(movieList: List<Contents.Movie>) {
    Text(
        "Recommended Movies",
        fontSize = 20.sp,
        color = Color.White,
        modifier = Modifier
            .padding(start = 10.dp)
    )
    TvLazyRow {
        itemsIndexed(movieList) { index, item ->
            Card(
                border = CardDefaults.border(
                    focusedBorder = Border(
                        border = BorderStroke(
                            width = 1.dp,
                            color = Color.White
                        ),
                        shape = ShapeDefaults.Medium
                    )
                ),
                modifier = Modifier
                    .focusProperties {
                        right = if (index == movieList.size - 1) {
                            FocusRequester.Cancel
                        } else {
                            FocusRequester.Default
                        }
                    }
                    .width(192.dp)
                    .height(108.dp)
                    .padding(10.dp),
                onClick = {}
            ) {
                AsyncImage(
                    model = item.image,
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ItemSeriesCard(seriesList: List<Contents.Series>) {
    Text(
        "Recommended Series",
        fontSize = 20.sp,
        color = Color.White,
        modifier = Modifier
            .padding(start = 10.dp)
    )
    TvLazyRow {
        itemsIndexed(seriesList) { index, item ->
            Card(
                border = CardDefaults.border(
                    focusedBorder = Border(
                        border = BorderStroke(
                            width = 1.dp,
                            color = Color.White
                        ),
                        shape = ShapeDefaults.Medium
                    )
                ),
                modifier = Modifier
                    .focusProperties {
                        right = if (index == seriesList.size - 1) {
                            FocusRequester.Cancel
                        } else {
                            FocusRequester.Default
                        }
                    }
                    .width(192.dp)
                    .height(108.dp)
                    .padding(10.dp),
                onClick = {}
            ) {
                AsyncImage(
                    model = item.image,
                    contentScale = ContentScale.FillBounds,
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                )
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ItemTopMovies(movieList: List<Contents.Movie>) {
    Text(
        "Top 10 Movies",
        fontSize = 20.sp,
        color = Color.White,
        modifier = Modifier
            .padding(start = 10.dp)
    )
    TvLazyRow {
        itemsIndexed(movieList) { index, item ->
            Row {
                Text(
                    color = Color.White,
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(start = 10.dp)
                        .background(HomeScreenBackground),
                    text = (index + 1).toString(),
                    fontSize = 42.sp
                )
                Card(
                    border = CardDefaults.border(
                        focusedBorder = Border(
                            border = BorderStroke(
                                width = 1.dp,
                                color = Color.White
                            ),
                            shape = ShapeDefaults.Medium
                        )
                    ),
                    modifier = Modifier
                        .focusProperties {
                            right = if (index == movieList.size - 1) {
                                FocusRequester.Cancel
                            } else {
                                FocusRequester.Default
                            }
                        }
                        .width(120.dp)
                        .height(180.dp)
                        .padding(10.dp),
                    onClick = {}
                ) {
                    AsyncImage(
                        model = item.image,
                        contentScale = ContentScale.FillBounds,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }

        }
    }
}