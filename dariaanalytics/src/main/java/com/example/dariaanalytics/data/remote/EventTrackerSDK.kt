package com.example.dariaanalytics.data.remote

import androidx.lifecycle.ViewModelProvider
import com.example.dariaanalytics.presentation.viewmodel.EventTrackingViewModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object EventTrackerSDK {

    private lateinit var apiService: ApiService
    private lateinit var eventTrackingViewModel: EventTrackingViewModel

    fun init() {
        apiService = Retrofit.Builder()
            .baseUrl(ApiService.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        eventTrackingViewModel = ViewModelProvider.NewInstanceFactory().create(EventTrackingViewModel::class.java)
    }

    fun trackAndPerformEvent(eventName: String) {
        eventTrackingViewModel.setEventName(eventName)
        eventTrackingViewModel.trackEvent(apiService)
    }
}