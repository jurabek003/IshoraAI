package uz.turgunboyevjurabek.ishoraai.Presentation.UI_items.EditProfileItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.turgunboyevjurabek.ishoraai.R

@Composable
fun EmailTextField(modifier: Modifier = Modifier, value: String, icon: Painter?) {

    val textState = remember { mutableStateOf(value) }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        shape = RoundedCornerShape(12.dp),
        shadowElevation = 6.dp
    ) {
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            modifier = modifier
                .fillMaxWidth()
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(12.dp)
                ),
            shape = RoundedCornerShape(12.dp),
            singleLine = true,
            trailingIcon = {
                if (icon != null){
                    IconButton(onClick = {}) {
                        Image(
                            painter =   icon,
                            contentDescription = "Check",
                            modifier=modifier
                                .size(20.dp)
                        )
                    }
                }
            },
            textStyle = TextStyle(
                fontSize = 18.sp,
                textDecoration = TextDecoration.Underline
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                disabledContainerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
        )
    }
}