package com.example.jetpacknav3.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
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
fun HomeScreen(name: String, onClick: () -> Unit = {}, onGotoFlowerList: () -> Unit = {}, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Hello $name!",
        )
        Button(onClick = onClick) {
            Text(text = "Go To Profile")
        }
        Button(onClick = onGotoFlowerList) {
            Text(text = "Go To Flower List")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    JetpackNav3Theme {
        HomeScreen("Android")
    }
}