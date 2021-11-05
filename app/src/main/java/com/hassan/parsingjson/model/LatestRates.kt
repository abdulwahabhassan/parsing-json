package com.hassan.parsingjson.model

data class LatestRates(
    val success: Boolean?,
    val timestamp: Long?,
    val base: String?,
    val date: String?,
    val rates: Map<String, Double>?
)
