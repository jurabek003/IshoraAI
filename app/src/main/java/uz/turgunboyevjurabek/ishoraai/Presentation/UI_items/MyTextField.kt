package uz.turgunboyevjurabek.ishoraai.Presentation.UI_items

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.unit.dp
import uz.turgunboyevjurabek.ishoraai.R

@Composable
fun MyTextField(
    modifier: Modifier = Modifier,
    value: String,
    placeholder: String,
    onValueChange: (String) -> Unit
) {

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 22.dp)
            .border(
                BorderStroke(
                    2.dp,
                    colorResource(id = R.color.selected)
                ), // Border qalinligi va rangi
                RoundedCornerShape(12.dp)
            ) ,
        value =value,
        onValueChange =onValueChange,
        placeholder = {
            Text(text = placeholder)
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent
        )
    )

}