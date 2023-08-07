package com.example.myapplication87.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication87.data.model.character
import com.example.myapplication87.databinding.ChracterItemBinding
import com.example.myapplication87.ui.viewmodel.CharacterViewModel
import com.squareup.picasso.Picasso

class CharacterViewHolder(private val binding: ChracterItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindViews(model: character) {
        binding.apply {
            binding.text.text = model.name
            binding.id.text = model.id.toString()
            Picasso.get().load(model.image).into(image);
        }
    }
}