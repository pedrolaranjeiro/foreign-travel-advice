package uk.co.flat14.ftaa.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable
import uk.co.flat14.ftaa.presentation.screens.CountryListScreen

@Composable
fun navigationStack(): NavHostController {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = CountryListRoute) {
        composable<CountryListRoute> {
            CountryListScreen()
        }
    }

    return navController
}

@Serializable
object CountryListRoute

