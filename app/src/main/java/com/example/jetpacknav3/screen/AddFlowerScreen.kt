package com.example.jetpacknav3.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data object AddFlower : NavKey

@Composable
fun AddFlowerScreen(onAddFlower: (Flower) -> Unit) {
    var name by remember { mutableStateOf("") }
    var pic by remember { mutableStateOf("") }
    var detail by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Flower Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = pic,
            onValueChange = { pic = it },
            label = { Text("Picture URL") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = detail,
            onValueChange = { detail = it },
            label = { Text("Detail") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { onAddFlower(Flower(name, pic, detail)) },
            modifier = Modifier.fillMaxWidth(),
            enabled = name.isNotBlank() && pic.isNotBlank() && detail.isNotBlank()
        ) {
            Text("Add Flower")
        }
    }
}
