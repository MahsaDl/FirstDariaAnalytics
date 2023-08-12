package com.example.dariaanalytics.data.remote

import com.example.dariaanalytics.domain.model.EventProperties
import retrofit2.Call
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

interface ApiService {
    companion object {
        const val BASE_URL = "https://reqres.in/"
    }
    @POST("/api/users")
    @FormUrlEncoded
    fun sendEvent(@Field("name") eventName: String, @Field("job") eventJob: String ): Call<EventProperties>
}