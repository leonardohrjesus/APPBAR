package org.business.lhrjesus

import android.os.Build
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat.startActivity

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()


actual fun openInstagram() {
    val context = AndroidContextHolder.context
    val packageName = "com.instagram.android"
    val intent: Intent

    // Tenta abrir o app do Instagram
    try {
        val packageManager = context.packageManager
        intent = packageManager.getLaunchIntentForPackage(packageName) ?: throw Exception("Instagram not installed")
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(context, intent, null)
    } catch (e: Exception) {
        // Se o Instagram não estiver instalado, abre no navegador
        val webUrl = "https://www.instagram.com/vila567bar/"
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(webUrl))
        browserIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(context, browserIntent, null)
    }
}

object AndroidContextHolder {
    lateinit var context: Context
        private set

    fun init(context: Context) {
        this.context = context.applicationContext
    }
}