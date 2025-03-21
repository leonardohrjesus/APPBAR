package org.business.lhrjesus.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class EventsDomain(
    val author: String? = null,
    val content: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    val title: String? = null,
    val url: String? = null,
    val urlToImage: String? = null
)
