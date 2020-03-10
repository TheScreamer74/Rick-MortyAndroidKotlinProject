package com.example.rick_mortyandroidkotlinproject.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.rick_mortyandroidkotlinproject.R
import com.example.rick_mortyandroidkotlinproject.databinding.MainFragmentBinding
import com.squareup.picasso.Picasso


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: MainFragmentBinding



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.main_fragment,
            container,
            false
        )



        binding.mainFragmentRandomButton.setOnClickListener{
            viewModel.generateRandomChar()
        }

        binding.mainFragmentButtonCharacter.setOnClickListener{
            viewModel.switchOnCharacterListFragment(it)
        }

        binding.mainFragmentButtonLocation.setOnClickListener{
            viewModel.switchOnLocationListFragment(it)
        }

        binding.mainFragmentButtonEpisode.setOnClickListener{
            viewModel.switchOnEpisodeListFragment(it)
        }

        binding.mainFragmentButtonDetailCharacter.setOnClickListener{
            viewModel.switchOnCharacterDetailFragment(it)
        }

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)


        binding.mainViewModel = viewModel
        binding.lifecycleOwner = this


        return binding.root


    }

    private fun generateNewChar() {
    }



}
