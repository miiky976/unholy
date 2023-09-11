package com.miiky.unholy.ui.components

import android.provider.MediaStore.Images
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.miiky.unholy.models.Note

@Composable
fun NoteCard(
    note : Note,
    modifier : Modifier = Modifier
) {
    ElevatedCard (
        colors = CardDefaults.cardColors(note.color),
        modifier = modifier
            .fillMaxWidth()
            .animateContentSize()
    ) {
        Box(modifier = modifier
            .fillMaxSize()
        ){
            Column(
                modifier = modifier
                    .padding(16.dp)
            ) {
                Text(text = note.title , style = MaterialTheme.typography.titleLarge)
                Text(text = note.content , style = MaterialTheme.typography.bodyMedium, textAlign = TextAlign.Justify)
            }
        }
    }
}