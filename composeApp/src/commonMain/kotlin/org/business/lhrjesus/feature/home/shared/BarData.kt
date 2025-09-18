package org.business.lhrjesus.feature.home.shared

import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class BarData (
    val name: String,
    val address: String,
    val latitude: Double,
    val date: LocalDateTime,
    val photoUrl: String,
    val category: String
)