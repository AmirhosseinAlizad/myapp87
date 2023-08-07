package com.example.myapplication87.data.repository

import com.example.myapplication87.data.model.character
import com.example.myapplication87.data.remote.RetrofitInstance
import retrofit2.Response

class CharacterRepository {
    suspend fun getCharacter(): Response<character> = RetrofitInstance.api.getCharacter()
}