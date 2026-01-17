package com.example.jetpacknav3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSaveableStateHolderNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import com.example.jetpacknav3.screen.Edit
import com.example.jetpacknav3.screen.EditScreen
import com.example.jetpacknav3.screen.Profile
import com.example.jetpacknav3.screen.ProfileScreen
import com.example.jetpacknav3.ui.theme.JetpackNav3Theme
import com.example.jetpacknav3.viewmodel.ProfileViewModel
import kotlinx.serialization.Serializable


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackNav3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val backStack = rememberNavBackStack(Home)

                    NavDisplay(
                        modifier = Modifier.padding(innerPadding),
                        backStack = backStack,
                        entryDecorators = listOf(
                            rememberSaveableStateHolderNavEntryDecorator(),
                            rememberViewModelStoreNavEntryDecorator()
                        ),
                        entryProvider = entryProvider {
                            entry<Home> {
                                Greeting(name = "Android", onClick = {
                                    backStack.add(Profile)
                                })
                            }
                            entry<Profile> {
                                val viewModel: ProfileViewModel = viewModel()
                                ProfileScreen(
                                    onClickNext = {
                                        backStack.add(Edit)
                                    },
                                    onBack = {
                                        backStack.removeLastOrNull()
                                    },
                                    viewModel = viewModel)
                            }
                            entry<Edit> {
                                EditScreen()
                            }
                        }
                    )
                }
            }
        }
    }
}


@Serializable
data object Home : NavKey

@Composable
fun Greeting(name: String, onClick: () -> Unit = {}, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = "Hello $name!",
        )
        Button(onClick = onClick) {
            Text(text = "Go To Profile")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackNav3Theme {
        Greeting("Android")
    }
}
