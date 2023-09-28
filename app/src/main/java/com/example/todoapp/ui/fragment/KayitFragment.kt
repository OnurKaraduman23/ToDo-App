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
import com.example.todoapp.databinding.FragmentKayitBinding
import com.example.todoapp.ui.viewmodel.KayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KayitFragment : Fragment() {
    private lateinit var binding : FragmentKayitBinding
    private lateinit var viewModel : KayitViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kayit,container,false)

        binding.kayitFragmentNesnesi = this
        binding.toolbarKayitFragmentBaslik = "Add To Do"
        return binding.root
    }

    fun toDoKaydet(it:View,name:String){
        viewModel.toDoKaydet(name)
        Navigation.findNavController(it).navigate(R.id.anasayfaFragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : KayitViewModel by viewModels()
        viewModel = tempViewModel
    }


}