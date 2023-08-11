package com.example.dariaanalytics.domain.repository

interface AnalyticsSDK {
    fun trackEvent(eventName: String, properties: Map<String, Any>?)
}