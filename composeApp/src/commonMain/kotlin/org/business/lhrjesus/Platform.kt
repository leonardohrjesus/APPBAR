package org.business.lhrjesus

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform