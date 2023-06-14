package vero.practicaAndroidSuperpoderes.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import vero.practicaAndroidSuperpoderes.R


@Composable
fun MyLazyGrid() {
    val cells = GridCells.Fixed(4)

    val heros = listOf(
        "Goku", "Vegeta", "Satan", "Celula",
        "Goku", "Vegeta", "Satan", "Celula",
        "Goku", "Vegeta", "Satan", "Celula",
        "Goku", "Vegeta", "Satan", "Celula",
        "Goku", "Vegeta", "Satan", "Celula",
        "Goku", "Vegeta", "Satan", "Celula",
        "Goku", "Vegeta", "Satan", "Celula",
    )

    LazyVerticalGrid(columns = cells) {
        itemsIndexed(heros) { index, item ->
            Text("$item at $index")
        }
    }
}

@Composable
fun MyLazyGrid2() {
    val cells = GridCells.Adaptive(30.dp)

    val heros = listOf(
        "Goku", "Vegeta", "Satan", "Celula",
        "Goku", "Vegeta", "Satan", "Celula",
        "Goku", "Vegeta", "Satan", "Celula",
        "Goku", "Vegeta", "Satan", "Celula",
        "Goku", "Vegeta", "Satan", "Celula",
        "Goku", "Vegeta", "Satan", "Celula",
        "Goku", "Vegeta", "Satan", "Celula",
    )

    LazyVerticalGrid(columns = cells) {
        itemsIndexed(heros) { index, item ->
            Text("$item at $index")
        }
    }
}

@Composable
fun MyFlexibleGrid(isTablet: Boolean, isHorizontal: Boolean) {
    val heros = listOf(
        "Goku", "Vegeta", "Satan", "Celula",
        "Goku", "Vegeta", "Satan", "Celula",
        "Goku", "Vegeta", "Satan", "Celula",
        "Goku", "Vegeta", "Satan", "Celula",
        "Goku", "Vegeta", "Satan", "Celula",
        "Goku", "Vegeta", "Satan", "Celula",
        "Goku", "Vegeta", "Satan", "Celula",
    )
    val cells = if (isTablet) {
        if (isHorizontal) {
            GridCells.Adaptive(100.dp)
        } else {
            GridCells.Fixed(3)
        }
    } else {
        GridCells.Fixed(1)
    }

    LazyVerticalGrid(columns = cells) {
        items(heros) {
            Cell(hero = it)
        }
    }
}

@Preview(showBackground = true, widthDp = 720, heightDp = 360)
@Composable
fun MyFlexibleGrid_Tablet_Horizontal_Preview() {
    MyFlexibleGrid(true, true)
}

@Preview(showBackground = true, widthDp = 360, heightDp = 720)
@Composable
fun MyFlexibleGrid_Tablet_Vertical_Preview() {
    MyFlexibleGrid(true, false)
}

@Preview(showBackground = true)
@Composable
fun MyFlexibleGrid_Mobile_Preview() {
    MyFlexibleGrid(false, false)
}

@Composable
fun Cell(hero: String) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "logo")
        Text(text = hero)
    }
}
