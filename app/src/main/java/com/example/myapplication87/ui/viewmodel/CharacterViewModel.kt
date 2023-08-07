package com.example.myapplication87.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication87.data.model.character
import com.example.myapplication87.data.repository.CharacterRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class CharacterViewModel(private val Repository: CharacterRepository) : ViewModel() {
    val CharacterResponse: MutableLiveData<Response<character>> = MutableLiveData()
    val CharacterNumberResponse: MutableLiveData<Response<character>> = MutableLiveData()
    fun getCharacter() {
        viewModelScope.launch {
            val response: Response<character> = Repository.getCharacter()
            CharacterResponse.value = response
        }
    }
    //fun getPostsNumber(number: Int) {
      //  viewModelScope.launch {
        //    val response: Response<character> = .getPostsNumber(number)
          //   CharacterNumberResponse.value = response
        //}
    //}
}