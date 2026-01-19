package com.example.jetpacknav3.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation3.runtime.NavKey
import com.example.jetpacknav3.screen.FlowerList
import com.example.jetpacknav3.screen.Home
import com.example.jetpacknav3.screen.Profile

abstract class BaseMainRoute(val name: String, val icon: ImageVector)

data object THome : BaseMainRoute("Home", Icons.Default.Home)
data object TFlower : BaseMainRoute("Flower", Icons.Default.Favorite)
data object TProfile : BaseMainRoute("Profile", Icons.Default.AccountBox)

class AppNavBackStack {

    val TOP_LEVEL_ROUTE = listOf(THome, TFlower, TProfile)

    private val routes = mapOf(
        THome to mutableStateListOf<NavKey>(Home),
        TFlower to mutableStateListOf<NavKey>(FlowerList),
        TProfile to mutableStateListOf<NavKey>(Profile)
    )

    var selected by mutableStateOf<BaseMainRoute>(THome)
        private set

    val currentRoute: SnapshotStateList<NavKey>
        get() = routes[selected]!!

    fun selectedTopRoute(route: BaseMainRoute) {
        selected = route
    }

    fun add(route: NavKey) {
        currentRoute.add(route)
    }

    fun removeLastOrNull() {
        if (currentRoute.size > 1) {
            currentRoute.removeAt(currentRoute.lastIndex)
        }
    }

    fun lastOrNull(): NavKey? {
        return currentRoute.lastOrNull()
    }
}
