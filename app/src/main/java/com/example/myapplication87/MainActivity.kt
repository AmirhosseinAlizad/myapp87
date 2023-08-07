package com.example.myapplication87

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication87.data.repository.CharacterRepository
import com.example.myapplication87.databinding.ActivityMainBinding
import com.example.myapplication87.ui.adapter.CharacterAdapter
import com.example.myapplication87.ui.viewmodel.CharacterViewModel
import com.example.myapplication87.ui.viewmodel.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: CharacterViewModel
    private lateinit var binding: ActivityMainBinding
    private val characterAdapter by lazy { CharacterAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        bindViews()
    }

    private fun bindViews() {
        val repository = CharacterRepository()
        val viewModelFactory = MainViewModelFactory(application, repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[CharacterViewModel::class.java]
        viewModel.CharacterResponse.observe(this) { response ->
            if (response.isSuccessful)
                response.body()?.let { characterAdapter.setData(listOf(it)) }
            else
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()

        }
        binding.recycler.apply {
            adapter = characterAdapter
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        }
    }
}