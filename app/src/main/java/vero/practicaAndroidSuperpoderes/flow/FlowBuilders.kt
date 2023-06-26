package vero.practicaAndroidSuperpoderes.flow

import android.util.Log
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.fold
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.transform
import vero.practicaAndroidSuperpoderes.data.local.model.MarvelCharacterLocal
import vero.practicaAndroidSuperpoderes.data.remote.DataMarvel
import vero.practicaAndroidSuperpoderes.data.remote.MarvelResponse
import vero.practicaAndroidSuperpoderes.data.remote.Result
import vero.practicaAndroidSuperpoderes.data.remote.Thumbnail
import vero.practicaAndroidSuperpoderes.domain.model.MarvelCharacter
import vero.practicaAndroidSuperpoderes.domain.model.MarvelSerie


fun generateListCharacters(): List<MarvelCharacter> {
    return listOf(
        MarvelCharacter(
            "id",
            "name",
            "photo"
        )
    )
}
fun generateListSeries(): List<MarvelSerie> {
    return listOf(
        MarvelSerie(
            "id",
            "title",
            "photo"
        )
    )
}

fun generateCharactersFlow(): Flow<List<MarvelCharacter>> {
    return flow {
        emit(
            listOf(
                MarvelCharacter(
                    "id",
                    "name",
                    "photo"
                )
            )
        )
    }
}
fun generatSeriesFlow(): Flow<List<MarvelSerie>> {
    return flow {
        emit(
            listOf(
                MarvelSerie(
                    "id",
                    "title",
                    "photo"
                )
            )
        )
    }
}

fun generateLocalCharactersFlow(): Flow<List<MarvelCharacterLocal>> {
    return flow {
        emit(
            listOf(
                MarvelCharacterLocal(
                    "id",
                    "name",
                    "photo",
                    false
                )
            )
        )
    }
}
fun generateFakeMarvelResponse(): MarvelResponse {
    return MarvelResponse(
        200,
        "OK",
        "© 2023 MARVEL",
        "Data provided by Marvel. © 2023 MARVEL",
        "<a href=\\\"http://marvel.com\\\">Data provided by Marvel. © 2023 MARVEL</a>",
        "",
        DataMarvel(
            0,
            20,
            1562,
            20,
            listOf(
                Result(
                    1,
                    "name",
                    "title",
                    "description",
                    Thumbnail(
                        "path",
                        "extension"
                    ),
                    "resourceUri"
                )
            )
        )
    )
}