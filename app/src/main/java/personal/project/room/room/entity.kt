package personal.project.room.room

//The Entity represents a table within the database and has to be annotated with
//@Enity.Each Entity consist of a minimum of one field has to define a primary key.


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_items")
data class ToDoEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "content") var content: String
)