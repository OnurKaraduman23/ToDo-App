package com.example.todoapp.data.repo

import com.example.todoapp.data.datasource.ToDoDataSource
import com.example.todoapp.data.entity.ToDo

class ToDoRepository(var tDs:ToDoDataSource) {


    suspend fun toDoKaydet(name:String) =tDs.toDoKaydet(name)
    suspend fun sil(id:Int) = tDs.sil(id)
    suspend fun toDoYukle() : List<ToDo> = tDs.toDoYukle()
    suspend fun guncelle(id:Int,name:String) =tDs.guncelle(id,name)
}