@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)

package uz.turgunboyevjurabek.ishoraai.Presentation.UI_screens.Auth

import androidx.compose.animation.core.spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.launch
import uz.turgunboyevjurabek.ishoraai.Data.PagerItem
import uz.turgunboyevjurabek.ishoraai.R

@Composable
fun Page1Screen(navController: NavController) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .height(70.dp)
                    .clip(RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp)),
                title = {
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    actionIconContentColor = colorResource(id = R.color.selected),
                    containerColor = if(!isSystemInDarkTheme()){
                     Color.White
                    }else{
                        MaterialTheme.colorScheme.surfaceColorAtElevation(20.dp)
                    }
                ),
                actions = {
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(0.2f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        IconButton(
                            onClick = {
                                navController.navigate("LoginScreen")
                            },
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_cancel),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(27.dp)
                            )
                        }
                    }

                }
            )
        }

    ) { innerPadding ->
        val pages = listOf(
            PagerItem(painterResource(id = R.drawable.girl),"Assalomu alaykum","Bu IshorAi imo-ishora tarjimon dasturi va men sizning vertual yordamchingiz Ishoraoyman"),
            PagerItem(painterResource(id = R.drawable.girl),"Ilova haqida qisqacha","Markaziy Osiyoda yagona bo’lgan, IshorAi ilovasi sun’iy intellekt orqali imo ishora tilini tushinish va nutqni imo ishora tiliga o’tkazish uchun yordam beradi. Hozirchi RIT(rus imo ishora tili)ni qo’llab quvvatlaydi"),
            PagerItem(painterResource(id = R.drawable.girl),"Ilova qanday ishlaydi","Sun’iy intellekt nutqni imo ishora tiliga aylantiradi. Imo ishora harakatlarini kamera orqali o’qib olib uni matn yoki ovoz ko’rinishida sizga taqdim qiladi. "),
        )

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
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {page ->
               Column(
                   horizontalAlignment = Alignment.CenterHorizontally,
                   verticalArrangement = Arrangement.spacedBy(10.dp)
               ) {
                   Image(
                       painter = pages[page].image,
                       contentDescription = null,
                       modifier = Modifier
                           .fillMaxWidth()
                           .height(380.dp),
                   )
                   Text(
                       text = pages[page].name,
                       fontSize = 18.sp,
                       onTextLayout = {},
                       color = colorResource(id = R.color.selected)
                   )
                   Divider(color = colorResource(id = R.color.selected), thickness = 2.dp)
                   Text(
                       text = pages[page].about,
                       fontSize = 15.sp,
                       onTextLayout = {},
                       color = colorResource(id = R.color.unselected),
                       modifier = Modifier
                           .padding(horizontal = 20.dp)
                           .height(400.dp)
                   )
               }
            }
            /**
             * Button va tab qismi
             */
            Row(
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .weight(0.2f)
                    .padding(top = 40.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Top
            ){
                var count=pagerState.currentPage

                if (pagerState.currentPage!=0){
                    Button(
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(
                                    count - 1,
                                    0.0f,
                                    animationSpec = spring(
                                        dampingRatio = 0.5f,
                                        stiffness = 100f
                                    )
                                )
                            }
                        },
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                            .wrapContentSize(),
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                        Text(text = "Ortga",onTextLayout = {},)
                    }
                }else{
                    Spacer(
                        modifier = Modifier
                            .width(130.dp)
                    )
                }

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
                    ) {
                    }
                }

                Button(
                    onClick = {
                        if (pagerState.currentPage==2){
                            navController.navigate("LoginScreen")
                            return@Button
                        }
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(
                                count + 1,
                                0.0f,
                                animationSpec = spring(
                                    dampingRatio = 0.5f,
                                    stiffness = 100f
                                )
                            )
                        }

                    },
                    modifier = Modifier
                        .padding(horizontal = 8.dp)
                        .width(130.dp)
                ) {
                    Text(text = "Oldinga",onTextLayout = {},)
                    Icon(imageVector = Icons.Default.ArrowForward, contentDescription = null)
                }
            }


        }


    }

}

@Preview(showSystemUi = true)
@Composable
private fun Page1ScreenUI() {
    val navController = rememberNavController()
    Page1Screen(navController)

}