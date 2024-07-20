package com.example.goodyoutubeshorts

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.goodyoutubeshorts.Model.Video_Model
import com.example.goodyoutubeshorts.adapter.Video_list_adapter
import com.example.goodyoutubeshorts.databinding.ActivityMainBinding
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.firebase.Firebase
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    private lateinit var adapter: Video_list_adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        FirebaseApp.initializeApp(this)
        // Get a Firestore instance
        val db = FirebaseFirestore.getInstance()
        setup_viewpager()

    }

    private fun setup_viewpager() {
        try{
            val options = FirestoreRecyclerOptions.Builder<Video_Model>()
                .setQuery(
                    Firebase.firestore.collection("videos"), Video_Model::class.java
                       ).build()
            adapter = Video_list_adapter (options)
            binding . viewpager . adapter = adapter
        }catch (e:Exception){
        Log.e("Error" , "Error from firebase" , e)
        }

    }
    override fun onStart() {
        super.onStart()
        adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        adapter.startListening()
    }
}
