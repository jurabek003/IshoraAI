package uz.turgunboyevjurabek.ishoraai.Presentation.Navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_screens.Auth.LoginScreen
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_screens.Auth.Page1Screen
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_screens.Auth.RegisterScreen
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_screens.Auth.SplashScreen


@Composable
fun AuthNavigation() {
val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "SplashScreen"){
        composable("SplashScreen"){
            SplashScreen(navController = navController)
        }
        composable("Page1Screen"){
            Page1Screen(navController = navController)
        }
        composable("LoginScreen"){
            LoginScreen(navController = navController)
        }
        composable("RegisterScreen"){
            RegisterScreen(navController = navController)
        }

    }


}