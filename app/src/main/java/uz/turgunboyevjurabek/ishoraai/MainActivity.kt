package uz.turgunboyevjurabek.ishoraai

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.OvershootInterpolator
import android.webkit.WebView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import uz.turgunboyevjurabek.ishoraai.Domein.CustomWebChromeClient
import uz.turgunboyevjurabek.ishoraai.Presentation.Navigation.AuthNavigation
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_screens.Auth.SplashScreen
import uz.turgunboyevjurabek.ishoraai.Presentation.ViewModel.ViewModelSplash
import uz.turgunboyevjurabek.ishoraai.ui.theme.IshoraAITheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<ViewModelSplash>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        installSplashScreen().apply {
//            setKeepOnScreenCondition {
//                !viewModel.isReady.value
//            }
//
//            setOnExitAnimationListener { screen ->
//                val zoomX = ObjectAnimator.ofFloat(
//                    screen.iconView,
//                    View.SCALE_X,
//                    0.4f,
//                    0.0f
//                )
//                zoomX.interpolator = OvershootInterpolator()
//                zoomX.duration = 500L
//                zoomX.doOnEnd { screen.remove() }
//
//                val zoomY = ObjectAnimator.ofFloat(
//                    screen.iconView,
//                    View.SCALE_Y,
//                    0.4f,
//                    0.0f
//                )
//                zoomY.interpolator = OvershootInterpolator()
//                zoomY.duration = 500L
//                zoomY.doOnEnd { screen.remove() }
//
//                zoomX.start()
//                zoomY.start()
//            }
            enableEdgeToEdge()
            setContent {
                IshoraAITheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Column(
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            AuthNavigation()
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun MyWebView() {

        val mUrl = "http://54.160.153.22:8083/"
        val context = LocalContext.current
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


