package com.example.dariaanalytics.domain.model

data class EventProperties(
    val eventName: String,
    val eventJob: String
){
    override fun toString(): String {
        return "EventProperties(eventName='$eventName')"
    }
}

