package vero.practicaAndroidSuperpoderes.data

import vero.practicaAndroidSuperpoderes.data.remote.MarvelResponse
import vero.practicaAndroidSuperpoderes.data.remote.PhotoType

import vero.practicaAndroidSuperpoderes.domain.model.MarvelCharacter
import vero.practicaAndroidSuperpoderes.domain.model.MarvelSerie
import javax.inject.Inject

class RemoteToPresentationMapper @Inject constructor() {

    fun map(marvelResponse: MarvelResponse): List<MarvelCharacter> {
        return marvelResponse.data.results.map {
            MarvelCharacter(
                it.id.toString(),
                it?.name ?: "",
                it.thumbnail.getImageUrl()
            )
        }
    }

    fun mapSeries(marvelResponse: MarvelResponse):List<MarvelSerie> {
        return marvelResponse.data.results.map {
            MarvelSerie(
                it.id.toString(),
                it?.title ?: "",
                it.thumbnail.getImageUrl(PhotoType.portrait)
            )
        }
    }
}