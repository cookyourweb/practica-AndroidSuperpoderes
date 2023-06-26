package vero.practicaAndroidSuperpoderes.domain.model

import vero.practicaAndroidSuperpoderes.data.remote.Thumbnail


data class MarvelComic(
    val id: Int?,
    val title: String?,
    val thumbnail: Thumbnail?,
    val description: String?
)