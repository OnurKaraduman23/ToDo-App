package com.example.todoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.todoapp.data.entity.ToDo

@Dao
interface ToDosDao {

    @Query("SELECT * FROM toDos")
    suspend fun toDoYukle() : List<ToDo>

    @Insert
    suspend fun kaydet(todo:ToDo)

    @Update
    suspend fun guncelle(todo:ToDo)

    @Delete
    suspend fun sil(todo:ToDo)
}