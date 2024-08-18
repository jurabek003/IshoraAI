package uz.turgunboyevjurabek.ishoraai.Presentation.UI_screens.Auth

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import uz.turgunboyevjurabek.ishoraai.Presentation.ViewModel.ViewModelSplash
import uz.turgunboyevjurabek.ishoraai.R

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun SplashScreen(navController: NavController) {

    val viewModel =viewModel<ViewModelSplash>()
    val context= LocalContext.current
    Toast.makeText(context, viewModel.isReady.value.toString(), Toast.LENGTH_SHORT).show()
    val scope= rememberCoroutineScope()
    LaunchedEffect(key1 = true) {
        delay(1500)
        navController.popBackStack()
        navController.navigate("Page1Screen")
    }

//    if (viewModel.isReady.value){
//        navController.navigate("Page1Screen")
//    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.selected)),

        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.okey),
            contentDescription = null,
            Modifier.size(100.dp)
        )
        Text(
            text = "IshoraAI",
            fontSize = 64.sp,
            color = Color.White,
            onTextLayout = {},
            fontFamily = FontFamily(Font(R.font.jua_regular))
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun SplashScreenPreview() {
    val navController= rememberNavController()
    SplashScreen(navController)
}