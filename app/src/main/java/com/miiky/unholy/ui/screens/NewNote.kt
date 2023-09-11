package com.miiky.unholy.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FormatAlignCenter
import androidx.compose.material.icons.rounded.FormatAlignJustify
import androidx.compose.material.icons.rounded.FormatAlignLeft
import androidx.compose.material.icons.rounded.FormatAlignRight
import androidx.compose.material.icons.rounded.Save
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.miiky.unholy.R

@Composable
fun NewNote(
    modifier: Modifier = Modifier
) {
    val title = remember {
        mutableStateOf("")
    }
    val content = remember {
        mutableStateOf("")
    }
    val textAlignOptions = listOf(
        TextAlignOption(Icons.Rounded.FormatAlignLeft, TextAlign.Start),
        TextAlignOption(Icons.Rounded.FormatAlignCenter, TextAlign.Center),
        TextAlignOption(Icons.Rounded.FormatAlignRight, TextAlign.End),
        TextAlignOption(Icons.Rounded.FormatAlignJustify, TextAlign.Justify)
    )

    val colorOptions = listOf(
        MaterialTheme.colorScheme.primary,
        MaterialTheme.colorScheme.secondary,
        MaterialTheme.colorScheme.tertiary,
        MaterialTheme.colorScheme.primaryContainer,
        MaterialTheme.colorScheme.secondaryContainer,
        MaterialTheme.colorScheme.tertiaryContainer,
        MaterialTheme.colorScheme.error,
        MaterialTheme.colorScheme.errorContainer
    )

    val (selectedTextAlign, onSelectedTextAlign) = remember { mutableStateOf(textAlignOptions[0]) }

    val (selectedColor, onSelectedColor) = remember { mutableStateOf(colorOptions[0]) }

    // UI
    Column(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        OutlinedTextField(
            value = title.value,
            onValueChange = { title.value = it },
            label = { Text(text = stringResource(id = R.string.title)) },
            modifier = modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )
//        OutlinedTextField(
//            value = content.value,
//            onValueChange = { content.value = it },
//            label = { Text(text = stringResource(id = R.string.content)) },
//            modifier = modifier
//                .padding(bottom = 16.dp)
//                .fillMaxWidth(),
//            textStyle = LocalTextStyle.current.copy(textAlign = selectedTextAlign.textAlign)
//        )
        Box(
            modifier = modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        ) {
            BasicTextField(
                value = content.value,
                onValueChange = { content.value = it },
                modifier = modifier
                    .fillMaxWidth(),
                textStyle = LocalTextStyle.current.copy(
                    textAlign = selectedTextAlign.textAlign,
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
            if (content.value.isEmpty()) {
                Text(
                    text = stringResource(id = R.string.content),
                    style = LocalTextStyle.current.copy(
                        color = MaterialTheme.colorScheme.onSurface.copy(
                            alpha = 0.5f
                        )
                    )
                )
            }
        }
        Row {
            textAlignOptions.forEach {
                FilledTonalButton(
                    onClick = {
                        onSelectedTextAlign(it)
                    },
                    modifier = modifier,
                    shape = when (it) {
                        textAlignOptions[0] -> RoundedCornerShape(
                            topStart = 10.dp,
                            bottomStart = 10.dp,
                            topEnd = 0.dp,
                            bottomEnd = 0.dp
                        )

                        textAlignOptions[textAlignOptions.lastIndex] -> RoundedCornerShape(
                            topStart = 0.dp,
                            bottomStart = 0.dp,
                            topEnd = 10.dp,
                            bottomEnd = 10.dp
                        )

                        else -> RoundedCornerShape(
                            topStart = 0.dp,
                            bottomStart = 0.dp,
                            topEnd = 0.dp,
                            bottomEnd = 0.dp
                        )
                    },
                    colors = ButtonDefaults.buttonColors(
                        if (it == selectedTextAlign) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.secondary
                    )
                ) {
                    Icon(
                        imageVector = it.icon,
                        contentDescription = it.textAlign.toString(),
                    )
                }
            }
        }
        Row {
            colorOptions.forEach {
                FilledTonalIconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.iconButtonColors(it)
                ) {

                }
            }
        }
        Button(
            onClick = { /*TODO*/ },
        ) {
            Icon(Icons.Rounded.Save, contentDescription = null)
            Text(text = stringResource(id = R.string.save))
        }
    }
}

data class TextAlignOption(
    val icon: ImageVector,
    val textAlign: TextAlign
)