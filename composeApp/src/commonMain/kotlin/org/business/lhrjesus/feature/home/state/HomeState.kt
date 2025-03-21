package org.business.lhrjesus.feature.home.state

import org.business.lhrjesus.domain.model.EventsDomain


sealed interface HomeState {
    data object Idle: HomeState
    data object Loading: HomeState
    data class NavigateToDetails(
        val urlToImage:String,
        val description:String
    ): HomeState
    data class ShowData(val data: List<EventsDomain>) : HomeState
}