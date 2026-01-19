package com.example.jetpacknav3.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation3.runtime.NavKey
import com.example.jetpacknav3.ui.theme.JetpackNav3Theme
import kotlinx.serialization.Serializable


@Serializable
data object Home : NavKey

@Composable
fun HomeScreen(name: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Hello $name!",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    JetpackNav3Theme {
        HomeScreen("Android")
    }
}