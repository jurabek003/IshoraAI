package uz.turgunboyevjurabek.ishoraai

import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.webkit.ConsoleMessage
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import uz.turgunboyevjurabek.ishoraai.Domein.CustomWebChromeClient
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_screens.Auth.SplashScreen
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_screens.MainScreen
import uz.turgunboyevjurabek.ishoraai.ui.theme.IshoraAITheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IshoraAITheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier.padding(innerPadding)
                    ) {
//                        MainScreen()
                        SplashScreen()
                    }
                }
            }
        }
    }
}

@Composable
fun MyWebView() {

    val mUrl = "http://54.160.153.22:8083/"
    val  context= LocalContext.current
    Toast.makeText(context, "VebView start...", Toast.LENGTH_SHORT).show()

    AndroidView(factory = {
        WebView(it).apply {
            this.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            this.webChromeClient = CustomWebChromeClient()
        }
    }, update = {
        it.loadUrl(mUrl)
    })
}


