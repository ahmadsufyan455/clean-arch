package com.zerodev.diexample.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.zerodev.diexample.R
import com.zerodev.diexample.databinding.ActivityMainBinding
import com.zerodev.diexample.view.viewmodel.story.MainViewModel
import com.zerodev.diexample.view.viewmodel.story.MainViewModelFactory
import com.zerodev.diexample.view.viewmodel.user.UserViewModel
import com.zerodev.diexample.view.viewmodel.user.UserViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mainFactory = MainViewModelFactory.getInstance()
        val userFactory = UserViewModelFactory.getInstance()
        val mainViewmodel = ViewModelProvider(this, mainFactory)[MainViewModel::class.java]
        val userViewmodel = ViewModelProvider(this, userFactory)[UserViewModel::class.java]
        mainViewmodel.getStory().observe(this) { story ->
            userViewmodel.getUser().observe(this) { user ->
                binding.name.text = user.name
                binding.email.text = user.email
            }
            binding.description.text = story.description
            Glide.with(this)
                .load(story.photoUrl)
                .into(binding.imgStory)
        }
    }
}