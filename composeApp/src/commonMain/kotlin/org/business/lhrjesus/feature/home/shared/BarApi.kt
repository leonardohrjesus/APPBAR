package org.business.lhrjesus.feature.home.shared

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class BarApi {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            })
        }
    }

    suspend fun getBares(): List<BarData> {

        val response: HttpResponse =  client.get("http://10.0.2.2:8080/api/bars")
        println("Erro ao carregar baresss: ${response}")
        return response.body()
    }
}



