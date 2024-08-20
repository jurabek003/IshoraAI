@file:OptIn(ExperimentalMaterial3Api::class)

package uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.ProfileUIItem

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.MyCustomIconButton
import uz.turgunboyevjurabek.ishoraai.R

@Composable
fun FondPart(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 35.dp)
            .height(80.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Absolute.SpaceBetween,
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                modifier = modifier
                    .size(40.dp),
                shape = RoundedCornerShape(23.dp),
                border = BorderStroke(1.dp, colorResource(id = R.color.selected)),
                colors = CardDefaults.cardColors(
                    containerColor = colorResource(id = R.color.bac_color)
                ),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize(),
                   horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.a_img),
                        contentDescription = null,
                        modifier=modifier
                            .size(14.dp)
                    )
                    Spacer(modifier = modifier.width(2.dp))
                    Image(
                        painter = painterResource(id = R.drawable.a_img),
                        contentDescription = null,
                        modifier=modifier
                            .size(9.dp)
                    )
                }
            }
            Spacer(modifier = modifier
                .fillMaxHeight()
                .width(10.dp)
            )
            Text(
                text = "Font o’lchami",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.nunito_medium)),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .width(150.dp),
            )
        }
        Text(
            text = "16",
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.nunito_medium)),
            color = colorResource(id = R.color.unselected)
        )
        ClickPartItemUI(onClick = { })
    }
}

@Preview
@Composable
private fun FondUI() {
    FondPart()

}