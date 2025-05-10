package org.business.lhrjesus.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.business.lhrjesus.feature.filter.FilterScreen
import org.business.lhrjesus.feature.home.screen.HomeScreen
import org.business.lhrjesus.feature.maps.MapsScreen
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
        composable<HomeRoutes.Filter> {
            FilterScreen(onBackPressed = {
                navHostController.popBackStack()
            },
                navigateToHomeScreen = {
                    navHostController.navigate(HomeRoutes.Home)
                },
                navigateToMapsScreen= {
                    navHostController.navigate(HomeRoutes.Maps)

                }
            )
        }

        composable<HomeRoutes.Home> {
            HomeScreen(
                /*navigateToDetailsScreen = { urlToImage , description ->
                    navHostController.navigate(HomeRoutes.Details(
                        urlToImage = urlToImage,
                        description = description
                    ))
                },*/
                navigateToFilterScreen = {
                    navHostController.navigate(HomeRoutes.Filter)
                },
                navigateToMapsScreen = {
                    navHostController.navigate(HomeRoutes.Maps)

                }
            )
        }

        composable<HomeRoutes.Maps> {
            MapsScreen(
                   onBackPressed = {
                       navHostController.popBackStack()
                   },
                navigateToFilterScreen = {
                    navHostController.navigate(HomeRoutes.Filter)
                },
                navigateToHomeScreen = {
                    navHostController.navigate(HomeRoutes.Home)

                }
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