package vero.practicaAndroidSuperpoderes.ui.navigation

sealed class Screens(val route: String) {
    object ListadoScreen : Screens(SCREEN1_LISTADO)
    object DetalleScreeen : Screens(SCREEN2_DETALLE)


    companion object {
        private const val SCREEN1_LISTADO = "ListadoScreen"
        private const val SCREEN2_DETALLE = "DetalleScreeen"


    }
}
