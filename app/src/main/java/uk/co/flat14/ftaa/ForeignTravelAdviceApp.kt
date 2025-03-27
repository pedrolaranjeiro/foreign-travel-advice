package uk.co.flat14.ftaa

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import uk.co.flat14.ftaa.di.appModule
import uk.co.flat14.ftaa.di.dataModule
import uk.co.flat14.ftaa.di.domainModule

class ForeignTravelAdviceApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidLogger()
            androidContext(this@ForeignTravelAdviceApp)
            modules(appModule, domainModule, dataModule)
        }
    }
}
