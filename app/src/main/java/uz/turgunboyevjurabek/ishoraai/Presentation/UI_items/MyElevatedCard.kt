@file:OptIn(ExperimentalMaterial3Api::class)

package uz.turgunboyevjurabek.ishoraai.Presentation.UI_items

import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import uz.turgunboyevjurabek.ishoraai.R

@Composable
fun MyElevatedCard(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    img:Painter
) {
    ElevatedCard(
        elevation = CardDefaults.elevatedCardElevation(
            defaultElevation = 3.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = if(!isSystemInDarkTheme()){
                Color.White
            }else MaterialTheme.colorScheme.surfaceColorAtElevation(3.dp)
        ),
        onClick = onClick,
        modifier = modifier
            .width(81.dp)
            .height(43.dp)
    ) {
        Image(
            painter = img,
            contentDescription = null,
            modifier= modifier
                .size(34.dp)
                .align(Alignment.CenterHorizontally)
        )
    }


}