package vero.practicaAndroidSuperpoderes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import vero.practicaAndroidSuperpoderes.ui.login.LoginScreen
import vero.practicaAndroidSuperpoderes.ui.login.LoginViewModel
import vero.practicaAndroidSuperpoderes.ui.superherolist.SuperHeroDetailScreen
import vero.practicaAndroidSuperpoderes.ui.superherolist.SuperHeroListScreen
import vero.practicaAndroidSuperpoderes.ui.superherolist.SuperHeroDetailViewModel
import vero.practicaAndroidSuperpoderes.ui.superherolist.SuperHeroListViewModel

@Composable

fun NavigationGraph(superHeroListViewModel: SuperHeroListViewModel, SuperHeroDetailViewModel:SuperHeroDetailViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.ListadoScreen.route) {
        composable(Screens.ListadoScreen.route) {
            Screens.ListadoScreen(viewModel = superHeroListViewModel) {
                navController.navigate(Screens.DetalleScreeen.route)
            }
        }

        composable(Screens.DetalleScreeen.route) {
            SuperHeroDetailScreen(viewModel = SuperHeroDetailViewModel)
            navController.navigate(Screens.DetalleScreeen.route)
        }
    }
}

private fun Screens.Companion.ListadoScreen(viewModel: SuperHeroListViewModel, value: () -> Unit) {

}
