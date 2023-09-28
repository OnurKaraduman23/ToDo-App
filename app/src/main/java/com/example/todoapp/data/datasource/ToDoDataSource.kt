package com.example.todoapp.data.datasource

import android.util.Log
import com.example.todoapp.data.entity.ToDo
import com.example.todoapp.room.ToDosDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ToDoDataSource(var tDao: ToDosDao){

   suspend fun toDoYukle():List<ToDo> =
       withContext(Dispatchers.IO){

            return@withContext tDao.toDoYukle()
       }


  suspend fun toDoKaydet(name:String){
      withContext(Dispatchers.IO){
          val yeniToDo = ToDo(0,name)
          tDao.kaydet(yeniToDo)
      }
    }
    suspend fun guncelle(id:Int,name:String){
        withContext(Dispatchers.IO){
            val guncellenenTodo = ToDo(id,name)
           tDao.guncelle(guncellenenTodo)
        }
    }
  suspend fun sil(id:Int){
      withContext(Dispatchers.IO){
          val silinenToDo = ToDo(id,"")
          tDao.sil(silinenToDo)
      }
  }

}