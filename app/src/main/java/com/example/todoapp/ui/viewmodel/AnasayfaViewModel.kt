package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todoapp.data.entity.ToDo
import com.example.todoapp.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var tRepo : ToDoRepository) : ViewModel() {


    var toDoListesi = MutableLiveData<List<ToDo>>()

    init {
        toDoYukle()
    }
    fun toDoYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            toDoListesi.value = tRepo.toDoYukle()
        }
    }
    fun sil(id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            tRepo.sil(id)
            toDoYukle()
        }
    }
}