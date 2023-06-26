package vero.practicaAndroidSuperpoderes.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import vero.practicaAndroidSuperpoderes.ui.superherolist.CharacterListScreen
import vero.practicaAndroidSuperpoderes.ui.superherolist.SuperHeroDetailScreen
import vero.practicaAndroidSuperpoderes.ui.superherolist.SuperHeroDetailViewModel
import vero.practicaAndroidSuperpoderes.ui.superherolist.CharacterListViewModel

@Composable

fun NavigationGraph(characterListViewModel: CharacterListViewModel, SuperHeroDetailViewModel:SuperHeroDetailViewModel) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screens.ListadoScreen.route) {
            composable(Screens.ListadoScreen.route) {
                CharacterListScreen() { id, name ->
                    navController.navigate(Screens.DetalleScreeen.createRoute(id, name))
                }
            }

            composable(
                Screens.DetalleScreeen.route, arguments = listOf(
                    navArgument(Screens.DetalleScreeen.ARG_ID) {
                        type = NavType.StringType
                    },
                    navArgument(Screens.DetalleScreeen.ARG_NAME) {
                        type = NavType.StringType
                    }
                )
            ) { backStackEntry ->
                val id =
                    backStackEntry.arguments?.getString(Screens.DetalleScreeen.ARG_ID) ?: ""
                val name =
                    backStackEntry.arguments?.getString(Screens.DetalleScreeen.ARG_NAME) ?: ""

                SuperHeroDetailScreen(
                    id, name, { navController.navigateUp() }
                )

            }
        }

    }
}