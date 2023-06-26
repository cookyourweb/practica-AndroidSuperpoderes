package vero.practicaAndroidSuperpoderes.ui.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import vero.practicaAndroidSuperpoderes.R
import vero.practicaAndroidSuperpoderes.domain.model.MarvelCharacter

val charactersDummyList = listOf(
    MarvelCharacter(
        "id",
        "3-D Man",
        "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784/landscape_xlarge.jpg"
    ),
    MarvelCharacter(
        "1017100",
        "A-Bomb (HAS)",
        "http://i.annihil.us/u/prod/marvel/i/mg/3/20/5232158de5b16"
    )
)

@Preview(showBackground = true)
@Composable
fun CharactersListScreen(characters: List<MarvelCharacter> = charactersDummyList, setFavorite:(MarvelCharacter)->Unit= {}, goDetail: (String, String) -> Unit = { _, _->}) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier = Modifier.fillMaxSize()
    ) {
        items(characters) { character ->
            ItemCharacter(character.name, character.photo, character.isFavorite,{ favorite ->
                setFavorite(MarvelCharacter(character.id,character.name, character.photo, favorite))
            }){
                goDetail(character.id, character.name)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ItemCharacter(
    hero: String = "3-D Man",
    photo: String = "http://i.annihil.us/u/prod/marvel/i/mg/c/e0/535fecbbb9784/landscape_xlarge.jpg",
    isFavorite: Boolean = false,
    setFavorite: (Boolean) -> Unit = {},
    goDetail: () -> Unit = {}
) {

    Card(
        modifier = Modifier
            .fillMaxSize()
            .background(if (isFavorite) Color.Magenta else Color.Gray)
            .height(300.dp)
            .clickable { goDetail() }
    )
    {
        AsyncImage(
            model = photo,
            contentDescription = "${hero} photo",
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            contentScale = ContentScale.Crop
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text( text = hero,
                style = androidx.compose.material3.MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(8.dp))
            FavoritesIcon(isFavorite) {
                    setFavorite(!isFavorite)
                    Log.d("En Item", isFavorite.toString())

                }
            
        }

        }
    }



@Composable
fun FavoritesIcon(isFavorite: Boolean = false, onClick: () -> Unit) {

    Image(
        painter = painterResource(
            id =
            if (isFavorite) {
                R.drawable.ico_redheart
            } else {
                R.drawable.ico_whiteheart
            }
        ),
        contentDescription = "Favorite icon",
        modifier = Modifier
            .size(30.dp)
            .testTag(
                if (isFavorite) {
                    R.drawable.ico_redheart.toString()
                } else {
                    R.drawable.ico_whiteheart.toString()
                }
            )
            .clickable {
                onClick()
                Log.d("En Imagen", isFavorite.toString())
            }
    )
}

