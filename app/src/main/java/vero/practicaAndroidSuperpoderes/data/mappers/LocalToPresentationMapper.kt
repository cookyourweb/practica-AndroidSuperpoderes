package vero.practicaAndroidSuperpoderes.data

import vero.practicaAndroidSuperpoderes.data.local.model.MarvelCharacterLocal
import vero.practicaAndroidSuperpoderes.domain.model.MarvelCharacter
import javax.inject.Inject

class LocalToPresentationMapper @Inject constructor() {

    fun map(characterList: List<MarvelCharacterLocal>): List<MarvelCharacter> {
        return characterList.map { map(it) }
    }

    fun map(character:MarvelCharacterLocal): MarvelCharacter {
        return MarvelCharacter(character.id,character.name,character.photo, character.isFavorite)
    }

    fun map(character:MarvelCharacter): MarvelCharacterLocal {
        return MarvelCharacterLocal(character.id,character.name,character.photo,character.isFavorite)
    }
}