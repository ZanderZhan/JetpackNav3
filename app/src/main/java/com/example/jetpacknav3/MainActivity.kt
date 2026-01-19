package com.example.jetpacknav3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.jetpacknav3.models.AppNavBackStack
import com.example.jetpacknav3.screen.FlowerDetail
import com.example.jetpacknav3.screen.FlowerDetailScreen
import com.example.jetpacknav3.screen.FlowerList
import com.example.jetpacknav3.screen.FlowerListScreen
import com.example.jetpacknav3.screen.Home
import com.example.jetpacknav3.screen.HomeScreen
import com.example.jetpacknav3.scene.ListDetailSceneStrategy
import com.example.jetpacknav3.screen.flowers
import com.example.jetpacknav3.screen.AddFlower
import com.example.jetpacknav3.screen.AddFlowerScreen
import com.example.jetpacknav3.screen.Edit
import com.example.jetpacknav3.screen.EditScreen
import com.example.jetpacknav3.screen.Profile
import com.example.jetpacknav3.screen.ProfileScreen
import com.example.jetpacknav3.ui.theme.JetpackNav3Theme
import com.example.jetpacknav3.viewmodel.ProfileViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackNav3Theme {
                val appBackStack = remember { AppNavBackStack() }

                Scaffold(modifier = Modifier.fillMaxSize(), bottomBar = {
                    NavigationBar {
                        appBackStack.TOP_LEVEL_ROUTE.forEach { route ->
                            val selected = route == appBackStack.selected

                            NavigationBarItem(
                                selected = selected,
                                onClick = {
                                    appBackStack.selectedTopRoute(route)
                                },
                                label = {
                                    Text(text = route.name)
                                },
                                icon = {
                                    Icon(
                                        imageVector = route.icon,
                                        contentDescription = route.name
                                    )
                                }
                            )
                        }
                    }
                }) { innerPadding ->
                    val backStack = appBackStack.currentRoute

                    val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass

                    NavDisplay(
                        modifier = Modifier.padding(innerPadding),
                        backStack = backStack,
                        sceneStrategy = ListDetailSceneStrategy(windowSizeClass),
                        entryDecorators = listOf(
                            rememberSaveableStateHolderNavEntryDecorator(),
                            rememberViewModelStoreNavEntryDecorator()
                        ),
                        entryProvider = entryProvider {
                            entry<Home> {
                                HomeScreen(name = "Android")
                            }
                            entry<Profile> {
                                val viewModel: ProfileViewModel = viewModel()
                                ProfileScreen(
                                    onClickNext = {
                                        appBackStack.add(Edit)
                                    },
                                    onBack = {
                                        appBackStack.removeLastOrNull()
                                    },
                                    viewModel = viewModel
                                )
                            }
                            entry<Edit> {
                                EditScreen()
                            }
                            entry<FlowerList>(
                                metadata = ListDetailSceneStrategy.ListDetail
                            ) { navKey ->
                                FlowerListScreen(flowers, onItemClick = { flower ->
                                    if (appBackStack.lastOrNull() is FlowerDetail) {
                                        appBackStack.removeLastOrNull()
                                    }
                                    // Handle item click here
                                    val detail = flowers.first { it.name == flower }
                                    appBackStack.add(FlowerDetail(detail))
                                }, onAddFlower = {
                                    appBackStack.add(AddFlower)
                                })
                            }
                            entry<FlowerDetail>(
                                metadata = ListDetailSceneStrategy.ListDetail
                            ) { detail ->
                                FlowerDetailScreen(detail.flower)
                            }
                            entry<AddFlower> {
                                ModalBottomSheet(
                                    onDismissRequest = {
                                        appBackStack.removeLastOrNull()
                                    },
                                ) {
                                    AddFlowerScreen { flower ->
                                        flowers.add(flower)
                                    }
                                }
                            }
                        }
                    )
                }
            }
        }
    }
}
