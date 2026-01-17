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
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.jetpacknav3.ui.theme.JetpackNav3Theme
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
                        entryProvider = entryProvider {
                            entry<Home> {
                                Greeting(name = "Android", onClick = {
                                    backStack.add(Profile)
                                })
                            }
                            entry<Profile> {
                                Profile(onBack = {
                                    backStack.removeLastOrNull()
                                })
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


@Serializable
data object Profile : NavKey

@Composable
fun Profile(onBack: () -> Unit = {}, modifier: Modifier = Modifier) {
    return Column {
        Text(
            text = "Profile",
            modifier = modifier
        )
        Button(onClick = onBack) {
            Text(text = "Go Back")
        }
    }


}
