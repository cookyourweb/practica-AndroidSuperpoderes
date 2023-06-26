package vero.practicaAndroidSuperpoderes.ui.superherolist

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel


import vero.practicaAndroidSuperpoderes.ui.components.DetailGrid


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun SuperHeroDetailScreen(
    id: String = "1",
    name: String = "Detail 1",
    goBack: () -> Unit = {},
    viewModel: SuperHeroDetailViewModel = hiltViewModel(),
) {

    LaunchedEffect(key1 = Unit, block = {
        val idNumber = id.toInt()
        Log.d("Vista", "LLamando get series")
        viewModel.getSeries(idNumber)
        viewModel.getComics(idNumber)
    })

    Scaffold(modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(text = name)
                },
                navigationIcon = {
                    IconButton(onClick = { goBack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Ir hacia atrás"
                        )
                    }
                }
            )
        }
    ) {
        val isLoading = viewModel.isLoading.collectAsState()
        val series = viewModel.series.collectAsState()
        val comics = viewModel.comics.collectAsState()
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
        ) {

            if (isLoading.value) {

                LoadingLayout()

            } else {
                if (series.value.isEmpty() && comics.value.isEmpty()) {
                    Text(text = "No  hay  series")
                } else {
                    DetailGrid(series.value, comics.value)
                }

            }
        }


    }
}


