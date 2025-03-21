package org.business.lhrjesus.navigation.main

import HomeScreen
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.business.lhrjesus.navigation.routes.HomeRoutes

@Composable
fun HomeNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = HomeRoutes.Home,
        modifier = modifier
    ) {
        composable<HomeRoutes.About> {
           TODO()
        }

        composable<HomeRoutes.Home> {
            HomeScreen(
                /*navigateToDetailsScreen = { urlToImage , description ->
                    navHostController.navigate(HomeRoutes.Details(
                        urlToImage = urlToImage,
                        description = description
                    ))
                },
                navigateToAboutScreen = {
                    navHostController.navigate(HomeRoutes.About)
                }*/
            )
        }

        composable<HomeRoutes.Details> {
         /*   DetailsScreen(
                onBackPressed = {
                    navHostController.popBackStack()
                }
            )*/
        }
    }
}