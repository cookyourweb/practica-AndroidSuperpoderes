package vero.practicaAndroidSuperpoderes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dagger.hilt.android.AndroidEntryPoint

import vero.practicaAndroidSuperpoderes.ui.navigation.NavigationGraph
import vero.practicaAndroidSuperpoderes.ui.navigation.Screens
import vero.practicaAndroidSuperpoderes.ui.superherolist.CharacterListScreen
import vero.practicaAndroidSuperpoderes.ui.superherolist.SuperHeroDetailViewModel
import vero.practicaAndroidSuperpoderes.ui.superherolist.CharacterListViewModel
import vero.practicaAndroidSuperpoderes.ui.superherolist.SuperHeroDetailScreen

import vero.practicaAndroidSuperpoderes.ui.theme.PracticaAndroidSuperpoderesTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    private val superHeroDetailViewModel: SuperHeroDetailViewModel by viewModels()
    private val characterListViewModel: CharacterListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticaAndroidSuperpoderesTheme {
                NavigationGraph(characterListViewModel, superHeroDetailViewModel)


            }
        }
    }


    @Composable
    fun Screen1(onClickListener: () -> (Unit)) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red), contentAlignment = Alignment.Center
        ) {
            androidx.compose.material.Text(
                "Screen 1",
                modifier = Modifier.clickable { onClickListener() })
        }
    }

    @Preview
    @Composable
    fun Screen1_Preview() {
        Screen1({})
    }

    @Composable
    fun Screen2() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue), contentAlignment = Alignment.Center
        ) {
            androidx.compose.material.Text("Screen 2")
        }
    }

    @Composable
    fun Screen3() {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green), contentAlignment = Alignment.Center
        ) {
            androidx.compose.material.Text("Screen 3")
        }
    }
}
