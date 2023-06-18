package vero.practicaAndroidSuperpoderes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import vero.practicaAndroidSuperpoderes.Screen3
import vero.practicaAndroidSuperpoderes.ui.login.LoginScreen
import vero.practicaAndroidSuperpoderes.ui.login.LoginViewModel
import vero.practicaAndroidSuperpoderes.ui.superherolist.SuperHeroListScreen
import vero.practicaAndroidSuperpoderes.ui.superherolist.SuperHeroListViewModel

@Composable

fun NavigationGraph(loginViewModel: LoginViewModel, superHeroListViewModel: SuperHeroListViewModel) {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screens.LoginScreen.route) {
        composable(Screens.LoginScreen.route) {
            LoginScreen(viewModel = loginViewModel) {
                navController.navigate(Screens.SuperheroScreen.route)
            }
        }

        composable(Screens.SuperheroScreen.route) {
            SuperHeroListScreen(viewModel = superHeroListViewModel)
        }
    }
}
