package vero.practicaAndroidSuperpoderes.ui.superherolist
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material.icons.sharp.FavoriteBorder
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import vero.practicaAndroidSuperpoderes.components.MyTopbar

import vero.practicaAndroidSuperpoderes.domain.model.Hero

@Composable
fun SuperHeroListScreen(viewModel: SuperHeroListViewModel) {

    val state by viewModel.state.collectAsState()
    val favs by viewModel.favs.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getSuperheros()
    }


    SuperHeroListScreenContent(state,favs) { hero ->
viewModel.insertSuperhero(hero)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroListScreenContent(heros: List<Hero>, favs: Int, onSuperHeroListClicked: (Hero) -> Unit) {

    val scaffoldS = rememberScaffoldState()
    //scaffoldS.snackbarHostState.showSnackbar("show")
    // Se controla lo que se va mostrando en lugar de poner if then

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            MyTopBar()
        },
        bottomBar = {
            MyBottomBar(favs)
        }
    ) {
        LazyColumn(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp), contentPadding = it) {
            items(heros, key = { it.id }) { hero ->
                SuperheroItem(hero = hero, onHeroClick = onSuperHeroListClicked)
            }
        }
    }
}

@Composable
fun BottomBarItem(text: String, icon: ImageVector) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(imageVector = icon, contentDescription = icon.name)
        Text(text = text)
    }
}

@Preview
@Composable
fun BottomBarItem_Preview() {
    BottomBarItem("Home", Icons.Default.Home)
}

@Composable
fun MyBottomBar(favs: Int = 0) {

    BottomAppBar() {
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            BottomBarItem("Home", Icons.Default.Home)
            BottomBarItem("Favs: $favs", Icons.Default.Favorite)
        }
    }
}

@Preview
@Composable
fun MyBottomBar_Preview() {
    MyBottomBar()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar() {

    CenterAlignedTopAppBar(title = {
        Text(text = "Listado Superheroes")
    })
}

@Preview
@Composable
fun MyTopBar_Preview() {
    MyTopBar()
}


@Composable
fun SuperheroItem(hero: Hero,
                  modifier: Modifier = Modifier,
                  onHeroClick: (Hero) -> Unit) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)

            //.clickable { onHeroClick(hero) }
    ) {
        AsyncImage(
            model = hero.photo,
            contentDescription = "${hero.name} photo",
            modifier = Modifier
                .fillMaxWidth()
                .clickable {  Log.d("Clicked", "Superhero Image clicked")}
                .weight(1f),
            contentScale = ContentScale.Crop
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = hero.name,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Blue,
                modifier = Modifier
                    .padding(8.dp))


              


            androidx.compose.material.Icon(
                imageVector = Icons.Sharp.Favorite,
                contentDescription = "Favorite Icon",
                tint = Color.LightGray,
                modifier = Modifier
                    .padding(8.dp)
                    .size(35.dp)
                    .clickable { onHeroClick(hero)
                    }
            )

        }
       
    
    
    
    }
}


                
                

@Preview
@Composable
fun SuperheroItem_Preview() {
    SuperheroItem(Hero("", "Goku", "",isFavorite = false)){}
}

@Preview(showBackground = true)
@Composable
fun SuperHeroListScreen_Preview() {
    SuperHeroListScreenContent(emptyList(), 0) { }
}

