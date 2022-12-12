package com.rakesh.cvbuilderapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient

class WebActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)
        val urlToLoad = intent.getStringExtra("url")
        webView = findViewById(R.id.web_view)
        webView.webViewClient = WebViewClient()

        // load url of the website
        webView.loadUrl(urlToLoad!!)

        // enable javascript
        webView.settings.javaScriptEnabled = true

        // enable zoom feature
        webView.settings.setSupportZoom(true)
    }

    // on Back button pressed
    override fun onBackPressed() {
        if (webView.canGoBack())
            webView.goBack()
        else
            super.onBackPressed()
    }
}