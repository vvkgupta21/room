package personal.project.room.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ToDoEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun todoDao(): ToDoDao
}