package org.business.lhrjesus.domain.repository

import kotlinx.coroutines.flow.Flow
import org.business.lhrjesus.domain.model.EventsDomain

interface HomeRepository {
    fun getEvents(): Flow<EventsDomain>
}