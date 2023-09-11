package com.miiky.unholy.models

import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

data class Note(
    var id : Int,
    var title : String,
    var content : String,
    var date : String,
    var color : Color,
    var expanded : Boolean = false,
    var justify : TextAlign = TextAlign.Start
)