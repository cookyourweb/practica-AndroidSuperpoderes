package vero.practicaAndroidSuperpoderes.ui.superherolist
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

import vero.practicaAndroidSuperpoderes.domain.model.Hero

@Composable
fun  SuperHeroListScreen (viewModel: SuperHeroListViewModel) {




    val state by viewModel.state.collectAsState()

    LaunchedEffect(Unit){
        viewModel.getSuperheros()
    }

    SuperHeroListScreenContent(state) { hero ->

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroListScreenContent(heros: List<Hero>, onSuperHeroListClicked: (String) -> Unit) {
    Scaffold(modifier = Modifier.fillMaxSize()) {//por defecto
        LazyColumn(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp), contentPadding =  it){
            items(heros, key = {it.id}){ hero ->
                SuperheroItem(hero = hero)
            }
        }
    }
}

@Composable
fun SuperheroItem(hero: Hero) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .height(300.dp)
    ){
        AsyncImage(model = hero.photo, contentDescription = "${hero.name}photo",
        modifier= Modifier
            .fillMaxSize()
            .weight(1f),//con 1f nos ocupa todo o que hay
            contentScale = ContentScale.Crop
        )
        Text(text = hero.name, style = MaterialTheme.typography.headlineLarge, modifier = Modifier.padding(8.dp))
    }

}
@Preview(showBackground = true)
@Composable
fun SuperHeroItem_Preview() {
    SuperheroItem(Hero(id = "", name = "Goku", photo = ""))
}
@Preview(showBackground = true)
@Composable
fun SuperHeroListScreen_Preview() {
    SuperHeroListScreenContent(emptyList()) {  }
}