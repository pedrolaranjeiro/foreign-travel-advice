package uk.co.flat14.ftaa.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import kotlinx.serialization.Serializable
import uk.co.flat14.ftaa.domain.model.CountryInformation
import uk.co.flat14.ftaa.presentation.screens.CountryDetailsScreen
import uk.co.flat14.ftaa.presentation.screens.CountryListScreen


@Composable
fun navigationStack(): NavHostController {
    val navController = LocalNavController.current

    NavHost(navController = navController, startDestination = CountryListRoute) {
        composable<CountryListRoute> {
            CountryListScreen()
        }

        composable<CountryDetailRoute> {
            val args  = it.toRoute<CountryDetailRoute>()
           CountryDetailsScreen(args.countryName)
        }

    }

    return navController
}

@Serializable
object CountryListRoute


@Serializable
data class CountryDetailRoute(
    val countryName: String
)

