package com.example.myapplication87.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication87.data.model.character
import com.example.myapplication87.databinding.ChracterItemBinding

class CharacterAdapter : RecyclerView.Adapter<CharacterViewHolder>() {
    private var characterList = emptyList<character>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder =
        CharacterViewHolder(
            ChracterItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int {
        return characterList.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bindViews(characterList[position])
    }
    fun setData(newList:List<character>){
        characterList=newList
    }
}