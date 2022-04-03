package com.yun.phoneplan.data.repository

import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface OpenApi {
    @GET("/openAPI.xml")
    fun phone(
//        @Query("ServiceKey") ServiceKey: String,
//        @Query("solYear") solYear: String,
//        @Query("solMonth") solMonth: String,
//        @Query("numOfRows") numOfRows: String
    ): String//Observable<MoonModel.RS>
}