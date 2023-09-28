package com.example.todoapp.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todoapp.R
import com.example.todoapp.data.entity.ToDo
import com.example.todoapp.databinding.CardTasarimBinding
import com.example.todoapp.ui.fragment.AnasayfaFragmentDirections
import com.example.todoapp.ui.viewmodel.AnasayfaViewModel
import com.example.todoapp.ui.viewmodel.KayitViewModel
import com.google.android.material.snackbar.Snackbar

class ToDoAdapter(var mContext:Context, var toDoList:List<ToDo>,var viewModel: AnasayfaViewModel):RecyclerView.Adapter<ToDoAdapter.CardTasarimNesneleriniTutucu>() {

    inner class CardTasarimNesneleriniTutucu(var tasarim:CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimNesneleriniTutucu {
        val binding : CardTasarimBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_tasarim,parent,false)
        return CardTasarimNesneleriniTutucu(binding)
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }

    override fun onBindViewHolder(holder: CardTasarimNesneleriniTutucu, position: Int) {

        val toDo = toDoList.get(position)
        val t = holder.tasarim

        t.toDoNesnesi = toDo

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${toDo.name} \nsilinsin mi?",Snackbar.LENGTH_SHORT)
                .setBackgroundTint(Color.GRAY)
                .setTextColor(Color.RED)
                .setActionTextColor(Color.BLUE)
                .setAction("EVET"){
                    viewModel.sil(toDo.id)
                    viewModel.toDoYukle()
                }
                .show()
        }
        t.satirCard.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.detayFragmentGecis(toDo)
            Navigation.findNavController(it).navigate(gecis)
        }
        t.checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                t.textViewName.setBackgroundResource(R.drawable.strike_through)
            } else {
                t.textViewName.setBackgroundResource(0)
            }
        }

    }
}