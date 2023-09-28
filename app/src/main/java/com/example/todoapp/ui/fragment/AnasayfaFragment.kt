package com.example.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.todoapp.R
import com.example.todoapp.data.entity.ToDo
import com.example.todoapp.databinding.FragmentAnasayfaBinding
import com.example.todoapp.ui.adapter.ToDoAdapter
import com.example.todoapp.ui.viewmodel.AnasayfaViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding:FragmentAnasayfaBinding
    private lateinit var viewModel:AnasayfaViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa,container,false)

        binding.anasayfaFragmentNesnesi = this
        binding.toolbarAnasayfaBaslik = "To Do"

        viewModel.toDoListesi.observe(viewLifecycleOwner){
            binding.myAdapter = ToDoAdapter(requireContext(),it,viewModel)
        }





        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }

    override fun onResume() {
        super.onResume()
        viewModel.toDoYukle()
    }

    fun toDoEkle(it:View){
        Navigation.findNavController(it).navigate(R.id.kayitFragmentGecis)
    }





}