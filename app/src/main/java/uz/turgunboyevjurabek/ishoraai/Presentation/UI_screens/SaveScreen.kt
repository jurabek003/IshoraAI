@file:OptIn(ExperimentalMaterial3Api::class)

package uz.turgunboyevjurabek.ishoraai.Presentation.UI_screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uz.turgunboyevjurabek.ishoraai.Data.SaveListItem
import uz.turgunboyevjurabek.ishoraai.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaveScreen(modifier: Modifier = Modifier,navHostController: NavHostController) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp)),
                
                title = {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Saqlangan imo-ishoralar orqali samarali aloqa qiling",
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_black)),
                    )
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
    ) {innerPadding->
        val list= ArrayList<SaveListItem>()
        list.addAll(listOf(
            SaveListItem(
                img = painterResource(id = R.drawable.save_img1),
                title = "Assalomu alaykum"
            ),
            SaveListItem(
                img = painterResource(id = R.drawable.save_img2),
                title = "Mening ismim Donaxon"
            ),
            SaveListItem(
                img = painterResource(id = R.drawable.save_img3),
                title = "Metro qayoqdaligini ko’rsata olasizmi"
            ),
        ))
        Column(
            modifier = modifier
                .padding(innerPadding)

        ) {
            LazyColumn(
                modifier=modifier
                    .fillMaxSize()
            ) {
                items(list.size){
                    SaveListUI(saveListItem = list[it])
                }
            }
        }

    }

}

@Composable
fun SaveListUI(saveListItem: SaveListItem) {
    Card(
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .padding(10.dp),
        shape =  RoundedCornerShape(20.dp) ,
        elevation = CardDefaults.elevatedCardElevation(5.dp),
        border = BorderStroke(2.dp, colorResource(id = R.color.selected)),
        colors = CardDefaults.cardColors(
            containerColor = if (!isSystemInDarkTheme()){
                Color.White
            }else{
                MaterialTheme.colorScheme.surfaceColorAtElevation(20.dp)
            }
        ),
        onClick = {}
    ){
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = saveListItem.img,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.3f)
            )
            Text(
                text = saveListItem.title,
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.nunito_medium)),
                fontWeight = FontWeight.Bold,
                maxLines = 3,
                lineHeight = TextUnit(20f, TextUnitType.Sp),
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .padding(start = 10.dp)
            )

        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun SaveScreenPreview() {
    val navController= rememberNavController()
    SaveScreen(navHostController = navController)
}