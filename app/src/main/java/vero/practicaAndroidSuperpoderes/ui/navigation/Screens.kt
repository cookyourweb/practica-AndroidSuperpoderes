package vero.practicaAndroidSuperpoderes.ui.navigation

sealed class Screens(val route: String) {

    object ListadoScreen : Screens(SCREEN1_LISTADO)

    object DetalleScreeen : Screens(DETAIL_ROUTE){
        const val ARG_ID = "id"
        const val ARG_NAME = "name"

        fun createRoute(id: String, name: String): String {
            return "$SCREEN2_DETALLE/$id/$name"
        }
    }


    companion object {
        private const val SCREEN1_LISTADO = "ListadoScreen"
        private const val SCREEN2_DETALLE = "DetalleScreeen"
        private const val DETAIL_ROUTE = "DetalleScreeen/{id}/{name}"


    }
}
