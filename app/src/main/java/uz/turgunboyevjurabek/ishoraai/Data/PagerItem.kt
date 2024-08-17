package uz.turgunboyevjurabek.ishoraai.Data

import androidx.compose.ui.graphics.painter.Painter

data class PagerItem(
    val image: Painter,
    val name: String,
    val about: String
)