package com.example.jetpacknav3.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import com.example.jetpacknav3.viewmodel.ProfileViewModel
import kotlinx.serialization.Serializable

@Serializable
data object Profile : NavKey

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel,
    onClickNext: () -> Unit,
    onBack: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    val name by viewModel.name.observeAsState("")

    Column {
        Text(
            text = "Hello: $name",
            modifier = modifier
        )
        Button(onClick = { viewModel.changeName("Zander") }) {
            Text(text = "Change Name to Zander")
        }
        Button(onClick = onClickNext) {
            Text(text = "Go To Edit Screen")
        }
        Button(onClick = onBack) {
            Text(text = "Go Back")
        }
    }
}
