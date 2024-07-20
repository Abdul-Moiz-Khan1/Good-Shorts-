package com.example.goodyoutubeshorts.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.goodyoutubeshorts.Model.Video_Model
import com.example.goodyoutubeshorts.databinding.VideoItemBinding

class Video_list_adapter {

    inner class video_viewHolder(private val binding: VideoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bindVideo(Model: Video_Model) {
            binding.videoView.apply {
                setVideoPath(Model.url)
                setOnPreparedListener {
                    it.start()
                    it.isLooping = true
                }
                setOnClickListener{

                }
            }
        }
    }

}