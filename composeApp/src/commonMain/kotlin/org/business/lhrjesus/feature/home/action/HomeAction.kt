package org.business.lhrjesus.feature.home.action

sealed interface HomeAction {
    data object Idle: HomeAction
    data class  RequestNavigateToDetails(
        val urlToImage: String,
        val description: String
    ): HomeAction
    data object RequestBrakingNews: HomeAction
}