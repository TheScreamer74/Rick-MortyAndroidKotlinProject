package com.example.rick_mortyandroidkotlinproject.characterList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rick_mortyandroidkotlinproject.R
import com.example.rick_mortyandroidkotlinproject.databinding.FragmentListCharactersBinding

class CharacterListFragment : Fragment() {


    companion object {
        fun newInstance() = CharacterListFragment()
    }

    private lateinit var viewModel: CharacterListViewModel

    private lateinit var binding: FragmentListCharactersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list_characters,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(CharacterListViewModel::class.java)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.characterList.adapter = CharacterListAdapter()

        binding.fragmentListCharacterBtnNext.setOnClickListener{
            viewModel.nextPage(it)
            binding.fragmentListCharacterBtnPevious.isEnabled = true
        }

        binding.fragmentListCharacterBtnPevious.setOnClickListener{
            viewModel.previousPage(it)
            binding.fragmentListCharacterBtnNext.isEnabled = true
        }

        return binding.root

    }


}