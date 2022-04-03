package com.yun.phoneplan.di

import com.yun.phoneplan.util.PreferenceManager
import org.koin.dsl.module


val sharedPreferences = module {
    fun provideSharedPref(): PreferenceManager {
        return PreferenceManager
    }
    single { provideSharedPref() }
}