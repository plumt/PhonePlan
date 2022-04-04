package com.yun.phoneplan.data.repository

import com.yun.phoneplan.data.model.SmartChoiceModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface OpenApi {
    @GET("/api/openAPI.xml")
    fun choice(
        @Query("authkey") ServiceKey: String,
        @Query("voice") voice: String,
        @Query("data") data: String,
        @Query("sms") sms: String,
        @Query("age") age: String,
        @Query("type") type: String,
        @Query("dis") dis: String
    ): Observable<SmartChoiceModel.RS>
}