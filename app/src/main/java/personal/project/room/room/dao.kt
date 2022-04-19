package personal.project.room.room

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface ToDoDao {

    @Query("SELECT * FROM todo_items")
    fun getAll(): LiveData<List<ToDoEntity>>

    @Query("SELECT * FROM TODO_ITEMS WHERE title LIKE :title")
    fun findByTitle(title: String): ToDoEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(todo: List<ToDoEntity>)

    @Delete
    fun delete(todo: List<ToDoEntity>)

    @Query("DELETE FROM todo_items")
    fun deleteAll()

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(toDoEntity: ToDoEntity)

}