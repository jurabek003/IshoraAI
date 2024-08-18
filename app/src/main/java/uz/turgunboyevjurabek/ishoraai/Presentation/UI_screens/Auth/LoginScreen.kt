@file:OptIn(ExperimentalMaterial3Api::class)

package uz.turgunboyevjurabek.ishoraai.Presentation.UI_screens.Auth

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.MyElevatedCard
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.MyTextField
import uz.turgunboyevjurabek.ishoraai.R

@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavController) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .height(70.dp)
                    .clip(RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp)),
                title = {
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = if (!isSystemInDarkTheme()) {
                        Color.White
                    } else {
                        MaterialTheme.colorScheme.surfaceColorAtElevation(20.dp)
                    }
                ),
            )
        }
    ) { innerPadding ->
        Column(modifier = modifier
            .padding(innerPadding)
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            var email by remember {
                mutableStateOf("")
            }
            var password by remember {
                mutableStateOf("")
            }

            Spacer(modifier = modifier.height(60.dp))
            Image(
                painter = painterResource(id = R.drawable.okey),
                contentDescription = "ok",
                modifier = modifier
                    .width(84.dp)
                    .height(97.dp)
            )
            Spacer(modifier = modifier.height(25.dp))
            Text(
                text = "Akkauntga kirish",
                fontSize = 20.sp,
                onTextLayout = {},
                fontFamily = FontFamily(Font(R.font.nunito_bold))
            )
            Spacer(modifier = modifier.height(25.dp))

            MyTextField(
                value = email,
                placeholder = "Elektron manzil",
                onValueChange = {
                    email = it
                },
            )
            Spacer(modifier = modifier.height(25.dp))
            MyTextField(
                value = password,
                placeholder = "Parol",
                onValueChange = {
                    password = it
                }
            )
            Spacer(modifier = modifier.height(25.dp))
            Button(
                onClick = {

                },
                modifier = modifier
                    .padding(horizontal = 22.dp)
                    .fillMaxWidth()
                    .height(53.dp),
                shape =RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(id = R.color.selected),
                )
            ) {
                Text(
                    text = "Kirish",
                    fontSize = 20.sp,
                    onTextLayout = {},
                    fontFamily = FontFamily(Font(R.font.nunito_bold))
                )
            }

            Spacer(modifier = modifier.height(30.dp))
            Text(
                text = "Yoki bular orqali",
                fontSize = 13.sp,
                onTextLayout = {},
                fontFamily = FontFamily(Font(R.font.nunito_medium)),
                color = colorResource(id = R.color.unselected)
            )
            Spacer(modifier = modifier.height(30.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                MyElevatedCard(onClick = { }, img = painterResource(id = R.drawable.ic_google) )
                MyElevatedCard(onClick = { }, img = painterResource(id = R.drawable.ic_facebook) )
                MyElevatedCard(onClick = { }, img = painterResource(id = R.drawable.ic_x) )

            }
            Spacer(modifier = modifier.height(40.dp))
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Sizda akkaunt yo’qmi ?", fontSize = 13.sp,onTextLayout = {},)
                TextButton(
                    onClick = {
                        navController.navigate("RegisterScreen")
                    }
                ){
                    Text(text = "Ro’yxatdan o’tish", color = colorResource(id = R.color.selected), fontSize = 13.sp,onTextLayout = {},)
                }
            }

        }
    }

}

@Preview
@Composable
private fun LoginPrevUI() {
    val navController = rememberNavController()
    LoginScreen(navController = navController)
}