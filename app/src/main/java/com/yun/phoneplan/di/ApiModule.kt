package com.yun.phoneplan.di

import com.yun.phoneplan.data.repository.OpenApi
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {

    fun providerOpenApi(retrofit: Retrofit): OpenApi {
        return retrofit.create(OpenApi::class.java)
    }

    single() { providerOpenApi(get()) }
}