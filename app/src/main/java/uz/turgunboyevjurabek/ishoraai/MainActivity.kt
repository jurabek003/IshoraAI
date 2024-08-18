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
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalAbsoluteTonalElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import uz.turgunboyevjurabek.ishoraai.Domein.CustomWebChromeClient
import uz.turgunboyevjurabek.ishoraai.Presentation.BottomNavigationItem
import uz.turgunboyevjurabek.ishoraai.Presentation.Navigation.AuthNavigation
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_screens.Auth.SplashScreen
import uz.turgunboyevjurabek.ishoraai.Presentation.ViewModel.ViewModelSplash
import uz.turgunboyevjurabek.ishoraai.ui.theme.IshoraAITheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<ViewModelSplash>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            IshoraAITheme {
                val navController = rememberNavController()
                // Hozirgi marshrutni kuzatish
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val context = LocalContext.current
                WindowCompat.setDecorFitsSystemWindows(window, false)
                Scaffold(
                    bottomBar = {
                        if (currentRoute !in listOf("SplashScreen", "Page1Screen", "LoginScreen", "RegisterScreen")) {
                            MyNavigationBar(navController)
                        }
                    }
                ) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .padding(innerPadding)
                            .fillMaxSize()
                    ) {
                        AuthNavigation(navController = navController)
                    }
                }
            }
        }
    }
}

@Composable
fun MyNavigationBar(navController: NavHostController) {
    val items = listOf(
        BottomNavigationItem(
            title = "Asosiy",
            icon = painterResource(id = R.drawable.ic_home),
            selectedColor = colorResource(id = R.color.selected),
            unselectedColor = colorResource(id = R.color.unselected),
            screenRout = "MainScreen",
            badgeCount = 0
        ),
        BottomNavigationItem(
            title = "Kurslar",
            icon = painterResource(id = R.drawable.ic_cours),
            selectedColor = colorResource(id = R.color.selected),
            unselectedColor = colorResource(id = R.color.unselected),
            screenRout = "TasbexScreen",
            badgeCount = 0
        ),
        BottomNavigationItem(
            title = "Saqlangan",
            icon = painterResource(id = R.drawable.ic_saves),
            selectedColor = colorResource(id = R.color.selected),
            unselectedColor = colorResource(id = R.color.unselected),
            screenRout = "Dayof7Screen",
            badgeCount = 0
        ),
        BottomNavigationItem(
            title = "Profilim",
            icon = painterResource(id = R.drawable.ic_profile),
            selectedColor = colorResource(id = R.color.selected),
            unselectedColor = colorResource(id = R.color.unselected),
            screenRout = "Dayof30Screen",
            badgeCount = 0
        ),
    )
    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    NavigationBar(
        containerColor = if (!isSystemInDarkTheme()) {
            Color.White
        } else {
            MaterialTheme.colorScheme.surfaceColorAtElevation(20.dp)
        },
        tonalElevation = 12.dp,
        modifier = Modifier
            .height(100.dp)
            .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))

    ) {
        items.forEachIndexed { index, bottomNavigationItem ->
            NavigationBarItem(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                },
                label = {
                    Text(
                        text = bottomNavigationItem.title,
                        fontSize = 10.sp,
                        onTextLayout = {},
                        fontWeight = FontWeight.ExtraBold
                    )
                },
                icon = {
                    Icon(
                        painter = bottomNavigationItem.icon,
                        contentDescription = null,
                        modifier = Modifier.size(26.dp),
                        tint = if (selectedTabIndex == index) bottomNavigationItem.selectedColor else bottomNavigationItem.unselectedColor
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = MaterialTheme.colorScheme.surfaceColorAtElevation(
                        LocalAbsoluteTonalElevation.current
                    )
                ),
            )

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

//installSplashScreen().apply {
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

