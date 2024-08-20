package uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.ProfileUIItem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
fun LanguagePart(modifier: Modifier = Modifier) {
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
            MyCustomIconButton(
                onClick = { },
                img = painterResource(id = R.drawable.ic_language)
            )
            Spacer(modifier = modifier
                .fillMaxHeight()
                .width(10.dp)
            )
            Text(
                text = "Tilni o’zgartirish",
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.nunito_medium)),
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Bold,
                modifier = modifier
                    .width(150.dp),
            )
        }
        Text(
            text = "O'zbek",
            fontSize = 14.sp,
            fontFamily = FontFamily(Font(R.font.nunito_medium)),
            color = colorResource(id = R.color.unselected)
        )
        ClickPartItemUI(onClick = { })
    }
}

@Preview
@Composable
private fun LanguageUI() {
    LanguagePart()
}