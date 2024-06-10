package com.danielnastase.gooder.presentation.clients

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.danielnastase.gooder.GooderAppState
import com.danielnastase.gooder.R
import com.danielnastase.gooder.presentation.DiscoverScreen
import com.danielnastase.gooder.presentation.StoreScreen
import com.danielnastase.gooder.presentation.clients.profile.ProfileScreen

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    appState: GooderAppState
) {
    val homeState = rememberAppState()

    val bottomNavigationItems = listOf(
        BottomNavigationItem(
            title = "Discover",
            icon = painterResource(id = R.drawable.shopping_bag),
            route = HomeRoutes.DiscoverScreen.route
        ),
        BottomNavigationItem(
            title = "Stores",
            icon = painterResource(id = R.drawable.store),
            route = HomeRoutes.StoresScreen.route
        ),
        BottomNavigationItem(
            title = "Profile",
            icon = painterResource(id = R.drawable.profile),
            route = HomeRoutes.ProfileScreen.route
        )
    )
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            bottomBar = {
                Column {
                    Divider(color = MaterialTheme.colorScheme.secondary)
                    NavigationBar(
                        containerColor = MaterialTheme.colorScheme.background,
                        contentColor = MaterialTheme.colorScheme.primary,
                    ) {
                        bottomNavigationItems.forEachIndexed {index, item ->
                            NavigationBarItem(
                                selected = index == selectedItemIndex,
                                onClick = {
                                    selectedItemIndex = index
                                    homeState.navigateAndClear(item.route)
                                },
                                label = {
                                    Text(
                                        item.title,
                                        color = if (index == selectedItemIndex) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                                    )
                                },
                                icon = {
                                    Icon(
                                        painter = item.icon,
                                        contentDescription = item.title,
                                        tint = if (index == selectedItemIndex) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                                    )
                                },
                                colors = NavigationBarItemDefaults.colors(
                                    indicatorColor = MaterialTheme.colorScheme.background
                                )
                            )
                        }
                    }
                }
            }
        ) {
            NavHost(
                navController = homeState.navController,
                startDestination = HomeRoutes.DiscoverScreen.route
            ){
                homeGraph(homeState, appState)
            }
        }
    }
}

@Composable
fun rememberAppState(navController: NavHostController = rememberNavController()) =
    remember(navController) {
        GooderAppState(navController)
    }

fun NavGraphBuilder.homeGraph(
    homeState: GooderAppState,
    appState: GooderAppState
) {
    composable(HomeRoutes.DiscoverScreen.route) {
        DiscoverScreen(homeState)
    }
    composable(HomeRoutes.StoresScreen.route) {
        StoreScreen(homeState)
    }
    composable(HomeRoutes.ProfileScreen.route) {
        ProfileScreen(homeState, appState)
    }
}

data class BottomNavigationItem(
    val title: String,
    val icon: Painter,
    val route: String
)