package uz.turgunboyevjurabek.ishoraai.Domein

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter

data class BottomNavigationItem (
    val title: String,
    val icon:Painter,
    val selectedColor: Color,
    val unselectedColor:Color,
    val screenRout:String,
    val badgeCount:Int
)
