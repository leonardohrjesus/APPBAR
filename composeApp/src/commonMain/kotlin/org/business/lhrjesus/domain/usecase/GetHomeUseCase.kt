package org.business.lhrjesus.domain.usecase


import kotlinx.coroutines.flow.Flow
import org.business.lhrjesus.domain.model.EventsDomain
import org.business.lhrjesus.domain.repository.HomeRepository

class GetHomeUseCase(
    private val repository: HomeRepository
) {

    fun getBreakingNews():Flow<EventsDomain> = repository.getEvents()


}