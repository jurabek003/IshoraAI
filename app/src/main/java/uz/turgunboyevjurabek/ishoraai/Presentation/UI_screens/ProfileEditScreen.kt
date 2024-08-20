@file:OptIn(ExperimentalMaterial3Api::class)

package uz.turgunboyevjurabek.ishoraai.Presentation.UI_screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.AlertDialogDefaults.shape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.ChangeProfileImgItem
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.EditProfileItem.CalendarTextField
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.EditProfileItem.ElevatedTextField
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.EditProfileItem.EmailTextField
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.EditProfileItem.SexElevatedTextField
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.MyCustomIconButton
import uz.turgunboyevjurabek.ishoraai.R

@Composable
fun ProfileEditScreen(modifier: Modifier = Modifier,navHostController: NavHostController) {
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier
                    .height(70.dp)
                    .clip(RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp)),
                title = {
                    Text(
                        text = "Tahrirlash",
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

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
        ){
            Spacer(modifier = modifier.height(20.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .height(100.dp),
                horizontalArrangement = Arrangement.Absolute.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ChangeProfileImgItem()
                Spacer(modifier = modifier.size(20.dp))
            }
            Spacer(modifier = modifier.height(20.dp))
            Divider(thickness = 2.dp, color = colorResource(id = R.color.selected))
            Text(
                text = "Shaxsiy",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.nunito_bold)),
                modifier = modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp)
            )
            Spacer(modifier = modifier.height(10.dp))
            ElevatedTextField(
                modifier = modifier,
                value = "Donaxon Olimova",
                icon = painterResource(id = R.drawable.ic_ptichka)
            )
            Spacer(modifier = modifier.height(20.dp))
            Row(
                modifier = modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SexElevatedTextField(value = "Ayol", icon = null)
                CalendarTextField(value = "12/12/1211", icon = painterResource(id = R.drawable.ic_calendar))
            }
            Spacer(modifier = modifier.height(25.dp))
            Text(
                text = "Email va parol",
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.nunito_bold)),
                modifier = modifier
                    .padding(horizontal = 20.dp)
                    .padding(top = 20.dp)
            )
            Spacer(modifier = modifier.height(10.dp))
            EmailTextField(modifier = modifier, value = "dona21@gmail.com", icon = null)
        }
    }

}

@Preview(showSystemUi = true)
@Composable
private fun ProfileEditScreenUI() {
    val navHostController= NavHostController(LocalContext.current)
    ProfileEditScreen(Modifier,navHostController)
}