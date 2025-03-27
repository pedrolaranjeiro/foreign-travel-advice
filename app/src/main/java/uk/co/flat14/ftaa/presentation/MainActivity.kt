package uk.co.flat14.ftaa.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.koin.androidx.compose.KoinAndroidContext
import uk.co.flat14.ftaa.presentation.theme.FTATheme


val LocalNavController = compositionLocalOf<NavHostController> {
    error("No LocalNavController provided")
}
class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoinAndroidContext {
                CompositionLocalProvider(value = LocalNavController provides rememberNavController()) {
                    FTATheme {
                        Surface {
                            navigationStack()
                        }
                    }
                }
            }
        }
    }
}
