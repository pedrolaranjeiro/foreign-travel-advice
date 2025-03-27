package uk.co.flat14.ftaa.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import org.koin.androidx.compose.KoinAndroidContext
import uk.co.flat14.ftaa.presentation.theme.FTATheme

class MainActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KoinAndroidContext {
                FTATheme {
                    Surface {
                        navigationStack()
                    }
                }
            }
        }
    }
}
