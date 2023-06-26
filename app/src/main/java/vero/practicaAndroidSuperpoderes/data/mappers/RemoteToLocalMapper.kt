package vero.practicaAndroidSuperpoderes.data.mappers

import vero.practicaAndroidSuperpoderes.data.local.model.MarvelCharacterLocal
import vero.practicaAndroidSuperpoderes.data.remote.MarvelResponse
import javax.inject.Inject

class RemoteToLocalMapper @Inject constructor() {

    fun map(marvelResponse: MarvelResponse): List<MarvelCharacterLocal> {
        return marvelResponse.data.results.map {
            MarvelCharacterLocal(
                it.id.toString(),
                it?.name ?: "",
                it.thumbnail.getImageUrl()
            )
        }
    }
}