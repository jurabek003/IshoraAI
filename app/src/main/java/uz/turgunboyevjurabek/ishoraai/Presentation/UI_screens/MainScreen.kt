package uz.turgunboyevjurabek.ishoraai.Presentation.UI_screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.turgunboyevjurabek.ishoraai.Domein.BottomNavigationItem
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.BottomNavigationButton
import uz.turgunboyevjurabek.ishoraai.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "AutoboxingStateCreation")
@Composable
fun MainScreen() {
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


    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
            var selectedTabIndex by rememberSaveable {
                mutableIntStateOf(0)
            }
            NavigationBar {
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
                    )

                }
            }
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "O’zingizga kerakli xizmat turini tanlang",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .padding(top = 100.dp, start = 30.dp, end = 30.dp)
            )

            LazyRow(
                modifier = Modifier.padding(top = 15.dp)
            ) {
                items(3){
                    ListUI()
                }
            }

        }
    }

}

@Composable
fun ListUI() {
    Card(
        border = BorderStroke(2.dp, colorResource(id = R.color.selected)),
        modifier = Modifier
            .padding(20.dp)
            .width(230.dp)
            .wrapContentHeight(unbounded = true),
        shape = RoundedCornerShape(25.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.img1),
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(130.dp)
            )
            Text(text = "Imo ishoraga", fontSize = 18.sp, textAlign = TextAlign.Center, fontWeight = FontWeight.ExtraBold)
            Text(
                text = "Matn yoki ovozni imo-ishora tiliga o’tkazish",
                fontSize = 13.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .alpha(0.5f)
                    .padding(top = 10.dp, start = 5.dp, end = 5.dp)
            )


        }

    }


}