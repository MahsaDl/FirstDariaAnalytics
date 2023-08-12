package com.example.dariaanalytics.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dariaanalytics.data.remote.ApiService
import com.example.dariaanalytics.domain.model.EventProperties
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EventTrackingViewModel : ViewModel() {

    private val _eventName = MutableLiveData<String>()
    private val eventName: LiveData<String> = _eventName

    fun setEventName(eventName: String) {
        _eventName.value = eventName
    }

    private val _eventJob = MutableLiveData<String>()
    private val eventJob: LiveData<String> = _eventJob

    fun setEventJob(eventJob: String) {
        _eventJob.value = eventJob
    }

    fun trackEvent(apiService: ApiService) {
        val eventName = eventName.value ?: return
//        val eventJob = eventJob.value ?: return
        val eventJob = "job"
        val eventProperties = EventProperties(eventName,eventJob)
        apiService.sendEvent(eventProperties.eventName,eventProperties.eventJob).enqueue(object : Callback<EventProperties> {
            override fun onResponse(
                call: Call<EventProperties>,
                response: Response<EventProperties>
            ) {
                val eventProperties = response.body()
                eventProperties?.let { Log.e("mahsa", it.eventName ) }
            }

            override fun onFailure(call: Call<EventProperties>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}