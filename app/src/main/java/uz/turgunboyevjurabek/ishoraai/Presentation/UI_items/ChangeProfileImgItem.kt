@file:OptIn(ExperimentalMaterial3Api::class)

package uz.turgunboyevjurabek.ishoraai.Presentation.UI_items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.turgunboyevjurabek.ishoraai.R

@Composable
fun ChangeProfileImgItem(modifier: Modifier = Modifier) {

    Box(
        modifier = modifier
            .size(120.dp),
        contentAlignment = Alignment.BottomEnd,
        ){
        Image(
            painter = painterResource(id = R.drawable.donoxon_img),
            contentDescription = null,
            modifier = modifier
                .clip(CircleShape),
        )
        Card(
            modifier = modifier
                .size(35.dp)
                .padding(5.dp),
            shape = RoundedCornerShape(23.dp),
            border = BorderStroke(1.dp, colorResource(id = R.color.selected)),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.bac_color)
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_camera),
                    contentDescription = null,
                    modifier=Modifier
                        .size(12.dp)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ChangeProfileImgItemUI() {
    ChangeProfileImgItem()
}