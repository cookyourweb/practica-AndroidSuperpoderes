package vero.practicaAndroidSuperpoderes.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "superheros")
data class Hero(
   @PrimaryKey val id: String,
    val name: String,
    val photo: String,
    val isFavorite:Boolean = false
)
