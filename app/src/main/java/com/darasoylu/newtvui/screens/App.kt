package com.darasoylu.newtvui.screens

import androidx.compose.animation.*
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Search
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.tv.material3.*
import com.darasoylu.newtvui.R
import com.darasoylu.newtvui.screens.movies.home.HomeScreen
import com.darasoylu.newtvui.ui.theme.HomeScreenBackground
import com.darasoylu.newtvui.ui.theme.TopBarColor

@Composable
fun App(

) {
    val tabs = listOf("Home", "Live", "Movies", "Series", "Search")
    val selectedTabIndex = remember { mutableStateOf(0) }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(color = TopBarColor)
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic_display),
                contentDescription = null,
                modifier = Modifier.fillMaxHeight()
            )

            TabRow(
                selectedTabIndex = selectedTabIndex.value,
                separator = { Spacer(modifier = Modifier.size(10.dp)) },
                indicator = { tabPositions, doesTabRowHaveFocus ->
                    TabRowDefaults.PillIndicator(
                        tabPositions[selectedTabIndex.value],
                        doesTabRowHaveFocus,
                        modifier = Modifier
                    )

                }
            ) {
                tabs.forEachIndexed { index, tab ->
                    val isFocused = selectedTabIndex.value == index
                    Tab(
                        interactionSource = MutableInteractionSource(),
                        selected = selectedTabIndex.value == index,
                        onClick = {
                            selectedTabIndex.value = index
                        },
                        colors = TabDefaults.pillIndicatorTabColors(
                            contentColor = Color.Yellow,
                            focusedContentColor = Color.Green
                        ),
                        onFocus = {
                            selectedTabIndex.value = index
                        },
                        modifier = Modifier
                    ) {
                        Text(
                            text = tab,
                            color = if (isFocused) Color.Black else Color.White,
                            modifier = Modifier.padding(10.dp),
                            fontSize = 16.sp
                        )
                    }
                }
            }

            IconButton(
                onClick = { },
                modifier = Modifier.size(48.dp)
            ) {
                Icon(
                    imageVector = Icons.Sharp.Settings,
                    contentDescription = "Settings"
                )
            }
        }

        when (selectedTabIndex.value) {
            0 -> HomeContent()
            1 -> LiveContent()
            2 -> MoviesContent()
            3 -> SeriesContent()
            4 -> SearchContent()
        }
    }
}

@Composable
fun HomeContent() {
    HomeScreen()
}

@Composable
fun LiveContent() {
    //LiveScreen()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = HomeScreenBackground)
    ) {
        Button(
            onClick = { },
            colors = ButtonDefaults.colors(
                containerColor = Color.Black,
                contentColor = Color.White,
                focusedContentColor = Color.Black,
                focusedContainerColor = Color.White,
            ),
            modifier = Modifier.padding(8.dp),
        ) {
            Text(text = "Live")
        }
        Text(text = "Live Content", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun MoviesContent() {
    //MoviesScreen()
    Text(text = "Movies Content", modifier = Modifier.padding(16.dp))
}

@Composable
fun SeriesContent() {
    //SeriesScreen()
    Text(text = "Series Content", modifier = Modifier.padding(16.dp))
}

@Composable
fun SearchContent() {
    //SearchScreen()
    Text(text = "Search Content", modifier = Modifier.padding(16.dp))
}

@Composable
fun searchWithAnimation() {
    var isSettingsIconFocused by remember { mutableStateOf(false) }
    val boxWidth by animateDpAsState(if (isSettingsIconFocused) 120.dp else 48.dp)

    Box(
        modifier = Modifier
            .onFocusChanged {
                isSettingsIconFocused = it.isFocused
            }
            .background(if (isSettingsIconFocused) Color.Transparent else Color.Transparent)
            .width(boxWidth)
            .height(48.dp)

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            IconButton(
                onClick = { /* TODO: Handle settings icon click */ },
                modifier = Modifier.weight(1f)
            ) {
                Icon(
                    imageVector = Icons.Sharp.Search,
                    contentDescription = "Settings"
                )
            }
            AnimatedVisibility(
                visible = isSettingsIconFocused,
                enter = fadeIn(animationSpec = tween(300)) + slideInHorizontally(animationSpec = tween(300)) { it },
                exit = fadeOut(animationSpec = tween(300)) + slideOutHorizontally(animationSpec = tween(300)) { it }
            ) {
                Text(text = "Search", color = Color.White, modifier = Modifier.padding(start = 8.dp))
            }
        }
    }
}