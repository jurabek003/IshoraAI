package uz.turgunboyevjurabek.ishoraai.Domein

import android.util.Log
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView

class CustomWebChromeClient : WebChromeClient() {
    override fun onCloseWindow(window: WebView?) {}

    override fun onConsoleMessage(consoleMessage: ConsoleMessage?): Boolean {
        Log.d("jjjj", consoleMessage?.message().toString())
        return true
    }
}