package com.example.todoapp.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repo.ToDoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DEBUG_PROPERTY_NAME
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class KayitViewModel@Inject constructor(var tRepo : ToDoRepository) : ViewModel() {

    fun toDoKaydet(name:String){
        CoroutineScope(Dispatchers.Main).launch {
            tRepo.toDoKaydet(name)
        }
    }
}