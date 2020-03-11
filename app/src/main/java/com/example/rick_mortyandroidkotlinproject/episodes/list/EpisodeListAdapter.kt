package com.example.rick_mortyandroidkotlinproject.episodes.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.rick_mortyandroidkotlinproject.databinding.EpisodeItemViewBinding
import com.example.rick_mortyandroidkotlinproject.network.properties.Episode

class EpisodeListAdapter(private val onClickListener: OnClickListener): ListAdapter<Episode, EpisodeListAdapter.EpisodeItemViewHolder>(DiffCallback) {

    companion object DiffCallback : DiffUtil.ItemCallback<Episode>() {
        override fun areItemsTheSame(oldItem: Episode, newItem: Episode): Boolean {
            return oldItem === newItem
        }
        override fun areContentsTheSame(oldItem: Episode, newItem: Episode): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class EpisodeItemViewHolder(private var binding: EpisodeItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(episode: Episode?) {
            binding.episode = episode
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeItemViewHolder {
        return EpisodeItemViewHolder(EpisodeItemViewBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: EpisodeItemViewHolder, position: Int) {
        val episode = getItem(position)
        holder.itemView.setOnClickListener{
            onClickListener.onClick(episode.id)
        }
        holder.bind(episode)
    }

    class OnClickListener(val clickListener: (episodeId: Int) -> Unit) {
        fun onClick(episodeId:Int) = clickListener(episodeId)
    }
}