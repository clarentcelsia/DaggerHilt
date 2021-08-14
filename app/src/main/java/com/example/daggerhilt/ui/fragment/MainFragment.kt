package com.example.daggerhilt.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.daggerhilt.R
import com.example.daggerhilt.databinding.FragmentMainBinding
import com.example.daggerhilt.model.Data
import com.example.daggerhilt.ui.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private val myModel: MyViewModel by viewModels()

    private var _binding: FragmentMainBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_listFragment)
        }

        binding.button.setOnClickListener {
            val name = binding.etName.text.toString()
            val contact = binding.etContact.text.toString()
            val email = binding.etEmail.text.toString()

            myModel.insertData(
                Data(name, contact, email)
            )

            reset()
        }
    }

    private fun reset(){
        binding.etName.text?.clear()
        binding.etContact.text?.clear()
        binding.etEmail.text?.clear()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}