@file:OptIn(ExperimentalMaterial3Api::class)

package uz.turgunboyevjurabek.ishoraai.Presentation.UI_items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.turgunboyevjurabek.ishoraai.R

@Composable
fun MyCustomIconButton(modifier: Modifier = Modifier, onClick: () -> Unit,img:Painter) {
    Card(
        modifier = modifier
            .size(40.dp),
        shape = RoundedCornerShape(23.dp),
        border = BorderStroke(1.dp, colorResource(id = R.color.selected)),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.bac_color)
        ),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = img,
                contentDescription = null,
                modifier=modifier
                    .size(15.dp)
            )
        }
    }

}