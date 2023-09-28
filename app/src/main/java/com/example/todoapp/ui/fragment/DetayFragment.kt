package com.example.todoapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentDetayBinding
import com.example.todoapp.ui.viewmodel.DetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetayFragment : Fragment() {

    private lateinit var binding : FragmentDetayBinding
    private lateinit var viewModel : DetayViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_detay,container,false)

        binding.detayFragmentNesnesi = this
        binding.toolbarDetayAnasayfaBaslik = "To Do Detail"

        val bundle : DetayFragmentArgs by navArgs()
        val gelenToDo = bundle.toDo

        binding.toDoNesnesi = gelenToDo

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : DetayViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun toDoGuncelle(it:View,id:Int,name:String){
        viewModel.toDoGuncelle(id,name)
        Navigation.findNavController(it).navigate(R.id.anasayfaFragment)
    }


}