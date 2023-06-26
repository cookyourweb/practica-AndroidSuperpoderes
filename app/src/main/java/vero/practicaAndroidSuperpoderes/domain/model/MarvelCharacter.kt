package vero.practicaAndroidSuperpoderes.domain.model



data class MarvelCharacter(
    val id:String,
    val name: String,
    val photo: String,
    var isFavorite: Boolean = false
)

