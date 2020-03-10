package com.example.rick_mortyandroidkotlinproject.episodes.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.rick_mortyandroidkotlinproject.R
import com.example.rick_mortyandroidkotlinproject.databinding.FragmentListEpisodesBinding


class EpisodeListFragment: Fragment() {

    private lateinit var viewModel: EpisodeListViewModel

    private lateinit var binding: FragmentListEpisodesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_list_episodes,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(EpisodeListViewModel::class.java)

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.episodeList.adapter = EpisodeListAdapter()

        binding.fragmentListEpisodeBtnNext.setOnClickListener{
            viewModel.nextPage(it)
            binding.fragmentListEpisodeBtnPevious.isEnabled = true
        }

        binding.fragmentListEpisodeBtnPevious.setOnClickListener{
            viewModel.previousPage(it)
            binding.fragmentListEpisodeBtnNext.isEnabled = true
        }

        return binding.root
    }
}