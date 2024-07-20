package com.example.goodyoutubeshorts.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.goodyoutubeshorts.Model.Video_Model
import com.example.goodyoutubeshorts.databinding.VideoItemBinding
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class Video_list_adapter(options: FirestoreRecyclerOptions<Video_Model>): FirestoreRecyclerAdapter<Video_Model, Video_list_adapter.video_viewHolder>(options) {


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
                    if(isPlaying){
                        pause()
                        binding.pauseIcon.visibility = View.VISIBLE
                    }else{
                        resume()
                        binding.pauseIcon.visibility = View.GONE
                    }

                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): video_viewHolder {
        val binding = VideoItemBinding.inflate(LayoutInflater.from(parent.context) ,parent,false)
        return video_viewHolder(binding)
    }

    override fun onBindViewHolder(holder: video_viewHolder, position: Int, model: Video_Model) {
        holder.bindVideo(model)

    }

}