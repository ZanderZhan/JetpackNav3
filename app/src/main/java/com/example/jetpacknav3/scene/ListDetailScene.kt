package com.example.jetpacknav3.scene

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.scene.Scene


class ListDetailScene<T: Any>(
    override val key: Any,
    override val entries: List<NavEntry<T>>,
    override val previousEntries: List<NavEntry<T>>
): Scene<T> {

    override val content: @Composable (() -> Unit) = {
        val navEntries = entries.takeLast(2)
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.fillMaxWidth(0.3f)) {
                navEntries.first().Content()
            }
            Column(modifier = Modifier.fillMaxWidth()) {
                navEntries.last().Content()
            }
        }
    }

}