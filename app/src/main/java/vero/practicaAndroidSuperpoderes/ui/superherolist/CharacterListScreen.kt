package vero.practicaAndroidSuperpoderes.ui.superherolist
import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.TopAppBar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import vero.practicaAndroidSuperpoderes.ui.components.CharactersListScreen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")

@Preview(showBackground = true)
@Composable
fun CharacterListScreen(
viewModel: CharacterListViewModel = hiltViewModel(),
onCharacterClick: (String, String)-> Unit = {_,_ ->}
) {
    androidx.compose.material.Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    androidx.compose.material.Text(text = "Marvel Characters")
                }
            )
        }
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {

            val characters = viewModel.characters.collectAsState()

            if (characters.value.isEmpty()) {
                LoadingLayout()
            } else {
                CharactersListScreen(characters.value, { mvcharacter ->
                    viewModel.setLike(mvcharacter)
                    Log.d("Character List", mvcharacter.isFavorite.toString())
                }) { characterId, characterName ->
                    onCharacterClick(characterId, characterName)
                }
            }
        }

    }
}

@Composable
fun LoadingLayout(){

    Column() {
        Spacer(modifier = Modifier
            .fillMaxHeight()
            .weight(1f))
        CircularProgressIndicator(
            strokeWidth = 5.dp,
            modifier = Modifier
                .fillMaxHeight()
                .width(75.dp)
                .weight(2f)
        )
    }

}