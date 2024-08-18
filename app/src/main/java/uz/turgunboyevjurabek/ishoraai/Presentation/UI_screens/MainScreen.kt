@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package uz.turgunboyevjurabek.ishoraai.Presentation.UI_screens

import android.annotation.SuppressLint
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerSnapDistance
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import uz.turgunboyevjurabek.ishoraai.Data.PagerItem
import uz.turgunboyevjurabek.ishoraai.Presentation.BottomNavigationItem
import uz.turgunboyevjurabek.ishoraai.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "AutoboxingStateCreation")
@Composable
fun MainScreen(navController: NavController) {
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
    Scaffold(modifier = Modifier.fillMaxSize(),
        bottomBar = {
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
                    )

                }
            }
        }
    ) {innerpadding->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpadding),
        ) {
            val pages = listOf(
                PagerItem(painterResource(id = R.drawable.img1),"Imo ishoraga","Matn yoki ovozni imo-ishora tiliga o’tkazish"),
                PagerItem(painterResource(id = R.drawable.boy),"Matn yoki ovozga","Imo-ishor tilini kamera orqali real vaqtda matn yoki ovozga aylantiring"),
                PagerItem(painterResource(id = R.drawable.boy2),"Video yuklash","Olingan videoni yuklang va matn yoki ovozga aylantiring"),
            )
            Text(
                text = "O’zingizga kerakli xizmat turini tanlang",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                onTextLayout = {},
                fontFamily = FontFamily(Font(R.font.nunito_black)),
                modifier = Modifier
                    .padding(horizontal = 50.dp)
                    .padding(top = 80.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            var selectedTabIndex by remember {
                mutableIntStateOf(0)
            }
            var pagerState = rememberPagerState {
                pages.size
            }

            LaunchedEffect(selectedTabIndex) {
                pagerState.animateScrollToPage(selectedTabIndex)
            }
            LaunchedEffect(pagerState.currentPage, pagerState.isScrollInProgress) {
                if (!pagerState.isScrollInProgress) {
                    selectedTabIndex = pagerState.currentPage
                }
            }
            val lowVelocityAnimationSpec = spring<Float>(
                dampingRatio = 0.5f,
                stiffness = 50f // Past qattiqlik: sekin va yumshoq animatsiya
            )
            HorizontalPager(
                state = pagerState,
                contentPadding = PaddingValues(horizontal = 70.dp), // Har bir sahifa uchun chekka bo'shliq
                modifier = Modifier
                    .fillMaxWidth(),
                flingBehavior = PagerDefaults.flingBehavior(
                    state = pagerState,
                    lowVelocityAnimationSpec = lowVelocityAnimationSpec,
//                    pagerSnapDistance = PagerSnapDistance.atMost(2),
                    snapAnimationSpec = tween(
                        durationMillis = 500,
                        easing = LinearOutSlowInEasing
                    )
                ),

                ) {page->
                ListUI(pages[page].image,pages[page].name,pages[page].about)
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 35.dp)
                    .weight(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Bottom
            ) {
                repeat(pagerState.pageCount){iteration->
                    val color=if (pagerState.currentPage==iteration) colorResource(id = R.color.selected) else Color.Transparent
                    OutlinedCard(
                        border = BorderStroke(1.dp, color = colorResource(id = R.color.selected)),
                        colors = CardDefaults.cardColors(
                            containerColor = color,
                        ),
                        modifier = Modifier
                            .padding(4.dp)
                            .height(10.dp)
                            .width(26.dp)
                    ) {}
                }
            }

        }
    }

}

@Composable
fun ListUI(img:Painter,name:String,about:String) {
    Card(
        border = BorderStroke(2.dp, colorResource(id = R.color.selected)),
        modifier = Modifier
            .padding(15.dp)
            .width(240.dp)
            .wrapContentHeight(unbounded = true),
        shape = RoundedCornerShape(25.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 25.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = img,
                contentDescription = null,
                modifier = Modifier
                    .width(100.dp)
                    .height(140.dp)
            )
            Text(
                text = name,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.ExtraBold
            )
            Text(
                text = about,
                fontSize = 16.sp,
                onTextLayout = {},
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.nunito_medium)),
                modifier = Modifier
                    .alpha(0.5f)
                    .padding(top = 10.dp, start = 5.dp, end = 5.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
        }

    }
}

@Preview(showSystemUi = true)
@Composable
private fun MainScreenPreview() {
    val navController=rememberNavController()
    MainScreen(navController = navController)
}