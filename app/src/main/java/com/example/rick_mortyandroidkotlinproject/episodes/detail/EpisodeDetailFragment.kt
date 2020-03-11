package com.example.rick_mortyandroidkotlinproject.episodes.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rick_mortyandroidkotlinproject.R
import com.example.rick_mortyandroidkotlinproject.databinding.FragmentDetailEpisodeBinding


class EpisodeDetailFragment: Fragment() {

    private lateinit var viewModel: EpisodeDetailViewModel
    private lateinit var viewModelFactory: EpisodeDetailViewModelFactory

    private lateinit var binding: FragmentDetailEpisodeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_detail_episode,
            container,
            false
        )
        val args = arguments?.let { EpisodeDetailFragmentArgs.fromBundle(it) }

        viewModelFactory = EpisodeDetailViewModelFactory(args?.episodeId?: 1)
        viewModel = ViewModelProvider(this, viewModelFactory).get(EpisodeDetailViewModel::class.java)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

}