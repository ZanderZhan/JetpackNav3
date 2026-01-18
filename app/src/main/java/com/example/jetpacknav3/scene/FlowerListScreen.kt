package com.example.jetpacknav3.scene

import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
data class Flower(val name: String, val pic: String, val detail: String)

var flowers = mutableListOf(
    Flower(
        "Rose",
        "https://images.pexels.com/photos/56866/garden-rose-red-pink-56866.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        "Roses are a group of herbaceous shrubs in the family Rosaceae. There are over three hundred species and tens of thousands of cultivars. They are widely used for perfumes and as ornamental crops."
    ),
    Flower(
        "Tulip",
        "https://images.pexels.com/photos/1075960/pexels-photo-1075960.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        "Tulips are a genus of spring-blooming perennial herbaceous geophytes. The flowers are usually large, showy and brightly colored, generally red, pink, yellow, or white."
    ),
    Flower(
        "Lily",
        "https://images.pexels.com/photos/673857/pexels-photo-673857.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        "Lilies are a group of flowering plants which are important in culture and literature in much of the world. They grow from bulbs and are known for their large, prominent flowers."
    ),
    Flower(
        "Sunflower",
        "https://images.pexels.com/photos/46216/sunflower-flowers-bright-yellow-46216.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=1",
        "Helianthus annuus, the common sunflower, is a large annual forb of the genus Helianthus. It is grown as a crop for its edible oil and edible fruits. It is also used as wild bird food, as livestock forage."
    ),
    Flower(
        "Daisy",
        "https://westmountflorist.com/cdn/shop/articles/freya-ingva-6P9JgFe3f9Q-unsplash.jpg?v=1725909146&width=2048",
        "The common daisy (Bellis perennis) is a perennial herbaceous plant with short creeping rhizomes and small rounded evergreen leaves. The flowerhead is a composite flower."
    )
)

@Serializable
data object FlowerList : NavKey

@Composable
fun FlowerListScreen(flowers: List<Flower>, onItemClick : (String) -> Unit, onAddFlower: () -> Unit, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(flowers) { flower ->
            Text(text = flower.name, modifier = Modifier.clickable(){
                onItemClick(flower.name)
            })
        }
        item {
            Button(onClick = onAddFlower) {
                Text(text = "Add another Flower")
            }
        }
    }
}
