package com.example.rick_mortyandroidkotlinproject.character.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.rick_mortyandroidkotlinproject.R
import com.example.rick_mortyandroidkotlinproject.databinding.FragmentDetailCharacterBinding
import kotlinx.coroutines.android.awaitFrame

class CharacterDetailFragment: Fragment() {

    private lateinit var viewModel: CharacterDetailViewModel
    private lateinit var viewModelFactory: CharacterDetailViewModelFactory

    private lateinit var binding: FragmentDetailCharacterBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail_character,
            container,
            false
        )

        val args = arguments?.let { CharacterDetailFragmentArgs.fromBundle(it) }
        viewModelFactory = CharacterDetailViewModelFactory(args?.characterId?: 1)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CharacterDetailViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}