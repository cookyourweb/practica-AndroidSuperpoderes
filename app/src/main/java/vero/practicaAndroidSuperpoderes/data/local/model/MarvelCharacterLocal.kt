package vero.practicaAndroidSuperpoderes.data.local.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class MarvelCharacterLocal (
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "photo") val photo: String,
    @ColumnInfo(name="favorite") var isFavorite:Boolean = false
)