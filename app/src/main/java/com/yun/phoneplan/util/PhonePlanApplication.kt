package com.yun.phoneplan.util

import android.app.Application
import com.yun.phoneplan.di.apiModule
import com.yun.phoneplan.di.networkModule
import com.yun.phoneplan.di.sharedPreferences
import com.yun.phoneplan.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PhonePlanApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@PhonePlanApplication)
            koin.loadModules(
                listOf(
                    viewModelModule,
                    sharedPreferences,
                    networkModule,
                    apiModule
                )
            )
            koin.createRootScope()
        }
    }
}