package org.business.lhrjesus.feature.home.viewmodel

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.business.lhrjesus.feature.home.shared.BarApi
import org.business.lhrjesus.feature.home.shared.BarData

class BarViewModel {

    private val api = BarApi()
    private val _bares = MutableStateFlow<List<BarData>>(emptyList())
    val bares: StateFlow<List<BarData>> = _bares

    private val viewModelScope = CoroutineScope(SupervisorJob() + Dispatchers.Default)

    fun loadBares() {
        viewModelScope.launch {
            try {
                val result = api.getBares()
                println("Erro ao carregar baress: ${result}")

                _bares.value = result
            } catch (e: Exception) {
                println("Erro ao carregar bares: ${e}")
            }
        }
    }
}
