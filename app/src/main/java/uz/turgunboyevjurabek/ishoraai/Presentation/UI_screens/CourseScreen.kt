@file:OptIn(ExperimentalMaterial3Api::class)

package uz.turgunboyevjurabek.ishoraai.Presentation.UI_screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import uz.turgunboyevjurabek.ishoraai.Data.CourseLists
import uz.turgunboyevjurabek.ishoraai.R

@Composable
fun CourseScreen(modifier: Modifier = Modifier,navHostController: NavHostController) {
    Scaffold(
        modifier = modifier
            .fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomEnd = 25.dp, bottomStart = 25.dp)),

                title = {
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Bilimingizni oshirish uchun bepul kurslarni taqdim qilamiz",
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
        val list= ArrayList<CourseLists>()
        list.addAll(listOf(
            CourseLists(
                img = painterResource(id = R.drawable.course_img1),
                title = "Lorem ipsum",
                about = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem."
            ),
   CourseLists(
                img = painterResource(id = R.drawable.course_img1),
                title = "Lorem ipsum",
                about = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem."
            ),
   CourseLists(
                img = painterResource(id = R.drawable.course_img1),
                title = "Lorem ipsum",
                about = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem."
            ),
   CourseLists(
                img = painterResource(id = R.drawable.course_img1),
                title = "Lorem ipsum",
                about = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem."
            ),
   CourseLists(
                img = painterResource(id = R.drawable.course_img1),
                title = "Lorem ipsum",
                about = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem."
            ),
   CourseLists(
                img = painterResource(id = R.drawable.course_img1),
                title = "Lorem ipsum",
                about = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem."
            ),
   CourseLists(
                img = painterResource(id = R.drawable.course_img1),
                title = "Lorem ipsum",
                about = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem."
            ),
   CourseLists(
                img = painterResource(id = R.drawable.course_img1),
                title = "Lorem ipsum",
                about = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem."
            ),
   CourseLists(
                img = painterResource(id = R.drawable.course_img1),
                title = "Lorem ipsum",
                about = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem."
            ),
   CourseLists(
                img = painterResource(id = R.drawable.course_img1),
                title = "Lorem ipsum",
                about = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem."
            ),
   CourseLists(
                img = painterResource(id = R.drawable.course_img1),
                title = "Lorem ipsum",
                about = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem."
            ),
   CourseLists(
                img = painterResource(id = R.drawable.course_img1),
                title = "Lorem ipsum",
                about = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem."
            ),
   CourseLists(
                img = painterResource(id = R.drawable.course_img1),
                title = "Lorem ipsum",
                about = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem."
            ),
   CourseLists(
                img = painterResource(id = R.drawable.course_img1),
                title = "Lorem ipsum",
                about = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Maecenas porttitor congue massa. Fusce posuere, magna sed pulvinar ultricies, purus lectus malesuada libero, sit amet commodo magna eros quis urna. Nunc viverra imperdiet enim. Fusce est. Vivamus a tellus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Proin pharetra nonummy pede. Mauris et orci. Aenean nec lorem."
            ),

        ))
        Column(
            modifier = modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier=modifier
                    .fillMaxSize()
            ) {
                items(list.size){it->
                    ListCourseUI(courseLists = list[it], id = it)
                }
            }
        }
    }
}

@Composable
fun ListCourseUI(courseLists: CourseLists,id:Int) {
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
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (id%2==0){
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .fillMaxHeight()
                        .padding(start = 17.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = courseLists.title,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_black))
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = courseLists.about,
                        fontSize = 12.sp,
                        maxLines = 2,
                        lineHeight = TextUnit(15f, TextUnitType.Sp),
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = FontFamily(Font(R.font.nunito_medium)),
                    )

                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = courseLists.img,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(110.dp)
                            .height(80.dp)
                            .clip(RoundedCornerShape(5.dp))
                    )
                }

            }else{
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.5f)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = courseLists.img,
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .width(110.dp)
                            .height(80.dp)
                            .clip(RoundedCornerShape(5.dp))
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .padding(start = 17.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = courseLists.title,
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.nunito_black))
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = courseLists.about,
                        fontSize = 12.sp,
                        maxLines = 2,
                        lineHeight = TextUnit(15f, TextUnitType.Sp),
                        overflow = TextOverflow.Ellipsis,
                        fontFamily = FontFamily(Font(R.font.nunito_medium)),
                    )

                }
            }

        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun CourseScreenPreview() {
    val navController= rememberNavController()
    CourseScreen(navHostController = navController)
}
