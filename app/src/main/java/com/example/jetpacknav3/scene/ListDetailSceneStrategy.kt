package com.example.jetpacknav3.scene

import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.scene.Scene
import androidx.navigation3.scene.SceneStrategy
import androidx.navigation3.scene.SceneStrategyScope
import androidx.window.core.layout.WindowSizeClass

class ListDetailSceneStrategy<T: Any>(var windowSizeClass: WindowSizeClass) : SceneStrategy<T> {

    override fun SceneStrategyScope<T>.calculateScene(entries: List<NavEntry<T>>): Scene<T>? {

        if (!windowSizeClass.isWidthAtLeastBreakpoint(WindowSizeClass.WIDTH_DP_MEDIUM_LOWER_BOUND)) return null

        val sceneEntries = entries.takeLast(2)
        if (sceneEntries.size != 2) return null

        val detailEntry = sceneEntries[1]
        val listEntry = sceneEntries[0]

        if (listEntry.metadata[ListDetailKey] != true) return null
        if (detailEntry.metadata[ListDetailKey] != true) return null

        return ListDetailScene(
            key = listEntry.contentKey,
            entries = sceneEntries,
            previousEntries = entries.dropLast(2),
        )
    }

    companion object {

        val ListDetailKey = "List_Detail"

        val ListDetail = mapOf(ListDetailKey to true)
    }


}