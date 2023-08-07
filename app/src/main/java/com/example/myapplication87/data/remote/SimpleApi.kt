package com.example.myapplication87.data.remote

import com.example.myapplication87.data.model.character
import com.example.myapplication87.utils.Constance
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET(value = Constance.END_POINT)
    suspend fun getCharacter(): Response<character>
}