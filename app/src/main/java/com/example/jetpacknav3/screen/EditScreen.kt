package com.example.jetpacknav3.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object Edit : NavKey

@Composable
fun EditScreen(modifier: Modifier = Modifier) {
    Text(text = "Edit Screen", modifier = modifier)
}