@file:OptIn(ExperimentalMaterial3Api::class)

package uz.turgunboyevjurabek.ishoraai.Presentation.UI_screens

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.MyCustomIconButton
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.ProfileUIItem.CancelProfilePart
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.ProfileUIItem.FondPart
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.ProfileUIItem.LanguagePart
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.ProfileUIItem.LightAndNightModePart
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.ProfileUIItem.NotificationPart
import uz.turgunboyevjurabek.ishoraai.R

@Composable
fun ProfileScreen(modifier: Modifier = Modifier,navHostController: NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier
                    .height(70.dp)
                    .clip(RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp)),
                title = {
                    Text(
                        text = "Profile",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_black)),
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(0.2f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(
                            onClick = {
                                navHostController.popBackStack()
                            },
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_navigation),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(27.dp)
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    navigationIconContentColor = colorResource(id = R.color.selected),
                    containerColor = if (!isSystemInDarkTheme()) {
                        Color.White
                    } else {
                        MaterialTheme.colorScheme.surfaceColorAtElevation(20.dp)
                    }
                ),
            )
        }
    ) {innerPadding->
        Column(modifier = modifier
            .padding(innerPadding)
            .fillMaxSize()
        ) {
            Spacer(modifier = modifier.height(20.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .padding(horizontal = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Absolute.SpaceAround,
            ) {
                Image(
                    painter = painterResource(id = R.drawable.donoxon_img),
                    contentDescription = null,
                    modifier = modifier
                        .size(80.dp)
                )
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .padding(end = 40.dp)
                        .fillMaxHeight()
                ) {
                    Text(
                        text = "Donaxon Olimova",
                        fontSize = 18.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_bold))
                    )
                    Text(
                        text = "dona21@gmail.com",
                        fontSize = 12.sp,
                        textDecoration = TextDecoration.Underline,
                        fontFamily = FontFamily(Font(R.font.nunito_light)),
                        color = colorResource(id = R.color.unselected)
                        )
                }
                val contex= LocalContext.current
              MyCustomIconButton(
                  onClick = {
                      Toast.makeText(contex, "Bosildi ", Toast.LENGTH_SHORT).show()
                  },
                  img = painterResource(id = R.drawable.img_edt),
              )
            }
            Spacer(modifier = modifier.height(5.dp))
            Divider(color = colorResource(id = R.color.selected), thickness = 2.dp)
            Spacer(modifier = modifier.height(20.dp))
           NotificationPart()
           LightAndNightModePart()
           LanguagePart()
           FondPart()
           CancelProfilePart()
            Spacer(modifier = modifier.height(40.dp))
            OutlinedButton(
                modifier = modifier
                    .padding(horizontal = 22.dp)
                    .fillMaxWidth()
                    .height(70.dp),
                shape = RoundedCornerShape(20.dp),
                border = BorderStroke(2.dp, colorResource(id = R.color.selected)),
                onClick = {  }
            ) {
                Image(
                    painter = painterResource(id = R.drawable.operator_img),
                    contentDescription = null,
                    modifier=modifier
                        .size(24.dp)
                )
                Spacer(modifier =modifier.width(10.dp))
                Text(
                    text = "Operatorga murojat qilish",
                    color = colorResource(id = R.color.selected),
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.nunito_medium))
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProfileScreenUI() {
    val navHostController= NavHostController(LocalContext.current)
    ProfileScreen(navHostController = navHostController)

    
}