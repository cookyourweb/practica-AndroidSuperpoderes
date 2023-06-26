package vero.practicaAndroidSuperpoderes.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import vero.practicaAndroidSuperpoderes.domain.model.MarvelSerie


@Preview(showBackground = true)
@Composable
fun DetailGrid(series: List<MarvelSerie> = emptyList(), comics: List<MarvelSerie> = emptyList()) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier = Modifier.fillMaxSize()
    ) {
        item(span = { GridItemSpan(2) }) {
            Title(text = "Series")
        }

        items(series) { serie ->
            ItemSerie(serie.title, serie.photo)
        }

        item(span = { GridItemSpan(2) }) {
            Title(text = "Comics")
        }

        items(comics) { comic ->
            ItemSerie(comic.title, comic.photo)
        }

    }
}

@Composable
fun Title(text: String) {
    Text(
        text,
        style = MaterialTheme.typography.h5,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(5.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun ItemSerie(
    title: String = "Deadpool (1997 - 2002)",
    photo: String = "http://i.annihil.us/u/prod/marvel/i/mg/3/60/4c606835416be/landscape_xlarge.jpg"
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.End,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(Color.DarkGray)
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = photo),
            contentDescription = "Image  Serie",
            modifier = Modifier
                .fillMaxWidth()
                .size(200.dp)
                .padding(5.dp, 5.dp),

        )
        Text(
            text = title,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(),


            style = MaterialTheme.typography.h6.copy(fontSize = 20.sp)
        )
    }
}