package uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.ProfileUIItem

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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.turgunboyevjurabek.ishoraai.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClickPartItemUI(modifier: Modifier = Modifier,onClick: () -> Unit) {

    Card(
        modifier = modifier
            .size(22.dp),
        shape = RoundedCornerShape(5.dp),
        onClick = onClick
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.click_ic),
                contentDescription = null,
//                modifier=modifier
//                    .size(15.dp)
            )
        }
    }

}

@Preview
@Composable
private fun ClickPartUI() {
//ClickPartItemUI ()
}